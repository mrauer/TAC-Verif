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
 *  java.util.EnumSet
 *  java.util.HashSet
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.DependenciesSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;
import java.util.EnumSet;
import java.util.HashSet;

public final class DraftV4DependenciesSyntaxChecker
extends DependenciesSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new DraftV4DependenciesSyntaxChecker();

    private DraftV4DependenciesSyntaxChecker() {
        NodeType[] arrnodeType = new NodeType[]{NodeType.ARRAY};
        super(arrnodeType);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkDependency(ProcessingReport processingReport, MessageBundle messageBundle, String string, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree).get(string);
        NodeType nodeType = NodeType.getNodeType(jsonNode);
        if (nodeType != NodeType.ARRAY) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.dependencies.value.incorrectType").putArgument("property", string).putArgument("expected", this.dependencyTypes).putArgument("found", nodeType));
            return;
        }
        int n2 = jsonNode.size();
        if (n2 == 0) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.empty").put("property", string));
            return;
        }
        HashSet hashSet = new HashSet();
        boolean bl = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            JsonNode jsonNode2;
            JsonNode jsonNode3 = jsonNode.get(i2);
            NodeType nodeType2 = NodeType.getNodeType(jsonNode3);
            bl = hashSet.add((Object)DependenciesSyntaxChecker.EQUIVALENCE.wrap((Object)jsonNode3));
            NodeType nodeType3 = NodeType.STRING;
            if (nodeType2 == nodeType3) {
                jsonNode2 = jsonNode;
            } else {
                ProcessingMessage processingMessage = this.newMsg(schemaTree, messageBundle, "common.array.element.incorrectType").put("property", string);
                jsonNode2 = jsonNode;
                processingReport.error(processingMessage.putArgument("index", i2).putArgument("expected", EnumSet.of((Enum)nodeType3)).putArgument("found", nodeType2));
            }
            jsonNode = jsonNode2;
        }
        if (!bl) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.array.duplicateElements").put("property", string));
        }
    }
}

