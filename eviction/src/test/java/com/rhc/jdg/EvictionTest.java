package com.rhc.jdg;

import junit.framework.Assert;

import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class EvictionTest {

	@Test
	public void testJavaEviction() {
		Cache<String, String> cache = new JavaCacheProvider().getCache();
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
	}
	
	@Test
	public void testXmlEviction() {
		Cache<String, String> cache = new XmlCacheProvider().getCache();
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
	}
	
	@Test
	public void testRemoteEviction() {
		RemoteCache<String, String> cache = new RemoteCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		cache.put("key3", "value1");
		cache.put("key4", "value1");
		cache.put("key5", "value1");
		cache.put("key6", "value1");
		Assert.assertTrue("Cache size is over 5", cache.size() <= 5);

		//Remote cache does not expose .evict(Object key) method
	}
}
