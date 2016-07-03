package purejava;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "routeHeader")
public class VesselHeader {
	@XmlElement(name = "vesselName")
	private String vesselName;
	@XmlElement(name = "maxCapacity")
	private double maximumLoad;
	@XmlElement(name = "speed")
	private double cruiseSpeed;
	@XmlElement(name = "maxSpeed")
	private double maxSpeed;
	@XmlElement(name = "startDate")
	private Date startDate;
	@XmlElement(name = "endDate")
	private Date endDate;

	public VesselHeader() {
		super();
	}

	public VesselHeader(VesselHeaderBuilder vesselHeaderBuilder) {
		super();
		this.vesselName = vesselHeaderBuilder.vesselName;
		this.maximumLoad = vesselHeaderBuilder.maximumLoad;
		this.cruiseSpeed = vesselHeaderBuilder.cruiseSpeed;
		this.maxSpeed = vesselHeaderBuilder.maxSpeed;
		this.startDate = vesselHeaderBuilder.startDate;
		this.endDate = vesselHeaderBuilder.endDate;
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

	public static class VesselHeaderBuilder {
		private final String vesselName;
		private double maximumLoad;
		private double cruiseSpeed;
		private double maxSpeed;
		private Date startDate;
		private Date endDate;

		public VesselHeaderBuilder(String vesselName) {
			this.vesselName = vesselName;
		}

		public VesselHeaderBuilder maximumLoad(double maximumLoad) {
			this.maximumLoad = maximumLoad;
			return this;
		}

		public VesselHeaderBuilder cruiseSpeed(double cruiseSpeed) {
			this.cruiseSpeed = cruiseSpeed;
			return this;
		}

		public VesselHeaderBuilder maxSpeed(double maxSpeed) {
			this.maxSpeed = maxSpeed;
			return this;
		}

		public VesselHeaderBuilder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public VesselHeaderBuilder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public VesselHeader build() {
			return new VesselHeader(this);

		}
	}
}
