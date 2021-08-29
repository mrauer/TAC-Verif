/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.github.fge.jsonschema.core.exceptions;

import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public class ProcessingException
extends Exception {
    private static final long serialVersionUID = -4194415456857460489L;
    private final ProcessingMessage processingMessage;

    public ProcessingException() {
        this(new ProcessingMessage().setLogLevel(LogLevel.FATAL));
    }

    public ProcessingException(ProcessingMessage processingMessage) {
        this.processingMessage = processingMessage.setLogLevel(LogLevel.FATAL);
    }

    public ProcessingException(ProcessingMessage processingMessage, Throwable throwable) {
        this.processingMessage = processingMessage.setLogLevel(LogLevel.FATAL).put("exceptionClass", throwable.getClass().getName()).put("exceptionMessage", throwable.getMessage());
    }

    public ProcessingException(String string) {
        this(new ProcessingMessage().setMessage(string).setLogLevel(LogLevel.FATAL));
    }

    public ProcessingException(String string, Throwable throwable) {
        this.processingMessage = new ProcessingMessage().setLogLevel(LogLevel.FATAL).setMessage(string).put("exceptionClass", throwable.getClass().getName()).put("exceptionMessage", throwable.getMessage());
    }

    public final String getMessage() {
        return this.processingMessage.toString();
    }

    public final ProcessingMessage getProcessingMessage() {
        return this.processingMessage;
    }

    public final String getShortMessage() {
        return this.processingMessage.getMessage();
    }
}

