package step25.ex9;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    int no;
    String title;
    String content;
    Date registeredDate;
    
    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", registeredDate=" + registeredDate
                + "]";
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
    public Date getRegisteredDate() {
        return registeredDate;
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
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    
}
