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
package com.github.fge.jsonschema.core.keyword.syntax.checkers.common;

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

public final class AdditionalSyntaxChecker
extends AbstractSyntaxChecker {
    public AdditionalSyntaxChecker(String string) {
        NodeType nodeType = NodeType.BOOLEAN;
        NodeType[] arrnodeType = new NodeType[]{NodeType.OBJECT};
        super(string, nodeType, arrnodeType);
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof ObjectNode) {
            collection.add((Object)JsonPointer.of(this.keyword, new Object[0]));
        }
    }
}

