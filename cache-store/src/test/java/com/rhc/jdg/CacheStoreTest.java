package com.rhc.jdg;

import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class CacheStoreTest {
	
	@Test
	public void testJavaCache() {
		JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
		Cache<String, String> cache = javaCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.evict("key1");
		cache.evict("key2");
		Assert.assertEquals("Cache does not have entries", 2, cache.size());
		Assert.assertEquals("value1", cache.get("key1"));
		Assert.assertEquals("value2", cache.get("key2"));
	}
	
	@Test
	public void testXmlCache() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Cache<String, String> cache = xmlCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.evict("key1");
		cache.evict("key2");
		Assert.assertEquals("Cache does not have entries", 2, cache.size());
		Assert.assertEquals("value1", cache.get("key1"));
		Assert.assertEquals("value2", cache.get("key2"));
	}
	
	
	@Test
	public void testRemoteCache() {
		//How do we test this? Remember that the remote interface does not expose evict method.
	}
}
