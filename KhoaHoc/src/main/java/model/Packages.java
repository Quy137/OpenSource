package model;

public class Packages {
	private String packagesID;
	private String namePackages;
	private double costPrice;
	private double salePrice;
	private String discription;
	private String payment;
	
	public Packages(String packagesID, String namePackages, double costPrice, double salePrice, String discription,
			String payment) {
		super();
		this.packagesID = packagesID;
		this.namePackages = namePackages;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.discription = discription;
		this.payment = payment;
	}
	

	public Packages(String packagesID) {
		super();
		this.packagesID = packagesID;
	}


	public Packages() {
		super();
	}

	public String getPackagesID() {
		return packagesID;
	}

	public void setPackagesID(String packagesID) {
		this.packagesID = packagesID;
	}

	public String getNamePackages() {
		return namePackages;
	}

	public void setNamePackages(String namePackages) {
		this.namePackages = namePackages;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Packages [packagesID=" + packagesID + ", namePackages=" + namePackages + ", costPrice=" + costPrice
				+ ", salePrice=" + salePrice + ", discription=" + discription + ", payment=" + payment + "]";
	}
	
	
}
