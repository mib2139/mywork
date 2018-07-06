import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext myapp = new ClassPathXmlApplicationContext("Beans.xml");
		//Car obj = (Car) myapp.getBean("car");

		Student obj2 = (Student) myapp.getBean("student");

		//System.out.println(obj.toString());
		System.out.println(obj2.toString());
	}
}
