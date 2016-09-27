package nfl;

/**
 * Created by Adrian on 9/26/2016.
 */
public class NFLSeason {
    private int seasonId;
    private String year;

    public NFLSeason(int seasonId, String year) {
        this.seasonId = seasonId;
        this.year = year;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
