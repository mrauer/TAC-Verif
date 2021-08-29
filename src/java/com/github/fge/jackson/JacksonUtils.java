/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonFactory
 *  com.fasterxml.jackson.core.JsonGenerationException
 *  com.fasterxml.jackson.core.JsonGenerator
 *  com.fasterxml.jackson.core.JsonGenerator$Feature
 *  com.fasterxml.jackson.databind.DeserializationConfig
 *  com.fasterxml.jackson.databind.DeserializationFeature
 *  com.fasterxml.jackson.databind.JsonMappingException
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.ObjectWriter
 *  com.fasterxml.jackson.databind.SerializationConfig
 *  com.fasterxml.jackson.databind.SerializationFeature
 *  com.fasterxml.jackson.databind.cfg.MapperConfig
 *  com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.fasterxml.jackson.databind.ser.DefaultSerializerProvider
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 */
package com.github.fge.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class JacksonUtils {
    public static final ObjectWriter WRITER;

    public static {
        ObjectMapper objectMapper = JacksonUtils.newMapper();
        objectMapper._deserializationConfig.useRootWrapping();
        WRITER = objectMapper.writer();
    }

    public static Map<String, JsonNode> asMap(JsonNode jsonNode) {
        HashMap hashMap = new HashMap();
        Objects.requireNonNull((Object)jsonNode);
        if (!(jsonNode instanceof ObjectNode)) {
            return hashMap;
        }
        Iterator iterator = jsonNode.fields();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public static ObjectMapper newMapper() {
        ObjectMapper objectMapper = new ObjectMapper(null, null, null);
        JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
        DeserializationConfig deserializationConfig = objectMapper._deserializationConfig;
        DeserializationConfig deserializationConfig2 = deserializationConfig._nodeFactory == jsonNodeFactory ? deserializationConfig : new DeserializationConfig(deserializationConfig, jsonNodeFactory);
        objectMapper._deserializationConfig = deserializationConfig2;
        DeserializationFeature deserializationFeature = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        int n3 = deserializationConfig2._deserFeatures | deserializationFeature.getMask();
        if (n3 != deserializationConfig2._deserFeatures) {
            DeserializationConfig deserializationConfig3;
            deserializationConfig2 = deserializationConfig3 = new DeserializationConfig(deserializationConfig2, deserializationConfig2._mapperFeatures, n3, deserializationConfig2._parserFeatures, deserializationConfig2._parserFeaturesToChange, deserializationConfig2._formatReadFeatures, deserializationConfig2._formatReadFeaturesToChange);
        }
        objectMapper._deserializationConfig = deserializationConfig2;
        JsonGenerator.Feature[] arrfeature = new JsonGenerator.Feature[1];
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN;
        arrfeature[0] = feature;
        for (int i3 = 0; i3 < 1; ++i3) {
            JsonGenerator.Feature feature2 = arrfeature[i3];
            JsonFactory jsonFactory = objectMapper._jsonFactory;
            jsonFactory._generatorFeatures |= feature2.getMask();
        }
        SerializationFeature serializationFeature = SerializationFeature.INDENT_OUTPUT;
        SerializationConfig serializationConfig = objectMapper._serializationConfig;
        int n4 = serializationConfig._serFeatures | serializationFeature.getMask();
        if (n4 != serializationConfig._serFeatures) {
            SerializationConfig serializationConfig2;
            serializationConfig = serializationConfig2 = new SerializationConfig(serializationConfig, serializationConfig._mapperFeatures, n4, serializationConfig._generatorFeatures, serializationConfig._generatorFeaturesToChange, serializationConfig._formatWriteFeatures, serializationConfig._formatWriteFeaturesToChange);
        }
        objectMapper._serializationConfig = serializationConfig;
        return objectMapper;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String prettyPrint(JsonNode jsonNode) {
        StringWriter stringWriter = new StringWriter();
        try {
            ObjectWriter objectWriter = WRITER;
            objectWriter._writeValueAndClose(objectWriter.createGenerator((Writer)stringWriter), (Object)jsonNode);
            stringWriter.flush();
            return stringWriter.toString();
        }
        catch (IOException iOException) {}
        return stringWriter.toString();
        catch (JsonMappingException jsonMappingException) {
            throw new RuntimeException("How did I get there??", (Throwable)jsonMappingException);
        }
        catch (JsonGenerationException jsonGenerationException) {
            throw new RuntimeException("How did I get there??", (Throwable)jsonGenerationException);
        }
    }
}

