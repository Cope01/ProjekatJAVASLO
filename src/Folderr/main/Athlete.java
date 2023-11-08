package Folderr.main;
import java.time.LocalDate;

public class Athlete implements Competition{
    private String name; //atributes
    private String surname;
    private int athleteNumber;
    private LocalDate dateOfBirth;
    private Discipline discipline;
    private Match[] listOfPersonalMatches = new Match[5];

    public Athlete(){ //non-args constructor

    }

    /**
     * parametarized constructor with name and surname
     * @param name
     * @param surname
     */
    public Athlete(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    /**
     * parametarized constructor with name,surname,athleteNumber,dateOfBirth
     * @param name
     * @param surname
     * @param athleteNumber
     * @param dateOfBirth
     */
    public Athlete(String name, String surname,int athleteNumber,LocalDate dateOfBirth,Discipline discipline){
        this(name,surname);
        this.athleteNumber=athleteNumber;
        this.dateOfBirth=dateOfBirth;
        this.discipline=discipline;
    }
    public Discipline getDiscipline() {
        return discipline;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline=discipline;
    }
    public String getName(){//getter

        return name;
    }
    public void setName(String name){//setter
        this.name=name;
    }
    public String getSurname(){

        return name;
    }
    public void setSurname(String surname) throws  java.lang.IllegalArgumentException{

        this.surname=surname;
    }
    public int getAthleteNumber(){

        return athleteNumber;
    }
    public void setAthleteNumber(int athleteNumber) throws  java.lang.IllegalArgumentException{

        this.athleteNumber=athleteNumber;
    }
    public LocalDate getDateOfBirth(){

        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) throws  java.lang.IllegalArgumentException{

        this.dateOfBirth=dateOfBirth;
    }
    public Match[] getListOfPersonalMatches(){
        return listOfPersonalMatches;
    }
    public void setListOfPersonalMatches(Match[] listOfPersonalMatches) throws  java.lang.IllegalArgumentException{
        this.listOfPersonalMatches=listOfPersonalMatches;
    }

    public void checkValidity(Venue venue) {
        for (int i = 0; i < venue.listOfMatches.length; i++) {
            if (venue.listOfMatches[i].athleteExists(getSurname())) {
                int c = listOfPersonalMatches.length;
                boolean MatchWasFound = false;
                for (int k = 0; k < c; k++) {
                    if (listOfPersonalMatches[k] == (venue.listOfMatches[i])) {
                        MatchWasFound = true;
                        break;
                    }
                }
                if (!MatchWasFound) {
                    for (int j = 0; j < listOfPersonalMatches.length; j++) {
                        if (listOfPersonalMatches[j] == null) {
                            listOfPersonalMatches[j] = venue.listOfMatches[i];
                            break;
                        }
                    }
                }
            }
        }
    }
    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return "Athlete [name=" + name + ", surname=" + surname + ", athleteNumber=" + athleteNumber + ", DateOfBirth=" + dateOfBirth +
        "]";
    }
}
