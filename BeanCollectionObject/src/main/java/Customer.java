import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {
	private List<Object> list;
	private Set<Object> sets;
	private Map<Object,Object> maps;


	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public Set<Object> getSets() {
		return sets;
	}

	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}

	public Map<Object, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<Object, Object> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "Customer getSets()=" + getSets() + ", getMaps()=" + getMaps() + "]";
	}

}
