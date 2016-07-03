package purejava;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "leg")
@XmlType(propOrder = { "destPort", "arrivalTime", "departureTime", "totalContainersToUnload", "totalWeightToUnload",
		"totalContainersToLoad", "totalWeightToLoad" })
public class Route {
	private String startPort;
	private int avgLoadTime;
	private Date departureTime;
	private int totalContainersToLoad;
	private double totalWeightToLoad;
	private double distToDest;
	private String destPort;
	private int avgUnloadTime;
	private Date arrivalTime;
	private int totalContainersToUnload;
	private double totalWeightToUnload;

	public Route() {
		super();
	}

	public Route(RouteBuilder routeBuilder) {
		super();
		this.startPort = routeBuilder.startPort;
		this.avgLoadTime = routeBuilder.avgLoadTime;
		this.departureTime = routeBuilder.departureTime;
		this.totalContainersToLoad = routeBuilder.totalContainersToLoad;
		this.totalWeightToLoad = routeBuilder.totalWeightToLoad;
		this.distToDest = routeBuilder.distToDest;
		this.destPort = routeBuilder.destPort;
		this.avgUnloadTime = routeBuilder.avgUnloadTime;
		this.arrivalTime = routeBuilder.arrivalTime;
		this.totalContainersToUnload = routeBuilder.totalContainersToUnload;
		this.totalWeightToUnload = routeBuilder.totalWeightToUnload;
	}

	public String getStartPort() {
		return startPort;
	}

	public int getAvgLoadTime() {
		return avgLoadTime;
	}

	@XmlElement(name = "derpartureDate")
	public Date getDepartureTime() {
		return departureTime;
	}

	@XmlElement(name = "loadContainers")
	public int getTotalContainersToLoad() {
		return totalContainersToLoad;
	}

	@XmlElement(name = "loadWeight")
	public double getTotalWeightToLoad() {
		return totalWeightToLoad;
	}

	public double getDistToDest() {
		return distToDest;
	}

	@XmlElement(name = "startPortName")
	public String getDestPort() {
		return destPort;
	}

	public int getAvgUnloadTime() {
		return avgUnloadTime;
	}

	@XmlElement(name = "arrivalDate")
	public Date getArrivalTime() {
		return arrivalTime;
	}

	@XmlElement(name = "dischargeContainers")
	public int getTotalContainersToUnload() {
		return totalContainersToUnload;
	}

	@XmlElement(name = "dischargeWeight")
	public double getTotalWeightToUnload() {
		return totalWeightToUnload;
	}

	public static class RouteBuilder {
		private String startPort;
		private int avgLoadTime;
		private Date departureTime;
		private int totalContainersToLoad;
		private double totalWeightToLoad;
		private double distToDest;
		private String destPort;
		private int avgUnloadTime;
		private Date arrivalTime;
		private int totalContainersToUnload;
		private double totalWeightToUnload;

		public RouteBuilder(String startPort, String destPort) {
			this.startPort = startPort;
			this.destPort = destPort;
		}

		public RouteBuilder totalContainersToLoad(int totalContainersToLoad) {
			this.totalContainersToLoad = totalContainersToLoad;
			return this;
		}

		public RouteBuilder avgUnloadTime(int avgUnloadTime) {
			this.avgUnloadTime = avgUnloadTime;
			return this;
		}

		public RouteBuilder avgLoadTime(int avgLoadTime) {
			this.avgLoadTime = avgLoadTime;
			return this;
		}

		public RouteBuilder totalContainersToUnload(int totalContainersToUnload) {
			this.totalContainersToUnload = totalContainersToUnload;
			return this;
		}

		public RouteBuilder totalWeightToLoad(double totalWeightToLoad) {
			this.totalWeightToLoad = totalWeightToLoad;
			return this;
		}

		public RouteBuilder distToDest(double distToDest) {
			this.distToDest = distToDest;
			return this;
		}

		public RouteBuilder totalWeightToUnload(double totalWeightToUnload) {
			this.totalWeightToUnload = totalWeightToUnload;
			return this;
		}

		public RouteBuilder departureTime(Date departureTime) {
			this.departureTime = departureTime;
			return this;
		}

		public RouteBuilder arrivalTime(Date arrivalTime) {
			this.arrivalTime = arrivalTime;
			return this;
		}

		public Route build() {
			return new Route(this);
		}

	}
}
