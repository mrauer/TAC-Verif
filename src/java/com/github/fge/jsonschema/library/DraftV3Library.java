/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.util.Dictionary
 *  com.github.fge.jsonschema.library.Library
 *  java.lang.Object
 */
package com.github.fge.jsonschema.library;

import com.github.fge.jsonschema.core.keyword.syntax.dictionaries.DraftV3SyntaxCheckerDictionary;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.library.digest.DraftV3DigesterDictionary;
import com.github.fge.jsonschema.library.format.DraftV3FormatAttributesDictionary;
import com.github.fge.jsonschema.library.validator.DraftV3ValidatorDictionary;

public final class DraftV3Library {
    private static final Library LIBRARY = new Library(DraftV3SyntaxCheckerDictionary.get(), DraftV3DigesterDictionary.get(), DraftV3ValidatorDictionary.get(), DraftV3FormatAttributesDictionary.get());

    private DraftV3Library() {
    }

    public static Library get() {
        return LIBRARY;
    }
}

