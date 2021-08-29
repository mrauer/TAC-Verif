/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.exceptions;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;

public interface ExceptionProvider {
    public ProcessingException doException(ProcessingMessage var1);
}

