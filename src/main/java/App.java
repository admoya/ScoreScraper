import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Adrian on 8/20/2016.
 */
public class App {
    public static void main(String[] args) {
        Document NFLScores = HTMLFetcher.fetch("http://www.cbssports.com/nfl/scoreboard");
        Elements scoreboxes = NFLScores.getElementsByClass("scoreBox");
        for (Element scorebox : scoreboxes){
            if(scorebox.getElementsByClass("awayTeam").size() == 0){
                continue;
            }
            //Element gameDate = scorebox.getElementsByClass("gameDate").get(0);
            Element gameStatus = scorebox.getElementsByClass("gameStatus").get(0);

            Element awayTeam = scorebox.getElementsByClass("awayTeam").get(0);
            Element homeTeam = scorebox.getElementsByClass("homeTeam").get(0);

            Element awayTeamInfo = awayTeam.getElementsByClass("teamLocation").get(0);
            String awayTeamLocation = awayTeamInfo.getElementsByTag("a").text();
            String awayTeamScore = awayTeam.getElementsByClass("finalScore").text();

            Element homeTeamInfo = homeTeam.getElementsByClass("teamLocation").get(0);
            String homeTeamLocation = homeTeamInfo.getElementsByTag("a").text();
            String homeTeamScore = homeTeam.getElementsByClass("finalScore").text();

            System.out.println(awayTeamLocation + " " + awayTeamScore);
            System.out.println(homeTeamLocation + " " + homeTeamScore);
            System.out.println(gameStatus.text());
            //System.out.println(gameDate.text());
            System.out.println("------------------------");
        }
    }
}
