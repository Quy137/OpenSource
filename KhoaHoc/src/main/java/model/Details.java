package model;



public class Details {
	private String id;
	private String image;
	private String rating;
	private Customer customerFK;
	private Packages packagesFK;
	
	


	public Details(String id, String image, String rating, Customer customerFK, Packages packagesFK) {
		super();
		this.id = id;
		this.image = image;
		this.rating = rating;
		this.customerFK = customerFK;
		this.packagesFK = packagesFK;
	}


	public Details() {
		super();
	}


	public Customer getCustomerFK() {
		return customerFK;
	}

	public void setCustomerFK(Customer customerFK) {
		this.customerFK = customerFK;
	}

	public Packages getPackagesFK() {
		return packagesFK;
	}

	public void setPackagesFK(Packages packagesFK) {
		this.packagesFK = packagesFK;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	

	
	
}
