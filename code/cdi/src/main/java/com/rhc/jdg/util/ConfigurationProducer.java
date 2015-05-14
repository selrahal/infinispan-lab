package com.rhc.jdg.util;

import javax.enterprise.inject.Produces;

import org.infinispan.cdi.ConfigureCache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

import com.rhc.jdg.FarmCache;

public class ConfigurationProducer {
	
	@ConfigureCache("farm")
	@FarmCache
	@Produces
	public Configuration configureCache() {
		return new ConfigurationBuilder()
			.jmxStatistics()
				.enable()
			.build();
	}
	
	//Note, no configuration for default cache!
}
