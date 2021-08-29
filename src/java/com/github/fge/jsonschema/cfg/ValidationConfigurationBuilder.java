/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.EnumMap
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.cfg;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.messages.JsonSchemaSyntaxMessageBundle;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.library.DraftV3Library;
import com.github.fge.jsonschema.library.DraftV4HyperSchemaLibrary;
import com.github.fge.jsonschema.library.DraftV4Library;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ValidationConfigurationBuilder
implements Thawed<ValidationConfiguration> {
    private static final MessageBundle BUNDLE;
    private static final Map<SchemaVersion, Library> DEFAULT_LIBRARIES;
    public int cacheSize;
    public Library defaultLibrary;
    public final Map<JsonRef, Library> libraries;
    public MessageBundle syntaxMessages;
    public boolean useFormat;
    public MessageBundle validationMessages;

    public static {
        EnumMap enumMap;
        BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
        DEFAULT_LIBRARIES = enumMap = new EnumMap(SchemaVersion.class);
        enumMap.put((Object)SchemaVersion.DRAFTV3, (Object)DraftV3Library.get());
        enumMap.put((Object)SchemaVersion.DRAFTV4, (Object)DraftV4Library.get());
        enumMap.put((Object)SchemaVersion.DRAFTV4_HYPERSCHEMA, (Object)DraftV4HyperSchemaLibrary.get());
    }

    public ValidationConfigurationBuilder() {
        Map<SchemaVersion, Library> map = DEFAULT_LIBRARIES;
        this.defaultLibrary = (Library)map.get((Object)SchemaVersion.DRAFTV4);
        this.useFormat = true;
        this.cacheSize = 512;
        this.libraries = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            JsonRef jsonRef = JsonRef.fromURI(((SchemaVersion)((Object)entry.getKey())).getLocation());
            Library library = (Library)entry.getValue();
            this.libraries.put((Object)jsonRef, (Object)library);
        }
        this.syntaxMessages = MessageBundles.getBundle(JsonSchemaSyntaxMessageBundle.class);
        this.validationMessages = MessageBundles.getBundle(JsonSchemaValidationBundle.class);
    }

    public ValidationConfigurationBuilder(ValidationConfiguration validationConfiguration) {
        this.defaultLibrary = (Library)DEFAULT_LIBRARIES.get((Object)SchemaVersion.DRAFTV4);
        this.useFormat = true;
        this.cacheSize = 512;
        this.libraries = new HashMap(validationConfiguration.libraries);
        this.defaultLibrary = validationConfiguration.defaultLibrary;
        this.useFormat = validationConfiguration.useFormat;
        this.cacheSize = validationConfiguration.cacheSize;
        this.syntaxMessages = validationConfiguration.syntaxMessages;
        this.validationMessages = validationConfiguration.validationMessages;
    }

    public ValidationConfigurationBuilder addLibrary(String string, Library library) {
        MessageBundle messageBundle;
        JsonRef jsonRef;
        try {
            jsonRef = JsonRef.fromString(string);
            messageBundle = BUNDLE;
        }
        catch (JsonReferenceException jsonReferenceException) {
            throw new IllegalArgumentException(jsonReferenceException.getMessage());
        }
        messageBundle.checkArgumentPrintf(jsonRef.isAbsolute(), "refProcessing.uriNotAbsolute", jsonRef);
        messageBundle.checkNotNull(library, "nullLibrary");
        boolean bl = this.libraries.put((Object)jsonRef, (Object)library) == null;
        messageBundle.checkArgumentPrintf(bl, "dupLibrary", jsonRef);
        return this;
    }

    public ValidationConfiguration freeze() {
        return new ValidationConfiguration(this);
    }

    public ValidationConfigurationBuilder setCacheSize(int n) {
        MessageBundle messageBundle = BUNDLE;
        boolean bl = n >= -1;
        messageBundle.checkArgument(bl, "invalidCacheSize");
        this.cacheSize = n;
        return this;
    }

    public ValidationConfigurationBuilder setDefaultLibrary(String string, Library library) {
        this.addLibrary(string, library);
        this.defaultLibrary = library;
        return this;
    }

    public ValidationConfigurationBuilder setDefaultVersion(SchemaVersion schemaVersion) {
        BUNDLE.checkNotNull(schemaVersion, "nullVersion");
        this.defaultLibrary = (Library)DEFAULT_LIBRARIES.get((Object)schemaVersion);
        return this;
    }

    public ValidationConfigurationBuilder setSyntaxMessages(MessageBundle messageBundle) {
        BUNDLE.checkNotNull(messageBundle, "nullMessageBundle");
        this.syntaxMessages = messageBundle;
        return this;
    }

    public ValidationConfigurationBuilder setUseFormat(boolean bl) {
        this.useFormat = bl;
        return this;
    }

    public ValidationConfigurationBuilder setValidationMessages(MessageBundle messageBundle) {
        BUNDLE.checkNotNull(messageBundle, "nullMessageBundle");
        this.validationMessages = messageBundle;
        return this;
    }
}

