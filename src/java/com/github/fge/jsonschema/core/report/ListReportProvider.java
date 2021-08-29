/*
 * Decompiled with CFR 0.0.
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.report.AbstractReportProvider;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingReport;

public final class ListReportProvider
extends AbstractReportProvider {
    public ListReportProvider(LogLevel logLevel, LogLevel logLevel2) {
        super(logLevel, logLevel2);
    }

    @Override
    public ProcessingReport newReport() {
        return new ListProcessingReport(this.logLevel, this.exceptionThreshold);
    }

    @Override
    public ProcessingReport newReport(LogLevel logLevel) {
        return new ListProcessingReport(logLevel);
    }

    @Override
    public ProcessingReport newReport(LogLevel logLevel, LogLevel logLevel2) {
        return new ListProcessingReport(logLevel, logLevel2);
    }
}

