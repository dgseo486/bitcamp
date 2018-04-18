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
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
    public ClassroomDao() throws Exception {
        this.load();
    }
    
    public void load() throws Exception {
        try (ObjectInputStream in = 
                new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/classroom.data")));) {
            while(true) {
                try {
                    Classroom classroom = (Classroom) in.readObject();
                    if (classroom.getNo() >= Classroom.count) {
                        Classroom.count = classroom.getNo() + 1; 
                    }
                    this.insert(classroom);
                } catch(Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() throws Exception {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/classroom.data")));) {
            Iterator<Classroom> classrooms = this.list();
            
            while(classrooms.hasNext()) {
                out.writeObject(classrooms.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int indexOf(Object key) {
        int index = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getNo() == index) {
                return i;
            }
        }
        return -1;
    }
}
