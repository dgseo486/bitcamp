package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.Annotation.Component;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
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
