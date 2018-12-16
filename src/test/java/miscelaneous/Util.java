package miscelaneous;

import java.nio.charset.Charset;
import java.util.Random;

public class Util {
	public static String generarRandomString(int cantidad) {
	    byte[] array = new byte[cantidad];
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}
}
