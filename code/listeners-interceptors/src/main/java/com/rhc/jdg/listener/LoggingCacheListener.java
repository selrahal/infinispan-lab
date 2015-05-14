package com.rhc.jdg.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntriesEvicted;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryActivated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryInvalidated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryLoaded;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryModified;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryPassivated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryVisited;
import org.infinispan.notifications.cachelistener.annotation.DataRehashed;
import org.infinispan.notifications.cachelistener.annotation.PartitionStatusChanged;
import org.infinispan.notifications.cachelistener.annotation.TopologyChanged;
import org.infinispan.notifications.cachelistener.annotation.TransactionCompleted;
import org.infinispan.notifications.cachelistener.annotation.TransactionRegistered;
import org.infinispan.notifications.cachelistener.event.CacheEntriesEvictedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryActivatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryInvalidatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryLoadedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryModifiedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryPassivatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryVisitedEvent;
import org.infinispan.notifications.cachelistener.event.DataRehashedEvent;
import org.infinispan.notifications.cachelistener.event.PartitionStatusChangedEvent;
import org.infinispan.notifications.cachelistener.event.TopologyChangedEvent;
import org.infinispan.notifications.cachelistener.event.TransactionCompletedEvent;
import org.infinispan.notifications.cachelistener.event.TransactionRegisteredEvent;
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
	
	@CacheEntryActivated
	public void onCacheEntryActivated(CacheEntryActivatedEvent<String, String> event) {
		System.out.println("Cache entry activated:  " + event.getKey());
	}
	
	@CacheEntryInvalidated
	public void onCacheEntryInvalidated(CacheEntryInvalidatedEvent<String, String> event) {
		System.out.println("Cache entry invalidated:  " + event.getKey());
	}
	
	@CacheEntryLoaded
	public void onCacheEntryLoaded(CacheEntryLoadedEvent<String, String> event) {
		System.out.println("Cache entry loaded:  " + event.getKey());
	}
	
	@CacheEntryModified
	public void onCacheEntryModified(CacheEntryModifiedEvent<String, String> event) {
		System.out.println("Cache entry modified:  " + event.getKey());
	}
	
	@CacheEntryPassivated
	public void onCacheEntryPassivated(CacheEntryPassivatedEvent<String, String> event) {
		System.out.println("Cache entry passivated:  " + event.getKey());
	}
	
	@CacheEntryRemoved
	public void onCacheEntryRemoved(CacheEntryRemovedEvent<String, String> event) {
		System.out.println("Cache entry removed:  " + event.getKey());
	}
	
	@CacheEntryVisited
	public void onCacheEntryVisited(CacheEntryVisitedEvent<String, String> event) {
		System.out.println("Cache entry visited:  " + event.getKey());
	}
	
	@DataRehashed
	public void onDataRehashed(DataRehashedEvent<String, String> event) {
		System.out.println("Data rehashed:  " + event);
	}
	
	@PartitionStatusChanged
	public void onPartitionStatusChanged(PartitionStatusChangedEvent<String, String> event) {
		System.out.println("Partition status changed:  " + event);
	}
	
	@TopologyChanged
	public void onTopologyChanged(TopologyChangedEvent<String, String> event) {
		System.out.println("Topology Changed:  " + event);
	}
	
	@TransactionCompleted
	public void onTransactionCompleted(TransactionCompletedEvent<String, String> event) {
		System.out.println("Transaction completed:  " + event);
	}
	
	@TransactionRegistered
	public void onTransactionRegistered(TransactionRegisteredEvent<String, String> event) {
		System.out.println("Transaction registered:  " + event);
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
