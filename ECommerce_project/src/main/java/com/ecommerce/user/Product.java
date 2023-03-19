package com.ecommerce.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	@Column(length = 3000)
	private String pDesc;
	private String pphoto;
	private int pprice;
	private int pdiscount;
	private int pquantity;
	@ManyToOne
	private Catagory catagory;

	public Product(int pid, String pname, String pDesc, String pphoto, int pprice, int pdiscount, int pquantity,
			Catagory catagory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pDesc = pDesc;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pquantity = pquantity;
		this.catagory = catagory;
	}

	public Product(String pname, String pDesc, String pphoto, int pprice, int pdiscount, int pquantity,
			Catagory catagory) {
		super();
		this.pname = pname;
		this.pDesc = pDesc;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pquantity = pquantity;
		this.catagory = catagory;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getPphoto() {
		return pphoto;
	}

	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pDesc=" + pDesc + ", pphoto=" + pphoto + ", pprice="
				+ pprice + ", pdiscount=" + pdiscount + ", pquantity=" + pquantity + ", catagory=" + catagory + "]";
	}
	
	public int getPriceAfterDis() {
		int d = (int) ((this.getPdiscount()/100.0)*this.getPprice());
		return this.getPprice() - d;
	}

}
