package Folderr.main;

import Folderr.EverythingElse.Schedule;

public class Event {
    private String name ; //atributes
    private static Schedule schedule;
    private boolean cancelled;
    public Event(){}
    public Event(String name, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", cancelled=" + cancelled +
                '}';
    }
}
