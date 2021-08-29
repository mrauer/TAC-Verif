/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.processing;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;

public interface Processor<IN extends MessageProvider, OUT extends MessageProvider> {
    public OUT process(ProcessingReport var1, IN var2) throws ProcessingException;
}

