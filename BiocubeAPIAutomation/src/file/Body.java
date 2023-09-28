package file;

public class Body {
	public static String api() {
		String payLoad="{\r\n"
				+ "  \"image\": \"string\",\r\n"
				+ "  \"liveliness\": true,\r\n"
				+ "  \"mobile\": true\r\n"
				+ "}";
		return payLoad;
	}

}