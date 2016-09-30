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
    private final String scoresURL = "http://www.scores.com/nfl/scores/index.cfm/week/3/season/2016";
    private ArrayList<NFLTeam> teams;

    public ScoresParser(ArrayList<NFLTeam> teams) {
        this.teams = teams;
    }

    public ArrayList<NFLGame> getGames(){
        ArrayList<NFLGame> games;
        Document NFLData = HTMLFetcher.fetch(scoresURL);
        games = getCurrentGames(NFLData);

        games.addAll(getPreGames(NFLData));

        return games;
    }

    private ArrayList<NFLGame> getCurrentGames(Document NFLData){
        ArrayList<NFLGame> games = new ArrayList<NFLGame>();

        for (Element game : NFLData.getElementsByClass("scoreboard")){
            Elements rows = game.select("tr");
            rows.remove(0);
            int seasonId = NFLSeason.getCurrentSeasonId();
            int awayTeamCode = 0;
            int homeTeamCode = 0;
            int awayScore = 0;
            int homeScore = 0;
            LocalDateTime startTime = LocalDateTime.now();
            String status = "In Progress";
            for (int i = 0; i < 2 ; i++){
                Element row = rows.get(i);
                Elements columns = row.select("td");
                String teamCityAndName = columns.get(0).text();
//                System.out.println(row.text());
                if(i == 0) {
                    awayTeamCode = NFLTeam.getTeamCode(teams, teamCityAndName);
                    awayScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("AWAY SCORE = " + columns.get(7).text());
                }
                else{
                    homeTeamCode = NFLTeam.getTeamCode(teams, teamCityAndName);
                    homeScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("HOME SCORE = " + columns.get(7).text());
                }
            }
            games.add(new NFLGame(awayTeamCode, homeTeamCode, seasonId, startTime, status, awayScore, homeScore));
        }
        return games;
    }

    private ArrayList<NFLGame> getPreGames(Document NFLData){
        ArrayList<NFLGame> games = new ArrayList<NFLGame>();
        System.out.println(NFLData.toString());
        System.out.println(NFLData.getElementsByClass("pre-game"));
        for (Element game : NFLData.getElementsByClass("pre-game")){
            Elements rows = game.select("tr");
            rows.remove(0);
            int seasonId = NFLSeason.getCurrentSeasonId();
            int awayTeamCode = 0;
            int homeTeamCode = 0;
            int awayScore = 0;
            int homeScore = 0;
            LocalDateTime startTime = LocalDateTime.now();
            String status = "Pre-Game";
            for (int i = 0; i < 2 ; i++){
                Element row = rows.get(i);
                Elements columns = row.select("td");
                String teamCityAndName = columns.get(0).text();
//                System.out.println(row.text());
                if(i == 0) {
                    awayTeamCode = NFLTeam.getTeamCode(teams, teamCityAndName);
                    awayScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("AWAY SCORE = " + columns.get(7).text());
                }
                else{
                    homeTeamCode = NFLTeam.getTeamCode(teams, teamCityAndName);
                    homeScore = Integer.parseInt(columns.get(7).text());
//                    System.out.println("HOME SCORE = " + columns.get(7).text());
                }
            }
            games.add(new NFLGame(awayTeamCode, homeTeamCode, seasonId, startTime, status, awayScore, homeScore));
        }
        return games;
    }
}
