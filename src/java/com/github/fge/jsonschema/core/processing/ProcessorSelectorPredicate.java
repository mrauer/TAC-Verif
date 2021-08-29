/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.google.common.base.Predicate
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorSelector;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ProcessorSelectorPredicate<IN extends MessageProvider, OUT extends MessageProvider> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    public final Processor<IN, OUT> byDefault;
    public final Map<Predicate<IN>, Processor<IN, OUT>> choices;
    private final Predicate<IN> predicate;

    public ProcessorSelectorPredicate(ProcessorSelector<IN, OUT> processorSelector, Predicate<IN> predicate) {
        this.predicate = predicate;
        this.choices = new LinkedHashMap(processorSelector.choices);
        this.byDefault = processorSelector.byDefault;
    }

    public ProcessorSelector<IN, OUT> then(Processor<IN, OUT> processor) {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        this.choices.put(this.predicate, processor);
        return new ProcessorSelector(this);
    }
}

