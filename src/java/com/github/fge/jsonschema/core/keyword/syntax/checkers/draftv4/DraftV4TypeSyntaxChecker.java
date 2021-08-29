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

public final class DraftV4TypeSyntaxChecker
extends AbstractSyntaxChecker {
    private static final EnumSet<NodeType> ALL_TYPES = EnumSet.allOf(NodeType.class);
    private static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;
    private static final SyntaxChecker INSTANCE = new DraftV4TypeSyntaxChecker();

    private DraftV4TypeSyntaxChecker() {
        NodeType nodeType = NodeType.ARRAY;
        NodeType[] arrnodeType = new NodeType[]{NodeType.STRING};
        super("type", nodeType, arrnodeType);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        if (jsonNode.isTextual()) {
            String string = jsonNode.textValue();
            if (NodeType.fromName(string) == null) {
                processingReport.error(this.newMsg(schemaTree, messageBundle, "common.typeDisallow.primitiveType.unknown").putArgument("found", string).putArgument("valid", ALL_TYPES));
            }
            return;
        }
        int n2 = jsonNode.size();
        if (n2 == 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.empty"));
            return;
        }
        HashSet hashSet = new HashSet();
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            JsonNode jsonNode2 = jsonNode.get(i2);
            NodeType nodeType = NodeType.getNodeType(jsonNode2);
            boolean bl2 = hashSet.add((Object)EQUIVALENCE.wrap((Object)jsonNode2));
            NodeType nodeType2 = NodeType.STRING;
            if (nodeType != nodeType2) {
                processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.element.incorrectType").putArgument("index", i2).putArgument("expected", nodeType2).putArgument("found", nodeType));
            } else {
                String string = jsonNode2.textValue();
                if (NodeType.fromName(string) == null) {
                    processingReport.error(this.newMsg(schemaTree, messageBundle, "common.typeDisallow.primitiveType.unknown").put("index", i2).putArgument("found", string).putArgument("valid", ALL_TYPES));
                }
            }
            bl = bl2;
        }
        if (!bl) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.duplicateElements"));
        }
    }
}

