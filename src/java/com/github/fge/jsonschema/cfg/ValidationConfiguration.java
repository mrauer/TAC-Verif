/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.util.Map
 */
package com.github.fge.jsonschema.cfg;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class ValidationConfiguration
implements Frozen<ValidationConfigurationBuilder> {
    public final int cacheSize;
    public final Library defaultLibrary;
    public final Map<JsonRef, Library> libraries;
    public final MessageBundle syntaxMessages;
    public final boolean useFormat;
    public final MessageBundle validationMessages;

    public ValidationConfiguration(ValidationConfigurationBuilder validationConfigurationBuilder) {
        this.libraries = ImmutableMap.copyOf(validationConfigurationBuilder.libraries);
        this.defaultLibrary = validationConfigurationBuilder.defaultLibrary;
        this.useFormat = validationConfigurationBuilder.useFormat;
        this.cacheSize = validationConfigurationBuilder.cacheSize;
        this.syntaxMessages = validationConfigurationBuilder.syntaxMessages;
        this.validationMessages = validationConfigurationBuilder.validationMessages;
    }

    public static ValidationConfiguration byDefault() {
        return ValidationConfiguration.newBuilder().freeze();
    }

    public static ValidationConfigurationBuilder newBuilder() {
        return new ValidationConfigurationBuilder();
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public Library getDefaultLibrary() {
        return this.defaultLibrary;
    }

    public Map<JsonRef, Library> getLibraries() {
        return this.libraries;
    }

    public MessageBundle getSyntaxMessages() {
        return this.syntaxMessages;
    }

    public boolean getUseFormat() {
        return this.useFormat;
    }

    public MessageBundle getValidationMessages() {
        return this.validationMessages;
    }

    public ValidationConfigurationBuilder thaw() {
        return new ValidationConfigurationBuilder(this);
    }
}

