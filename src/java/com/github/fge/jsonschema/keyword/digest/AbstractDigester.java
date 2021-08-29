/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.keyword.digest;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.Digester;
import java.util.EnumSet;

public abstract class AbstractDigester
implements Digester {
    public static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    public final String keyword;
    private final EnumSet<NodeType> types;

    public /* varargs */ AbstractDigester(String string, NodeType nodeType, NodeType ... arrnodeType) {
        this.keyword = string;
        this.types = EnumSet.of((Enum)nodeType, (Enum[])arrnodeType);
    }

    @Override
    public final EnumSet<NodeType> supportedTypes() {
        return EnumSet.copyOf(this.types);
    }

    public final String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"digester for keyword \"");
        stringBuilder.append(this.keyword);
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }
}

