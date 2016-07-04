package purejava;

import java.util.Calendar;

public class Validator {
	public static Boolean validateCase1(Vessel vessel) {
		Boolean error = false;
		double totalWeight = 0.0;
		Route currentRoute;
		for (int i = 0; i < vessel.getRoutes().size(); i++) {
			currentRoute = vessel.getRoutes().get(i);
			totalWeight += currentRoute.getTotalWeightToLoad();
			if (totalWeight > vessel.getVesselHeader().getMaximumLoad()) {
				System.out.println(
						"Vessel " + vessel.getVesselHeader().getVesselName() + " exceeded the maximum capacity in port "
								+ currentRoute.getStartPort() + " loading container no. " + i);
				error = true;
			}
			totalWeight -= currentRoute.getTotalWeightToUnload();
		}
		if (error)
			return false;
		return true;
	}

	public static Boolean validateCase2(Vessel vessel) {
		Boolean error = false;
		Route currentRoute;
		for (int i = 0; i < vessel.getRoutes().size(); i++) {
			currentRoute = vessel.getRoutes().get(i);
			// case 2
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentRoute.getDepartureTime());
			cal.add(Calendar.MINUTE, 90);
			int loadingTime = currentRoute.getAvgUnloadTime() * currentRoute.getTotalContainersToLoad() / 60;
			int unloadingTime = currentRoute.getAvgUnloadTime() * currentRoute.getTotalContainersToUnload() / 60;
			cal.add(Calendar.MINUTE, loadingTime + unloadingTime);
			if (cal.getTime().after(currentRoute.getArrivalTime())) {
				System.out.println("Cannot finish loading procedure for " + vessel.getVesselHeader().getVesselName()
						+ " in leg no. " + i);
				error = true;
			}
		}
		if (error)
			return false;
		return true;
	}

	public static Boolean validateCase3(Vessel vessel) {
		Boolean error = false;
		Route currentRoute;
		for (int i = 0; i < vessel.getRoutes().size(); i++) {
			currentRoute = vessel.getRoutes().get(i);
			if (currentRoute.getArrivalTime().getTime()
					- currentRoute.getDepartureTime().getTime() < currentRoute.getDepartureTime().getTime()
							- currentRoute.getArrivalTime().getTime()) {
				System.out.println("Departure date time " + currentRoute.getDepartureTime()
						+ " is incorrect for vessel " + vessel.getVesselHeader().getVesselName() + " destination port "
						+ currentRoute.getDestPort() + ", start port " + currentRoute.getStartPort());
				error = true;
			}
		}
		if (error)
			return false;
		return true;
	}

	public static Boolean validateCase4(Vessel vessel) {
		Boolean error = false;
		// if departure time of first leg differs from start time of vessel OR arrival time of last leg differs from end
		// time of vessel
		if (!(vessel.getRoutes().get(0).getDepartureTime().equals(vessel.getVesselHeader().getStartDate())
				&& vessel.getRoutes().get(vessel.getRoutes().size() - 1).getArrivalTime()
						.equals(vessel.getVesselHeader().getEndDate()))) {
			System.out.println(
					"Schedule start date time != first leg departure date time or schedule end date time != last leg arrival date time");
			error = true;
		}
		if (error)
			return false;
		return true;

	}

	public static Boolean validateAll(Vessel vessel) {
		return validateCase1(vessel) && validateCase2(vessel) && validateCase3(vessel) && validateCase4(vessel);
	}
}
