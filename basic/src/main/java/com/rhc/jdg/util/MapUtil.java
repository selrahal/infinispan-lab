package com.rhc.jdg.util;

import java.util.Map;

public class MapUtil {
	public static String contents(Map<String,String> map) {
		StringBuilder toReturn = new StringBuilder();
		for (String key : map.keySet()) {
			toReturn.append(key + ":" + map.get(key));
			toReturn.append("\n");
		}
		
		return toReturn.toString();
	}
}
