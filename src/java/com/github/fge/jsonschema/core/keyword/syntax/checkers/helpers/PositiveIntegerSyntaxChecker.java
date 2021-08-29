/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.util.Collection
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;

public final class PositiveIntegerSyntaxChecker
extends AbstractSyntaxChecker {
    public PositiveIntegerSyntaxChecker(String string) {
        super(string, NodeType.INTEGER, new NodeType[0]);
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        if (!jsonNode.canConvertToInt()) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.integerTooLarge").put("max", Integer.MAX_VALUE));
            return;
        }
        if (jsonNode.intValue() < 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.integerIsNegative"));
        }
    }
}

