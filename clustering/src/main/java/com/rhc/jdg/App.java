package com.rhc.jdg;

import java.util.Map;
import java.util.Scanner;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.util.MapUtil;

public class App {
	private static JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
//	private static XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
//	private static RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
	
	public static void main(String[] args) {
		Map<String, String> javaCache = javaCacheProvider.getCache();
//		Map<String, String> xmlCache = xmlCacheProvider.getCache();
//		RemoteCache<String, String> remoteCache = remoteCacheProvider.getCache();
		
		boolean running = true;
		Scanner input = new Scanner(System.in);
		
		while (running) {
			System.out.print("Add [a], Remove [r], or List [l]:");
			String choice = input.next();
			
			if (choice.equalsIgnoreCase("a")) {
				System.out.print("Key:");
				String key = input.next();
				System.out.print("Value:");
				String value = input.next();
				javaCache.put(key, value);
			} else if (choice.equalsIgnoreCase("r")) {
				System.out.print("Key:");
				String key = input.next();
				javaCache.remove(key);
			} else if (choice.equalsIgnoreCase("l")) {
				System.out.println(MapUtil.contents(javaCache));
			} else {
				System.out.println("Unknown input!");
			}
		}
		
		input.close();
	}
}
