/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.format.draftv3.DateAttribute
 *  com.github.fge.jsonschema.format.draftv3.PhoneAttribute
 *  com.github.fge.jsonschema.format.draftv3.TimeAttribute
 *  com.github.fge.jsonschema.format.draftv3.UTCMillisecAttribute
 *  com.github.fge.jsonschema.format.helpers.IPv4FormatAttribute
 *  com.github.fge.jsonschema.format.helpers.SharedHostNameAttribute
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.format;

import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.draftv3.DateAttribute;
import com.github.fge.jsonschema.format.draftv3.PhoneAttribute;
import com.github.fge.jsonschema.format.draftv3.TimeAttribute;
import com.github.fge.jsonschema.format.draftv3.UTCMillisecAttribute;
import com.github.fge.jsonschema.format.helpers.IPv4FormatAttribute;
import com.github.fge.jsonschema.format.helpers.SharedHostNameAttribute;
import com.github.fge.jsonschema.library.format.CommonFormatAttributesDictionary;

public final class DraftV3FormatAttributesDictionary {
    private static final Dictionary<FormatAttribute> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addAll(CommonFormatAttributesDictionary.get());
        dictionaryBuilder.addEntry("date", (Object)DateAttribute.getInstance());
        dictionaryBuilder.addEntry("host-name", (Object)new SharedHostNameAttribute("host-name"));
        dictionaryBuilder.addEntry("ip-address", (Object)new IPv4FormatAttribute("ip-address"));
        dictionaryBuilder.addEntry("phone", (Object)PhoneAttribute.getInstance());
        dictionaryBuilder.addEntry("time", (Object)TimeAttribute.getInstance());
        dictionaryBuilder.addEntry("utc-millisec", (Object)UTCMillisecAttribute.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private DraftV3FormatAttributesDictionary() {
    }

    public static Dictionary<FormatAttribute> get() {
        return DICTIONARY;
    }
}

