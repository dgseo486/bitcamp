package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    private static int count = 1;
    
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
    
    public Task(Team team) {
        this.team = team;
        this.no = count++;
    }
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        this(team);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getState() {
        return state;
    }

    public Member getWorker() {
        return worker;
    }

    public Team getTeam() {
        return team;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setWorker(Member worker) {
        this.worker = worker;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
}
