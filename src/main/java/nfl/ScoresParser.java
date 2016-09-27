package nfl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.HTMLFetcher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Adrian on 9/26/2016.
 */
public class ScoresParser {
    private static final String scoresURL = "http://www.scores.com/nfl/scores/";


    public static ArrayList<NFLGame> getGames(ArrayList<NFLTeam> teams){
        ArrayList<NFLGame> games = new ArrayList<NFLGame>();
        Document NFLData = HTMLFetcher.fetch(scoresURL);

        for (Element game : NFLData.getElementsByClass("scoreboard")){
            Elements rows = game.select("tr");
            rows.remove(0);
            int seasonId = getCurrentSeasonId();
            int awayTeamCode = 0;
            int homeTeamCode = 0;
            int awayScore = 0;
            int homeScore = 0;
            LocalDateTime startTime = LocalDateTime.now();
            String status = "Final";
            String quarter = "NA";
            for (int i = 0; i < 2 ; i++){
                Element row = rows.get(i);
                Elements columns = row.select("td");
                String teamCityAndName = columns.get(0).text();
//                System.out.println(row.text());
                if(i == 0) {
                    awayTeamCode = getTeamCode(teams, teamCityAndName);
                    awayScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("AWAY SCORE = " + columns.get(7).text());
                }
                else{
                    homeTeamCode = getTeamCode(teams, teamCityAndName);
                    homeScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("HOME SCORE = " + columns.get(7).text());
                }
            }
            games.add(new NFLGame(awayTeamCode, homeTeamCode, seasonId, startTime, status, awayScore, homeScore, quarter));
        }

        return games;
    }

    private static int getTeamCode (ArrayList<NFLTeam> teams, String cityAndName){
        int retval = -1;
        //System.out.println("----" + cityAndName);
        switch(cityAndName){
            case "St. Louis Rams":
                cityAndName = "Los Angeles Rams";
                break;
            case "Tampa Bay Bucs":
                cityAndName = "Tampa Bay Buccaneers";
                break;

        }
        for (NFLTeam team : teams){
            //System.out.println("----------" +team.getCityAndName() + " " + team.getTeamId());
            if (cityAndName.equals(team.getCityAndName())) {
//                System.out.println(cityAndName + " matched " + team.getCityAndName());
                retval = team.getTeamId();
//                System.out.println("--Returning: " + retval);
                return retval;
            }
        }
        System.out.println(cityAndName + " DID NOT MATCH");
        return retval;
    }

    private static int getCurrentSeasonId(){
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        int code = (year % 2016) + 1;

        if (month < 7)
            code--;

        return code;
    }

    private static String getCurrentYear(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        return Integer.toString(year);
    }
}
