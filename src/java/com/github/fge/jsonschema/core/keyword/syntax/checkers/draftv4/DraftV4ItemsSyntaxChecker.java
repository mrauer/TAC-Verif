/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaOrSchemaArraySyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Objects;

public final class DraftV4ItemsSyntaxChecker
extends SchemaOrSchemaArraySyntaxChecker {
    private static final SyntaxChecker INSTANCE = new DraftV4ItemsSyntaxChecker();

    private DraftV4ItemsSyntaxChecker() {
        super("items");
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void extraChecks(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof ArrayNode && jsonNode.size() == 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.empty"));
        }
    }
}

