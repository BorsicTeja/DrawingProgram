package main.features;

public class Rectangle implements FeatureInterface {

    private Point upperLeftPoint;
    private Point lowerRightPoint;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.upperLeftPoint = new Point(x1, y1);
        this.lowerRightPoint = new Point(x2, y2);
    }

    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(Point upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public Point getLowerRightPoint() {
        return lowerRightPoint;
    }

    public void setLowerRightPoint(Point lowerRightPoint) {
        this.lowerRightPoint = lowerRightPoint;
    }

    @Override
    public void addFeature(Canvas canvas, char drawCharacter) {
        char[][] drawRectangle = canvas.getCanvas();
        for (int i = upperLeftPoint.getY(); i <= lowerRightPoint.getY(); i++) {
            for (int j = upperLeftPoint.getX(); j <= lowerRightPoint.getX(); j++) {
                if ((i == upperLeftPoint.getY() || i == lowerRightPoint.getY()) || (j == upperLeftPoint.getX() || j == lowerRightPoint.getX())) {
                    drawRectangle[i][j] = drawCharacter;
                }
            }
        }
        canvas.displayCanvas();
    }
}
