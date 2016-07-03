package purejava;

import java.util.Calendar;

public class Validator {
	public static Boolean validate(Vessel vessel) {
		Boolean error = false;
		double totalWeight = 0.0;
		Route currentRoute;
		for (int i = 0; i < vessel.getRoutes().size(); i++) {
			currentRoute = vessel.getRoutes().get(i);
			// case 1
			totalWeight += currentRoute.getTotalWeightToLoad();
			if (totalWeight > vessel.getVesselHeader().getMaximumLoad()) {
				System.out.println(
						"Vessel " + vessel.getVesselHeader().getVesselName() + " exceeded the maximum capacity in port "
								+ currentRoute.getStartPort() + " loading container no. " + i);
				error = true;
			}
			totalWeight -= currentRoute.getTotalWeightToUnload();
			// end of case 1
			// case 2
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentRoute.getArrivalTime());
			cal.add(Calendar.MINUTE, 90);
			int loadingTime = currentRoute.getAvgUnloadTime() * currentRoute.getTotalContainersToLoad() * 60;
			int unloadingTime = currentRoute.getAvgUnloadTime() * currentRoute.getTotalContainersToUnload() * 60;
			cal.add(Calendar.MINUTE, loadingTime + unloadingTime);
			if (cal.after(currentRoute.getDepartureTime())) {
				System.out.println("Cannot finish loading procedure for " + vessel.getVesselHeader().getVesselName()
						+ " in leg no. " + i);
				error = true;
			}
			// end of case 2
		}
		// case 3

		// end of case 3
		// case 4
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
		// end of case 4
		return true;
	}
}
