/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.NumericNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.fasterxml.jackson.databind.node.TextNode
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Formatter
 *  java.util.IllegalFormatException
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package com.github.fge.jsonschema.core.report;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.fge.jsonschema.core.exceptions.ExceptionProvider;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.SimpleExceptionProvider;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class ProcessingMessage
implements AsJson {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    private final List<Object> args = new ArrayList();
    private ExceptionProvider exceptionProvider = SimpleExceptionProvider.getInstance();
    private LogLevel level;
    private final Map<String, JsonNode> map = new LinkedHashMap();

    public ProcessingMessage() {
        this.setLogLevel(LogLevel.INFO);
    }

    private void addArgument(String string, Object object) {
        if (string != null) {
            this.args.add(object);
        }
        if (!this.map.containsKey((Object)"message")) {
            return;
        }
        String string2 = ((JsonNode)this.map.get((Object)"message")).textValue();
        try {
            String string3 = new Formatter().format(string2, this.args.toArray()).toString();
            this.map.put((Object)"message", (Object)FACTORY.textNode(string3));
        }
        catch (IllegalFormatException illegalFormatException) {}
    }

    private ProcessingMessage putNull(String string) {
        if (string == null) {
            return this;
        }
        Map<String, JsonNode> map = this.map;
        Objects.requireNonNull((Object)FACTORY);
        map.put((Object)string, (Object)NullNode.instance);
        return this;
    }

    public ProcessingException asException() {
        return this.exceptionProvider.doException(this);
    }

    @Override
    public JsonNode asJson() {
        JsonNodeFactory jsonNodeFactory = FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        for (Map.Entry entry : this.map.entrySet()) {
            JsonNode jsonNode = (JsonNode)entry.getValue();
            if (jsonNode == null) {
                objectNode.nullNode();
                jsonNode = NullNode.instance;
            }
            objectNode._children.put(entry.getKey(), (Object)jsonNode);
        }
        return objectNode;
    }

    public LogLevel getLogLevel() {
        return this.level;
    }

    public String getMessage() {
        if (this.map.containsKey((Object)"message")) {
            return ((JsonNode)this.map.get((Object)"message")).textValue();
        }
        return "(no message)";
    }

    public ProcessingMessage put(String string, int n) {
        return this.put(string, (JsonNode)FACTORY.numberNode(n));
    }

    public ProcessingMessage put(String string, JsonNode jsonNode) {
        if (string == null) {
            return this;
        }
        if (jsonNode == null) {
            return this.putNull(string);
        }
        this.map.put((Object)string, (Object)jsonNode.deepCopy());
        return this;
    }

    public ProcessingMessage put(String string, AsJson asJson) {
        return this.put(string, asJson.asJson());
    }

    public <T> ProcessingMessage put(String string, Iterable<T> iterable) {
        if (iterable == null) {
            return this.putNull(string);
        }
        JsonNodeFactory jsonNodeFactory = FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        for (Object object : iterable) {
            NullNode nullNode;
            if (object == null) {
                Objects.requireNonNull((Object)FACTORY);
                nullNode = NullNode.instance;
            } else {
                nullNode = FACTORY.textNode(object.toString());
            }
            arrayNode.add((JsonNode)nullNode);
        }
        return this.put(string, (JsonNode)arrayNode);
    }

    public <T> ProcessingMessage put(String string, T t) {
        if (t == null) {
            return this.putNull(string);
        }
        return this.put(string, (JsonNode)FACTORY.textNode(t.toString()));
    }

    public ProcessingMessage put(String string, String string2) {
        if (string2 == null) {
            return this.putNull(string);
        }
        return this.put(string, (JsonNode)FACTORY.textNode(string2));
    }

    public ProcessingMessage putArgument(String string, int n) {
        this.addArgument(string, n);
        return this.put(string, n);
    }

    public ProcessingMessage putArgument(String string, JsonNode jsonNode) {
        this.addArgument(string, (Object)jsonNode);
        return this.put(string, jsonNode);
    }

    public ProcessingMessage putArgument(String string, AsJson asJson) {
        this.addArgument(string, (Object)asJson.asJson());
        return this.put(string, asJson);
    }

    public <T> ProcessingMessage putArgument(String string, Iterable<T> iterable) {
        this.addArgument(string, iterable);
        return this.put(string, (T)iterable);
    }

    public <T> ProcessingMessage putArgument(String string, T t) {
        this.addArgument(string, t);
        return this.put(string, t);
    }

    public ProcessingMessage setExceptionProvider(ExceptionProvider exceptionProvider) {
        BUNDLE.checkNotNull(exceptionProvider, "processing.nullExceptionProvider");
        this.exceptionProvider = exceptionProvider;
        return this;
    }

    public ProcessingMessage setLogLevel(LogLevel logLevel) {
        BUNDLE.checkNotNull(logLevel, "processing.nullLevel");
        this.level = logLevel;
        return this.put("level", (T)((Object)logLevel));
    }

    public ProcessingMessage setMessage(String string) {
        this.args.clear();
        return this.put("message", string);
    }

    public String toString() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.map);
        JsonNode jsonNode = (JsonNode)linkedHashMap.remove((Object)"message");
        String string = jsonNode == null ? "(no message)" : jsonNode.textValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.level);
        stringBuilder.append(": ");
        stringBuilder.append(string);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            stringBuilder.append("\n    ");
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append(": ");
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}

