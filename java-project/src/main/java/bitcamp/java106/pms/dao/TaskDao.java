package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TaskDao extends AbstractDao<Task> {
    
    public TaskDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        try (ObjectInputStream in = 
                new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/task.data")));) {
            while(true) {
                try {
                    Task task = (Task) in.readObject();
                    if (task.getNo() >= Task.count) {
                        Task.count = task.getNo() + 1; 
                    }
                    this.insert(task);
                } catch(Exception e) {
                    break;
                }
            }
        }
    }
    
    public void save() throws Exception {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/task.data")));) {
            Iterator<Task> tasks = this.list();
            
            while(tasks.hasNext()) {
                out.writeObject(tasks.next());
            }
        }
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
