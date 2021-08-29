/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.base.Equivalence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.JsonNumEquivalence;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public abstract class DependenciesSyntaxChecker
extends AbstractSyntaxChecker {
    public static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;
    public final EnumSet<NodeType> dependencyTypes;

    public /* varargs */ DependenciesSyntaxChecker(NodeType ... arrnodeType) {
        NodeType nodeType = NodeType.OBJECT;
        super("dependencies", nodeType, new NodeType[0]);
        this.dependencyTypes = EnumSet.of((Enum)nodeType, (Enum[])arrnodeType);
    }

    public abstract void checkDependency(ProcessingReport var1, MessageBundle var2, String var3, SchemaTree var4) throws ProcessingException;

    @Override
    public final void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree);
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(JacksonUtils.asMap(jsonNode));
        for (Map.Entry entry : treeMap.entrySet()) {
            String string = (String)entry.getKey();
            JsonNode jsonNode2 = (JsonNode)entry.getValue();
            Objects.requireNonNull((Object)jsonNode2);
            if (jsonNode2 instanceof ObjectNode) {
                collection.add((Object)JsonPointer.of(this.keyword, string));
                continue;
            }
            this.checkDependency(processingReport, messageBundle, (String)entry.getKey(), schemaTree);
        }
    }
}

