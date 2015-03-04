Infinispan Tech Talk 
=====================

Lab content for Infinispan Tech Talk

Infinispan documentation is available [here](http://infinispan.org/documentation/). The documentation of the latest version is available [here](http://infinispan.org/docs/7.1.x/user_guide/user_guide.html).

To run the applications in Client-Server mode, you'll need to have the Infinispan standalone server installed. Go to the [Infinispan downloads page](http://infinispan.org/download/) and click "Server" to download the server. 

## 1. Basic configuration ##
* Project: basic
* Inspect the project and find the classes which create Caches. Note that there are two types of caches: library (the cache resides in the same jvm as the application) and client-server mode (the cache and the application reside in seperate jvms). There are two ways of configration library mode caches, one is using the Java api and the other is to provide the configuration with an xml file. In client-server mode the configuration is specified in the application servers configuration file (standalone.xml or clustered.xml). The xml configuration for library mode and the xml configuration for client-server mode differ slightly. Be on the lookout for these idiosyncrasies.

## 2. Eviction ##
* Project: eviction
* Caches often are backed by a larger, and typically slower, cache store. Eviction policies determine how many cache entries to keep in memory at any given time. There are several strategies available that will dictate which entries get evicted (and when) to keep the amount of in-memory entries below the maximum.

## 3. Expiration ##
* Project: expiration
* Expiration is the configuration of when cache entries are no longer valid. When a cache entry expires it is removed from the cluster and will not be accessible any more. There are two parameters used to define expiration, a lifespan and a max idle time. When an entry has been in the cache for longer than its lifespan it will be evicted. When an entry has not been accessed for longer than its max idle time it will be evicted. Although these two parameters may be configured on a cache level, you can also configure them on a per-entry basis by using one of the overloaded put(....) methods on the cache.

## 4. Cache Store ##
* Project: cache-store
* In typical usage patterns consisting of caches, the cache is not the source of truth for the data being cached. Infinispan supports this through the use of cache stores. Caches can be configured to leverage a cache store for retrieving, and storing, data. Support in infinispan for different cache store types include: simple file storage, JDBC, JPA, another Infinispan Server, and LevelDB. Infinispan can be configured to write to the cache store synchronously (write-through) or asynchronously (write-behind).

## 5. Listeners and Interceptors ##
* Project: listeners-interceptors
* Cache listeners and interceptors can be used for a variety of functions, anywhere from logging to custom security. In infinispan caches are implemented with a command pattern and can be provided interceptors to alter, or enhance, individual commands functionality. This section show how to register some simple logging listeners and interceptors.

## 6. Clustering ##
* Project: clustering
* Cache clustering can be done in both library mode and client-server mode. There are three types of clustering modes: replication, distribution, and invalidation. In replication mode the set of entries in any given cache in the cluster is identical to the set of entries in any other cache in the cluster. In distribution mode each cache in the cluster will contain a subset of the set of all entries. There are many factors that go into deciding which entries are present on which caches in the cluster, and they are configurable so you can ensure losless storage even in the event of a data warehouse outage. Invalidation mode serves as a read only cache, when a cache entry is changed on any cache it is immediatly removed from each other cache. This will force the other caches to go back to the cache store to retrieve the new data.

## 7. CDI ##
* Project: cdi
* Infinispan comes with a library that makes retrieving caches via CDI very simple. With a few annotations you can designate cache configurations that should be used. Then, just through injecting caches, you will have access to all the functionality needed.

## 8. Asynchronous API ##
* Project: async
* For most Map operations the Cache interface exposes asynchronous equivalents. Methods like getAsync(...) will return a future. This can be used when performance is a priority and awaiting the results of some operations is not needed.

## 9. Challenge ##
* Replace the in-memory map used in Matyas Danter's farm application with a cache in client-server mode. The cache should only allow a maximum of 20 animals to be in memory at any given time. It should also automatically remove animals that have not been interacted with for 5 minutes (the animals have wondered off of the farm at this point).
* Project: https://github.com/mdanter/farm
