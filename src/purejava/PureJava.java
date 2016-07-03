package purejava;

import java.io.File;

public class main {

	public static void main(String[] args) {
		Parser parser = new Parser();
		File file = new File("C:\\Users\\JIT\\Desktop\\vesselsAndRoutes.txt");
		parser.parse(file);
	}

}
