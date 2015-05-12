package com.rhc.jdg;

import java.util.Map;

import org.apache.log4j.Logger;
import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;
import com.rhc.jdg.util.MapUtil;

public class CacheTest {
	private static final Logger LOG = Logger.getLogger(CacheTest.class);
	
	@Test
	public void testJavaCache() {
		JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
		Map<String, String> javaCache = javaCacheProvider.getCache();
		javaCache.put("key1", "value1");
		javaCache.put("key2", "value2");
		LOG.info("Java Cache contents(" + MapUtil.contents(javaCache) +")");
		Assert.assertEquals("Cache size is incorrect", 2, javaCache.size());
		Assert.assertEquals("Value for key1 is incorrect", "value1", javaCache.get("key1"));
		Assert.assertEquals("Value for key2 is incorrect", "value2", javaCache.get("key2"));
		javaCacheProvider.stop();
	}
	
	@Test
	public void testXmlCache() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Map<String, String> xmlCache = xmlCacheProvider.getCache();
		xmlCache.put("key1", "value1");
		xmlCache.put("key2", "value2");
		LOG.info("XML Cache contents(" + MapUtil.contents(xmlCache) + ")");
		Assert.assertEquals("Cache size is incorrect", 2, xmlCache.size());
		Assert.assertEquals("Value for key1 is incorrect", "value1", xmlCache.get("key1"));
		Assert.assertEquals("Value for key2 is incorrect", "value2", xmlCache.get("key2"));
		xmlCacheProvider.stop();
	}
	
	@Test
	public void testRemoteCache() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<String, String> remoteCache = remoteCacheProvider.getCache();
		remoteCache.put("key1", "value1");
		remoteCache.put("key2", "value2");
		LOG.info("Remote Cache contents(" + MapUtil.contents(remoteCache) + ")");
		Assert.assertEquals("Cache size is incorrect", 2, remoteCache.size());
		Assert.assertEquals("Value for key1 is incorrect", "value1", remoteCache.get("key1"));
		Assert.assertEquals("Value for key2 is incorrect", "value2", remoteCache.get("key2"));
		remoteCacheProvider.stop();
	}
}
