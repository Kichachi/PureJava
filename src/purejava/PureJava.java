package purejava;

import java.io.File;

public class PureJava {

	public static void main(String[] args) {
		File file = new File("vesselsAndRoutes.txt");
		Vessel vessel = Parser.parse(file);
		if (Validator.validate(vessel)) {
			XMLWriter.writeToXml(vessel);
		}
	}

}
