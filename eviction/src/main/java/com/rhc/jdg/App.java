package com.rhc.jdg;

import java.util.Map;
import java.util.Map.Entry;

import org.infinispan.Cache;

import com.rhc.jdg.util.CacheProvider;
import com.rhc.jdg.util.MapUtil;

public class App {
	private static CacheProvider cacheProvider = new CacheProvider();
	
	public static void main(String[] args) {
		Map<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		cache.put("key4", "value4");
		cache.put("key5", "value5");
		System.out.println(MapUtil.contents(cache));
		cache.put("key6", "value6");
		System.out.println(MapUtil.contents(cache));
		for (Entry<String, String> entry : cache.entrySet()) {
			((Cache<String, String>)cache).evict(entry.getKey());
		}
		System.out.println("---After Evict---");
		System.out.println(MapUtil.contents(cache));
	}
}
