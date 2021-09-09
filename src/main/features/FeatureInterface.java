package main.features;

public interface FeatureInterface {

    /**
     * Method to add different features (with possible different characters) to the canvas.
     * @param canvas The canvas on which we want to add the function.
     * @param drawCharacter Character with which we display the feature.
     */
    void addFeature(Canvas canvas, char drawCharacter);
}
