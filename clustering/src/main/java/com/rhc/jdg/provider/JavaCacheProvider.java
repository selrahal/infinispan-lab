package com.rhc.jdg.provider;

import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

public class JavaCacheProvider {
	private CacheContainer cacheContainer;

	protected CacheContainer getCacheContainer() {
		if (cacheContainer == null) {
			GlobalConfiguration globalConfig = new GlobalConfigurationBuilder()
			  .transport().defaultTransport()
			     .nodeName("node1")
			     .clusterName("myCluster")
			  .build();
			
			
			Configuration config = new ConfigurationBuilder()
				.jmxStatistics()
					.enable()
				.persistence().addSingleFileStore().purgeOnStartup(true)
				.clustering()
				    .cacheMode(CacheMode.REPL_SYNC)
				    .sync()
				        .replTimeout(20, TimeUnit.SECONDS)
				.build();
			cacheContainer = new DefaultCacheManager(globalConfig, config, true);
		}
		return cacheContainer;
	}

	public Cache<String, String> getCache(String identifier) {
		return getCacheContainer().getCache(identifier);
	}

	public Cache<String, String> getCache() {
		return getCacheContainer().getCache();
	}
	
	public void stop() {
		if (cacheContainer != null) {
			cacheContainer.stop();
		}
	}
}
