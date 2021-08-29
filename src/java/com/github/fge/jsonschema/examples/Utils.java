/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.URL
 *  java.util.Objects
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.github.fge.jsonschema.examples;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {
    private static final String PKGBASE;

    public static {
        String string = Utils.class.getPackage().getName();
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline23((char)'/');
        stringBuilder.append(string.replace((CharSequence)".", (CharSequence)"/"));
        PKGBASE = stringBuilder.toString();
    }

    private Utils() {
    }

    public static JsonNode loadResource(String string) throws IOException {
        String string2 = GeneratedOutlineSupport.outline21((StringBuilder)new StringBuilder(), (String)PKGBASE, (String)string);
        Objects.requireNonNull((Object)string2);
        if (string2.startsWith("/")) {
            URL uRL = JsonLoader.class.getResource(string2);
            if (uRL == null) {
                ClassLoader classLoader;
                if (Thread.currentThread().getContextClassLoader() != null) {
                    classLoader = Thread.currentThread().getContextClassLoader();
                } else {
                    Objects.requireNonNull((Object)JsonLoader.class.getClassLoader());
                    classLoader = JsonLoader.class.getClassLoader();
                }
                uRL = classLoader.getResource(JsonLoader.INITIAL_SLASH.matcher((CharSequence)string2).replaceFirst(""));
            }
            if (uRL != null) {
                InputStream inputStream = null;
                try {
                    inputStream = uRL.openStream();
                    JsonNode jsonNode = JsonLoader.READER.fromInputStream(inputStream);
                    return jsonNode;
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
            throw new IOException(GeneratedOutlineSupport.outline19((String)"resource ", (String)string2, (String)" not found"));
        }
        throw new IllegalArgumentException("resource path does not start with a '/'");
    }
}

