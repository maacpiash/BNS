package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent rootUIElement = loader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("বাংলা সংবাদ");
            primaryStage.setScene(new Scene(rootUIElement));
            primaryStage.show();
        } catch (Exception x) {
            HelperMethods.showErrorDialog(x);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
