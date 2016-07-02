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
			Vessel vessel;
			List<Route> routes = new ArrayList<Route>();
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			// header start
			String vesselName = line;
			double maximumLoad = Double.parseDouble(buffReader.readLine());
			double cruiseSpeed = Double.parseDouble(buffReader.readLine());
			double maxSpeed = Double.parseDouble(buffReader.readLine());
			Date startDate = formatter.parse(buffReader.readLine());
			Date endDate = formatter.parse(buffReader.readLine());
			vessel = new Vessel.VesselBuilder(vesselName).maximumLoad(maximumLoad).cruiseSpeed(cruiseSpeed)
					.maxSpeed(maxSpeed).startDate(startDate).endDate(endDate).build();
			// header end
			line = buffReader.readLine(); // reading new line
			// routes start
			String startPort;
			int avgLoadTime;
			Date departureTime;
			int totalContainersToLoad;
			double totalWeightToLoad;
			double distToDest;
			String destPort;
			int avgUnloadTime;
			Date arrivalTime;
			int totalContainersToUnload;
			double totalWeightToUnload;
			while (line != null) {
				startPort = buffReader.readLine();
				avgLoadTime = Integer.parseInt(buffReader.readLine());
				departureTime = formatter.parse(buffReader.readLine());
				totalContainersToLoad = Integer.parseInt(buffReader.readLine());
				totalWeightToLoad = Double.parseDouble(buffReader.readLine());
				distToDest = Double.parseDouble(buffReader.readLine());
				destPort = buffReader.readLine();
				avgUnloadTime = Integer.parseInt(buffReader.readLine());
				arrivalTime = formatter.parse(buffReader.readLine());
				totalContainersToUnload = Integer.parseInt(buffReader.readLine());
				totalWeightToUnload = Double.parseDouble(buffReader.readLine());
				Route route = new Route.RouteBuilder(startPort, destPort).avgLoadTime(avgLoadTime)
						.departureTime(departureTime).totalContainersToLoad(totalContainersToLoad)
						.totalWeightToLoad(totalWeightToLoad).distToDest(distToDest).avgUnloadTime(avgUnloadTime)
						.arrivalTime(arrivalTime).totalContainersToUnload(totalContainersToUnload)
						.totalWeightToUnload(totalWeightToUnload).build();
				routes.add(route);
				line = buffReader.readLine();
			}
			// routes end

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
