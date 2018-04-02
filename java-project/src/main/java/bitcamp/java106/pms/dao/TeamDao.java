package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {

    private LinkedList<Team> collection = new LinkedList<>();

    public void insert(Team team) {
        this.collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.collection.size()];
        for(int i = 0; i < this.collection.size(); i++) {
            arr[i] = this.collection.get(i);
        }
        return arr;
    }
    
    public Team get(String name) {
        int i;
        if((i = this.getTeamIndex(name)) == -1) {
            return null;
        }
        return this.collection.get(i);
    }
    
    
    public void update(Team team) {
        int i;
        if((i = this.getTeamIndex(team.getName())) == -1) {
            return;
        }
        this.collection.set(i, team);
    }
    
    public void delete(String name) {
        int i;
        if((i = this.getTeamIndex(name)) == -1) {
            return;
        }
        this.collection.remove(i);
    }

    private int getTeamIndex (String name) {
        for (int i = 0; i < this.collection.size(); i++) {
            if ((this.collection.get(i)).getName().toLowerCase().equals(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
