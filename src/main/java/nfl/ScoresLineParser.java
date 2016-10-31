package nfl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.HTMLFetcher;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Adrian on 9/29/2016.
 */
public class ScoresLineParser {
    private final String url = "http://www.scoresline.com/scores.asp?F=NFL";
    private ArrayList<NFLTeam> teams;

    public ScoresLineParser(ArrayList<NFLTeam> teams) {
        this.teams = teams;
    }

    public ArrayList<NFLGame> getGames(){
        ArrayList<NFLGame> games = new ArrayList<NFLGame>();
        Document NFLData = HTMLFetcher.fetch(url);
        int seasonId = NFLSeason.getCurrentSeasonId();

        for (Element row : NFLData.getElementsByTag("tr")){
            /*
            TODO: Differentiate between the three table types (In progress, Final, Scheduled Today) and treat them all differently
            In-progress will have 8 columns
            3rd column for scheduled games will have the title "Starts At"
             */
            Elements cols = row.getElementsByTag("td");

            //Row is a game in progress
            if (cols.size() == 8 && cols.get(1).text().equals("NFL")){
                String awayTeamCity = cols.get(3).getElementsByTag("a").text();
                String homeTeamCity = cols.get(5).getElementsByTag("a").text();

                String awayTeamNickname = translateCityToNickname(awayTeamCity);
                String homeTeamNickname = translateCityToNickname(homeTeamCity);

                int awayScore = Integer.parseInt(cols.get(4).text());
                int homeScore = Integer.parseInt(cols.get(6).text());

                System.out.println("Away Team: " + awayTeamNickname + " - " + awayScore);
                System.out.println("Home Team: " + homeTeamNickname + " - " + homeScore);
                System.out.println("-----------");
            }
//            if (cols.size() > 1){
//                int colOffset = 0;
//                if (cols.get(1).text().equals("NFL"))
//                    colOffset = 1;
//                if (cols.get(0+colOffset).text().equals("NFL")){
//                    String awayTeamCity = cols.get(2+colOffset).getElementsByTag("a").text();
//                    String homeTeamCity = cols.get(4+colOffset).getElementsByTag("a").text();
//
//                    String awayTeamNickname = translateCityToNickname(awayTeamCity);
//                    String homeTeamNickname = translateCityToNickname(homeTeamCity);
//
//                    int awayScore = Integer.parseInt(cols.get(3+colOffset).text());
//                    int homeScore = Integer.parseInt(cols.get(5+colOffset).text());
//
//                    String status = "";
//                    if (colOffset == 1){
//                        status = "In Progress";
//                    }
//                    else if (cols.get(6).getElementsByTag("a").get(0).text().equals("Final")){
//                        status = "Final";
//                    }
//                    else {
//                        status = cols.get(2).text();
//                    }
//                    System.out.println("Status: " + status);
//                    System.out.println("Away Team: " + translateCityToNickname(awayTeamCity) + " " + awayScore);
//                    System.out.println("Home Team: " + translateCityToNickname(homeTeamCity) + " " + homeScore);
//                    System.out.println("-----");
//                }
//            }
        }
        return games;
    }

    //Ugly, but necessary for the way this site lists teams
    private String translateCityToNickname(String city){
        HashMap<String, String> teams = new HashMap<>();
        teams.put("Atlanta", "Falcons");
        teams.put("Arizona", "Cardinals");
        teams.put("Buffalo", "Bills");
        teams.put("Baltimore", "Ravens");
        teams.put("Carolina", "Panthers");
        teams.put("Chicago", "Bears");
        teams.put("Cincinnati", "Bengals");
        teams.put("Cleveland", "Browns");
        teams.put("Dallas", "Cowboys");
        teams.put("Denver", "Broncos");
        teams.put("Detroit", "Lions");
        teams.put("Green Bay", "Packers");
        teams.put("Houston", "Texans");
        teams.put("Indianapolis", "Colts");
        teams.put("Jacksonville", "Jaguars");
        teams.put("Kansas City", "Chiefs");
        teams.put("Miami", "Dolphins");
        teams.put("Minnesota", "Vikings");
        teams.put("New England", "Patriots");
        teams.put("New Orleans", "Saints");
        teams.put("Ny Giants", "Giants");
        teams.put("Ny Jets", "Jets");
        teams.put("Oakland", "Raiders");
        teams.put("Philadelphia", "Eagles");
        teams.put("Pittsburgh", "Steelers");
        teams.put("San Diego", "Chargers");
        teams.put("San Francisco", "49ers");
        teams.put("Seattle", "Seahawks");
        teams.put("St Louis", "Rams");
        teams.put("Los Angeles", "Rams");
        teams.put("Tampa Bay", "Buccaneers");
        teams.put("Tennessee", "Titans");
        teams.put("Washington", "Redskins");

        return teams.get(city);
    }
}
