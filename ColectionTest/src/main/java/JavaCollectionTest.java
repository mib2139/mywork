import java.util.ArrayList;
import java.util.List;

public class JavaCollectionTest {
	List<String> mylist = new ArrayList<String>();
	public static void main(String[] args) {

		JavaCollectionTest myapp = new JavaCollectionTest();
		
		myapp.mylist.add("Apple");
		myapp.mylist.add("Banana");
		myapp.mylist.add("Orange");
		myapp.mylist.add("Pear");
		System.out.println(myapp.mylist.toString());

	}

}
