
public class City {
	private String country;
	private String city;

	public City() {

	}

	public City(String country) {
		this.country = country;
	}

	public City(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(country)
				.append(", ");
		builder.append(city);
		return builder.toString();
	}

}