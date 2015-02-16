package com.rhc.jdg.util;

import java.util.Map;
import java.util.Set;

public class MapUtil {
	public static <K,V> String contents(Map<K,V> map) {
		StringBuilder toReturn = new StringBuilder();
		Set<K> keys = map.keySet();
		for (K key: keys) {
			toReturn.append(key + ":" + map.get(key));
			toReturn.append("\n");
		}
		
		return toReturn.toString();
	}
}
