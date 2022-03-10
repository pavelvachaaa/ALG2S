/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

/**
 *
 * @author pavel.vacha
 */
public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x) {
        this(x, 0);
    }

    public Point() {
        this(0, 0);
    }

    public double distanceFromOrigin() {
        return distanceFromPoint(new Point(0, 0));
    }

    public double distanceFromPoint(double x, double y) {
        return distanceFromPoint(new Point(x, y));
    }

    public double distanceFromPoint(Point p) {
        return Math.hypot(this.x - p.getX(), this.y - p.getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        if (x < -1) {
            throw new IllegalArgumentException("Debile");
        }
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("[%.3f;%.3f]", this.x, this.y); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        System.out.println(new Point(3, 2));
    }

}
