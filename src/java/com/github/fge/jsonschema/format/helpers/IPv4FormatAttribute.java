/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.net.InetAddresses
 *  java.lang.Object
 *  java.lang.String
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
import com.google.common.net.InetAddresses;

public final class IPv4FormatAttribute
extends AbstractFormatAttribute {
    private static final int IPV4_LENGTH = 4;

    public IPv4FormatAttribute(String string) {
        super(string, NodeType.STRING, new NodeType[0]);
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        boolean bl = InetAddresses.ipStringToBytes((String)string) != null;
        if (bl && InetAddresses.forString((String)string).getAddress().length == 4) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidIPv4Address").putArgument("value", string));
    }
}

