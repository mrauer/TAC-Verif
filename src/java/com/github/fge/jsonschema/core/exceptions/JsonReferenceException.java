/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Throwable
 */
package com.github.fge.jsonschema.core.exceptions;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public final class JsonReferenceException
extends ProcessingException {
    private static final long serialVersionUID = 2630907528006411833L;

    public JsonReferenceException(ProcessingMessage processingMessage) {
        super(processingMessage);
    }

    public JsonReferenceException(ProcessingMessage processingMessage, Throwable throwable) {
        super(processingMessage, throwable);
    }
}

