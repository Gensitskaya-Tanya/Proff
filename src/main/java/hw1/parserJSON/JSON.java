package hw1.parserJSON;


import java.util.Arrays;

public class JSON {
	private String name;
	private String surname;
	private String[] phones;
	private String[] sites;
	private Address address;


	@Override
	public String toString() {
		return "fromJSON{" + '\n' +
				"name='" + name + '\'' + '\n' +
				"surname='" + surname + '\'' + '\n' +
				"phones=" + Arrays.toString(phones) + '\n' +
				"sites=" + Arrays.toString(sites) + '\n' +
				"address=" + address + '\n' +
				'}';
	}
}
