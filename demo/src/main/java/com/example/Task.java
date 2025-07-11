package com.example;
public class Task {

    private String taskName;
    private String time;


    // Builder task to create option of creating Tasks that have needs to be completed at a certain time
    public Task(Builder builder){
        this.taskName = builder.taskName;
        this.time = builder.time; 
    }

    public static class Builder{

        private String taskName;
        private String time; 

        public Builder(String taskName){  // Task name is mandatory 
            this.taskName = taskName;
        }

        public Builder addTime(String time){  // Option variable : time to be completed in 24hrs format
            this.time = time;
            return this;
        }

        public Task build(){  // Command to create specific task
            return new Task(this);
        }
    
    }

    public String getName(){  // Returns name of Task
        return this.taskName;
    }

    public String getTime() {  // Returns time of Task
        if (this.time == null) { 
            System.out.println("There is no deadline");
        }
        return this.time;
    }

    public boolean checkTimeFormat(String time){
        return (time.matches("\\d{4}"));
    }

    public void setTime(String time){   // If user wants to set the time after creation of task
        if(checkTimeFormat(time)){
            this.time = time;
            System.out.println("Time has been set to " + time);
        } else {
            System.out.println("Invalid time format. Please enter time in the format of \"0000\"");
        }
    }

}
