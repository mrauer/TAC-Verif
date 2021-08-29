/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.util.Collection
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;

public final class ExclusiveMinimumSyntaxChecker
extends AbstractSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new ExclusiveMinimumSyntaxChecker();

    private ExclusiveMinimumSyntaxChecker() {
        super("exclusiveMinimum", NodeType.BOOLEAN, new NodeType[0]);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        if (!schemaTree.getNode().has("minimum")) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.exclusiveMinimum"));
        }
    }
}

