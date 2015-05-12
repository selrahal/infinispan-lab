package com.rhc.jdg;

import org.infinispan.Cache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
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
		Assert.assertEquals("Java Cache size is not correct", 2, cache.size());
		Assert.assertEquals("value1", cache.get("key1"));
		Assert.assertEquals("value2", cache.get("key2"));
		
		javaCacheProvider.stop();
	}
	
	@Test
	public void testXmlCache() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Cache<String, String> cache = xmlCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.evict("key1");
		cache.evict("key2");
		Assert.assertEquals("XML Cache size is not correct", 2, cache.size());
		Assert.assertEquals("value1", cache.get("key1"));
		Assert.assertEquals("value2", cache.get("key2"));
		
		xmlCacheProvider.stop();
	}
	
	
	@Test
	public void testRemoteCache() {
		//How do we test this? Remote cache does not expose .evict method......
	}
}
