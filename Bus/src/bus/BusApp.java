/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pavli
 */
public class BusApp {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Line line1 = new Line(15, new ArrayList<Station>() {
            {
                add(new Station("Fugnerova"));
                add(new Station("Šaldovo náměstí"));
                add(new Station("Poliklinika", true));
                add(new Station("Husova"));
                add(new Station("Technická univerzita"));
            }
        });

        Bus bus1 = new Bus(41, "DPMLJ", line1);

        int i = 1;
        ArrayList<Station> lineStations = line1.getStations();
        int numOfStations = lineStations.size();
        int nPassangersIn, nPassangersOut, realNIn, realNOut;

        for (Station station : lineStations) {

            if (i == numOfStations) {
                System.out.printf("%d. %s - konečná, prosím, všichni vystupte\n", i, station);
                System.out.println(bus1);
                bus1.emptyTheBus();
                System.out.println(bus1);
                continue;
            }

            System.out.printf("%d. %s\n%s\n============== \n", i, station, bus1);

            if (station.getIsOnSign()) {
                sc.nextLine();
                System.out.println("Zmáčknul někdo STOP? (a/n)");
                if (InputUtils.readString(sc).toLowerCase().charAt(0) == 'n') {
                    i++;
                    continue;
                }
            }

            System.out.println("Zadejte kolik lidí chce vystoupit a nastoupit:");
            while (((nPassangersOut = InputUtils.readInt(sc)) < 0 | (nPassangersIn = InputUtils.readInt(sc)) < 0)) {
                System.out.println("Zadejte kolik lidí chce vystoupit a nastoupit:");
            }

            realNOut = bus1.getOffTheBus(nPassangersOut);
            realNIn = bus1.getOnTheBus(nPassangersIn);

            if (realNIn != nPassangersIn) {
                System.out.printf("Mohlo nastoupit jen %d lidí\n", realNIn);
            }
            if (realNOut != nPassangersOut) {
                System.out.printf("Vystoupilo %d lidí\n", realNOut);
            }

            System.out.println("");
            i++;
        }

    }

}
