package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int size_id;
	private String sizename;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_size", joinColumns = { @JoinColumn(name = "SIZE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PRODUCT_ID") })
	private List<Product> listproduct = new ArrayList<Product>();

	public Size(int size_id, String sizename, List<Product> listproduct) {
		super();
		this.size_id = size_id;
		this.sizename = sizename;
		this.listproduct = listproduct;
	}

	public Size() {
		super();
	}

	public int getSize_id() {
		return size_id;
	}

	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}

	public String getSizename() {
		return sizename;
	}

	public void setSizename(String sizename) {
		this.sizename = sizename;
	}

	public List<Product> getListproduct() {
		return listproduct;
	}

	public void setListproduct(List<Product> listproduct) {
		this.listproduct = listproduct;
	}

	@Override
	public String toString() {
		return "Size [size_id=" + size_id + ", sizename=" + sizename + ", listproduct=" + listproduct + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(size_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Size other = (Size) obj;
		return size_id == other.size_id;
	}


}
