/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.LinkedHashSet
 */
package com.github.fge.jsonschema.core.load;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.SchemaLoader;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.RawProcessor;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.util.LinkedHashSet;

public final class RefResolver
extends RawProcessor<SchemaTree, SchemaTree> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private final SchemaLoader loader;

    public RefResolver(SchemaLoader schemaLoader) {
        super("schema", "schema");
        this.loader = schemaLoader;
    }

    private static JsonRef nodeAsRef(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.path("$ref");
        if (!jsonNode2.isTextual()) {
            return null;
        }
        try {
            JsonRef jsonRef = JsonRef.fromString(jsonNode2.textValue());
            return jsonRef;
        }
        catch (JsonReferenceException jsonReferenceException) {
            return null;
        }
    }

    @Override
    public SchemaTree rawProcess(ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        LinkedHashSet linkedHashSet;
        JsonRef jsonRef;
        block3 : {
            linkedHashSet = new LinkedHashSet();
            do {
                JsonRef jsonRef2;
                JsonPointer jsonPointer;
                if ((jsonRef2 = RefResolver.nodeAsRef(schemaTree.getNode())) == null) {
                    return schemaTree;
                }
                jsonRef = schemaTree.resolve(jsonRef2);
                if (!linkedHashSet.add((Object)jsonRef)) break block3;
                if (!schemaTree.containsRef(jsonRef)) {
                    schemaTree = this.loader.get(jsonRef.getLocator());
                }
                if ((jsonPointer = schemaTree.matchingPointer(jsonRef)) == null) break;
                schemaTree = schemaTree.setPointer(jsonPointer);
            } while (true);
            throw new ProcessingException(new ProcessingMessage().setMessage(BUNDLE.getMessage("refProcessing.danglingRef")).put("schema", schemaTree).putArgument("ref", jsonRef));
        }
        throw new ProcessingException(new ProcessingMessage().setMessage(BUNDLE.getMessage("refProcessing.refLoop")).put("schema", schemaTree).putArgument("ref", jsonRef).put("path", linkedHashSet));
    }

    public String toString() {
        return "ref resolver";
    }
}

