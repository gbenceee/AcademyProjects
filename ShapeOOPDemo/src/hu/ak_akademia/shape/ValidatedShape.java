package hu.ak_akademia.shape;

public abstract class ValidatedShape implements Shape {

	 /**
     * Validates the given side length.
     *
     * @param sideLength
     *            The side length to validate.
     * @param validationErrorMessage
     *            The message to display if the validation fails.
     */
    protected void validate(double sideLength, String validationErrorMessage) {
        if (!new LengthValidator(sideLength).isValid()) {
            throw new IllegalArgumentException(validationErrorMessage);
        }
    }

}
