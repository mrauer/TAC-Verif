/*
 * Decompiled with CFR 0.0.
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.report.AbstractProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public final class DevNullProcessingReport
extends AbstractProcessingReport {
    public DevNullProcessingReport() {
    }

    public DevNullProcessingReport(LogLevel logLevel) {
        super(logLevel);
    }

    public DevNullProcessingReport(LogLevel logLevel, LogLevel logLevel2) {
        super(logLevel, logLevel2);
    }

    @Override
    public void log(LogLevel logLevel, ProcessingMessage processingMessage) {
    }
}

