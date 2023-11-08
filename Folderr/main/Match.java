package Folderr.main;


import Folderr.EverythingElse.Schedule;

import java.time.LocalDateTime;

public class Match extends Event implements Competition{
    private Athlete[] athletesList = new Athlete[10];
    public Match(){             //non-args constructor
    }

    /**
     * Parametarized constructor which has name and schedule
     * @param name
     * @param schedule
     */
    public Match(String name, Schedule schedule){

        super(name, schedule);
    }
    /**
     * canCompete method which sees if the athlete is the desired age to compete in the match
     * @param athlete
     * @return
     */
    public boolean canCompete(Athlete athlete){

        LocalDateTime dateOfBirth = athlete.getDateOfBirth().atStartOfDay();
        LocalDateTime currentDate = LocalDateTime.now();

        //aiy age in years, aim age in months, aid age in days
        int aiy =currentDate.getYear()-dateOfBirth.getYear();
        int aim = currentDate.getMonthValue()-dateOfBirth.getMonthValue();
        int aid=currentDate.getDayOfMonth()-dateOfBirth.getDayOfMonth();

        if (aiy <=18 && aiy >= 14){
            if (aiy == 14){
                if (aim > 0 || (aim == 0 && aid >= 0)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else
                if (aiy == 18){
                    if (aim < 0 || (aim == 0 && aid <= 0)) {
                        return true;
                    }
                    else{
                        return false;
                    }
            }
                else{
                    return true;
            }
        }
        else{
            return false;
        }
    }

    /**
     * method addAthleteToMatch which goes through the loop to see if there are any free spots left and if there is a free spot it adds athlete there and finishes and
     * if there is no free spots it prints out a message
     * @param athlete
     */
    public void addAthleteToMatch(Athlete athlete) throws AddingAthleteException {
        int i;
        if(canCompete(athlete)){
        for(i = 0; i <= 9; i++) {
            if(athletesList[i] == null) {
                athletesList[i] = athlete;
                break;
            }
        }
        if(i == 10){
            System.out.println("There are no more spots left for the match, either remove an athlete or don't add a new one");
        }}
        else throw new AddingAthleteException("The athlete is too young or too old");
    }

    /**
     * method removeAthleteFromTheMatch which removes athlete, it looks for the athlete in the loop and then sets it to null
     * @param athlete
     */
    public void removeAthleteFromTheMatch(Athlete athlete){
        for(int i=0;i<=9;i++){
            if(athletesList[i] == athlete) {
                athletesList[i] = null;
            }
        }
    }

    /**
     *  method removeAthleteFromTheMatch which removes athlete based on the athlete number, ot looks in the loop if the parameter is not null so it can remove it
     *  and then it checks wheter the athlete number we wrote is the same as the athlete number in the loop and if it is it sets it to null
     * @param athleteNumber
     * @return
     */
    public boolean removeAthleteFromTheMatch(int athleteNumber){
        for(int i = 0; i <= 9; i++){
            if(athletesList[i] != null){
                if(athletesList[i].getAthleteNumber() == athleteNumber){
                    athletesList[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this method basically returns the number of athletes in the match by counting all the spots that are not null
     * @return
     */
    public int getNumberOfAthletesInMatch() {
        int br = 0;
        for(int i = 0; i <= 9; i++){
            if(athletesList[i] != null){
                br++;
            }
        }
        return br;
    }

    /**
     * this method checks if the athlete exists based on his surname
     * @param surname
     * * @return
     */
    public boolean athleteExists(String surname){
        for(int i = 0; i <= 9; i++) {
            if(athletesList[i] != null){
                if(athletesList[i].getSurname() == surname){
                    return true;
                }
            }
        }
        return false;
    }

    public void checkValidity(Venue venue) {
        for (int i = 0; i < venue.listOfMatches.length; i++) {
            if (venue.listOfMatches[i] == this){
                System.out.println("The match"+ this.getName() +"can take place");
                return;
            }
        }
        System.out.println("The match"+ this.getName() +"has not been adedd to the venue");
    }
    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}