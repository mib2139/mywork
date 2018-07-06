

public class Car {

	String model;
	String color;
	String company;
	int price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Car() {
		
	}
	
	public Car(String model, String color, String company, int price) {
		super();
		this.model = model;
		this.color = color;
		this.company = company;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Model()=" + getModel() + ", Color()=" + getColor() + ", Company()=" + getCompany()
		+ ", Price()=" + getPrice() + "]";
	}

}
