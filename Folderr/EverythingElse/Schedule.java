package Folderr.EverythingElse;

import java.time.LocalDateTime;
public class Schedule{
    private LocalDateTime dateTime; //atributes

    public Schedule(){ //no-args constructor

    }

    /**
     *
     * @param dateTime
     */
    public Schedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return "si.feri.opj.Urosevic.EverythingElse.Schedule [dateTime=" + dateTime + "]";
    }
}
