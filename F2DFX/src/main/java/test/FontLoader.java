package test;

import java.util.logging.Logger;

import javafx.scene.text.Font;

public class FontLoader {
	static final Logger log = Logger.getLogger(FontLoader.class.getName());
	public static void doit()
	{
		Font fontAwesomeSolid = Font.loadFont(FontLoader.class.getResourceAsStream("/font/fa-solid-900.ttf"), 14);
		log.info( "Family:" + fontAwesomeSolid.getFamily());
	}
}
