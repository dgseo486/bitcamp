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
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TeamDao extends AbstractDao<Team> {
    
    public TeamDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        try (ObjectInputStream in = 
                new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/team.data")));) {
            while(true) {
                try {
                    this.insert((Team) in.readObject());
                } catch(Exception e) {
                    break;
                }
            }
        }
    }
    
    public void save() throws Exception {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/team.data")));) {
            Iterator<Team> teams = this.list();
            
            while(teams.hasNext()) {
                out.writeObject(teams.next());
            }
        }
    }
    
    public int indexOf(Object key) {
        String name = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            if (name.equalsIgnoreCase(collection.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

}
