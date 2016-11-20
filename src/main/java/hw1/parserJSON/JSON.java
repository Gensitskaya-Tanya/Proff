package hw1.parserJSON;


import java.util.Arrays;

public class JSON {
	private String name;
	private String surname;
	private String[] phones;
	private String[] sites;
	private Address address;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String[] getPhones() {
		return phones;
	}

	public String[] getSites() {
		return sites;
	}

	public Address getAddress() {
		return address;
	}

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
