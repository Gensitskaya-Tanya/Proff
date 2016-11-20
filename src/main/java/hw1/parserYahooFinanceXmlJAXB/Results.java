package hw1.parserYahooFinanceXmlJAXB;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "results")
public class Results {

	@XmlElement(name = "rate")
	private List<Rate> listrate = new ArrayList<>();


	public List<Rate> getListrate() {
		return listrate;
	}
	public void addRate(Rate rate){
		listrate.add(rate);
	}

	@Override
	public String toString() {
		return Arrays.deepToString(listrate.toArray());
	}
}
