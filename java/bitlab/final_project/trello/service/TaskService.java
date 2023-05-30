package bitlab.final_project.trello.service;

import bitlab.final_project.trello.models.Tasks;

import java.util.List;

public interface TaskService {

    void addTask(Tasks tasks);

    List<Tasks> findAllTasks(Long id);

    Tasks findById(Long id);

    void saveTasks(Tasks tasks);

    void deleteTask(Long id);
}
