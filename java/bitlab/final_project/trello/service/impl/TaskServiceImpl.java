package bitlab.final_project.trello.service.impl;

import bitlab.final_project.trello.models.Tasks;
import bitlab.final_project.trello.repositories.TaskRep;
import bitlab.final_project.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRep taskRep;

    @Override
    public void addTask(Tasks tasks) {
        taskRep.save(tasks);
    }

    @Override
    public List<Tasks> findAllTasks(Long id) {
        return taskRep.findAllByFoldersId(id);
    }

    @Override
    public Tasks findById(Long id) {
        return taskRep.findById(id).orElseThrow();
    }

    @Override
    public void saveTasks(Tasks tasks) {
        taskRep.save(tasks);
    }

    @Override
    public void deleteTask(Long id) {
        taskRep.deleteById(id);
    }
}