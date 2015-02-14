package com.rhc.jdg.util;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import com.rhc.jdg.interceptor.LoggingCacheInterceptor;
import com.rhc.jdg.listener.LoggingCacheListener;

public class CacheProvider {
	private CacheContainer cacheManager;
	
	public CacheContainer getCacheManager() {
		if (cacheManager == null) {
			cacheManager = new DefaultCacheManager();
		}
		return cacheManager;
	}
	
	public Cache getCache() {
		Cache toReturn = getCacheManager().getCache();
		registerListeners(toReturn);
		registerInterceptors(toReturn);
		return getCacheManager().getCache();
	}
	
	private void registerListeners(Cache cache) {
		cache.addListener(new LoggingCacheListener());
	}
	
	private void registerInterceptors(Cache cache) {
		AdvancedCache advancedCache = cache.getAdvancedCache();
		advancedCache.addInterceptor(new LoggingCacheInterceptor(), 0);
	}
}
