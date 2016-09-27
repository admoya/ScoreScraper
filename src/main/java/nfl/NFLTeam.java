package nfl;

/**
 * Created by Adrian on 9/26/2016.
 */
public class NFLTeam {
    private int teamId;
    private String city;
    private String nickname;
    private String conference;
    private String division;
    private String cityAndName;

    public NFLTeam(int teamId, String city, String nickname, String conference, String division) {
        this.teamId = teamId;
        this.city = city;
        this.nickname = nickname;
        this.conference = conference;
        this.division = division;
        this.cityAndName = city + " " + nickname;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCityAndName() {
        return cityAndName;
    }

    public void setCityAndName(String cityAndName) {
        this.cityAndName = cityAndName;
    }
}
