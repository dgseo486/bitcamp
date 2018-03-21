package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {

    Team[] teams = new Team[1000];
    int teamIndex = 0;

    public void insert(Team team) {
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.teamIndex];
        for(int i = 0; i < this.teamIndex; i++) {
            arr[i] = this.teams[i];
        }
        return arr;
    }
    
    public Team get(int i) {
        if(i < 0 || i >= this.teamIndex) {
            return null;
        }
        return this.teams[i];
    }
    
    public int getTeamIndex (String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void update(int i, Team team) {
        this.teams[i] = team;
    }
    
    public void delete(int i) {
        this.teams[i] = null;
    }

}
