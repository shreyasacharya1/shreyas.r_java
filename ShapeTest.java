abstract class Shape {
    int dimension1, dimension2;

    Shape(int d1, int d2) {
        dimension1 = d1;
        dimension2 = d2;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    void printArea() {
        System.out.println("Rectangle Area: " + (dimension1 * dimension2));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        System.out.println("Triangle Area: " + (0.5 * dimension1 * dimension2));
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    @Override
    void printArea() {
        System.out.println("Circle Area: " + (Math.PI * dimension1 * dimension1));
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        rectangle.printArea();

        Shape triangle = new Triangle(8, 6);
        triangle.printArea();

        Shape circle = new Circle(7);
        circle.printArea();
    }
}
