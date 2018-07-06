import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*ApplicationContext mycontext = new ClassPathXmlApplicationContext("Beans.xml");
		Customer mycous = (Customer)mycontext.getBean("customer");
		System.out.println(mycous.toString());*/
		
		ApplicationContext mycontext = new ClassPathXmlApplicationContext("Beans2.xml");
		Customer mycous = (Customer)mycontext.getBean("customer");
		System.out.print(mycous.toString());
	}

}
