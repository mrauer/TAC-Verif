/*
 * Decompiled with CFR 0.0.
 */
package com.github.fge.jsonschema.exceptions;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public final class InvalidInstanceException
extends ProcessingException {
    private static final long serialVersionUID = -3273787152985150466L;

    public InvalidInstanceException(ProcessingMessage processingMessage) {
        super(processingMessage);
    }
}

