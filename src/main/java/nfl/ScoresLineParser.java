package nfl;

import org.jsoup.nodes.Document;
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
