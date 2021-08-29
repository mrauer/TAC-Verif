/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.core.util.DictionaryBuilder
 *  com.github.fge.jsonschema.format.extra.Base64FormatAttribute
 *  com.github.fge.jsonschema.format.extra.JsonPointerFormatAttribute
 *  com.github.fge.jsonschema.format.extra.MD5FormatAttribute
 *  com.github.fge.jsonschema.format.extra.MacAddressFormatAttribute
 *  com.github.fge.jsonschema.format.extra.SHA1FormatAttribute
 *  com.github.fge.jsonschema.format.extra.SHA256FormatAttribute
 *  com.github.fge.jsonschema.format.extra.SHA512FormatAttribute
 *  com.github.fge.jsonschema.format.extra.UUIDFormatAttribute
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library.format;

import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.extra.Base64FormatAttribute;
import com.github.fge.jsonschema.format.extra.JsonPointerFormatAttribute;
import com.github.fge.jsonschema.format.extra.MD5FormatAttribute;
import com.github.fge.jsonschema.format.extra.MacAddressFormatAttribute;
import com.github.fge.jsonschema.format.extra.SHA1FormatAttribute;
import com.github.fge.jsonschema.format.extra.SHA256FormatAttribute;
import com.github.fge.jsonschema.format.extra.SHA512FormatAttribute;
import com.github.fge.jsonschema.format.extra.UUIDFormatAttribute;

public final class ExtraFormatsDictionary {
    private static final Dictionary<FormatAttribute> DICTIONARY;

    public static {
        DictionaryBuilder dictionaryBuilder = Dictionary.newBuilder();
        dictionaryBuilder.addEntry("base64", (Object)Base64FormatAttribute.getInstance());
        dictionaryBuilder.addEntry("json-pointer", (Object)JsonPointerFormatAttribute.getInstance());
        dictionaryBuilder.addEntry("mac", (Object)MacAddressFormatAttribute.getInstance());
        dictionaryBuilder.addEntry("md5", (Object)MD5FormatAttribute.getInstance());
        dictionaryBuilder.addEntry("sha1", (Object)SHA1FormatAttribute.getInstance());
        dictionaryBuilder.addEntry("sha256", (Object)SHA256FormatAttribute.getInstance());
        dictionaryBuilder.addEntry("sha512", (Object)SHA512FormatAttribute.getInstance());
        dictionaryBuilder.addEntry("uuid", (Object)UUIDFormatAttribute.getInstance());
        DICTIONARY = dictionaryBuilder.freeze();
    }

    private ExtraFormatsDictionary() {
    }

    public static Dictionary<FormatAttribute> get() {
        return DICTIONARY;
    }
}

