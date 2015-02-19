package com.rhc.jdg;


import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class ListenersAndInterceptorsTest {

	@Test
	public void testJavaCache() {
		Cache<String, String> cache = new JavaCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
	}
	
	@Test
	public void testXmlCache() {
		Cache<String, String> cache = new XmlCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
	}
	
	@Test
	public void testRemoteCache() {
		RemoteCache<String, String> cache = new RemoteCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
	}
}
