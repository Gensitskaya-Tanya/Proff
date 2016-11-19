package hw1.parserXMLTrain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
 * отправляются сегодня с 15:00 до 19:00.
 * Написать код для добавления новых поездов в существующий XML.
 */
public class Main {
	public static void main(String[] args) {
		Train train1 = new Train("Kiev", "Lviv", "11.12.2016", "12:30", 1);
		Train train2 = new Train("Kiev", "Lviv", "11.12.2016", "12:30", 2);
		Train train3 = new Train("Kiev", "Lviv", "19.11.2016", "18:30", 3);
		Train train4 = new Train("Kiev", "Lviv", "11.12.2016", "12:30", 4);
		Train train5 = new Train("Kiev", "Lviv", "19.11.2016", "17:30", 5);

		Trains trains = new Trains();
		trains.addTrain(train1);
		trains.addTrain(train2);
		trains.addTrain(train3);
		trains.addTrain(train4);
		trains.addTrain(train5);

		try {
			File file = new File("F:\\_Prog\\Proff\\src\\main\\java\\hw1\\parserXMLTrain\\output.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			// читабельное форматирование
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// пишем в файл
			marshaller.marshal(trains, file);
			marshaller.marshal(trains, System.out);

			// читаем из файла
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			trains = (Trains) unmarshaller.unmarshal(file);
			printTrain_From_15_to_19(trains);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void printTrain_From_15_to_19(Trains trains) {
		List<Train> listTrain = trains.getListTrain();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date dateToday = new Date();
		String dateTodayStr = dateFormat.format(dateToday);

		for (Train etrain : listTrain) {
			String trainDateString = etrain.getDate();
			if (dateTodayStr.equals(trainDateString)) {
				String hour = etrain.getDeparture().substring(0, 2);  // time
				int hourInt = Integer.parseInt(hour);
				if (hourInt >= 17 && hourInt <= 19) {
					System.out.println("---------------");
					System.out.println(etrain);
				}

			}
		}
	}


}
