package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {

    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public void insert(Member member) {
        this.members[this.memberIndex++] = member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[this.memberIndex];
        for(int i = 0; i < this.memberIndex; i++) {
            arr[i] = this.members[i];
        }
        return arr;
    }
    
    public Member get(int i) {
        if(i < 0 || i >= this.memberIndex) {
            return null;
        }
        return this.members[i];
    }
    
    public int getMemberIndex (String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (id.equals(this.members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void update(int i, Member member) {
        this.members[i] = member;
    }
    
    public void delete(int i) {
        this.members[i] = null;
    }

}
