# Quarkus Infinispan Sample

This example showcases how to use the Infinispan client with Quarkus. 

# Start the Infinispan server

You have two options:

**Option 1:** Running with Docker `docker run -it -p 11222:11222 -e USER="admin" -e PASS="password" infinispan/server:latest`

There is a known issue between Docker For Mac and Infinispan Client integration. Explanations can be found in
[this blog post](https://blog.infinispan.org/2018/03/accessing-infinispan-inside-docker-for.html).
You **won't need to do this in production**, but for Docker for Mac users we have to configure the following 
property in the file `src/main/resources/META-INF/resources/hotrod-client.properties`: `quarkus.infinispan-client.client-intelligence=BASIC`

