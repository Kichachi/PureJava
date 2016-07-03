package purejava;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class PureJavaTest {
	@Test
	public void checkParsingCorectness() throws ParseException {
		File file = new File("vesselsAndRoutes.txt");
		Vessel vessel = Parser.parse(file);

		Assert.assertEquals("Cruise Speed has been badly parsed.", vessel.getVesselHeader().getCruiseSpeed(), 5.2,
				0.000001);

		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

		Date date = formatter.parse("17-07-2013 21:00");
		Assert.assertEquals("End dates aren't equal", vessel.getVesselHeader().getEndDate(), date);

		date = formatter.parse("15-03-2013 14:00");
		Assert.assertEquals("Start dates aren't equal", vessel.getVesselHeader().getStartDate(), date);

		Assert.assertEquals("Maximum loads aren't equal", vessel.getVesselHeader().getMaximumLoad(), 10000.2, 0.000001);

		Assert.assertEquals("Max Speed has been badly parsed.", vessel.getVesselHeader().getMaxSpeed(), 10.3, 0.000001);

	}

	@Test
	public void checkRoutesParsingCorectness() throws ParseException {
		File file = new File("vesselsAndRoutes.txt");
		Vessel vessel = Parser.parse(file);

		Assert.assertEquals("Start ports don't match", vessel.getRoutes().get(3).getStartPort(), "Hong Kong");

		Assert.assertEquals("Total weights to discharge don't match",
				vessel.getRoutes().get(1).getTotalWeightToUnload(), 2000, 0.000001);

		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = formatter.parse("14-05-2013 15:00");
		Assert.assertEquals("Arrival date times dont match", vessel.getRoutes().get(2).getArrivalTime(), date);

		Assert.assertEquals("Distances to destination ports dont match", vessel.getRoutes().get(3).getDistToDest(),
				6982.67, 0.0000001);

	}

	@Test
	public void validationTest() {
		File file = new File("vesselsAndRoutes2.txt");
		Vessel vessel = Parser.parse(file);
		Assert.assertFalse("Method should return false, as the file is not correct", Validator.validate(vessel));

		file = new File("vesselsAndRoutes.txt");
		vessel = Parser.parse(file);
		Assert.assertTrue("Method should return true, as the file is correct", Validator.validate(vessel));
	}

}
