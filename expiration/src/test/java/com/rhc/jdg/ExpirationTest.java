package com.rhc.jdg;

import junit.framework.Assert;

import org.infinispan.Cache;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class ExpirationTest {

	@Test
	public void testJavaEviction() {
		Cache<String, String> cache = new JavaCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue(cache.containsKey("key1"));
		Assert.assertFalse(cache.containsKey("key2"));
		
	}
	
	@Test
	public void testXmlEviction() {
		Cache<String, String> cache = new XmlCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue(cache.containsKey("key1"));
		Assert.assertFalse(cache.containsKey("key2"));
	}
	
	@Test
	public void testRemoteEviction() {
		RemoteCache<String, String> cache = new RemoteCacheProvider().getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value1");
		
		safeWait(700);
		
		cache.get("key1");
		
		safeWait(700);
		
		cache.get("key1");
		
		Assert.assertTrue(cache.containsKey("key1"));
		Assert.assertFalse(cache.containsKey("key2"));
	}
	
	private void safeWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
	}
}
