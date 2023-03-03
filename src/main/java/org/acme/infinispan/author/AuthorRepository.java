package org.acme.infinispan.author;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepositoryBase<AuthorEntity, Integer> {
    public AuthorEntity findByName(String name) {
        return find("name", name).firstResult();
    }

    public AuthorEntity findByNameAndSurname(String name, String surname) {
        return find("name = ?1 and surname = ?2", name, surname).firstResult();
    }
}
