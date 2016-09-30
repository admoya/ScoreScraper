package nfl;

import java.time.LocalDate;

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

    public static int getCurrentSeasonId(){
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        int code = (year % 2016) + 1;

        if (month < 7)
            code--;

        return code;
    }

    public static String getCurrentYear(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        return Integer.toString(year);
    }
}
