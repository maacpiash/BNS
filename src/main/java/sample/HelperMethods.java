package sample;

import javafx.scene.control.Alert;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelperMethods {
    public static void showErrorDialog(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR : " + e.toString() );
        alert.setHeaderText("The program could not run properly due to the following error.");
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        alert.setContentText(errors.toString());
        alert.showAndWait();
    }
}