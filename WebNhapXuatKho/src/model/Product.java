package model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pro_id;
	private String pname;
	
	@Lob
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "cate_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "sup_id")
	private Supplier supplier;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_size", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SIZE_ID") })
	private List<Size> listsize = new ArrayList<Size>();

	public Product(int pro_id, String pname, byte[] image, Category category, Supplier supplier, List<Size> listsize) {
		super();
		this.pro_id = pro_id;
		this.pname = pname;
		this.image = image;
		this.category = category;
		this.supplier = supplier;
		this.listsize = listsize;
	}

	public Product() {
		super();
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Size> getListsize() {
		return listsize;
	}

	public void setListsize(List<Size> listsize) {
		this.listsize = listsize;
	}

	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pname=" + pname + ", image=" + Arrays.toString(image) + ", category="
				+ category + ", supplier=" + supplier + ", listsize=" + listsize + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pro_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pro_id == other.pro_id;
	}
	
	
}
