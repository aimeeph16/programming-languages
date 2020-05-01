public class Driver {
    public static void main(String[] args){
        Rectangle rec1 = new Rectangle(3.0, 4.0);
        rec1.getArea();
        rec1.getPerimeter();
        System.out.println(rec1.toString());

        Square sq1 = new Square();
        sq1.getArea();
        System.out.println(sq1.toString());

        Circle c1 = new Circle();
        c1.getRadius();
        c1.getArea();
        c1.getPerimeter();
        System.out.println(c1.toString());

    }
}
