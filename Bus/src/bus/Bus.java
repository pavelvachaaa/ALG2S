/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bus;

/**
 *
 * @author pavli
 */
public class Bus {

    private int numOfSeats;
    private String company;
    private Line assignedLine;
    private int currentNumOfPassangers;

    public Bus(int numOfSeats, String company, Line assignedLine) {
        if (this.numOfSeats < 0) {
            throw new IllegalArgumentException("Jak chceš mít autobus se záporným počtem míst???");
        }

        this.numOfSeats = numOfSeats;
        this.company = company;
        this.assignedLine = assignedLine;
        this.currentNumOfPassangers = 0;
    }

    public Bus() {
        this(40, "", null);
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getCompany() {
        return company;
    }

    public Line getAssignedLine() {
        return assignedLine;
    }

    public int getCurrentNumOfPassangers() {
        return currentNumOfPassangers;
    }

    public int getOnTheBus(int numOfPassangers) {
        if (numOfPassangers < 0) {
            throw new IllegalArgumentException("Nemůže nastoupit záporný počet lidí");
        }

        if (this.currentNumOfPassangers + numOfPassangers > this.numOfSeats) {
            numOfPassangers = this.numOfSeats - this.currentNumOfPassangers;
        }

        this.currentNumOfPassangers += numOfPassangers;
        return numOfPassangers;
    }

    public int getOffTheBus(int numOfPassangers) {
        if (numOfPassangers < 0) {
            throw new IllegalArgumentException("Nemůže nastoupit záporný počet lidí");
        }

        if (numOfPassangers > this.currentNumOfPassangers) {
            numOfPassangers = this.currentNumOfPassangers;
        }

        this.currentNumOfPassangers -= numOfPassangers;
        return numOfPassangers;
    }

    public void emptyTheBus() {
        this.getOffTheBus(this.currentNumOfPassangers);
    }

    @Override
    public String toString() {
        return String.format("Autobus číslo %s společnosti %s s počtem sedadel %d veze %d cestujících", this.assignedLine.getNumber(), this.company, this.numOfSeats, this.currentNumOfPassangers);
    }

}
