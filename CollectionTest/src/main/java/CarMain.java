import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		
		ApplicationContext mycontext = new ClassPathXmlApplicationContext("CarBean.xml");
		CarList mycar= (CarList) mycontext.getBean("carlist");
		System.out.println(mycar.toString1());
		System.out.println(mycar.toString2());
	}

}
