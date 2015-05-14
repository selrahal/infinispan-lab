package com.rhc.jdg;


import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class ExpirationTest {

	@Test
	public void testJavaExpiration() {
		JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
		Cache<String, String> cache = javaCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue("Cache does not contain key1", cache.containsKey("key1"));
		Assert.assertFalse("Cache contains key2", cache.containsKey("key2"));
		
		javaCacheProvider.stop();
	}
	
	@Test
	public void testXmlExpiration() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Cache<String, String> cache = xmlCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue("Cache does not contain key1", cache.containsKey("key1"));
		Assert.assertFalse("Cache contains key2", cache.containsKey("key2"));
		
		xmlCacheProvider.stop();
	}
	
	@Test
	public void testRemoteExpiration() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<String, String> cache = remoteCacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue("Cache does not contain key1", cache.containsKey("key1"));
		Assert.assertFalse("Cache contains key2", cache.containsKey("key2"));
		
		remoteCacheProvider.stop();
	}
	
	private void safeWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
	}
}
