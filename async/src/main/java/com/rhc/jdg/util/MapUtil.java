package com.rhc.jdg.util;

import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {
	public static <K,V> String contents(Map<K,V> map) {
		StringBuilder toReturn = new StringBuilder();
		for (Entry<K,V> entry : map.entrySet()) {
			toReturn.append(entry.getKey() + ":" + entry.getValue());
			toReturn.append("\n");
		}
		
		return toReturn.toString();
	}
}
