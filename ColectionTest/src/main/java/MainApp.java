import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext mycontext = new ClassPathXmlApplicationContext("Beans.xml");
		
		Fruit obj= (Fruit) mycontext.getBean("fruit");
		System.out.println(obj.toString());
	}

}
