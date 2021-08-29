/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.github.fge.jsonschema.format.extra;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MacAddressFormatAttribute
extends AbstractFormatAttribute {
    private static final Pattern MACADDR;
    private static final FormatAttribute instance;

    public static {
        instance = new MacAddressFormatAttribute();
        MACADDR = Pattern.compile((String)"[A-Za-z0-9]{2}(?::[A-Za-z0-9]{2}){5}");
    }

    private MacAddressFormatAttribute() {
        super("mac", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return instance;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        if (!MACADDR.matcher((CharSequence)string).matches()) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.macAddr.invalid").putArgument("value", string));
        }
    }
}

