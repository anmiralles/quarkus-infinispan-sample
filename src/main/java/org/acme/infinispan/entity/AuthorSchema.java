package org.acme.infinispan.entity;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { Author.class }, schemaPackageName = "author")
public interface AuthorSchema extends GeneratedSchema {
}
