package com.rhc.jdg;

import java.util.Map;

import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

import com.rhc.jdg.util.MapUtil;

public class App {
	public static void main(String[] args) {
		EmbeddedCacheManager cacheManager = new DefaultCacheManager();
		Map<String, String> cache = cacheManager.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		System.out.println(MapUtil.contents(cache));
		
	}
}
