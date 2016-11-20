package hw1.parserXmlJAXB_Train;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "train")
public class Train {

	private String from;
	private String to;
	private String date;
	private String departure;
	private int id;

	public Train() {
	}

	public Train(String from, String to, String date, String departure, int id) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.departure = departure;
		this.id = id;
	}


	public String getFrom() {
		return from;
	}

	@XmlElement
	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	@XmlElement
	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	@XmlElement
	public void setDate(String date) {
		this.date = date;
	}

	public String getDeparture() {
		return departure;
	}

	@XmlElement
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Train number:" + id + "\n" +
				"from = " + from + "\n" +
				"to = " + to + "\n" +
				"date = " + date + "\n" +
				"departure = " + departure;
	}
}
