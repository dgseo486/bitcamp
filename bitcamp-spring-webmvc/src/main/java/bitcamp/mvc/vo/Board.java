package bitcamp.mvc.vo;

import java.sql.Date;

public class Board {
    int no;
    String title;
    String content;
    Date createdDate;
    Member user;
    
    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate
                + ", user=" + user + "]";
    }
    public Member getUser() {
        return user;
    }
    public void setUser(Member user) {
        this.user = user;
    }
    public int getNo() {
        return no;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
