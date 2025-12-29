package test;

import java.util.logging.Logger;

import javafx.scene.text.Font;

public class FontLoader {
	static final Logger log = Logger.getLogger(FontLoader.class.getName());

//	public static void doit_dont_work() throws FontFormatException, IOException {
//		Font fontAwesomeSolid = Font.createFont(Font.TRUETYPE_FONT,
//				FontLoader.class.getResourceAsStream("/font/fa-solid-900.ttf"));
//		log.info("Family:" + fontAwesomeSolid.getFamily());
//		log.info("Font Name:" + fontAwesomeSolid.getFontName());
//
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		boolean result = ge.registerFont(fontAwesomeSolid);
//		log.info("ge " + result);
//	}

	
//	public static void doit_dont_work() throws FontFormatException, IOException {
//		Font fontAwesomeSolid = Font.createFont(Font.TRUETYPE_FONT,
//				FontLoader.class.getResourceAsStream("/font/Font Awesome 5 Free-Solid-900.otf"));
//		log.info("Family:" + fontAwesomeSolid.getFamily());
//
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		ge.registerFont(fontAwesomeSolid);
//	}

	public static void doit()
	{
		Font fontAwesomeSolid = Font.loadFont(FontLoader.class.getResourceAsStream("/font/Font Awesome 5 Free-Solid-900.otf"), 14);
		log.info( "Family:" + fontAwesomeSolid.getFamily());
	}
}
