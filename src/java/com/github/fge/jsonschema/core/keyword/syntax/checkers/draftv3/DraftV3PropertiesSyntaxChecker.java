/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaMapSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class DraftV3PropertiesSyntaxChecker
extends SchemaMapSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new DraftV3PropertiesSyntaxChecker();

    private DraftV3PropertiesSyntaxChecker() {
        super("properties");
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void extraChecks(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree) throws ProcessingException {
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(JacksonUtils.asMap(schemaTree.getNode().get(this.keyword)));
        for (Map.Entry entry : treeMap.entrySet()) {
            NodeType nodeType;
            NodeType nodeType2;
            String string = (String)entry.getKey();
            JsonNode jsonNode = ((JsonNode)entry.getValue()).get("required");
            if (jsonNode == null || (nodeType = NodeType.getNodeType(jsonNode)) == (nodeType2 = NodeType.BOOLEAN)) continue;
            processingReport.error(this.newMsg(schemaTree, messageBundle, "draftv3.properties.required.incorrectType").putArgument("property", string).putArgument("found", nodeType).put("expected", nodeType2));
        }
    }
}

