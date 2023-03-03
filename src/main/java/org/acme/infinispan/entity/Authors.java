package org.acme.infinispan.entity;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.List;
import java.util.Objects;

public class Authors {
    private final List<Author> lstAuthors;

    @ProtoFactory
    public Authors(List<Author> lstAuthors) {
        this.lstAuthors = lstAuthors;
    }

    @ProtoField(number = 1)
    public List<Author> getLstAuthors() {
        return lstAuthors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return lstAuthors.equals(authors.lstAuthors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstAuthors);
    }

    @Override
    public String toString() {
        return "Authors{" +
                "lstAuthors=" + lstAuthors +
                '}';
    }
}
