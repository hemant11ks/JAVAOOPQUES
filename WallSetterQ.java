// In this program there is a condition for setting the value of setter in which if value is negative make it 0 using ternary.

public class WallSetterQ {
    private double width;
    private double height;

    public WallSetterQ() {
        // No-args constructor
    }

    public WallSetterQ(double width, double height) {
        this.width = (width < 0) ? 0 : width;
        this.height = (height < 0) ? 0 : height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = (width < 0) ? 0 : width;
    }

    public void setHeight(double height) {
        this.height = (height < 0) ? 0 : height;
    }

    public double getArea() {
        return width * height;
    }

    public static void main(String[] args) {
        WallSetterQ wall = new WallSetterQ(5, 4);
        System.out.println("Initial area= " + wall.getArea());

        wall.setHeight(-1.5);
        wall.setWidth(6.5);

        System.out.println("Width= " + wall.getWidth());
        System.out.println("Height= " + wall.getHeight());
        System.out.println("Area after setting width and height= " + wall.getArea());
    }
}
