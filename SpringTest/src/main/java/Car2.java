class Car2{
	String brand;
	int price;
	SmallCar matiz;
	
	Car2(){};
	
	Car2(String brand, int price){
		this.brand = brand;
		this.price = price;
	}

	void setBrand(String brand) {
		this.brand = brand;
	}

	void setPrice(int price) {
		this.price = price;
	}

	void setMatiz(SmallCar matiz) {

		this.matiz = matiz;
	}
}   