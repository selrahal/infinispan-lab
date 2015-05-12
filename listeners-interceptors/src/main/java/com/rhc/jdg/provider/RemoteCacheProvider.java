package com.rhc.jdg.provider;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

import com.rhc.jdg.listener.LoggingCacheClientListener;

public class RemoteCacheProvider{
	private RemoteCacheManager cacheManager;

	protected RemoteCacheManager getCacheManager() {
		if (cacheManager == null) {
			Configuration config = new ConfigurationBuilder().addServer()
					.host("localhost").port(11222).build();
			cacheManager = new RemoteCacheManager(config, true);
		}
		return cacheManager;
	}

	public RemoteCache<String, String> getCache(String identifier) {
		return getCacheManager().getCache(identifier);
	}

	public RemoteCache<String, String> getCache() {
		RemoteCache<String, String> toReturn = getCacheManager().getCache();
		registerListeners(toReturn);
		return toReturn;
	}
	
	private void registerListeners(RemoteCache<String, String> cache) {
		cache.addClientListener(new LoggingCacheClientListener());
	}
	
	public void stop() {
		if (cacheManager != null) {
			cacheManager.stop();
		}
	}

}
