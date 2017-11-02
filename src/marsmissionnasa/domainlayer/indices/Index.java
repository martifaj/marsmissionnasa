package marsmissionnasa.domainlayer.indices;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Index<K extends Comparable<K>, D> {
	private Map<K, D> map;
	
	public Index() {
		map = new TreeMap<>();
	}
	
	public void add(K key, D data) {
		map.put(key, data);
	}
	
	public D find(K key) {
		return map.get(key);
	}

	public void delete(K key) {
		map.remove(key);
	}
	
	public Set<K> keys() {
		return map.keySet();
	}
}
