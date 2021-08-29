/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.math.BigDecimal
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
import java.math.BigDecimal;
import java.util.Collection;

public final class DivisorSyntaxChecker
extends AbstractSyntaxChecker {
    public DivisorSyntaxChecker(String string) {
        NodeType nodeType = NodeType.INTEGER;
        NodeType[] arrnodeType = new NodeType[]{NodeType.NUMBER};
        super(string, nodeType, arrnodeType);
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        if (jsonNode.decimalValue().compareTo(BigDecimal.ZERO) <= 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.divisor.notPositive").put("found", jsonNode));
        }
    }
}

