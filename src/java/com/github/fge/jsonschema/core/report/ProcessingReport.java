/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  java.lang.Iterable
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import j$.lang.Iterable;

public interface ProcessingReport
extends java.lang.Iterable<ProcessingMessage>,
Iterable {
    public void debug(ProcessingMessage var1) throws ProcessingException;

    public void error(ProcessingMessage var1) throws ProcessingException;

    public void fatal(ProcessingMessage var1) throws ProcessingException;

    public LogLevel getExceptionThreshold();

    public LogLevel getLogLevel();

    public void info(ProcessingMessage var1) throws ProcessingException;

    public boolean isSuccess();

    public void mergeWith(ProcessingReport var1) throws ProcessingException;

    public void warn(ProcessingMessage var1) throws ProcessingException;
}

