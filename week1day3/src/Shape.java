public abstract class Shape {
    // location of the shape on a 2-D plane
    protected int x;
    protected int y;
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Shape() {
        this(0,0);
    }
    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void printArea();
}

class Rectangle extends Shape {
    private int width;
    private int height;
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public void printArea() {
        System.out.printf("The area of the rectangle is %d%n", width * height);
    }
}

class Triangle extends Shape {
    private int base;
    private int height;
    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public void printArea() {
        System.out.printf("The area of the triangle is %f%n", base * height / 2.0);
    }
}

class Circle extends Shape {
    static final double pi = 3.1415926;
    private int radius;
    Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void printArea() {
        System.out.printf("The area of the circle is %f%n", pi * radius * radius);
    }
}