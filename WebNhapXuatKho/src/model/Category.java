package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cate_id;
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> listp = new ArrayList<Product>();

	public Category(int cate_id, String name, List<Product> listp) {
		super();
		this.cate_id = cate_id;
		this.name = name;
		this.listp = listp;
	}

	public Category() {
		super();
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getListp() {
		return listp;
	}

	public void setListp(List<Product> listp) {
		this.listp = listp;
	}

	@Override
	public String toString() {
		return "Category [cate_id=" + cate_id + ", name=" + name + ", listp=" + listp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cate_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return cate_id == other.cate_id;
	}
	
	
}
