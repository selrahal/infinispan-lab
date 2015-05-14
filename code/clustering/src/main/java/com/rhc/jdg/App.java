package com.rhc.jdg;

import java.util.Map;
import java.util.Scanner;

import org.infinispan.client.hotrod.RemoteCache;

import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.RemoteCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;
import com.rhc.jdg.util.MapUtil;

public class App {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print(("Choose cache provider, [J]ava, [X]ML, or [R]emote:"));
		
		String choice = input.next();
		
		if ("J".equalsIgnoreCase(choice)) {
			JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
			Map<String, String> javaCache = javaCacheProvider.getCache();
			loop(input, javaCache);
			javaCacheProvider.stop();
		} else if ("X".equalsIgnoreCase(choice)) {
			XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
			Map<String, String> xmlCache = xmlCacheProvider.getCache();
			loop(input, xmlCache);
			xmlCacheProvider.stop();
		} else if ("R".equalsIgnoreCase(choice)) {
			RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
			RemoteCache<String, String> remoteCache = remoteCacheProvider.getCache();
			loop(input, remoteCache);
			remoteCacheProvider.stop();
		} else {
			System.out.println("Unknown option " + choice);
		}
		
		input.close();
	}
	
	
	private static void loop(Scanner input, Map<String, String> map) {
		boolean running = true;
		
		
		while (running) {
			System.out.print("Add [a], Remove [r], List [l], or quit [q]:");
			String choice = input.next();
			
			if ("a".equalsIgnoreCase(choice)) {
				System.out.print("Key:");
				String key = input.next();
				System.out.print("Value:");
				String value = input.next();
				map.put(key, value);
			} else if ("r".equalsIgnoreCase(choice)) {
				System.out.print("Key:");
				String key = input.next();
				map.remove(key);
			} else if ("l".equalsIgnoreCase(choice)) {
				System.out.println(MapUtil.contents(map));
			} else if ("q".equalsIgnoreCase(choice)) {
				running = false;
			} else {
				System.out.println("Unknown input!");
			}
		}
	}
}
