package Folderr.main;

import Folderr.EverythingElse.Schedule;


public abstract class Venue extends Schedule {
    private String name; //atribute
    private int phoneNumber;
    public static Match[] listOfMatches;
    private Discipline discipline;

    private Venue(){ //non-argument constructor

    }

    /**
     * parametarized constructor with only name
     * @param name
     */
    private Venue(String name){
        this.name=name;
    }
    /**
     *   parametarized constructor with one parameter name and phoneNumber
     *   @param name
     *   @param phoneNumber
     *
     */
    public Venue(String name, int phoneNumber, int Matches, Discipline discipline) {
        this(name);
        this.phoneNumber = phoneNumber;
        this.listOfMatches = new Match[Matches];
        this.discipline=discipline;
    }
    public Discipline getDiscipline() {
        return discipline;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline=discipline;
    }
    public void addMatch(Match match) throws AddingMatchException{
            if ((this instanceof Stadium) && match.getSchedule().getDateTime().getHour() >= 20) {
                    throw new AddingMatchException("You cannot start a match after 20:00");
                }
                int i;
                for(i=0;i< listOfMatches.length;i++){
                    if(listOfMatches[i] == null){
                        listOfMatches[i] = match;
                        System.out.println("Added match");
                        break;
                    }
                }
                if(i == (listOfMatches.length+1)){
                    System.out.println("There is no more place for the match");
                }
    }
    public void removeMatch(Match match) throws  java.lang.IllegalArgumentException{
        for(int i=0;i< listOfMatches.length;i++){
            if(listOfMatches[i] == match) {
                listOfMatches[i] = null;
            }
        }
    }
    public double getOccupancy(){
        double br=0;
        for(int i=0;i < listOfMatches.length;i++){
            if(listOfMatches[i]!=null){
                br++;
            }
        }
        return (br / getCapacity());
    }
    public void addAthleteToMatch(Match match, Athlete athlete) throws AddingAthleteException, java.lang.IllegalArgumentException {
        if (!match.canCompete(athlete)) {
            throw new AddingAthleteException("Athlete is not allowed to compete");
        }
        match.addAthleteToMatch(athlete);
    }
    public abstract int getCapacity();


    /**
     * toString method
     * @return name
     * @return phoneNumber
     */
    @Override
    public String toString() {
        return "Venue [name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }
}
