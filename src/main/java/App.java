import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import nfl.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import utils.HTMLFetcher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Adrian on 8/20/2016.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        NFLDao dao = new NFLDao("localHost", 3306, "nfl", "root", "gerby1");
        ArrayList<NFLTeam> teams = dao.getTeams();
        NFLSeason thisSeason = new NFLSeason(getCurrentSeasonId(), getCurrentYear());
       // System.out.println(thisSeason.getSeasonId() + " " + thisSeason.getYear());
//        for (NFLTeam team : teams){
//            System.out.println(team.getTeamId());
//        }

        ArrayList<NFLGame> games = ScoresParser.getGames(teams);
        for (NFLGame game : games){
//            System.out.println(game.getAwayTeam() +  " vs " + game.getHomeTeam());
            System.out.println(getTeam(teams, game.getAwayTeam()).getNickname() + " " + game.getAwayScore() + "\n" + getTeam(teams, game.getHomeTeam()).getNickname() + " " + game.getHomeScore() + "\n");
        }
//        for (NFLTeam team : teams){
//            System.out.println(team.getCityAndName());
//        }

//        MysqlDataSource ds = new MysqlDataSource();
//        ds.setUser("root");
//        ds.setPassword("gerby1");
//        ds.setServerName("localhost");
//        ds.setDatabaseName("nfl");
//        ds.setPort(3306);
//
//        Connection conn = ds.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM TEAMS");
//        while(rs.next()){
//            System.out.println(rs.getString(2));
//        }
//
//
//        rs.close();
//        stmt.close();
//        conn.close();



//        Document NFLScores = HTMLFetcher.fetch("http://www.scores.com/nfl/scores/");
//        for (Element game : NFLScores.getElementsByClass("scoreboard")){
//            System.out.println("----------------------------------------------\n");
//            Elements rows = game.select("tr");
//            rows.remove(0);
//            Element winner = game.getElementsByClass("winner").get(0);
//            String gameRecap = "";
//            for (Element row : rows){
//                //System.out.println(row.toString());
////                if (!row.getElementsByClass("winner").isEmpty())
////                    gameRecap += "Winner: ";
//                Elements columns = row.select("td");
//                gameRecap += columns.get(0).text() + " - " + columns.get(7).text() + "\n";
//            }
//            System.out.println(gameRecap);
//            System.out.println("----------------------------------------------\n");
//        }

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

    private static NFLTeam getTeam(ArrayList<NFLTeam> teams, int code){
        for (NFLTeam team : teams){
            if (code == team.getTeamId())
                return team;
        }
        return null;
    }
}