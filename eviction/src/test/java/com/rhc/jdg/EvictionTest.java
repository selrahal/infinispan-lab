package com.rhc.jdg;

import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class EvictionTest {

	@Test
	public void testJavaEviction() {
		JavaCacheProvider cacheProvider = new JavaCacheProvider();
		Cache<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.put("key3", "value1");
		cache.put("key4", "value1");
		cache.put("key5", "value1");
		cache.put("key6", "value1");
		Assert.assertTrue("Cache size is over 5", cache.size() <= 5);
		
		for (String key : cache.keySet()) {
			cache.evict(key);
		}
		
		Assert.assertEquals("Cache still contains entries", 0, cache.size());
		cacheProvider.stop();
	}
	
	@Test
	public void testXmlEviction() {
		XmlCacheProvider cacheProvider = new XmlCacheProvider();
		Cache<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.put("key3", "value1");
		cache.put("key4", "value1");
		cache.put("key5", "value1");
		cache.put("key6", "value1");
		Assert.assertTrue("Cache size is over 5", cache.size() <= 5);
		
		for (String key : cache.keySet()) {
			cache.evict(key);
		}
		
		Assert.assertEquals("Cache still contains entries", 0, cache.size());
		cacheProvider.stop();
	}
	
	@Test
	public void testRemoteEviction() {
		RemoteCacheProvider cacheProvider = new RemoteCacheProvider();
		RemoteCache<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.put("key3", "value1");
		cache.put("key4", "value1");
		cache.put("key5", "value1");
		cache.put("key6", "value1");
		Assert.assertTrue("Cache size is over 5, actual size is " + cache.size(), cache.size() <= 5);

		//Remote cache does not expose .evict(Object key) method
		cacheProvider.stop();
	}
}
