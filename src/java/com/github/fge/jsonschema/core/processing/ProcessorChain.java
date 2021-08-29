/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.processing.ProcessorChain$1
 *  com.github.fge.jsonschema.core.processing.ProcessorChain$ProcessorMerger
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorChain;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

/*
 * Exception performing whole class analysis.
 */
public final class ProcessorChain<IN extends MessageProvider, OUT extends MessageProvider> {
    private static final MessageBundle BUNDLE;
    private final Processor<IN, OUT> processor;

    public static {
        BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    }

    private ProcessorChain(Processor<IN, OUT> processor) {
        this.processor = processor;
    }

    public static <X extends MessageProvider, Y extends MessageProvider> ProcessorChain<X, Y> startWith(Processor<X, Y> processor) {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        return new ProcessorChain<X, Y>(processor);
    }

    public <NEWOUT extends MessageProvider> ProcessorChain<IN, NEWOUT> chainWith(Processor<OUT, NEWOUT> processor) {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        return new ProcessorChain<IN, OUT>((Processor<IN, OUT>)new /* Unavailable Anonymous Inner Class!! */);
    }

    public ProcessorChain<IN, OUT> failOnError() {
        return this.failOnError(new ProcessingMessage().setMessage(BUNDLE.getMessage("processing.chainStopped")));
    }

    public ProcessorChain<IN, OUT> failOnError(ProcessingMessage processingMessage) {
        1 var2_2 = new 1(this, processingMessage);
        return new ProcessorChain<IN, OUT>((Processor<IN, OUT>)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Processor<IN, OUT> getProcessor() {
        return this.processor;
    }
}

