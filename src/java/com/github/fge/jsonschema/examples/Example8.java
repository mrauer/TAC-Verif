/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.cfg.ValidationConfiguration
 *  com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder
 *  com.github.fge.jsonschema.examples.Example8$UUIDFormatAttribute
 *  com.github.fge.jsonschema.library.Library
 *  com.github.fge.jsonschema.library.LibraryBuilder
 *  com.github.fge.jsonschema.main.JsonSchemaFactory
 *  com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder
 *  com.github.fge.jsonschema.messages.JsonSchemaValidationBundle
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.github.fge.msgsimple.bundle.MessageBundleBuilder
 *  com.github.fge.msgsimple.source.MapMessageSource
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Map
 */
package com.github.fge.jsonschema.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Example8;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.library.DraftV4Library;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.library.LibraryBuilder;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.MessageBundleBuilder;
import com.github.fge.msgsimple.load.MessageBundles;
import com.github.fge.msgsimple.source.MapMessageSource;
import com.github.fge.msgsimple.source.MessageSource;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public final class Example8 {
    public Example8() {
    }

    public static /* varargs */ void main(String ... arrstring) throws IOException, ProcessingException {
        JsonNode jsonNode = Utils.loadResource("/custom-fmt.json");
        JsonNode jsonNode2 = Utils.loadResource("/custom-fmt-good.json");
        JsonNode jsonNode3 = Utils.loadResource("/custom-fmt-bad.json");
        Library library = DraftV4Library.get().thaw().addFormatAttribute("uuid", UUIDFormatAttribute.getInstance()).freeze();
        MapMessageSource.Builder builder = new MapMessageSource.Builder(null);
        InternalBundle internalBundle = MapMessageSource.BUNDLE;
        internalBundle.checkNotNull("invalidUUID", "cfg.map.nullKey");
        internalBundle.checkNotNull("input is not a valid UUID", "cfg.map.nullValue");
        builder.messages.put((Object)"invalidUUID", (Object)"input is not a valid UUID");
        MapMessageSource mapMessageSource = new MapMessageSource(builder, null);
        MessageBundleBuilder messageBundleBuilder = new MessageBundleBuilder(MessageBundles.getBundle(JsonSchemaValidationBundle.class));
        messageBundleBuilder.appendSource((MessageSource)mapMessageSource);
        MessageBundle messageBundle = new MessageBundle(messageBundleBuilder);
        ValidationConfiguration validationConfiguration = ValidationConfiguration.newBuilder().setDefaultLibrary("http://my.site/myschema#", library).setValidationMessages(messageBundle).freeze();
        JsonSchema jsonSchema = JsonSchemaFactory.newBuilder().setValidationConfiguration(validationConfiguration).freeze().getJsonSchema(jsonNode);
        ProcessingReport processingReport = jsonSchema.validate(jsonNode2);
        System.out.println((Object)processingReport);
        ProcessingReport processingReport2 = jsonSchema.validate(jsonNode3);
        System.out.println((Object)processingReport2);
    }
}

