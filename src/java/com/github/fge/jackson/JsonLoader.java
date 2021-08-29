/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package com.github.fge.jackson;

import com.github.fge.jackson.JsonNodeReader;
import java.util.regex.Pattern;

public final class JsonLoader {
    public static final Pattern INITIAL_SLASH = Pattern.compile((String)"^/+");
    public static final JsonNodeReader READER = new JsonNodeReader();
}

