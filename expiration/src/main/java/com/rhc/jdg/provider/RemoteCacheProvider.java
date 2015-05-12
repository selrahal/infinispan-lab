package com.rhc.jdg.provider;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

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
		return getCacheManager().getCache();
	}
	
	public void stop() {
		if (cacheManager != null) {
			cacheManager.stop();
		}
	}

}
