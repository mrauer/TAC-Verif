/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Enum
 *  java.lang.ExceptionInInitializerError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URL
 */
package com.github.fge.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public final class SchemaVersion
extends Enum<SchemaVersion> {
    private static final /* synthetic */ SchemaVersion[] $VALUES;
    public static final /* enum */ SchemaVersion DRAFTV3;
    public static final /* enum */ SchemaVersion DRAFTV4;
    public static final /* enum */ SchemaVersion DRAFTV4_HYPERSCHEMA;
    private final URI location;
    private final JsonNode schema;

    public static {
        SchemaVersion schemaVersion;
        SchemaVersion schemaVersion2;
        SchemaVersion schemaVersion3;
        DRAFTV4 = schemaVersion3 = new SchemaVersion("http://json-schema.org/draft-04/schema#", "/draftv4/schema");
        DRAFTV3 = schemaVersion = new SchemaVersion("http://json-schema.org/draft-03/schema#", "/draftv3/schema");
        DRAFTV4_HYPERSCHEMA = schemaVersion2 = new SchemaVersion("http://json-schema.org/draft-04/hyper-schema#", "/draftv4/hyper-schema");
        $VALUES = new SchemaVersion[]{schemaVersion3, schemaVersion, schemaVersion2};
    }

    private SchemaVersion(String string2, String string3) {
        try {
            this.location = URI.create((String)string2);
            URL uRL = SchemaVersion.class.getResource(string3);
            this.schema = JsonLoader.READER.fromInputStream(uRL.openStream());
            return;
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError((Throwable)iOException);
        }
    }

    public static SchemaVersion valueOf(String string) {
        return (SchemaVersion)Enum.valueOf(SchemaVersion.class, (String)string);
    }

    public static SchemaVersion[] values() {
        return (SchemaVersion[])$VALUES.clone();
    }

    public URI getLocation() {
        return this.location;
    }

    public JsonNode getSchema() {
        return this.schema.deepCopy();
    }
}

