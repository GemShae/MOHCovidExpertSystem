package views;

import javax.swing.*;

public class Popup extends JFrame {
    enum POPUPTYPE {
        WELCOME,
        REPEATDATA,
        MISSINGFORM,
        MISSINGQUESTION,
        ERRORNAME
    }
    private final POPUPTYPE option;

    public Popup (POPUPTYPE option) {
        this.option = option;

        //Could add background to popUp
        //Check if it's null and add a standard background or check for the option and add a background
        //Create a new panel and add the background to it
        //setContentpane to that panel

        initialiseComponents();
        initial();
    }

    public void initialiseComponents() {

    }

    public void initial() {
        switch (option) {
            case WELCOME -> {
                //Could put an icon
                //Could have come labels with message inside the PopUp
                setTitle("Welcome to the MOH Covid Expert System");
            }
            case REPEATDATA -> {
                setTitle("Action Not Allowed!");
            }
            case ERRORNAME -> {
                setTitle("Error in a name entered");
            }
            case MISSINGFORM -> {
                setTitle("Missing Form");
            }
            case MISSINGQUESTION -> {
                setTitle("Missing Question");
            }
        }
    }
}
