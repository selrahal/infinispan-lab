package com.rhc.jdg;

import javax.inject.Inject;

import org.infinispan.Cache;
import org.infinispan.jmx.JmxDomainConflictException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

	@Inject
	private Cache<String, String> injectedCache;
	
	@Inject
	@FarmCache
	private Cache<String, String> farmCache;
	
	
	public static void main(String[] args) {
		Weld weld = new Weld();
		try {
			WeldContainer container = weld.initialize();
			container.instance().select(App.class).get().run();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				weld.shutdown();
			} catch (JmxDomainConflictException e) {
				
			}
		}
	}

	public void run() {
		System.out.println(injectedCache);
		System.out.println(farmCache);
	}
}
