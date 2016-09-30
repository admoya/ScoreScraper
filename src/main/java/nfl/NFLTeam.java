package nfl;

import java.util.ArrayList;

/**
 * Created by Adrian on 9/26/2016.
 */
public class NFLTeam {
    private int teamId;
    private String city;
    private String nickname;
    private String conference;
    private String division;

    public NFLTeam(int teamId, String city, String nickname, String conference, String division) {
        this.teamId = teamId;
        this.city = city;
        this.nickname = nickname;
        this.conference = conference;
        this.division = division;
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

    public static int getTeamCode (ArrayList<NFLTeam> teams, String nickname){
        int retval = -1;
        //System.out.println("----" + cityAndName);
        switch(nickname){
//            case "St. Louis Rams":
//                nickname = "Los Angeles Rams";
//                break;
            case "Bucs":
                nickname = "Buccaneers";
                break;

        }
        for (NFLTeam team : teams){
            //System.out.println("----------" +team.getCityAndName() + " " + team.getTeamId());
            if (nickname.equals(team.getNickname())) {
//                System.out.println(cityAndName + " matched " + team.getCityAndName());
                retval = team.getTeamId();
//                System.out.println("--Returning: " + retval);
                return retval;
            }
        }
        System.out.println(nickname + " DID NOT MATCH");
        return retval;
    }


    public static NFLTeam getTeam(ArrayList<NFLTeam> teams, int code){
        for (NFLTeam team : teams){
            if (code == team.getTeamId())
                return team;
        }
        return null;
    }

    public static String getTeamNickname(ArrayList<NFLTeam> teams, int code){
        for (NFLTeam team : teams){
            if (code == team.getTeamId())
                return team.getNickname();
        }
        return null;
    }
}
