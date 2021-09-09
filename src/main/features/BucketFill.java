package main.features;

public class BucketFill implements FeatureInterface{

    private Point fillPoint;

    public BucketFill(){}

    public BucketFill(int x, int y) {
        this.fillPoint = new Point(x,y);
    }

    public Point getFillPoint() {
        return fillPoint;
    }

    public void setFillPoint(Point fillPoint) {
        this.fillPoint = fillPoint;
    }

    @Override
    public void addFeature(Canvas canvas, char drawCharacter) {
        char[][] drawBucketFill = canvas.getCanvas();
        bucketFill(drawBucketFill, fillPoint.getX(), fillPoint.getY(), canvas.getElseCharacter(), drawCharacter);
        canvas.displayCanvas();
    }

    /**
     * Recursive function to check on all four sides to know where to continue. It replaces the old "colour" with the new "colour".
     * @param canvas The canvas on which we want to add the function.
     * @param x X coordinate of the point where we want to start the Bucket Fill function.
     * @param y Y coordinate of the point where we want to start the Bucket Fill function.
     * @param previousCharacter Represents the character we want to paint over.
     * @param newCharacter Represents the new character - the paint.
     */
    public void bucketFill(char canvas[][], int x, int y, char previousCharacter, char newCharacter) {
        if (canvas[y][x] != previousCharacter){
            return;
        }

        // Replace the color at (x, y)
        canvas[y][x] = newCharacter;

        // Recur for all four directions
        bucketFill(canvas, x + 1, y, previousCharacter, newCharacter);
        bucketFill(canvas, x - 1, y, previousCharacter, newCharacter);
        bucketFill(canvas, x, y + 1, previousCharacter, newCharacter);
        bucketFill(canvas, x, y - 1, previousCharacter, newCharacter);
    }
}
