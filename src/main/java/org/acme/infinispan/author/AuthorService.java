package org.acme.infinispan.author;

import org.acme.infinispan.entity.Author;
import org.acme.infinispan.entity.Authors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Authors findAll(){
        return new Authors(authorRepository.findAll().stream()
                .map(authorMapper::toDomain)
                .collect(Collectors.toList()));
    }

    public Author findByName(String name) {
        return authorMapper.toDomain(authorRepository.findByName(name));
    }

    public Author findByNameAndSurname(String name, String surname) {
        return authorMapper.toDomain(authorRepository.findByNameAndSurname(name, surname));
    }
}
