/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.format.helpers.IPv4FormatAttribute
 *  com.github.fge.jsonschema.format.helpers.SharedHostNameAttribute
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.format;

import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.helpers.IPv4FormatAttribute;
import com.github.fge.jsonschema.format.helpers.SharedHostNameAttribute;
import com.github.fge.jsonschema.library.format.CommonFormatAttributesDictionary;

public final class DraftV4FormatAttributesDictionary {
    private static final Dictionary<FormatAttribute> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonFormatAttributesDictionary.get());
        dictionaryBuilder.addEntry("hostname", (Object)new SharedHostNameAttribute("hostname"));
        dictionaryBuilder.addEntry("ipv4", (Object)new IPv4FormatAttribute("ipv4"));
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV4FormatAttributesDictionary() {
    }

    public static Dictionary<FormatAttribute> get() {
        return DICTIONARY;
    }
}

