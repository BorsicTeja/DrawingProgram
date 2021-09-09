package main.validators;

import main.enums.Command;
import main.features.Canvas;
import main.features.Line;
import main.features.Point;

import java.util.Scanner;

public class Validator {

    private static int CANVAS_VALUES = 2;
    private static int LINE_VALUES = 4;
    private static int RECTANGLE_VALUES = 4;
    private static int BUCKET_FILL_VALUES = 3;

    private InputValidator inputValidator;

    public Validator(){
        this.inputValidator = new InputValidator();
    }

    // Validate if users input command exists
    public boolean validateUserInput(String input) {
        for (Command command : Command.values()) {
            if (command.name().equals(input.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean canvasValidation(int[] parameters){
        try{
            if(inputValidator.validateCommand(parameters, CANVAS_VALUES) && inputValidator.validateValues(parameters)){
                System.out.println("Creating a canvas.");
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Please, check that your input is valid.");
            return false;
        }
    }

    public boolean lineValidation(int[] parameters, Canvas canvas){
        try{
            if(inputValidator.validateCanvasInitializion(canvas) && inputValidator.validateCommand(parameters, LINE_VALUES) && inputValidator.validateValues(parameters)
                    && inputValidator.validateRange(canvas, new Point(parameters[0], parameters[1])) && inputValidator.validateRange(canvas, new Point(parameters[2], parameters[3]))){
                System.out.println("Drawing a line.");
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Please, check that your input is valid.");
            return false;
        }
    }

    public boolean rectangleValidation(int[] parameters, Canvas canvas){
        try{
            if(inputValidator.validateCanvasInitializion(canvas) && inputValidator.validateCommand(parameters, RECTANGLE_VALUES) && inputValidator.validateValues(parameters)
                    && inputValidator.validateRange(canvas, new Point(parameters[0], parameters[1])) && inputValidator.validateRange(canvas, new Point(parameters[2], parameters[3]))){
                System.out.println("Drawing a rectangle.");
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Please, validate that your input equals the instructions.");
            return false;
        }
    }

    public boolean bucketFillValidation(int[] parameters, Canvas canvas){
        try{
            if(inputValidator.validateCanvasInitializion(canvas) && inputValidator.validateCommand(parameters, BUCKET_FILL_VALUES) && inputValidator.validateValues(parameters)
                    && inputValidator.validateRange(canvas, new Point(parameters[0], parameters[1]))){
                System.out.println("Performing the 'Bucket fill' function.");
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Please, validate that your input equals the instructions.");
            return false;
        }
    }
}
