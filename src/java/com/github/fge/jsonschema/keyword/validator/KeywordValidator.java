/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.processors.data.FullData
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 */
package com.github.fge.jsonschema.keyword.validator;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public interface KeywordValidator {
    public void validate(Processor<FullData, FullData> var1, ProcessingReport var2, MessageBundle var3, FullData var4) throws ProcessingException;
}

