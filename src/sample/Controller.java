package sample;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller {
    @FXML private WebView browserView;

    public void initialize() {
        try {
            WebEngine engine = browserView.getEngine();
            engine.setUserAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.44 (KHTML, like Gecko) Chrome/8.0 JavaFX/8.0 Safari/537.44");
            engine.load("https://www.kalerkantho.com/");
        } catch (Exception e) {
            HelperMethods.showErrorDialog(e);
        }
    }


}
