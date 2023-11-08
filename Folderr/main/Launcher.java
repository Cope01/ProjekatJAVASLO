package Folderr.main;

import Folderr.EverythingElse.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class Launcher{
    public static void main(String[] args){

        //Default constructor
        Athlete athlete1 = new Athlete();
        athlete1.setName("Lionel");
        athlete1.setSurname("Messi");
        athlete1.setDateOfBirth(LocalDate.of(2006,3,26));

        //Parametarized constructors

        Schedule schedule =new Schedule(LocalDateTime.of(2023, 4, 24, 14, 0));

        Training training= new Training("Cardio",new Schedule(LocalDateTime.of(2023, 5, 21, 17, 0)));
        training.setSchedule(schedule);
        training.setTrainerName("Piksi");

        //Football match
        Match Football = new Match("Champions League Final",schedule);
        Match Football2 = new Match("Champions League Final",schedule);
        boolean canCompete=Football.canCompete(athlete1);
        System.out.println(canCompete);
        System.out.println(athlete1.getName());

        Athlete athlete2 = new Athlete("Name1", "Surname1", 1 ,LocalDate.of(2007,10,20), Discipline.JUDO);
        Athlete athlete3 = new Athlete("Name2", "Surname2", 2 ,LocalDate.of(2005,5,20),Discipline.JUDO);
        Athlete athlete4 = new Athlete("Name3", "Surname3", 3 ,LocalDate.of(2006,7,11),Discipline.VOLLEYBALL);

        try {
            Football.addAthleteToMatch(athlete2);
            Football.addAthleteToMatch(athlete3);
            Football.addAthleteToMatch(athlete4);
        } catch (AddingAthleteException e) {
            e.printStackTrace();
        }

        Football.removeAthleteFromTheMatch(athlete4);

        Football.removeAthleteFromTheMatch(1);

        System.out.println(Football.getNumberOfAthletesInMatch());

        boolean athleteExists = Football.athleteExists("Surname2");

        Stadium stadium1 = new Stadium("Stadium1", 123456789,3,Discipline.JUDO);
        Hall hall1 = new Hall(3,"Hall1",123456789,2,Discipline.ATHLETICS);
        System.out.println(stadium1.getCapacity());
        System.out.println(hall1.getCapacity());

        System.out.println(stadium1.getOccupancy());

        System.out.println(hall1.getOccupancy());

        Schedule scheduleJudoMatch =new Schedule(LocalDateTime.of(2023, 4, 25, 16, 0));
        Match JudoMatch = new Match("World championship", scheduleJudoMatch);

        Schedule scheduleJudoMatch2 =new Schedule(LocalDateTime.of(2023, 4, 25, 21, 0));
        Match JudoMatch2 = new Match("European championship", scheduleJudoMatch2);
        try {
            JudoMatch2.addAthleteToMatch(athlete1);
        } catch (AddingAthleteException e) {
            e.printStackTrace();
        }
        Stadium stadium2 = new Stadium("Stadium2", 123456789,5,Discipline.JUDO);
        Stadium stadium3 = new Stadium("Stadium3", 326597879,5,Discipline.JUDO);

        Hall hall2 = new Hall(5,"Hall2",123156789,2,Discipline.JUDO);
        Hall hall3 = new Hall(5,"Hall3",333356789,2,Discipline.JUDO);

        try {
            stadium3.addMatch(JudoMatch2);
            stadium3.addMatch(JudoMatch);
            stadium2.addMatch(JudoMatch2);
        } catch (AddingMatchException e){
            e.printStackTrace();
        }

        try {
            hall3.addMatch(JudoMatch2);
            hall2.addMatch(JudoMatch);
        } catch (AddingMatchException e) {
            e.printStackTrace();
        }


        JudoMatch2.checkValidity(hall2);
        JudoMatch.checkValidity(stadium2);
        JudoMatch2.checkValidity(stadium3);
        JudoMatch.checkValidity(stadium3);

        athlete1.checkValidity(stadium3);
        athlete1.checkValidity(stadium3);
        athlete2.checkValidity(stadium2);
        System.out.println(athlete1.toString());
    }
}
