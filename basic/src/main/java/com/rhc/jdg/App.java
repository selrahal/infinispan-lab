package com.rhc.jdg;

import java.util.Map;

import org.infinispan.client.hotrod.RemoteCache;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;
import com.rhc.jdg.util.MapUtil;

public class App {
	private static JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
	private static XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
	private static RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
	
	public static void main(String[] args) {
		Map<String, String> cache = javaCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		System.out.println(MapUtil.contents(cache));
		
		
		cache = xmlCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		System.out.println(MapUtil.contents(cache));
		
		RemoteCache<String, String> remoteCache = remoteCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		System.out.println(MapUtil.contents(cache));
	}
}
