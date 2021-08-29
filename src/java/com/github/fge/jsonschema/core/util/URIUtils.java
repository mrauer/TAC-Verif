/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.URIUtils$1
 *  com.github.fge.jsonschema.core.util.URIUtils$2
 *  com.github.fge.jsonschema.core.util.URIUtils$3
 *  com.github.fge.jsonschema.core.util.URIUtils$4
 *  com.github.fge.jsonschema.core.util.URIUtils$5
 *  com.github.fge.jsonschema.core.util.URIUtils$6
 *  com.google.common.base.CharMatcher
 *  com.google.common.base.CharMatcher$InRange
 *  com.google.common.base.CharMatcher$Or
 *  com.google.common.base.Function
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 */
package com.github.fge.jsonschema.core.util;

import com.github.fge.jsonschema.core.util.ArgumentChecker;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import java.net.URI;

public final class URIUtils {
    private static final CharMatcher ALPHA;
    private static final Function<String, String> LOWERCASE;
    private static final ArgumentChecker<URI> PATHURI_CHECKER;
    private static final ArgumentChecker<URI> SCHEMAURI_CHECKER;
    private static final Function<URI, URI> SCHEMAURI_NORMALIZER;
    private static final ArgumentChecker<String> SCHEME_CHECKER;
    private static final CharMatcher SCHEME_LEGAL;
    private static final Function<URI, URI> URI_NORMALIZER;

    public static {
        CharMatcher charMatcher;
        ALPHA = charMatcher = new CharMatcher.Or((CharMatcher)new CharMatcher.InRange('a', 'z'), (CharMatcher)new CharMatcher.InRange('A', 'Z')).precomputed();
        SCHEME_LEGAL = charMatcher.or((CharMatcher)new CharMatcher.InRange('0', '9')).or(CharMatcher.anyOf((CharSequence)"+-.")).precomputed();
        LOWERCASE = new 1();
        URI_NORMALIZER = new 2();
        SCHEMAURI_NORMALIZER = new 3();
        SCHEME_CHECKER = new 4();
        PATHURI_CHECKER = new 5();
        SCHEMAURI_CHECKER = new 6();
    }

    private URIUtils() {
    }

    public static /* synthetic */ Function access$000() {
        return LOWERCASE;
    }

    public static /* synthetic */ Function access$100() {
        return URI_NORMALIZER;
    }

    public static /* synthetic */ CharMatcher access$200() {
        return ALPHA;
    }

    public static /* synthetic */ CharMatcher access$300() {
        return SCHEME_LEGAL;
    }

    public static void checkPathURI(URI uRI) {
        PATHURI_CHECKER.check(uRI);
    }

    public static void checkSchemaURI(URI uRI) {
        SCHEMAURI_CHECKER.check(uRI);
    }

    public static void checkScheme(String string) {
        SCHEME_CHECKER.check(string);
    }

    public static URI normalizeSchemaURI(URI uRI) {
        return (URI)SCHEMAURI_NORMALIZER.apply((Object)uRI);
    }

    public static String normalizeScheme(String string) {
        return (String)LOWERCASE.apply((Object)string);
    }

    public static URI normalizeURI(URI uRI) {
        return (URI)URI_NORMALIZER.apply((Object)uRI);
    }

    public static ArgumentChecker<URI> pathURIChecker() {
        return PATHURI_CHECKER;
    }

    public static ArgumentChecker<URI> schemaURIChecker() {
        return SCHEMAURI_CHECKER;
    }

    public static Function<URI, URI> schemaURINormalizer() {
        return SCHEMAURI_NORMALIZER;
    }

    public static ArgumentChecker<String> schemeChecker() {
        return SCHEME_CHECKER;
    }

    public static Function<String, String> schemeNormalizer() {
        return LOWERCASE;
    }

    public static Function<URI, URI> uriNormalizer() {
        return URI_NORMALIZER;
    }
}

