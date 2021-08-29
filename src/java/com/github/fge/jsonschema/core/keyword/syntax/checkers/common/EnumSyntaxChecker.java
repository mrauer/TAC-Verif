/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.base.Equivalence
 *  com.google.common.base.Equivalence$Wrapper
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonNumEquivalence;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class EnumSyntaxChecker
extends AbstractSyntaxChecker {
    private static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;
    private static final SyntaxChecker INSTANCE = new EnumSyntaxChecker();

    private EnumSyntaxChecker() {
        super("enum", NodeType.ARRAY, new NodeType[0]);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        HashSet hashSet = new HashSet();
        Iterator iterator = this.getNode(schemaTree).elements();
        while (iterator.hasNext()) {
            JsonNode jsonNode = (JsonNode)iterator.next();
            if (hashSet.add((Object)EQUIVALENCE.wrap((Object)jsonNode))) continue;
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.duplicateElements"));
            break;
        }
    }
}

