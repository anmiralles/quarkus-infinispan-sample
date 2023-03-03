package org.acme.infinispan.author;

import io.quarkus.infinispan.client.CacheInvalidate;
import io.quarkus.infinispan.client.CacheResult;
import io.quarkus.infinispan.client.Remote;
import org.acme.infinispan.entity.Author;
import org.acme.infinispan.entity.Authors;
import org.infinispan.client.hotrod.RemoteCache;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private final Logger logger;
    private final AuthorService authorService;

    public AuthorResource(Logger logger, AuthorService authorService) {
        this.logger = logger;
        this.authorService = authorService;
    }

    @Inject
    @Remote("author")
    RemoteCache<String, String> authorCache;

    @Inject
    @Remote("authors")
    RemoteCache<String, String> authorsCache;

    @GET
    @CacheResult(cacheName = "authors")
    public Authors getLstAuthors(String authors) {
        logger.info("Read authors list");
        return authorService.findAll();
    }

    @DELETE
    @CacheInvalidate(cacheName = "authors")
    public void invalidateAuthors(String authors) {
        logger.info("Cleaning authors cache");
    }

    @GET
    @Path("/{name}")
    @CacheResult(cacheName = "author")
    public Author getAuthorByName(@PathParam("name") String name) {
        logger.info("Read author");
        return authorService.findByName(name);
    }

    @DELETE
    @Path("/{name}")
    @CacheInvalidate(cacheName = "author")
    public void invalidateByName(@PathParam("name") String name) {
        logger.info("Cleaning author by name cache");
    }

    @GET
    @Path("/fullname")
    public Author getAuthorByName(@QueryParam("name") String name, @QueryParam("surname") String surname) {
        logger.info("Read author by name and surname");
        String compositeParam = name + ":"  + surname;
        return findAuthor(compositeParam);
    }

    @CacheResult(cacheName = "author")
    public Author findAuthor(String param) {
        String[] fullname = param.split(":");
        return authorService.findByNameAndSurname(fullname[0], fullname[1]);
    }

}
