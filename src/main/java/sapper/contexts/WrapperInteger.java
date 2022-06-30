package sapper.contexts;

public class WrapperInteger {
    double x;
    double y;
    int x1;
    int y1;

    public WrapperInteger(double x, double y, int x1, int y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
