package hw1.parserYahooFinanceXmlJAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Написать парсер для Yahoo Finance в
 * режиме XML (format=xml).
 */
public class Main {
	private static String path = "output.xml";
	public static void main(String[] args) throws Exception {
		String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
				"yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
		performRequestAndWriteToFile(request);
		try {
			Query query;
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);

			// читаем из файла
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			query = (Query) unmarshaller.unmarshal(file);
			System.out.println(query.toString());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static void performRequestAndWriteToFile(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
			char[] buf = new char[1000000];
			int r;
			do {
				if ((r = br.read(buf)) > 0)
					bw.write(new String(buf, 0, r));
				bw.flush();
			} while (r > 0);
		} finally {
			http.disconnect();
		}
	}

}
