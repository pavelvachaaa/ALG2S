/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import java.util.ArrayList;

/**
 *
 * @author pavli
 */
public class Line {

    private final int number;
    private final ArrayList<Station> stations;

    public Line(int number, ArrayList<Station> stations) {
        this.number = number;
        this.stations = stations;
    }

    public int getNumber() {
        return this.number;
    }

    public ArrayList<Station> getStations() {
        return this.stations;
    }
    
    
    @Override
    public String toString() {
        return String.format("Linka %d", this.number);
    }

}
