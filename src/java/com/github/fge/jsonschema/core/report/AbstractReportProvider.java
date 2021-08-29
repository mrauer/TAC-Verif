/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ReportProvider;

public abstract class AbstractReportProvider
implements ReportProvider {
    public final LogLevel exceptionThreshold;
    public final LogLevel logLevel;

    public AbstractReportProvider(LogLevel logLevel, LogLevel logLevel2) {
        this.logLevel = logLevel;
        this.exceptionThreshold = logLevel2;
    }
}

