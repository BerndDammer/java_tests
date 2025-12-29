package test;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws IOException {
		FontLoader.doit();
		TestController testController = new TestController();
        Scene scene = new Scene(testController);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
	}
}
