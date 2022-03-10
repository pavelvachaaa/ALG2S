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
public class MoneyBox {
    
    private String name;
    private int nOneCrown, nTwoCrowns;
    
    public MoneyBox(String name) {
        this(name, 0, 0);
    }
    
    public MoneyBox(String name, int oneCrown, int twoCrowns) {
        this.name = name;
        this.nOneCrown = checkMoney(oneCrown);
        this.nTwoCrowns = checkMoney(twoCrowns);
    }
    
    public static int checkMoney(int money) throws IllegalArgumentException {
        if (money < 0) {
            throw new IllegalArgumentException("Snažíš se zadat záporné koruny???????");
        }
        return money;
    }
    
    public int valueOf() {
        return this.nOneCrown + 2 * this.nTwoCrowns;
    }
    
    public boolean canBeBought(int price) {
        return this.valueOf() >= price;
    }
    
    public void addMoney(int oneCrown, int twoCrowns) {
        this.nOneCrown += checkMoney(oneCrown);
        this.nTwoCrowns += checkMoney(twoCrowns);
    }
    
    public void transferTo(MoneyBox b2, int oneCrown, int twoCrowns) {
        if (b2 == null) {
            throw new IllegalArgumentException("Neexistující účet");
        }
        
        int[] crowns = this.withDraw();
        b2.addMoney(crowns[0], crowns[1]);
    }
    
    public void transferTo(MoneyBox b2) {
        this.transferTo(b2, this.nOneCrown, this.nTwoCrowns);
    }
    
    public int[] withDraw(int oneCrown, int twoCrowns) {
        if (oneCrown > this.nOneCrown || twoCrowns > this.nTwoCrowns) {
            throw new IllegalArgumentException("Hmm, kouzelně ty peníze nevyčarujeme :--------)");
        }
        
        int[] crowns = {this.nOneCrown, this.nTwoCrowns};
        this.nOneCrown -= oneCrown;
        this.nTwoCrowns -= nTwoCrowns;
        
        return crowns;
    }
    
    public int[] withDraw() {
        return this.withDraw(this.nOneCrown, this.nTwoCrowns);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addCrown() {
        this.nOneCrown++;
    }
    
    public void addtwoCrowns() {
        this.nTwoCrowns++;
    }
    
    public int getOneCrown() {
        return nOneCrown;
    }
    
    public int getTwoCrowns() {
        return nTwoCrowns;
    }
    
    @Override
    public String toString() {
        return String.format("%s má v pokladničce %d - %d jednokorun a %d dvoukorun", this.name, this.valueOf(), this.nOneCrown, this.nTwoCrowns); //To change body of generated methods, choose Tools | Templates.
    }
    
}
