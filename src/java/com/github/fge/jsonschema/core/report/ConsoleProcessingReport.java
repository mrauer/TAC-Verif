/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.System
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.report.AbstractProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import java.io.PrintStream;

public final class ConsoleProcessingReport
extends AbstractProcessingReport {
    public ConsoleProcessingReport() {
    }

    public ConsoleProcessingReport(LogLevel logLevel) {
        super(logLevel);
    }

    public ConsoleProcessingReport(LogLevel logLevel, LogLevel logLevel2) {
        super(logLevel, logLevel2);
    }

    @Override
    public void log(LogLevel logLevel, ProcessingMessage processingMessage) {
        System.out.println((Object)processingMessage);
    }
}

