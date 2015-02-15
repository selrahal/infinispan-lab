package com.rhc.jdg.util;

import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

public class CacheProvider {
	private CacheContainer cacheManager;
	private CacheContainer remoteCacheManager;
	
	public CacheContainer getCacheManager() {
		if (cacheManager == null) {
			cacheManager = new DefaultCacheManager();
		}
		return cacheManager;
	}
	
	public CacheContainer getRemoteCacheManager() {
		if (cacheManager == null) {
			cacheManager = new DefaultCacheManager();
		}
		return cacheManager;
	}
	
	public Cache<String, String> getLibraryCache() {
		return getCacheManager().getCache();
	}
	
	public Cache<String, String> getRemoteCache() {
		return getRemoteCacheManager().getCache();
	}
}
