package main.features;

public class Canvas {

    private int width;
    private int height;
    private char[][] canvas;
    private static final char WIDTH_CHARACTER = '-';
    private static final char HEIGHT_CHARACTER = '|';
    protected static final char ELSE_CHARACTER = ' ';

    public Canvas(){}

    public Canvas(int width, int height) {
        // We add 2 for creation of the borders
        this.width = width + 2;
        this.height = height + 2;
        this.canvas = new char[this.height][this.width];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getCanvas() {
        return canvas;
    }

    protected char getElseCharacter(){
        return ELSE_CHARACTER;
    }

    public void buildCanvas() {
        for(int i = 0; i < height; i++ ) {
            for(int j = 0; j < width; j++) {
                if(i == 0 || i == height - 1) {
                    canvas[i][j] = WIDTH_CHARACTER;
                } else if(j == 0 || j == width - 1){
                    canvas[i][j] = HEIGHT_CHARACTER;
                } else{
                    canvas[i][j] = ELSE_CHARACTER;
                }
            }
        }
    }

    public void displayCanvas() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }
}
