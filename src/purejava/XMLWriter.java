package purejava;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLWriter {

	public static void writeToXml(Vessel vessel) {
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm");
			String fileName = vessel.getVesselHeader().getVesselName() + "_"
					+ formatter.format(vessel.getVesselHeader().getStartDate()) + "_"
					+ formatter.format(vessel.getVesselHeader().getEndDate()) + ".xml";
			fileName = fileName.replaceAll("\\s", "_");
			JAXBContext jaxbContext = JAXBContext.newInstance(Vessel.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(vessel, new File(fileName));
			jaxbMarshaller.marshal(vessel, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
