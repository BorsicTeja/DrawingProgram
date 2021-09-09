package main.validators;

import main.features.Canvas;
import main.features.Point;

public class InputValidator {

    // Validate that the canvas is initialized
    public static boolean validateCanvasInitializion(Canvas canvas) {
        if(canvas == null){
            return false;
        }
        return true;
    }

    /**
     * Validate if user input enough values.
     * @param parameters User input values.
     * @param numberOfValues Number of expected values.
     * @return
     */
    public static boolean validateCommand(int[] parameters, int numberOfValues){
        if(parameters.length == numberOfValues){
            return true;
        }
        return false;
    }

    // Validate if the values are positive
    public static boolean validateValues(int[] parameters){
        for (int param: parameters){
            if(param <= 0){
                return false;
            }
        }
        return true;
    }

    // Validate if the point is inside the canvas
    public static boolean validateRange(Canvas canvas, Point point){
        if (point.getX() <= 0 || point.getX() > canvas.getWidth() || point.getY() <= 0 || point.getY() > canvas.getHeight()){
            return false;
        }
        return true;
    }
}
