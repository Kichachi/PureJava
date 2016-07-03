package purejava;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "route")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vessel {
	@XmlElement(name = "routeHeader")
	private VesselHeader vesselHeader;
	@XmlElementWrapper(name = "legs")
	@XmlElement(name = "leg")
	private List<Route> routes;

	public Vessel() {
		super();
	}

	public Vessel(VesselBuilder vesselBuilder) {
		super();
		vesselHeader = new VesselHeader.VesselHeaderBuilder(vesselBuilder.vesselName)
				.maximumLoad(vesselBuilder.maximumLoad).cruiseSpeed(vesselBuilder.cruiseSpeed)
				.maxSpeed(vesselBuilder.maxSpeed).startDate(vesselBuilder.startDate).endDate(vesselBuilder.endDate)
				.build();
	}

	public VesselHeader getVesselHeader() {
		return vesselHeader;
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
