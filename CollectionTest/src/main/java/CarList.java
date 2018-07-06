
import java.util.List;
import java.util.Map;

public class CarList {
	private List<Object> list;
	private Map <Object, Object> maps;
	
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Map<Object, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<Object, Object> maps) {
		this.maps = maps;
	}
	
	public String toString1() {
		return "CarList [getList()=" + getList();
	}
	
	public String toString2() {
		return "CarMap [getMap()=" + getMaps();
	}
	
}
