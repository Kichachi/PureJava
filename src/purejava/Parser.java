package purejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {
	public void parse(File file) {
		try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
			String line = buffReader.readLine();
			List<Route> routes = new ArrayList<Route>();
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			// header start
			String vesselName = line;
			double maximumLoad = Double.parseDouble(buffReader.readLine());
			double cruiseSpeed = Double.parseDouble(buffReader.readLine());
			double maxSpeed = Double.parseDouble(buffReader.readLine());
			Date startDate = formatter.parse(buffReader.readLine());
			Date endDate = formatter.parse(buffReader.readLine());
			Vessel vessel = new Vessel.VesselBuilder(vesselName).maximumLoad(maximumLoad).cruiseSpeed(cruiseSpeed)
					.maxSpeed(maxSpeed).startDate(startDate).endDate(endDate).build();
			// header end
			line = buffReader.readLine(); // reading new line
			// routes start
			while (line != null) {
				String startPort = buffReader.readLine();
				int avgLoadTime = Integer.parseInt(buffReader.readLine());
				Date departureTime = formatter.parse(buffReader.readLine());
				int totalContainersToLoad = Integer.parseInt(buffReader.readLine());
				double totalWeightToLoad = Double.parseDouble(buffReader.readLine());
				double distToDest = Double.parseDouble(buffReader.readLine());
				String destPort = buffReader.readLine();
				int avgUnloadTime = Integer.parseInt(buffReader.readLine());
				Date arrivalTime = formatter.parse(buffReader.readLine());
				int totalContainersToUnload = Integer.parseInt(buffReader.readLine());
				double totalWeightToUnload = Double.parseDouble(buffReader.readLine());
				Route route = new Route.RouteBuilder(startPort, destPort).avgLoadTime(avgLoadTime)
						.departureTime(departureTime).totalContainersToLoad(totalContainersToLoad)
						.totalWeightToLoad(totalWeightToLoad).distToDest(distToDest).avgUnloadTime(avgUnloadTime)
						.arrivalTime(arrivalTime).totalContainersToUnload(totalContainersToUnload)
						.totalWeightToUnload(totalWeightToUnload).build();
				routes.add(route);
				line = buffReader.readLine();
			}
			vessel.setRoutes(routes);
			// routes end

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
