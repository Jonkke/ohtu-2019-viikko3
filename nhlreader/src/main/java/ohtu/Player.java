
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String birthdate;
    private String nationality;
    private String team;
    private int goals;
    private int assists;
    private int penalties;

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getName() {
        return name;
    }
    
    public String toPointString() {
        String format = "%-24s%-10s%s";
        String points = goals + " + " + assists + " = " + (goals + assists);
        return String.format(format, name, team, points);
    }

    @Override
    public String toString() {
        return name + " DOB: " + birthdate +
                " nationality: " + nationality +
                " team: " + team +
                " goals: " + goals +
                " assists: " + assists +
                " penalties: " + penalties;
    }

    @Override
    public int compareTo(Player o) {
        return (this.goals + this.assists) - (o.goals + o.assists); 
    }
      
}
