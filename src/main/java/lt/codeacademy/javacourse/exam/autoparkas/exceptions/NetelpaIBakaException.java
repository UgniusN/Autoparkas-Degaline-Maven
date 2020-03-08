package lt.codeacademy.javacourse.exam.autoparkas.exceptions;

public class NetelpaIBakaException  extends Exception{
    public final String message = "Pilama perdaug degalu į mašinos kuro baka.";

    @Override
    public String getMessage() {
        return message;
    }
}
