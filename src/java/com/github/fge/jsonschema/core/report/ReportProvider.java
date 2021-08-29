/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingReport;

public interface ReportProvider {
    public ProcessingReport newReport();

    public ProcessingReport newReport(LogLevel var1);

    public ProcessingReport newReport(LogLevel var1, LogLevel var2);
}

