package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Task;

public interface TaskService {
    List<Task> list(String teamName, int pageNo, int pageSize);
    Task get(int no);
    int add(Task task);
    int update(Task task);
    int delete(int no);
}