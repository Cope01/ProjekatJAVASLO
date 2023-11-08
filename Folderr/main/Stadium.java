package Folderr.main;

public class Stadium extends Venue{
    public Stadium(String name, int phoneNumber, int listOfMatches, Discipline discipline) {
        super(name, phoneNumber, listOfMatches, discipline);
    }
    public int getCapacity(){
        return listOfMatches.length;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
