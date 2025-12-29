package test;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TestController extends GridPane {
	static final Logger log = Logger.getLogger(TestController.class.getName());
	
	@FXML
	private StackPane stackTest;
	
	public TestController() throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fx/TestController.fxml"));

        fxmlLoader.setRoot(this);

        fxmlLoader.setController(this);
        fxmlLoader.load();
        
        VBox vbox = (VBox) getChildren().get(0);
        Label label = new Label("Programmatic");
        vbox.getChildren().add(label);
        String text = new String( new char[] { 0Xf580});
        label.setText(text);
        Font font = new Font("Font Awesome 5 Free Solid", 40);
        for(String s :Font.getFontNames())
        {
        	System.out.println( "Font: " + s);
        }
        for(String s :Font.getFamilies())
        {
        	System.out.println( "Family: " + s);
        }
        label.setFont( font);
        {
            HBox hbox = new HBox();
            Button onButton = new Button("on");
            onButton.setOnAction(this::onOn);

            Button offButton = new Button("off");
            offButton.setOnAction(this::onOff);
            
        	hbox.getChildren().addAll( onButton, offButton);
        	vbox.getChildren().add(hbox);
        }
	}
	private void onOn(final ActionEvent ae)
	{
		if( stackTest.getChildren().size() == 1)
		{
			WritableImage writableImage = new WritableImage(70, 70);
			PixelWriter pixelWriter = writableImage.getPixelWriter();
			for(int l = 0; l < writableImage.getHeight(); l++)
			{
				for( int s = 0; s < writableImage.getWidth(); s++)
				{
					pixelWriter.setArgb(s, l, 0X80443322);
				}
			}
			pixelWriter.setArgb(0, 0, 0X55555555);
			pixelWriter.setArgb(0, 1, 0X77777777);
			pixelWriter.setArgb(0, 2, 0X55555555);
			pixelWriter.setArgb(1, 0, 0X55555555);
			pixelWriter.setArgb(1, 1, 0X55555555);
			pixelWriter.setArgb(1, 2, 0XFF000000);
			ImageView imageView = new ImageView(writableImage);
			stackTest.getChildren().add(imageView);
		}
	}
	private void onOff(final ActionEvent ae)
	{
		if( stackTest.getChildren().size() > 1)
		{
			stackTest.getChildren().remove( stackTest.getChildren().get(1));
		}
	}
}
