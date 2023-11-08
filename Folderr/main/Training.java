package Folderr.main;

import Folderr.EverythingElse.Schedule;

public class Training extends Event{
    private String trainerName;

    public Training(){

    }

    /**
     * parametarized constructor with name
     * @param name
     */
    public Training(String name, Schedule schedule){

        super(name, schedule);
    }
    public String getTrainerName(){

    return trainerName;
    }
    public void setTrainerName(String trainerName){

        this.trainerName=trainerName;
    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + ", trainerName=" + trainerName;
    }
}
