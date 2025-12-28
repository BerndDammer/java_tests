package terminaltests;

import java.net.MalformedURLException;
import java.net.URL;

public class Parameter {
	private final String url;

	public Parameter(final String[] args) throws MalformedURLException {
		if (args.length >= 1) {
			url = args[0];
		} else {
			url = "localhost";
		}
	}

	public String getUrl() {
		return url;
	}
}
