package driver;

import views.AddPatient;
import views.Login;

import java.awt.*;

public class Driver {
    public static void main(String[] args) {
        //EventQueue.invokeLater(AddPatient::new);
        Login login = new Login();
        login.setVisible(true);
    }
}
