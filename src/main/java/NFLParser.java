import org.jsoup.nodes.Document;
import resource.NFLGame;

import java.util.ArrayList;

/**
 * Created by Adrian on 8/20/2016.
 */
public class NFLParser {
    private final String NFLScoresURL = "http://www.espn.com/nfl/scoreboard";
    private Document NFLScoreboard;
    public NFLParser(){
        this.NFLScoreboard = HTMLFetcher.fetch(NFLScoresURL);
    }

    public ArrayList<NFLGame> getGames(){

    return null;
    }
}
