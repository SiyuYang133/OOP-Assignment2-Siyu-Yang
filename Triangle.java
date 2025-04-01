public class Triangle extends Shape {
    private Coordinates point2;
    private Coordinates point3;

    // Constructor: point1 is the inherited position
    public Triangle(Coordinates point1, Coordinates point2, Coordinates point3) {
        super(3, point1); // A triangle has 3 sides
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            position.scale(factor, true);
            point2.scale(factor, true);
            point3.scale(factor, true);
        } else {
            position.scale(factor, false);
            point2.scale(factor, false);
            point3.scale(factor, false);
        }
    }

    @Override
    public double getArea() {
        double a = position.distance(point2);
        double b = point2.distance(point3);
        double c = point3.distance(position);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
    }

    @Override
    public double getPerimeter() {
        double a = position.distance(point2);
        double b = point2.distance(point3);
        double c = point3.distance(position);
        return a + b + c;
    }

    @Override
    public String display() {
        return "Triangle with points:\n" +
                "Point 1: " + position.display() + "\n" +
                "Point 2: " + point2.display() + "\n" +
                "Point 3: " + point3.display();
    }

    @Override
    public void translate(int dx, int dy) {
        super.translate(dx, dy);
        point2.translate(dx, dy);
        point3.translate(dx, dy);
    }
}
