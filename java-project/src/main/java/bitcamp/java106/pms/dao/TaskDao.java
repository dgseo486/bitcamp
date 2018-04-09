package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TaskDao extends AbstractDao<Task> {
    
    public TaskDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/task.csv"));
        
        while(true) {
            try {
                String[] arr = in.nextLine().split(",");
                Task task = new Task(null);
                task.setNo(Integer.parseInt(arr[0]));
                task.setTitle(arr[1]);
                task.setStartDate(Date.valueOf(arr[2]));
                task.setEndDate(Date.valueOf(arr[3]));
                task.setState(Integer.parseInt(arr[4]));
                task.setTeam(new Team(arr[5]));
                task.setWorker(new Member(arr[6]));
                this.insert(task);
            } catch(Exception e) {
                break;
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/task.csv"));
        
        Iterator<Task> tasks = this.list();
        
        while(tasks.hasNext()) {
            Task task = tasks.next();
            out.printf("%d,%s,%s,%s,%d,%s,%s", task.getNo(), task.getTitle(), task.getStartDate(), task.getEndDate(), 
                    task.getState(), task.getTeam().getName(), task.getWorker().getId());
        }
        out.close();
    }
    
    public Iterator<Task> list(String teamName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                tasks.add(task);
            }
        }
        return tasks.iterator();
    }
    
    public int indexOf(Object key) {
        int index = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Task task = collection.get(i);
            if (task.getNo() == index) {
                return i;
            }
        }
        return -1;
    }
}
