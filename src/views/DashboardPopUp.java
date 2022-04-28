package views;

import javax.swing.*;

public class DashboardPopUp extends JFrame {
    private Popup popupInitial;
    private Popup popupMissingForm;
    private Popup popupErrorName;
    private Popup popupRepeatData;
    private int errorType;

    public DashboardPopUp() {
        initialiseComponents();
        showPopupInitial();
        //addToFrame();
        //registerActionListeners();
        //registerKeyListeners();
    }

    public void initialiseComponents() {

    }

    //Show the initial PopUp
    private void showPopupInitial() {
        if (popupInitial == null) {
            popupInitial = new Popup(Popup.POPUPTYPE.WELCOME);
        }
        if (popupRepeatData != null) {
            popupRepeatData.dispose();
        }
        if (popupMissingForm != null) {
            popupMissingForm.dispose();
        }
        if (popupErrorName != null) {
            popupErrorName.dispose();
        }
        popupInitial.setVisible(true);
        //popupInitial.move();
    }

    private void showPopupMissingForm() {

    }

    private void showPopupErrorName() {

    }

    private void showPopupRepeatData() {

    }

    public void error() {
        switch (errorType) {
            case 0 -> showPopupMissingForm();
            case 1 -> showPopupErrorName();
            default -> showPopupRepeatData();
        }
    }
}
