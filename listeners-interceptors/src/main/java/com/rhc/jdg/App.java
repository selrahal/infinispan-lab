package com.rhc.jdg;

import org.infinispan.Cache;

import com.rhc.jdg.util.CacheProvider;
import com.rhc.jdg.util.MapUtil;

public class App {
	private static CacheProvider cacheProvider = new CacheProvider();
	
	public static void main(String[] args) {
		Cache<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		System.out.println(MapUtil.contents(cache));
	}
}
