/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.format.common.DateTimeAttribute
 *  com.github.fge.jsonschema.format.common.EmailAttribute
 *  com.github.fge.jsonschema.format.common.IPv6Attribute
 *  com.github.fge.jsonschema.format.common.RegexAttribute
 *  com.github.fge.jsonschema.format.common.URIAttribute
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.format;

import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.common.DateTimeAttribute;
import com.github.fge.jsonschema.format.common.EmailAttribute;
import com.github.fge.jsonschema.format.common.IPv6Attribute;
import com.github.fge.jsonschema.format.common.RegexAttribute;
import com.github.fge.jsonschema.format.common.URIAttribute;
import com.github.fge.jsonschema.library.format.ExtraFormatsDictionary;

public final class CommonFormatAttributesDictionary {
    private static final Dictionary<FormatAttribute> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(ExtraFormatsDictionary.get());
        dictionaryBuilder.addEntry("date-time", (Object)DateTimeAttribute.getInstance());
        dictionaryBuilder.addEntry("email", (Object)EmailAttribute.getInstance());
        dictionaryBuilder.addEntry("ipv6", (Object)IPv6Attribute.getInstance());
        dictionaryBuilder.addEntry("regex", (Object)RegexAttribute.getInstance());
        dictionaryBuilder.addEntry("uri", (Object)URIAttribute.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private CommonFormatAttributesDictionary() {
    }

    public static Dictionary<FormatAttribute> get() {
        return DICTIONARY;
    }
}

