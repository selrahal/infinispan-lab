package com.rhc.jdg.listener;

import org.infinispan.client.hotrod.annotation.ClientCacheEntryCreated;
import org.infinispan.client.hotrod.annotation.ClientCacheEntryModified;
import org.infinispan.client.hotrod.annotation.ClientCacheEntryRemoved;
import org.infinispan.client.hotrod.annotation.ClientCacheFailover;
import org.infinispan.client.hotrod.annotation.ClientListener;
import org.infinispan.client.hotrod.event.ClientCacheEntryCreatedEvent;
import org.infinispan.client.hotrod.event.ClientCacheEntryModifiedEvent;
import org.infinispan.client.hotrod.event.ClientCacheEntryRemovedEvent;
import org.infinispan.client.hotrod.event.ClientCacheFailoverEvent;

@ClientListener
public class LoggingCacheClientListener {
	
	@ClientCacheEntryCreated
	public void onClientCacheEntryCreated(ClientCacheEntryCreatedEvent<String> event) {
		System.out.println("Client cache entry created:" + event);
	}
	@ClientCacheEntryModified
	public void onClientCacheEntryModified(ClientCacheEntryModifiedEvent<String> event) {
		System.out.println("Client cache entry modified:" + event);
	}
	@ClientCacheEntryRemoved
	public void onClientCacheEntryRemoved(ClientCacheEntryRemovedEvent<String> event) {
		System.out.println("Client cache entry removed:" + event);
	}
	@ClientCacheFailover
	public void onClientCacheFailover(ClientCacheFailoverEvent event) {
		System.out.println("Client cache entry failover:" + event);
	}

}
