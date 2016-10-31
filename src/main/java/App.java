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
        ScoresLineParser slp = new ScoresLineParser(teams);
        slp.getGames();
//        NFLSeason thisSeason = new NFLSeason(NFLSeason.getCurrentSeasonId(), NFLSeason.getCurrentYear());
//        NFLParser np = new NFLParser(teams);
//        ArrayList<NFLGame> games = np.getGames();
//        dao.clearGames();
//
//        for (NFLGame game : games){
//            System.out.println(game.toString());
//            dao.insertGame(game);
//        }

    }

}