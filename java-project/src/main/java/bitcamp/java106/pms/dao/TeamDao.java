package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.ArrayList;

public class TeamDao {

    ArrayList collection = new ArrayList();

    public void insert(Team team) {
        this.collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.collection.size()];
        for(int i = 0; i < this.collection.size(); i++) {
            arr[i] = (Team)this.collection.get(i);
        }
        return arr;
    }
    
    public Team get(String name) {
        int index = this.getTeamIndex(name);
        if(index < 0) {
            return null;
        }
        return (Team)this.collection.get(index);
    }
    
    
    public void update(Team team) {
        int index = this.getTeamIndex(team.getName());
        if(index < 0) {
            return;
        }
        this.collection.set(index, team);
    }
    
    public void delete(String name) {
        int index = this.getTeamIndex(name);
        if(index < 0) {
            return;
        }
        this.collection.remove(index);
    }

    private int getTeamIndex (String name) {
        for (int i = 0; i < this.collection.size(); i++) {
            Team team = (Team)this.collection.get(i);
            if (team.getName().toLowerCase().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
