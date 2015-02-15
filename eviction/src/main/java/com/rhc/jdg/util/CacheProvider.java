package com.rhc.jdg.util;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

public class CacheProvider {
	private CacheContainer cacheManager;
	
	private Configuration getCacheConfiguration() {
		return new ConfigurationBuilder()
			.jmxStatistics()
				.enable()
			.eviction()
			    .strategy(EvictionStrategy.LRU)
			    .maxEntries(3)
			.build();
	}
	
	private CacheContainer getCacheManager() {
		if (cacheManager == null) {
			cacheManager = new DefaultCacheManager(getCacheConfiguration());
		}
		return cacheManager;
	}
	
	public Cache<String, String> getCache() {
		return getCacheManager().getCache();
	}
	
	
}
