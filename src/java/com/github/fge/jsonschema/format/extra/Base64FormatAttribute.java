/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$InRange
 *  com.google.common.base.CharMatcher$Negated
 *  com.google.common.base.CharMatcher$Or
 *  java.lang.CharSequence
 *  java.lang.Character
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
import com.google.common.base.CharMatcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Base64FormatAttribute
extends AbstractFormatAttribute {
    private static final CharMatcher NOT_BASE64;
    private static final Pattern PATTERN;
    private static final FormatAttribute instance;

    public static {
        PATTERN = Pattern.compile((String)"==?$");
        NOT_BASE64 = new CharMatcher.Negated((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.Or((CharMatcher)new CharMatcher.InRange('a', 'z'), (CharMatcher)new CharMatcher.InRange('A', 'Z')), (CharMatcher)new CharMatcher.InRange('0', '9')), CharMatcher.anyOf((CharSequence)"+/")));
        instance = new Base64FormatAttribute();
    }

    private Base64FormatAttribute() {
        super("base64", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return instance;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        if (string.length() % 4 != 0) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.base64.badLength").putArgument("length", string.length()));
            return;
        }
        int n2 = NOT_BASE64.indexIn((CharSequence)PATTERN.matcher((CharSequence)string).replaceFirst(""));
        if (n2 == -1) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.format.base64.illegalChars").putArgument("character", Character.toString((char)string.charAt(n2))).putArgument("index", n2));
    }
}

