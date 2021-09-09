package test;

import main.features.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FeatureTests {

    @Test
    public void testScannerInput() {
        String expectedInput = "C";
        String falseInput = "L";

        String input = "C";
        // Simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String actualInput = scanner.nextLine();

        assertNotNull(actualInput);
        assertNotEquals(falseInput, actualInput);
        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testFeatureCanvas() {
        int expectedWidth = 22;
        int expectedHeight = 6;
        Canvas canvas = new Canvas(20,4);

        assertTrue(canvas.getWidth() > 0);
        assertTrue(canvas.getHeight() > 0);
        assertEquals(expectedWidth, canvas.getWidth());
        assertEquals(expectedHeight, canvas.getHeight());
    }

    @Test
    public void testFeatureLine() {
        Point expectedStartingPoint = new Point(1,2);
        Point expectedEndingPoint = new Point(6,2);
        Line line = new Line(1, 2, 6, 2);

        assertNotNull(line.getStartingPoint());
        assertNotNull(line.getEndingPoint());
        assertEquals(expectedStartingPoint, line.getStartingPoint());
        assertEquals(expectedEndingPoint, line.getEndingPoint());
    }

    @Test
    public void testFeatureRectangle() {
        Point expectedUpperLeftPoint = new Point(14,1);
        Point expectedLowerRightPoint = new Point(18, 3);
        Rectangle rectangle = new Rectangle(14, 1,18,3);

        assertNotNull(rectangle.getUpperLeftPoint());
        assertNotNull(rectangle.getLowerRightPoint());
        assertEquals(expectedUpperLeftPoint, rectangle.getUpperLeftPoint());
        assertEquals(expectedLowerRightPoint, rectangle.getLowerRightPoint());
    }

    @Test
    public void testFeatureBucketFill() {
        Point expectedBucketFill = new Point(10,3);
        BucketFill bucketFill = new BucketFill(10,3);

        assertNotNull(bucketFill.getFillPoint());
        assertEquals(expectedBucketFill, bucketFill.getFillPoint());
    }

}
