package fr.digi.animalerie.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "petstore")
public class PetStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "manager")
	private String managerName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ADDR", referencedColumnName = "id")
	private Address address;

	@OneToMany(mappedBy = "store", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Set<Product> products;

	@OneToMany(mappedBy = "store", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Set<Animal> animals;

	{
		products = new HashSet<>();
		animals = new HashSet<>();
	}
	public PetStore() {
	}

	public PetStore(Address address, String name, String manager) {
		this.address = address;
		this.name = name;
		this.managerName = manager;
	}

    public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return managerName;
	}

	public void setManager(String manager) {
		managerName = manager;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addr) {
		this.address = addr;
		if (addr != null) {
			addr.setPetStore(this);
		}
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		if (product != null) {
			product.setStore(this);
		}
	}

	public void removeProduct(Product product) {
		if (product != null) {
			product.setStore(null);
		}
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	public void addAnimal(Animal animal) {
		if (animal != null) {
			animal.setStore(this);
		}
	}

	public void removeAnimal(Animal animal) {
		if (animal != null) {
			animal.setStore(null);
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PetStore{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", manager='").append(managerName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
