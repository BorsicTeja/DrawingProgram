package main;

import main.converters.ParameterConverter;
import main.enums.Command;
import main.features.*;
import main.validators.Validator;

import java.util.Scanner;

/**
 *  Main class to start the console application.
 */
public class Main {

    private static final char DRAW_CHARACTER = 'X';
    private static final String ERROR_MESSAGE = "Please, check that you already created a canvas and that input is valid.";

    public static void main(String[] args) {

        System.out.println("Welcome to the Drawing Program!");
        System.out.println("First, you must create the canvas. Use the Command 'C x y' to create your canvas." + "\n" +
                "Use the Command 'L x1 y1 x2 y2' to draw a line." + "\n" +
                "Use the Command 'R x1 y1 x2 y2' to draw a rectangle." + "\n" +
                "Use the Command 'B x1 y1 c' to perform the Bucket Fill function." + "\n" +
                "Use the Command 'Q' exit the program.");

        Canvas canvas = null;
        Scanner scanner = new Scanner(System.in);
        String userCommand = "";
        Validator validator = new Validator();
        ParameterConverter parameterConverter = new ParameterConverter();

        while(true){

            // Split characters on spaces
            String[] input = scanner.nextLine().split(" ");
            userCommand = input[0].toUpperCase();

            // Check if the command exists
            if(!validator.validateUserInput(userCommand)){
                System.out.println("Please, enter a valid command.");
                continue;
            }

            // The Bucket Fill function also accepts the drawing character. We convert it to ASCII.
            int[] parameters = parameterConverter.convertParameters(userCommand, input);

            switch (Command.valueOf(userCommand)) {
                case C:
                    if(!validator.canvasValidation(parameters)) {
                        System.out.println("Please, check your input and insert valid values.");
                        continue;
                    }
                    canvas = new Canvas(parameters[0], parameters[1]);
                    canvas.buildCanvas();
                    canvas.displayCanvas();
                    break;
                case L:
                    if(!validator.lineValidation(parameters, canvas)) {
                        System.out.println(ERROR_MESSAGE);
                        continue;
                    }
                    Line line = new Line(parameters[0], parameters[1], parameters[2], parameters[3]);
                    line.addFeature(canvas, DRAW_CHARACTER);
                    break;
                case R:
                    if(!validator.rectangleValidation(parameters, canvas)) {
                        System.out.println(ERROR_MESSAGE);
                        continue;
                    }
                    Rectangle rectangle = new Rectangle(parameters[0], parameters[1], parameters[2], parameters[3]);
                    rectangle.addFeature(canvas, DRAW_CHARACTER);
                    break;
                case B:
                    if(!validator.bucketFillValidation(parameters, canvas)) {
                        System.out.println(ERROR_MESSAGE);
                        continue;
                    }
                    BucketFill bucketFill = new BucketFill(parameters[0], parameters[1]);
                    bucketFill.addFeature(canvas, (char) parameters[2]);
                    break;
                case Q:
                    System.out.println("Quitting the program.");
                    System.exit(0);
            }
        }
    }
}
