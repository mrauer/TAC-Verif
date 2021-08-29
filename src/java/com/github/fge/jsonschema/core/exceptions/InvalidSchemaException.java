/*
 * Decompiled with CFR 0.0.
 */
package com.github.fge.jsonschema.core.exceptions;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public final class InvalidSchemaException
extends ProcessingException {
    private static final long serialVersionUID = 278790633227462029L;

    public InvalidSchemaException(ProcessingMessage processingMessage) {
        super(processingMessage);
    }
}

