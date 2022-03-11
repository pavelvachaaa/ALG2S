/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

/**
 *
 * @author pavli
 */
public class Station {

    private String name;
    private boolean isOnSign;

    public Station(String name, boolean isOnSign) {
        this.isOnSign = isOnSign;
        this.name = name;
    }

    public Station(String name) {
        this(name, false);
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsOnSign() {
        return this.isOnSign;
    }

    @Override
    public String toString() {
        if (this.isOnSign) {
            return String.format("Zastávka na znamení %s", this.name);
        }

        return String.format("Zastávka %s", this.name);
    }

}
