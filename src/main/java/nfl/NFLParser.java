package nfl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utils.HTMLFetcher;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Adrian on 9/27/2016.
 */
public class NFLParser {
    private final String url = "http://www.nfl.com/scores";
    private ArrayList<NFLTeam> teams;

    public NFLParser(ArrayList<NFLTeam> teams) {
        this.teams = teams;
    }

    public ArrayList<NFLGame> getGames(){
        ArrayList<NFLGame> games = new ArrayList<NFLGame>();
        Document NFLData = HTMLFetcher.fetch(url);
        int seasonId = NFLSeason.getCurrentSeasonId();
//        System.out.println(NFLData.toString());
        for (Element scoreBox : NFLData.getElementsByClass("new-score-box-wrapper")){
//            System.out.println("\n-------");
            System.out.println(scoreBox.toString());

            LocalDateTime startTime = LocalDateTime.now();
            String status = scoreBox.getElementsByClass("time-left").first().text();

            Element awayTeamData = scoreBox.getElementsByClass("away-team").first();
            Element homeTeamData = scoreBox.getElementsByClass("home-team").first();

            String awayTeamName = awayTeamData.getElementsByClass("team-name").first().text();
            int awayTeamCode = NFLTeam.getTeamCode(teams, awayTeamName);
            String homeTeamName = homeTeamData.getElementsByClass("team-name").first().text();
            int homeTeamCode = NFLTeam.getTeamCode(teams, homeTeamName);

            int awayTeamScore;
            int homeTeamScore;

            try {
                awayTeamScore = Integer.parseInt(awayTeamData.getElementsByClass("total-score").first().text());
            } catch (NumberFormatException e){
                awayTeamScore = 0;
            }
            try {
                homeTeamScore = Integer.parseInt(homeTeamData.getElementsByClass("total-score").first().text());
            } catch (NumberFormatException e){
                homeTeamScore = 0;
            }


//            System.out.println("Away Team: " + awayTeamName + " - " + awayTeamScore + "\nHome Team: " + homeTeamName + " - " + homeTeamScore + "\nStatus: " + status);
            games.add(new NFLGame(awayTeamCode, homeTeamCode, seasonId, startTime, status, awayTeamScore, homeTeamScore));
        }

        return games;
    }
}
