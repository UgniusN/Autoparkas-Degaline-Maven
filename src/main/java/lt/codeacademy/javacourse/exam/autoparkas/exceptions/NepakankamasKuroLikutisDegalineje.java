package lt.codeacademy.javacourse.exam.autoparkas.exceptions;

public class NepakankamasKuroLikutisDegalineje extends Exception {
    private final String message = "Nepakankamas kuro kiekis degalineje.";

    @Override
    public String getMessage() {
        return message;
    }
}
