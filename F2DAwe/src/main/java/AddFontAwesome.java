import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class AddFontAwesome {
	public static void doit()
	{
		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			final Font fa_brands_400 = Font.createFont( Font.TRUETYPE_FONT, AddFontAwesome.class.getResourceAsStream("fa-brands-400.ttf"));
			ge.registerFont(fa_brands_400);

			final Font fa_regular_400 = Font.createFont( Font.TRUETYPE_FONT, AddFontAwesome.class.getResourceAsStream("fa-regular-400.ttf"));
			ge.registerFont(fa_regular_400);
			
			final Font fa_solid_900 = Font.createFont( Font.TRUETYPE_FONT, AddFontAwesome.class.getResourceAsStream("fa-solid-900.ttf"));
			ge.registerFont(fa_solid_900);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
