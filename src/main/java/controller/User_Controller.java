package controller;

import javax.swing.JLabel;
import segurity.UserAccessControl;

public class User_Controller {
    public void loginUser(String userName, String Password, JLabel warning){
        UserAccessControl userAccessControl = new UserAccessControl();

        if (userName.isEmpty() || Password.isEmpty()) {
            warning.setText("Rellene todos los campos");
        } else {
            if (userAccessControl.userAuthenticate(userName, Password)) {
                warning.setText("Iniciando sesion...");
            } else {
                warning.setText("Los datos no son validos");
            }
        }

    }
}
