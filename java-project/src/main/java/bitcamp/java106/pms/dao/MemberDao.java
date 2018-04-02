package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {

    private LinkedList<Member> collection = new LinkedList<>();

    public void insert(Member member) {
        this.collection.add(member);
    }

    public Member[] list() {
        Member[] arr = new Member[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) {
            arr[i] = this.collection.get(i);
        }
        return arr;
    }

    public Member get(String id) {
        int index = this.getMemberIndex(id);
        if(index < 0) {
            return null;
        }
        return this.collection.get(index);
    }

    public void update(Member member) {
        int index = this.getMemberIndex(member.getId());
        if(index < 0) {
            return;
        }
        this.collection.set(index, member);
    }

    public void delete(String id) {
        int index = this.getMemberIndex(id);
        if(index < 0) {
            return;
        }
        this.collection.remove(index);
    }
    
    private int getMemberIndex(String id) {
        for (int i = 0; i < this.collection.size(); i++) {
            Member member = collection.get(i);
            if(member.getId().toLowerCase().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
