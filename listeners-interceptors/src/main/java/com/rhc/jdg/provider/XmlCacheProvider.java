package com.rhc.jdg.provider;

import java.io.IOException;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import com.rhc.jdg.interceptor.LoggingCacheInterceptor;
import com.rhc.jdg.listener.LoggingCacheListener;

public class XmlCacheProvider {
	private CacheContainer cacheContainer;

	protected CacheContainer getCacheContainer() {
		if (cacheContainer == null) {
			try {
				cacheContainer = new DefaultCacheManager("cache-config.xml",
						true);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return cacheContainer;
	}

	public Cache<String, String> getCache(String identifier) {
		Cache<String, String> toReturn = getCacheContainer().getCache(identifier);
		registerListeners(toReturn);
		registerInterceptors(toReturn);
		return toReturn;
	}

	public Cache<String, String> getCache() {
		Cache<String, String> toReturn = getCacheContainer().getCache();
		registerListeners(toReturn);
		registerInterceptors(toReturn);
		return toReturn;
	}
	
	private void registerListeners(Cache<String, String> cache) {
		cache.addListener(new LoggingCacheListener());
	}
	
	private void registerInterceptors(Cache<String, String> cache) {
		AdvancedCache<String, String> advancedCache = cache.getAdvancedCache();
		advancedCache.addInterceptor(new LoggingCacheInterceptor(), 0);
	}
	
	public void stop() {
		if (cacheContainer != null) {
			cacheContainer.stop();
		}
	}
}
