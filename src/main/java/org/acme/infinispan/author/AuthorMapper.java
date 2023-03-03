package org.acme.infinispan.author;

import org.acme.infinispan.entity.Author;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorMapper {

    Author toDomain(AuthorEntity entity) {
        return new Author(entity.getName(), entity.getSurname());
    }

}
