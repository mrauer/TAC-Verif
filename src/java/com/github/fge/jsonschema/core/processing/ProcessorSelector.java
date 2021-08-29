/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.processing.ProcessorSelector$Chooser
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
import com.github.fge.jsonschema.core.processing.ProcessorSelectorPredicate;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public final class ProcessorSelector<IN extends MessageProvider, OUT extends MessageProvider> {
    private static final MessageBundle BUNDLE;
    public final Processor<IN, OUT> byDefault;
    public final Map<Predicate<IN>, Processor<IN, OUT>> choices;

    public static {
        BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    }

    public ProcessorSelector() {
        this.choices = new LinkedHashMap();
        this.byDefault = null;
    }

    public ProcessorSelector(ProcessorSelectorPredicate<IN, OUT> processorSelectorPredicate) {
        this(processorSelectorPredicate.choices, processorSelectorPredicate.byDefault);
    }

    private ProcessorSelector(Map<Predicate<IN>, Processor<IN, OUT>> map, Processor<IN, OUT> processor) {
        this.choices = new LinkedHashMap(map);
        this.byDefault = processor;
    }

    public static /* synthetic */ MessageBundle access$100() {
        return BUNDLE;
    }

    public Processor<IN, OUT> getProcessor() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ProcessorSelector<IN, OUT> otherwise(Processor<IN, OUT> processor) {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        return new ProcessorSelector<IN, OUT>(this.choices, processor);
    }

    public ProcessorSelectorPredicate<IN, OUT> when(Predicate<IN> predicate) {
        BUNDLE.checkNotNull(predicate, "processing.nullPredicate");
        return new ProcessorSelectorPredicate(this, predicate);
    }

}

