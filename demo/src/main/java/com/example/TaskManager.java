package com.example;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> listOfTasks;
    private String taskName;
    private int time;

    public TaskManager(){
        listOfTasks = new ArrayList<>();
    }

    // Adding tasks to a list 
    public void addTasks(Task task){
        if(this.checkIfTasksExist(task)){
            System.out.println("This tasks already exists, please enter a different task");
        }else{
            listOfTasks.add(task);
        }
    }

    public boolean checkIfTasksExist(Task task){
        return listOfTasks.contains(task);
    }

    public void removeTask(Task task){
        listOfTasks.remove(task);
    }
    
    public void viewTask(){
        for(Task task : listOfTasks){
            System.out.println(task.getName());
            System.out.println(task.getTime());
        }
    }

}
