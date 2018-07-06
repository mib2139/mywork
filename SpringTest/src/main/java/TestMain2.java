import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain2 {

	public static void main(String[] args) {
		//1번
		Person person = new Person("techJava");
		System.out.println(person.getName());

		//2번
		Person person2 = new Person();
		person2.setName("GoJapan1");
		person2.setAge(20);
		System.out.println(person2.getName()+","+person2.getAge());

		//3번
		Person person3 = new Person();
		person3.setName("GoJapan2");
		person3.setAge(40);
		System.out.println(person3.getName()+","+person3.getAge());
		
		//4번
		Student2 stu = new Student2();
		stu.setPerson(person3);
		System.out.println(stu.toString());
	
		//5번

		ApplicationContext ac = new ClassPathXmlApplicationContext("Test.xml");
		Car2 obj3 = (Car2) ac.getBean("mycar2");
		System.out.println(obj3.toString());
		
	}

}
