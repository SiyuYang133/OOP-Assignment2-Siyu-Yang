public class Rectangle extends Shape {
    private int width;
    private int length;

    // Constructor
    public Rectangle(Coordinates coord, int width, int length) {
        super(4, coord); // A rectangle always has 4 sides
        this.width = width;
        this.length = length;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            this.width /= factor;
            this.length /= factor;
        }
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String display() {
        return "Rectangle at " + position.display() + ", Width: " + width + ", Length: " + length;
    }
}