package com.rhc.jdg.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntriesEvicted;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.event.CacheEntriesEvictedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStopped;
import org.infinispan.notifications.cachemanagerlistener.annotation.ViewChanged;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStoppedEvent;
import org.infinispan.notifications.cachemanagerlistener.event.ViewChangedEvent;

@Listener
public class LoggingCacheListener {

	@CacheEntryCreated
	public void onEntryCreated(CacheEntryCreatedEvent<String, String> event) {
		if (!event.isPre()) {
			System.out.println("Entry created for key=" + event.getKey());
		}
	}

	@CacheEntriesEvicted
	public void onEviction(CacheEntriesEvictedEvent<String, String> event) {
		System.out.println("These keys are evicted:  " + event.getEntries().keySet());
	}
	
	@CacheStopped
	public void onCacheStop(CacheStoppedEvent event) {
		System.out.println("Cache stopped.");
	}
	
	@ViewChanged
	public void onClusterChange(ViewChangedEvent event) {
		System.out.println("New cluster topology: " + event.getNewMembers());
	}
}
