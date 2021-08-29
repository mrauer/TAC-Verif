/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.base.CharMatcher
 *  java.lang.CharSequence
 *  java.lang.Character
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
import com.google.common.base.CharMatcher;

public abstract class HexStringFormatAttribute
extends AbstractFormatAttribute {
    private static final CharMatcher HEX_CHARS = CharMatcher.anyOf((CharSequence)"0123456789abcdefABCDEF").precomputed();
    public final int length;

    public HexStringFormatAttribute(String string, int n2) {
        super(string, NodeType.STRING, new NodeType[0]);
        this.length = n2;
    }

    @Override
    public final void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        if (this.length != string.length()) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.hexString.badLength").putArgument("actual", string.length()).putArgument("expected", this.length));
            return;
        }
        CharMatcher charMatcher = HEX_CHARS;
        if (charMatcher.matchesAllOf((CharSequence)string)) {
            return;
        }
        int n2 = charMatcher.negate().indexIn((CharSequence)string);
        processingReport.error(this.newMsg(fullData, messageBundle, "err.format.hexString.illegalChar").putArgument("character", Character.toString((char)string.charAt(n2))).putArgument("index", n2));
    }
}

