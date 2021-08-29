/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.NaturalOrdering
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.github.fge.jsonschema.core.keyword.syntax;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.processing.RawProcessor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class SyntaxProcessor
extends RawProcessor<SchemaTree, SchemaTree> {
    private final MessageBundle bundle;
    private final Map<String, SyntaxChecker> checkers;

    public SyntaxProcessor(MessageBundle messageBundle, Dictionary<SyntaxChecker> dictionary) {
        super("schema", "schema");
        this.bundle = messageBundle;
        this.checkers = dictionary.entries();
    }

    private ProcessingMessage newMsg(SchemaTree schemaTree, String string) {
        return new ProcessingMessage().put("schema", schemaTree).put("domain", "syntax").setMessage(this.bundle.getMessage(string));
    }

    private void validate(ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        JsonNode jsonNode = schemaTree.getNode();
        NodeType nodeType = NodeType.getNodeType(jsonNode);
        if (nodeType != NodeType.OBJECT) {
            processingReport.error(this.newMsg(schemaTree, "core.notASchema").putArgument("found", nodeType));
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(this.checkers);
        HashSet hashSet = Collections2.newHashSet((Iterator)jsonNode.fieldNames());
        treeMap.keySet().retainAll((Collection)hashSet);
        hashSet.removeAll((Collection)treeMap.keySet());
        if (!hashSet.isEmpty()) {
            processingReport.warn(this.newMsg(schemaTree, "core.unknownKeywords").putArgument("ignored", NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet)));
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = treeMap.values().iterator();
        while (iterator.hasNext()) {
            ((SyntaxChecker)iterator.next()).checkSyntax((Collection<JsonPointer>)arrayList, this.bundle, processingReport, schemaTree);
        }
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            this.validate(processingReport, schemaTree.append((JsonPointer)iterator2.next()));
        }
    }

    @Override
    public SchemaTree rawProcess(ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        this.validate(processingReport, schemaTree);
        return schemaTree;
    }

    public String toString() {
        return "syntax checker";
    }
}

