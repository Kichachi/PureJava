package purejava;

import java.util.Date;
import java.util.List;

public class Vessel {

	private String vesselName;
	private double maximumLoad;
	private double cruiseSpeed;
	private double maxSpeed;
	private Date startDate;
	private Date endDate;
	private List<Route> routes;

	public Vessel(VesselBuilder vesselBuilder) {
		this.vesselName = vesselBuilder.vesselName;
		this.maximumLoad = vesselBuilder.maximumLoad;
		this.cruiseSpeed = vesselBuilder.cruiseSpeed;
		this.maxSpeed = vesselBuilder.maxSpeed;
		this.startDate = vesselBuilder.startDate;
		this.endDate = vesselBuilder.endDate;
	}

	public String getVesselName() {
		return vesselName;
	}

	public double getMaximumLoad() {
		return maximumLoad;
	}

	public double getCruiseSpeed() {
		return cruiseSpeed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public static class VesselBuilder {
		private final String vesselName;
		private double maximumLoad;
		private double cruiseSpeed;
		private double maxSpeed;
		private Date startDate;
		private Date endDate;

		public VesselBuilder(String vesselName) {
			this.vesselName = vesselName;
		}

		public VesselBuilder maximumLoad(double maximumLoad) {
			this.maximumLoad = maximumLoad;
			return this;
		}

		public VesselBuilder cruiseSpeed(double cruiseSpeed) {
			this.cruiseSpeed = cruiseSpeed;
			return this;
		}

		public VesselBuilder maxSpeed(double maxSpeed) {
			this.maxSpeed = maxSpeed;
			return this;
		}

		public VesselBuilder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public VesselBuilder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public Vessel build() {
			return new Vessel(this);

		}
	}
}
