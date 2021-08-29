/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.processing.ProcessorMap$Mapper
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.google.common.base.Function
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorMap;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Function;
import java.util.HashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public final class ProcessorMap<K, IN extends MessageProvider, OUT extends MessageProvider> {
    private static final MessageBundle BUNDLE;
    private Processor<IN, OUT> defaultProcessor;
    private final Function<IN, K> keyFunction;
    private final Map<K, Processor<IN, OUT>> processors;

    public static {
        BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    }

    public ProcessorMap(Function<IN, K> function) {
        this.processors = new HashMap();
        this.defaultProcessor = null;
        BUNDLE.checkNotNull(function, "processing.nullFunction");
        this.keyFunction = function;
    }

    public static /* synthetic */ MessageBundle access$100() {
        return BUNDLE;
    }

    public ProcessorMap<K, IN, OUT> addEntry(K k3, Processor<IN, OUT> processor) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(k3, "processing.nullKey");
        messageBundle.checkNotNull(processor, "processing.nullProcessor");
        this.processors.put(k3, processor);
        return this;
    }

    public Processor<IN, OUT> getProcessor() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ProcessorMap<K, IN, OUT> setDefaultProcessor(Processor<IN, OUT> processor) {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        this.defaultProcessor = processor;
        return this;
    }

}

