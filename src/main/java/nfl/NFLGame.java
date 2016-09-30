package nfl;

import java.time.LocalDateTime;

/**
 * Created by Adrian on 8/20/2016.
 */
public class NFLGame {
    private int awayTeamCode;
    private int homeTeamCode;
    private int seasonId;
    private LocalDateTime startTime;
    private String status;
    private int awayScore;
    private int homeScore;

    public NFLGame(int awayTeamCode, int homeTeamCode, int seasonId, LocalDateTime startTime, String status, int awayScore, int homeScore) {
        this.awayTeamCode = awayTeamCode;
        this.homeTeamCode = homeTeamCode;
        this.seasonId = seasonId;
        this.startTime = startTime;
        this.status = status;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
    }

    public int getAwayTeamCode() {
        return awayTeamCode;
    }

    public void setAwayTeamCode(int awayTeamCode) {
        this.awayTeamCode = awayTeamCode;
    }

    public int getHomeTeamCode() {
        return homeTeamCode;
    }

    public void setHomeTeamCode(int homeTeamCode) {
        this.homeTeamCode = homeTeamCode;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public String toString(){
        String retVal = "Season: " + Integer.toString(seasonId) + "\n";
        retVal += "Away Team Code: " + Integer.toString(awayTeamCode) + "\n";
        retVal += "Home Team Code: " + Integer.toString(homeTeamCode) + "\n";
        retVal += "Start Time: " + startTime.toString() + "\n";
        retVal += "Status: " + status + "\n";
        retVal += "Away Score: " + Integer.toString(awayScore) + "\n";
        retVal += "Home Score: " + Integer.toString(homeScore) + "\n";

        return retVal;
    }

}
