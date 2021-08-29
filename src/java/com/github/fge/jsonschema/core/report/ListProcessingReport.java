/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.google.common.collect.Iterators
 *  com.google.common.collect.Iterators$1
 *  com.google.common.collect.UnmodifiableIterator
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.report;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonschema.core.report.AbstractProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.AsJson;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class ListProcessingReport
extends AbstractProcessingReport
implements AsJson {
    private static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    private final List<ProcessingMessage> messages = new ArrayList();

    public ListProcessingReport() {
    }

    public ListProcessingReport(LogLevel logLevel) {
        super(logLevel);
    }

    public ListProcessingReport(LogLevel logLevel, LogLevel logLevel2) {
        super(logLevel, logLevel2);
    }

    public ListProcessingReport(ProcessingReport processingReport) {
        this(processingReport.getLogLevel(), processingReport.getExceptionThreshold());
    }

    @Override
    public JsonNode asJson() {
        JsonNodeFactory jsonNodeFactory = FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        Iterator iterator = this.messages.iterator();
        while (iterator.hasNext()) {
            arrayNode.add(((ProcessingMessage)iterator.next()).asJson());
        }
        return arrayNode;
    }

    @Override
    public Iterator<ProcessingMessage> iterator() {
        Iterator iterator = this.messages.iterator();
        Objects.requireNonNull((Object)iterator);
        if (iterator instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator)iterator;
        }
        return new Iterators.1(iterator);
    }

    @Override
    public void log(LogLevel logLevel, ProcessingMessage processingMessage) {
        this.messages.add((Object)processingMessage);
    }
}

