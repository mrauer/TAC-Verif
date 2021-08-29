/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.net.InetAddresses
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.format.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.net.InetAddresses;

public final class IPv6Attribute
extends AbstractFormatAttribute {
    private static final FormatAttribute INSTANCE = new IPv6Attribute();
    private static final int IPV6_LENGTH = 16;

    private IPv6Attribute() {
        super("ipv6", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        boolean bl = InetAddresses.ipStringToBytes((String)string) != null;
        if (bl && InetAddresses.forString((String)string).getAddress().length == 16) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidIPV6Address").putArgument("value", string));
    }
}

