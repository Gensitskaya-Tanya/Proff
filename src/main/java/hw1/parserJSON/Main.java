package hw1.parserJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Задача 2. Распарсить следующую структуру данных:
 * {
 * “name”: “…”,
 * “surname”: “…”,
 * “phones”: [“044-256-78-90”, “066-123-45-67”, …],
 * “sites”: [“http://site1.com”, “http://site2.com”, …],
 * “address”: {
 * “country”: “…”,
 * “city”: “…”,
 * “street”: “…”
 * }
 * }
 */
public class Main {
	public static void main(String[] args) throws Exception {

		String data = readDataFromFile("F:\\_Prog\\Proff\\src\\main\\java\\hw1\\parserJSON\\json.txt");

		Gson gson = new GsonBuilder().create();
		JSON json = (JSON) gson.fromJson(data, JSON.class);


		System.out.println(json.toString());

		System.out.println("JSON: \n\t" + gson.toJson(json));
	}

	private static String readDataFromFile(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		String str;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
