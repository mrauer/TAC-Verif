/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.library.Library
 *  java.lang.Object
 */
package com.github.fge.jsonschema.library;

import com.github.fge.jsonschema.core.keyword.syntax.dictionaries.DraftV4HyperSchemaSyntaxCheckerDictionary;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.library.digest.DraftV4DigesterDictionary;
import com.github.fge.jsonschema.library.format.DraftV4FormatAttributesDictionary;
import com.github.fge.jsonschema.library.validator.DraftV4ValidatorDictionary;

public final class DraftV4HyperSchemaLibrary {
    private static final Library LIBRARY = new Library(DraftV4HyperSchemaSyntaxCheckerDictionary.get(), DraftV4DigesterDictionary.get(), DraftV4ValidatorDictionary.get(), DraftV4FormatAttributesDictionary.get());

    private DraftV4HyperSchemaLibrary() {
    }

    public static Library get() {
        return LIBRARY;
    }
}

