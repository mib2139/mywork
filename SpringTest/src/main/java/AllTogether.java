
class AllTogether {
	String model;
	String company;
	String color;
	int price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "모델명: " + getModel() + ", 회사이름: " + getCompany() + ", 컬러 : " + getColor()
		+ ", 가격: " + getPrice();
	}
	
	public AllTogether(String model, String company, String color, int price) {
		super();
		this.model = model;
		this.company = company;
		this.color = color;
		this.price = price;
	}
	
	public AllTogether() {

	}
	
}
