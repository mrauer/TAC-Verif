/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.processors.data.FullData
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.format;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.EnumSet;

public interface FormatAttribute {
    public EnumSet<NodeType> supportedTypes();

    public void validate(ProcessingReport var1, MessageBundle var2, FullData var3) throws ProcessingException;
}

