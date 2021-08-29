/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;
import java.util.Objects;

public abstract class SchemaOrSchemaArraySyntaxChecker
extends AbstractSyntaxChecker {
    public SchemaOrSchemaArraySyntaxChecker(String string) {
        NodeType nodeType = NodeType.ARRAY;
        NodeType[] arrnodeType = new NodeType[]{NodeType.OBJECT};
        super(string, nodeType, arrnodeType);
    }

    private void collectPointers(Collection<JsonPointer> collection, SchemaTree schemaTree) {
        JsonNode jsonNode = this.getNode(schemaTree);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof ObjectNode) {
            collection.add((Object)JsonPointer.of(this.keyword, new Object[0]));
            return;
        }
        for (int i2 = 0; i2 < jsonNode.size(); ++i2) {
            String string = this.keyword;
            Object[] arrobject = new Object[]{i2};
            collection.add((Object)JsonPointer.of(string, arrobject));
        }
    }

    @Override
    public final void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        this.collectPointers(collection, schemaTree);
        this.extraChecks(processingReport, messageBundle, schemaTree);
    }

    public abstract void extraChecks(ProcessingReport var1, MessageBundle var2, SchemaTree var3) throws ProcessingException;
}

