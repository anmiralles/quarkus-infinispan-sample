package org.acme.infinispan.entity;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { Authors.class, Author.class }, schemaPackageName = "authors")
public interface AuthorsSchema extends GeneratedSchema {
}
