/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneybox;

/**
 *
 * @author pavel.vacha
 */
public class MoneyBoxApp {

    public static void main(String[] args) {
        MoneyBox p = new MoneyBox("Alice", 1, 2);
        MoneyBox p2 = new MoneyBox("Bob");

        p2.addCrown();
        p2.addCrown();

        p2.addtwoCrowns();
        p2.addtwoCrowns();
        p2.addtwoCrowns();

        p2.addMoney(5, 10);

        System.out.printf("Alice má %d", p.valueOf());
        System.out.printf("Bob má %d", p2.valueOf());

        System.out.println("");

        System.out.println(p);
        System.out.println(p2);

        int hamburgerPrice = 39;
        System.out.printf("Alice si %s koupit hamburger\n", p.canBeBought(hamburgerPrice) ? "může" : "nemůže");
        System.out.printf("Alice si %s koupit hamburger\n", p2.canBeBought(hamburgerPrice) ? "může" : "nemůže");

        System.out.println(p.valueOf() > p2.valueOf() ? "Alice" : "Bob" + " má více peněz");

        p.transferTo(p2);
        System.out.println(p);
        System.out.println(p2);

    }

}
