/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.ValueHolder;

public abstract class RawProcessor<IN, OUT>
implements Processor<ValueHolder<IN>, ValueHolder<OUT>> {
    private final String inputName;
    private final String outputName;

    public RawProcessor(String string, String string2) {
        this.inputName = string;
        this.outputName = string2;
    }

    public final ProcessingMessage newMessage(IN IN) {
        return new ProcessingMessage().put(this.inputName, IN);
    }

    @Override
    public final ValueHolder<OUT> process(ProcessingReport processingReport, ValueHolder<IN> valueHolder) throws ProcessingException {
        OUT OUT = this.rawProcess(processingReport, valueHolder.getValue());
        return ValueHolder.hold(this.outputName, OUT);
    }

    public abstract OUT rawProcess(ProcessingReport var1, IN var2) throws ProcessingException;
}

