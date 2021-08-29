/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.EnumSet;

public abstract class AbstractFormatAttribute
implements FormatAttribute {
    private final String fmt;
    private final EnumSet<NodeType> supported;

    public /* varargs */ AbstractFormatAttribute(String string, NodeType nodeType, NodeType ... arrnodeType) {
        this.fmt = string;
        this.supported = EnumSet.of((Enum)nodeType, (Enum[])arrnodeType);
    }

    public final ProcessingMessage newMsg(FullData fullData, MessageBundle messageBundle, String string) {
        return fullData.newMessage().put("domain", "validation").put("keyword", "format").put("attribute", this.fmt).setMessage(messageBundle.getMessage(string)).put("value", fullData.getInstance().getNode());
    }

    @Override
    public final EnumSet<NodeType> supportedTypes() {
        return EnumSet.copyOf(this.supported);
    }
}

