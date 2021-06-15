
public class Address extends City {
	private int zipCode;
	private String nameOfPublicPlace;
	private String typeOfPublicPlace;
	private int number;

	public Address(int zipCode) {
		this.zipCode = zipCode;
	}

	public Address(String country, String city, int zipCode) {
		super(country, city);
		this.zipCode = zipCode;
	}

	public Address(int zipCode, int number) {
		this(zipCode);
		this.number = number;
	}

	public Address(String country, String city, int zipCode, String nameOfPublicPlace, String typeOfPublicPlace, int number) {
		super(country, city);
		this.zipCode = zipCode;
		this.nameOfPublicPlace = nameOfPublicPlace;
		this.typeOfPublicPlace = typeOfPublicPlace;
		this.number = number;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getNameOfPublicPlace() {
		return nameOfPublicPlace;
	}

	public void setNameOfPublicPlace(String nameOfPublicPlace) {
		this.nameOfPublicPlace = nameOfPublicPlace;
	}

	public String getTypeOfPublicPlace() {
		return typeOfPublicPlace;
	}

	public void setTypeOfPublicPlace(String typeOfPublicPlace) {
		this.typeOfPublicPlace = typeOfPublicPlace;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getCountry());
		builder.append(" ");
		builder.append(super.getCity());
		builder.append(" ");
		builder.append(zipCode);
		builder.append(" ");
		builder.append(nameOfPublicPlace);
		builder.append(" ");
		builder.append(typeOfPublicPlace);
		builder.append(" ");
		builder.append(number);
		return builder.toString();
	}
}