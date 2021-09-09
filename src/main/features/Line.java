package main.features;

public class Line implements FeatureInterface {

    private Point startingPoint;
    private Point endingPoint;

    public Line() {
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.startingPoint = new Point(x1, y1);
        this.endingPoint = new Point(x2, y2);
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }

    @Override
    public void addFeature(Canvas canvas, char drawCharacter) {
        char[][] drawLine = canvas.getCanvas();
        for (int i = startingPoint.getY(); i <= endingPoint.getY() && i < canvas.getHeight(); i++) {
            for (int j = startingPoint.getX(); j <= endingPoint.getX() && j < canvas.getWidth(); j++) {
                drawLine[i][j] = drawCharacter;
            }
        }
        canvas.displayCanvas();
    }
}
