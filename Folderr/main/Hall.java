package Folderr.main;

public class Hall extends Venue{
    private int numberOfAdditionalHalls;

    public Hall(int numberOfAdditionalHalls, String name, int phoneNumber, int Matches, Discipline discipline){
        super(name,phoneNumber,Matches,discipline);
        this.numberOfAdditionalHalls=numberOfAdditionalHalls;
    }
    public int getNumberOfAdditionalHalls() {
        return numberOfAdditionalHalls;
    }

    public void setNumberOfAdditionalHalls(int numberOfAdditionalHalls) {
        this.numberOfAdditionalHalls = numberOfAdditionalHalls;
    }
    public int getCapacity(){
        return listOfMatches.length + numberOfAdditionalHalls;
    }
    @Override
    public String toString() {

        return super.toString();
    }
}
