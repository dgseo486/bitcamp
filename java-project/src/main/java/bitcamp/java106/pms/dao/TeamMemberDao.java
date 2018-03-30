package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.util.ArrayList;

public class TeamMemberDao {
    
    private ArrayList teamCollection = new ArrayList();
    private ArrayList memberCollection = new ArrayList();
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase();
        String pmi = memberId.toLowerCase();
        for(int i = 0; i < teamCollection.size(); i++) {
            String tn = this.teamCollection.get(i).toString().toLowerCase();
            String mi = this.memberCollection.get(i).toString().toLowerCase();
            if(tn.equals(ptn) && mi.equals(pmi)) {
                return i;
            }
        }
        return -1;
    }
    
    public int addMember(String teamName, String memberId) {
        if(this.isExist(teamName, memberId)) {
            return 0;
        }
        this.teamCollection.add(teamName);
        this.memberCollection.add(memberId);
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if(index < 0) {
            return 0;
        }
        this.teamCollection.remove(index);
        this.memberCollection.remove(index);
        return 1;
    }
    
    public boolean isExist(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        if(index < 0) {
            return false;
        } else {
            return true;
        }
    }

    private int getMemberCount(String teamName) {
        int cnt = 0;
        String ptn = teamName.toLowerCase();
        for(int i = 0; i < this.teamCollection.size(); i++) {
            String tn = (this.teamCollection.get(i).toString()).toLowerCase();
            if(tn.equals(ptn)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    //((String)this.teamCollection.get(i)).toLowerCase() = this.teamCollection.get(i).toString()
    
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[getMemberCount(teamName)];
        
        for(int i = 0, x = 0; i < this.teamCollection.size(); i++) {
            String tn = ((String)this.teamCollection.get(i)).toLowerCase();
            if(tn.equals(ptn)) {
                members[x++] = this.memberCollection.get(i).toString();
            }
        }
        return members;
    }
    
}
