package hw1.parserXMLTrain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="trains")
public class Trains {

	@XmlElement(name="train")
	private List<Train> listTrain = new ArrayList<>();

	public void addTrain(Train trainNew){
		listTrain.add(trainNew);
	}

	public List<Train> getListTrain() {
		return listTrain;
	}

	@Override
	public String toString() {
		return Arrays.deepToString(listTrain.toArray());
	}
}
