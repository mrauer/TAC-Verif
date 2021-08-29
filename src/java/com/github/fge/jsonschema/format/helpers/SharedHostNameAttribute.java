/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.net.InternetDomainName
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.format.helpers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.net.InternetDomainName;
import java.util.Objects;

public final class SharedHostNameAttribute
extends AbstractFormatAttribute {
    public SharedHostNameAttribute(String string) {
        super(string, NodeType.STRING, new NodeType[0]);
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            Objects.requireNonNull((Object)string);
            new InternetDomainName(string);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidHostname").putArgument("value", string));
            return;
        }
    }
}

