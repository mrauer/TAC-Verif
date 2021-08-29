/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonFactory
 *  com.fasterxml.jackson.core.JsonLocation
 *  com.fasterxml.jackson.core.JsonParseException
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.JsonParser$Feature
 *  com.fasterxml.jackson.core.JsonProcessingException
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.MappingIterator
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.ObjectReader
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.github.fge.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import java.io.IOException;
import java.io.InputStream;

public final class JsonNodeReader {
    public static final MessageBundle BUNDLE = PropertiesBundle.forPath("/com/github/fge/jackson/jsonNodeReader");
    public final ObjectReader reader;

    public JsonNodeReader() {
        ObjectMapper objectMapper = JacksonUtils.newMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        this.reader = objectMapper.readerFor(JsonNode.class);
    }

    public JsonNodeReader(ObjectMapper objectMapper) {
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        this.reader = objectMapper.readerFor(JsonNode.class);
    }

    public static JsonNode readNode(MappingIterator<JsonNode> mappingIterator) throws IOException {
        JsonParser jsonParser = mappingIterator._parser;
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull((Object)jsonParser, "read.nullArgument");
        JsonLocation jsonLocation = jsonParser.getCurrentLocation();
        String string = messageBundle.getMessage("read.noContent");
        messageBundle.checkNotNull((Object)string, "read.nullArgument");
        if (mappingIterator.hasNextValue()) {
            String string2;
            JsonLocation jsonLocation2;
            block4 : {
                JsonNode jsonNode = (JsonNode)mappingIterator.nextValue();
                string2 = messageBundle.getMessage("read.trailingData");
                messageBundle.checkNotNull((Object)string2, "read.nullArgument");
                jsonLocation2 = mappingIterator._parser.getCurrentLocation();
                messageBundle.checkNotNull((Object)jsonLocation2, "read.nullArgument");
                try {
                    if (mappingIterator.hasNextValue()) break block4;
                    return jsonNode;
                }
                catch (JsonParseException jsonParseException) {
                    JsonLocation jsonLocation3 = ((JsonProcessingException)jsonParseException)._location;
                    BUNDLE.checkNotNull((Object)jsonLocation3, "read.nullArgument");
                    throw new JsonParseException(jsonParser, string2, jsonLocation3);
                }
            }
            throw new JsonParseException(jsonParser, string2, jsonLocation2);
        }
        throw new JsonParseException(jsonParser, string, jsonLocation);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public JsonNode fromInputStream(InputStream inputStream) throws IOException {
        void var3_7;
        MappingIterator mappingIterator;
        MappingIterator mappingIterator2;
        block5 : {
            JsonNode jsonNode;
            mappingIterator2 = null;
            JsonParser jsonParser = this.reader._parserFactory.createParser(inputStream);
            try {
                mappingIterator2 = this.reader.readValues(jsonParser);
                jsonNode = JsonNodeReader.readNode((MappingIterator<JsonNode>)mappingIterator2);
            }
            catch (Throwable throwable) {
                MappingIterator mappingIterator3 = mappingIterator2;
                mappingIterator2 = jsonParser;
                mappingIterator = mappingIterator3;
            }
            jsonParser.close();
            mappingIterator2.close();
            return jsonNode;
            break block5;
            catch (Throwable throwable) {
                mappingIterator = null;
            }
        }
        if (mappingIterator2 != null) {
            mappingIterator2.close();
        }
        if (mappingIterator == null) throw var3_7;
        mappingIterator.close();
        throw var3_7;
    }
}

