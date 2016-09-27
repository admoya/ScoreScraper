package nfl;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Adrian on 8/20/2016.
 */
public class NFLGame {
    private int awayTeam;
    private int homeTeam;
    private int season;
    private LocalDateTime startTime;
    private String status;
    private int awayScore;
    private int homeScore;
    private String quarter;

    public NFLGame(int awayTeam, int homeTeam, int season, LocalDateTime startTime, String status, int awayScore, int homeScore, String quarter) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.season = season;
        this.startTime = startTime;
        this.status = status;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
        this.quarter = quarter;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
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

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
