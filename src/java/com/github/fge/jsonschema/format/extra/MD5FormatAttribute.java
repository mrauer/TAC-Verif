/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.github.fge.jsonschema.format.extra;

import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.helpers.HexStringFormatAttribute;

public final class MD5FormatAttribute
extends HexStringFormatAttribute {
    private static final FormatAttribute instance = new MD5FormatAttribute();

    private MD5FormatAttribute() {
        super("md5", 32);
    }

    public static FormatAttribute getInstance() {
        return instance;
    }
}

