import java.util.List;

public class Fruit {
	List fruitlist;

	public List getFruitlist() {
		return fruitlist;
	}

	public void setFruitlist(List fruitlist) {
		this.fruitlist = fruitlist;
	}

	
	@Override
	public String toString() {
		return "Fruit [getFruitlist()=" + getFruitlist() + "]";
	}
	
	
	
}
