/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
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

public final class SchemaArraySyntaxChecker
extends AbstractSyntaxChecker {
    public SchemaArraySyntaxChecker(String string) {
        super(string, NodeType.ARRAY, new NodeType[0]);
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        int n2 = this.getNode(schemaTree).size();
        if (n2 == 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.empty"));
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = this.keyword;
            Object[] arrobject = new Object[]{i2};
            collection.add((Object)JsonPointer.of(string, arrobject));
        }
    }
}

