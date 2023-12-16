package fr.digi.animalerie.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "number")
	private String number;

	@Column(name = "street")
	private String street;

	@Column(name = "zipcode")
	private String zipCode;

	@Column(name = "city")
	private String city;

	@OneToOne(mappedBy = "address")
	private PetStore petStore;

	public Address() {
	}
	public Address(String number, String street, String zipcode, String city) {
		this.number = number;
		this.street = street;
		this.zipCode = zipcode;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Address{");
		sb.append("id=").append(id);
		sb.append(", number='").append(number).append('\'');
		sb.append(", street='").append(street).append('\'');
		sb.append(", zipCode='").append(zipCode).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append('}');
		return sb.toString();
	}


}