package com.rhc.jdg.util;

import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

public class CacheProvider {
	private CacheContainer cacheManager;
	
//	public CacheContainer getCacheManager() {
//		if (cacheManager == null) {
//			cacheManager = new DefaultCacheManager();
//		}
//		return cacheManager;
//	}
//	
//	public Cache getCache() {
//		return getCacheManager().getCache();
//	}
}
