package test;

import main.features.Canvas;
import main.validators.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTests {

    Validator validator;
    Canvas canvas;

    @Before
    public void init() {
        validator = new Validator();
        canvas = new Canvas(20,4);
    }

    @Test
    public void testCommandValidator() {
        String commandC = "c";
        String commandL = "L";
        String commandR = "r";
        String commandB = "B";
        String commandQ = "Q";
        String falseCommand = "A";

        assertTrue(validator.validateUserInput(commandC));
        assertTrue(validator.validateUserInput(commandL));
        assertTrue(validator.validateUserInput(commandR));
        assertTrue(validator.validateUserInput(commandB));
        assertTrue(validator.validateUserInput(commandQ));
        assertFalse(validator.validateUserInput(falseCommand));
    }

    @Test
    public void testCanvasValidator() {
        int[] parameters = new int[]{20,4};
        int[] missingParameters = new int[]{1};
        int[] negativeParameters = new int[]{1, -2};

        assertTrue(validator.canvasValidation(parameters));
        assertFalse(validator.canvasValidation(missingParameters));
        assertFalse(validator.canvasValidation(negativeParameters));
    }

    @Test
    public void testLineValidator() {
        int[] parameters = new int[]{1,2,6,2};
        int[] falseParameters = new int[]{0,0,0,0};
        int[] missingParameters = new int[]{1,2,3};
        int[] negativeParameters = new int[]{1, -2, 3, 5};
        Canvas falseCanvas = new Canvas();

        assertTrue(validator.lineValidation(parameters, canvas));
        assertFalse(validator.lineValidation(falseParameters, canvas));
        assertFalse(validator.lineValidation(parameters, falseCanvas));
        assertFalse(validator.lineValidation(missingParameters, canvas));
        assertFalse(validator.lineValidation(negativeParameters,canvas));
    }

    @Test
    public void testRectangleValidator() {
        int[] parameters = new int[]{14,1,18,3};
        int[] falseParameters = new int[]{0,0,0,0};
        int[] missingParameters = new int[]{1,2,3};
        int[] plentyParameters = new int[]{5, 2, 2, 5, 6};
        int[] negativeParameters = new int[]{14, -1, -18, 3};
        Canvas falseCanvas = new Canvas();

        assertTrue(validator.rectangleValidation(parameters, canvas));
        assertFalse(validator.rectangleValidation(falseParameters, canvas));
        assertFalse(validator.rectangleValidation(parameters, falseCanvas));
        assertFalse(validator.rectangleValidation(missingParameters, canvas));
        assertFalse(validator.rectangleValidation(plentyParameters, canvas));
        assertFalse(validator.rectangleValidation(negativeParameters,canvas));
    }

    @Test
    public void testBucketFillValidator() {
        int[] parameters = new int[]{10,3,51};
        int[] falseParameters = new int[]{0,0,0};
        int[] missingParameters = new int[]{1,2};
        int[] negativeParameters = new int[]{-1, 1, 8};
        Canvas falseCanvas = new Canvas();

        assertTrue(validator.bucketFillValidation(parameters, canvas));
        assertFalse(validator.bucketFillValidation(falseParameters, canvas));
        assertFalse(validator.bucketFillValidation(parameters, falseCanvas));
        assertFalse(validator.bucketFillValidation(missingParameters, canvas));
        assertFalse(validator.bucketFillValidation(negativeParameters,canvas));
    }
}
