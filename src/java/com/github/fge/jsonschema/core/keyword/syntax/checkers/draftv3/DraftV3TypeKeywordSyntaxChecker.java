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
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonNumEquivalence;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

public final class DraftV3TypeKeywordSyntaxChecker
extends AbstractSyntaxChecker {
    private static final String ANY = "any";
    private static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;

    public DraftV3TypeKeywordSyntaxChecker(String string) {
        NodeType nodeType = NodeType.STRING;
        NodeType[] arrnodeType = new NodeType[]{NodeType.ARRAY};
        super(string, nodeType, arrnodeType);
    }

    private static boolean typeIsValid(String string) {
        return ANY.equals((Object)string) || NodeType.fromName(string) != null;
        {
        }
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = schemaTree.getNode().get(this.keyword);
        if (jsonNode.isTextual()) {
            String string = jsonNode.textValue();
            if (!DraftV3TypeKeywordSyntaxChecker.typeIsValid(string)) {
                processingReport.error(this.newMsg(schemaTree, messageBundle, "common.typeDisallow.primitiveType.unknown").putArgument("found", string).putArgument("valid", EnumSet.allOf(NodeType.class)));
            }
            return;
        }
        int n2 = jsonNode.size();
        HashSet hashSet = new HashSet();
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            JsonNode jsonNode2;
            int n3;
            JsonNode jsonNode3 = jsonNode.get(i2);
            NodeType nodeType = NodeType.getNodeType(jsonNode3);
            boolean bl2 = hashSet.add((Object)EQUIVALENCE.wrap((Object)jsonNode3));
            NodeType nodeType2 = NodeType.OBJECT;
            if (nodeType == nodeType2) {
                String string = this.keyword;
                Object[] arrobject = new Object[]{i2};
                collection.add((Object)JsonPointer.of(string, arrobject));
                jsonNode2 = jsonNode;
                n3 = n2;
            } else {
                jsonNode2 = jsonNode;
                NodeType nodeType3 = NodeType.STRING;
                n3 = n2;
                if (nodeType != nodeType3) {
                    processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.element.incorrectType").putArgument("index", i2).putArgument("expected", EnumSet.of((Enum)nodeType2, (Enum)nodeType3)).putArgument("found", nodeType));
                } else if (!DraftV3TypeKeywordSyntaxChecker.typeIsValid(jsonNode3.textValue())) {
                    processingReport.error(this.newMsg(schemaTree, messageBundle, "common.typeDisallow.primitiveType.unknown").put("index", i2).putArgument("found", jsonNode3.textValue()).putArgument("valid", EnumSet.allOf(NodeType.class)));
                }
            }
            bl = bl2;
            jsonNode = jsonNode2;
            n2 = n3;
        }
        if (!bl) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.duplicateElements"));
        }
    }
}

