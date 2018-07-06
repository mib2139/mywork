import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashmapBasic {

	public static void main(String[] args) {
		//예제 1번
		Map<Integer , String> maps = new HashMap<Integer, String>();
		maps.put(1, "Audi");
		maps.put(2, "Bentz");
		maps.put(3, "fox");
		maps.put(4, "LandRover");

		System.out.println(maps);

		
		//2번
		if (maps.containsKey(1)) {
			System.out.println("------키값 매칭");
			System.out.println(maps.get(1));
		}

		//예제3번
		System.out.println("-------------------------3번");

		for (int i = 0; i < maps.size(); i++) {
			System.out.println(maps.get(i+1));
		}

		//예제 4번 - 업데이트가 필요함
		System.out.println("-------------------------4번");
		 maps.forEach((number,carType)->{
	         System.out.println(number + "=>"+ carType);
	      });


		//예제 5번 - put해서 넣은 값을 set형태 즉, 집합 형태로 만들어짐.
		System.out.println("-------------------------5번");
		maps.entrySet().forEach(
				entry->{
					System.out.println(entry.getKey() +"=" + entry.getValue());	
				});

		//예제 6번 - 키를 설정해주는 친구라서 get으로 받아도 되는 듯
		System.out.println("-------------------------6번");
		maps.keySet().forEach(entry->{
			System.out.println(entry +"=>"+maps.get(entry));
		});

		
		/*예제 7번 - 집합형태인 맵을 스트링으로 바꾼다. 그리고 필터링을 filter를 통해서 한다.
		 * 그리고 필터를 해야하는 내용을 filter의 아규먼트를 통해서 넘긴다. 
		 * landRover와 같으은 내용을 map에 저장한다. 그리고 그내용을 map으로 넘김 또 그걸 모음 이게 result값이 됨
		 */		
		System.out.println("-------------------------7번");
		String result = null;
	    result = maps.entrySet().stream().filter(map->"Audi".equals(map.getValue()))
	            .map(map->map.getValue())
	            .collect(Collectors.joining()
	                  ); 
	      System.out.println(result);

	}

}
