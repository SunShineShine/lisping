package lisping.vm;

import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.HashedMap;

public class HashMap<K, V> extends HashedMap<K, V> {

	private static final long serialVersionUID = 1L;

	@Override
	public AbstractHashedMap.HashEntry<K, V> getEntry(Object key) {
		return super.getEntry(key);
	}

}
