/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.github.fge.jsonschema.format.extra;

import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.format.helpers.HexStringFormatAttribute;

public final class SHA256FormatAttribute
extends HexStringFormatAttribute {
    private static final FormatAttribute instance = new SHA256FormatAttribute();

    private SHA256FormatAttribute() {
        super("sha256", 64);
    }

    public static FormatAttribute getInstance() {
        return instance;
    }
}

