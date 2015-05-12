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
		JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
		Cache<String, String> cache = javaCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
		javaCacheProvider.stop();
	}
	
	@Test
	public void testXmlCache() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Cache<String, String> cache = xmlCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
		xmlCacheProvider.stop();
	}
	
	@Test
	public void testRemoteCache() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<String, String> cache = remoteCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.get("key1");
		cache.get("key1");
		remoteCacheProvider.stop();
	}
}
