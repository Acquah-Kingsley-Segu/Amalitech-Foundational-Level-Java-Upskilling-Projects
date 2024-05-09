package amalitech.screen;

public interface ScreenAction {
    byte MONTHS_IN_YEAR=12;
    void askForContent();
    void takeContent();
    boolean validateContent(double content);

    double manipulateContent();
}
