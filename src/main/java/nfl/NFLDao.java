package nfl;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Adrian on 9/26/2016.
 */
public class NFLDao {
    private DataSource ds;

    public NFLDao(DataSource ds){
        this.ds = ds;
    }

    //Initializes MySQL DataSource
    public NFLDao(String serverName, int port, String dbName, String userName, String password){
        MysqlDataSource tmpDs = new MysqlDataSource();
        tmpDs.setServerName(serverName);
        tmpDs.setPort(port);
        tmpDs.setDatabaseName(dbName);
        tmpDs.setUser(userName);
        tmpDs.setPassword(password);

        this.ds = tmpDs;
    }

    public ArrayList<NFLTeam> getTeams() throws SQLException {
        ArrayList<NFLTeam> teams = new ArrayList<NFLTeam>();
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TEAMS");

        while (rs.next()){
            NFLTeam team = new NFLTeam(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            teams.add(team);
        }

        rs.close();
        stmt.close();
        conn.close();
        return teams;
    }
}
