package test;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class TestController extends GridPane {
	public TestController() throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fx/TestController.fxml"));

        fxmlLoader.setRoot(this);

        fxmlLoader.setController(this);
        fxmlLoader.load();

	}

}
