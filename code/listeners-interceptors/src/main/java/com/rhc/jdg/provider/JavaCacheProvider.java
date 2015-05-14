package com.rhc.jdg.provider;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import com.rhc.jdg.interceptor.LoggingCacheInterceptor;
import com.rhc.jdg.listener.LoggingCacheListener;

public class JavaCacheProvider {
	private CacheContainer cacheContainer;

	protected CacheContainer getCacheContainer() {
		if (cacheContainer == null) {
			Configuration config = new ConfigurationBuilder()
				.jmxStatistics()
					.enable()
				.build();
			cacheContainer = new DefaultCacheManager(config);
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
