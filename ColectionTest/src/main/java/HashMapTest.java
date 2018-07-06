import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import ch.qos.logback.core.db.dialect.MySQLDialect;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HashMapTest {

	static float result = 0f;
	static int count = 0;
	static int result2 = 0;

	private static Map<String, Integer> mymap = new HashMap<String, Integer>();


	public HashMapTest(Map<String, Integer> mymap) {
		super();
		this.mymap = mymap;
	}

	public Map<String, Integer> getMymap() {
		mymap.forEach((name2,grade)->{
			result += grade;
		});
		return mymap;
	}
	public void setMymap(Map<String, Integer> mymap) {
		this.mymap = mymap;
	}
	@Override
	public String toString() {
		return "HashMapTest [Mymap()=" + getMymap() + "]"+ "총합은 : "+result;
		
	}

	public static void main(String[] args) {

		//1번
		System.out.println("------------------------------------1번");
		mymap.put("Kim", 86);
		mymap.put("Choi", 89);
		mymap.put("Park", 90);
		mymap.put("Ju", 90);
		System.out.println(mymap);


		//2번 해쉬맵의 총점과 평균을 구하시오 
		//2-1번
		System.out.println("------------------------------------2-1번");
		Object[] keys = mymap.keySet().toArray();
		for (int i = 0; i < 4; i++) {
			result +=mymap.get(keys[i]);
		}

		System.out.println("총점은 :"+result);	
		System.out.println("평균은 :"+result/4);	
		result = 0;

		//2-2번
		System.out.println("------------------------------------2-2번");
		mymap.forEach((name2,grade)->{
			result += grade;
		});
		System.out.println("총점은 :"+result);	
		System.out.println("평균은 :"+result/4);	
		result = 0;

		System.out.println("------------------------------------2-3번");

		//2-3번
		mymap.entrySet().forEach(
				entry->{
					result += entry.getValue();
				});
		System.out.println("총점은 :"+result);	
		System.out.println("평균은 :"+result/4);	
		result = 0;

		System.out.println("------------------------------------2-4번");

		//2-4번
		mymap.keySet().forEach(entry->{
			result += mymap.get(entry);
		});
		System.out.println("총점은 :"+result);	
		System.out.println("평균은 :"+result/4);	
		result = 0;

		//3번
		System.out.println("------------------------------------3번");
		System.out.println("Ju의 점수는"+mymap.get("Ju"));


		//4번
		System.out.println("------------------------------------4번");
		mymap.forEach((number,carType)->{
			if (carType>=80) {
				count++;
			}
		});
		System.out.println("80점이 넘는 사람은"+count);


		//5번
		ApplicationContext mycontext = new ClassPathXmlApplicationContext("HashMapBeans.xml");
		HashMapTest mb =  (HashMapTest) mycontext.getBean("mymap");
		System.out.println(mb.toString());



	}

}
