package com.rhc.jdg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.infinispan.Cache;

import com.rhc.jdg.provider.JavaCacheProvider;

public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		JavaCacheProvider cacheProvider = new JavaCacheProvider();
		Cache<String, String> cache = cacheProvider.getCache();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		System.out.println("Cache " + cache + " size:" + cache.size());
		int interations = 100000;
		
		long startTime = System.currentTimeMillis();
		for (int i = 0 ; i < interations ; i++) {
			cache.get("key1");
		}
		System.out.println("Sync " + (System.currentTimeMillis() - startTime));
		
		startTime = System.currentTimeMillis();
		List<Future> futures = new ArrayList<Future>(interations);
		for (int i = 0 ; i < interations ; i++) {
			futures.add(cache.getAsync("key1"));
		}
		
		for (Future future : futures) {
			future.get();
		}
		System.out.println("ASync " + (System.currentTimeMillis() - startTime));
		cacheProvider.stop();
	}
}
