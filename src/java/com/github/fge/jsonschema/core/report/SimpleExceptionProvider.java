/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.exceptions.ExceptionProvider;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public final class SimpleExceptionProvider
implements ExceptionProvider {
    private static final ExceptionProvider INSTANCE = new SimpleExceptionProvider();

    private SimpleExceptionProvider() {
    }

    public static ExceptionProvider getInstance() {
        return INSTANCE;
    }

    @Override
    public ProcessingException doException(ProcessingMessage processingMessage) {
        return new ProcessingException(processingMessage);
    }
}

