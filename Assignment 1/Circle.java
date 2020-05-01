import java.lang.Math.*;
public class Circle extends Shape{
    private double radius = 1.0;

    public Circle() {}

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    public double getPerimeter() {
        return Math.PI*2*this.radius;
    }

    @Override
    public String toString() {
        return "a circle with radius = " + getRadius() + ", which is a subclass of " + super.toString();
    }
}
