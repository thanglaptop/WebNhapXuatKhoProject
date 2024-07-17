package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sup_id;
	private String sup_name;
	private String address;
	private String phone;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private List<Product> listp = new ArrayList<Product>();

	public Supplier(int sup_id, String sup_name, String address, String phone, List<Product> listp) {
		super();
		this.sup_id = sup_id;
		this.sup_name = sup_name;
		this.address = address;
		this.phone = phone;
		this.listp = listp;
	}

	public Supplier() {
		super();
	}

	public int getSup_id() {
		return sup_id;
	}

	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}

	public String getSup_name() {
		return sup_name;
	}

	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Product> getListp() {
		return listp;
	}

	public void setListp(List<Product> listp) {
		this.listp = listp;
	}

	@Override
	public String toString() {
		return "Supplier [sup_id=" + sup_id + ", sup_name=" + sup_name + ", address=" + address + ", phone=" + phone
				+ ", listp=" + listp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sup_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return sup_id == other.sup_id;
	}
	
}
