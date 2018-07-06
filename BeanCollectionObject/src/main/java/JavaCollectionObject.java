import java.util.ArrayList;
import java.util.List;

public class JavaCollectionObject {
static int bufsize=3;
	public static void main(String[] args) {
		List<Student> stulist = new ArrayList<Student>();

		Student[]  stu = new Student[3];
		for (int i = 0; i <  bufsize; i++) {
			stu[i] = new Student("gntp"+i);
			stulist.add(stu[i]);
		}
		System.out.println(stulist);
	}
	
	
	

}
