/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.report.ListProcessingReport
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

public final class ProcessingResult<R extends MessageProvider> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private final ProcessingReport report;
    private final R result;

    private ProcessingResult(ProcessingReport processingReport, R r3) {
        BUNDLE.checkNotNull((Object)processingReport, "processing.nullReport");
        this.report = processingReport;
        this.result = r3;
    }

    private static ProcessingReport buildReport(ProcessingReport processingReport, ProcessingException processingException) {
        ListProcessingReport listProcessingReport;
        listProcessingReport = new ListProcessingReport(LogLevel.DEBUG, LogLevel.NONE);
        try {
            listProcessingReport.fatal(processingException.getProcessingMessage().put("info", BUNDLE.getMessage("processing.moreMessages")));
            listProcessingReport.mergeWith(processingReport);
        }
        catch (ProcessingException processingException2) {}
        return listProcessingReport;
    }

    public static <IN extends MessageProvider, OUT extends MessageProvider> ProcessingResult<OUT> of(Processor<IN, OUT> processor, ProcessingReport processingReport, IN IN) throws ProcessingException {
        BUNDLE.checkNotNull(processor, "processing.nullProcessor");
        return new ProcessingResult<OUT>(processingReport, processor.process(processingReport, IN));
    }

    public static <IN extends MessageProvider, OUT extends MessageProvider> ProcessingResult<OUT> uncheckedResult(Processor<IN, OUT> processor, ProcessingReport processingReport, IN IN) {
        try {
            ProcessingResult<OUT> processingResult = ProcessingResult.of(processor, processingReport, IN);
            return processingResult;
        }
        catch (ProcessingException processingException) {
            return new ProcessingResult<Object>(ProcessingResult.buildReport(processingReport, processingException), null);
        }
    }

    public ProcessingReport getReport() {
        return this.report;
    }

    public R getResult() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.report.isSuccess();
    }
}

