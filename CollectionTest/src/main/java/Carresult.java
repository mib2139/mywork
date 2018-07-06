import java.util.ArrayList;
import java.util.List;

public class Carresult {
	static int bufsize=3;
	List<String> mylist = new ArrayList<String>();
	public static void main(String[] args) {
		//1번
		Carresult myapp = new Carresult();

		myapp.mylist.add("아우디");
		myapp.mylist.add("벤츠");
		myapp.mylist.add("폭스바겐");
		System.out.println(myapp.mylist.toString());
		
		//2번
		List<Car> carlist = new ArrayList<Car>();
		Car[] stu = new Car[3];
		
		stu[0] = new Car("audi","balck","아우디",9000);
		stu[1] = new Car("bentz","balck","벤츠",9000);
		stu[2] = new Car("fox","balck","폭스바겐",9000);

		carlist.add(stu[0]);
		carlist.add(stu[1]);
		carlist.add(stu[2]);
		System.out.println(carlist);
	}
}