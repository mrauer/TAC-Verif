/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.base.Equivalence
 *  com.google.common.base.Equivalence$Wrapper
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.HashSet
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4;

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
import java.util.EnumSet;
import java.util.HashSet;

public final class RequiredSyntaxChecker
extends AbstractSyntaxChecker {
    private static final Equivalence<JsonNode> EQUIVALENCE = new JsonNumEquivalence();
    private static final SyntaxChecker INSTANCE = new RequiredSyntaxChecker();

    private RequiredSyntaxChecker() {
        super("required", NodeType.ARRAY, new NodeType[0]);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        int n2 = jsonNode.size();
        if (n2 == 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.empty"));
            return;
        }
        HashSet hashSet = new HashSet();
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            NodeType nodeType;
            JsonNode jsonNode2 = jsonNode.get(i2);
            boolean bl2 = hashSet.add((Object)EQUIVALENCE.wrap((Object)jsonNode2));
            NodeType nodeType2 = NodeType.getNodeType(jsonNode2);
            if (nodeType2 != (nodeType = NodeType.STRING)) {
                processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.element.incorrectType").putArgument("index", i2).putArgument("expected", EnumSet.of((Enum)nodeType)).putArgument("found", nodeType2));
            }
            bl = bl2;
        }
        if (!bl) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.duplicateElements"));
        }
    }
}

