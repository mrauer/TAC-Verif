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
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class SchemaMapSyntaxChecker
extends AbstractSyntaxChecker {
    public SchemaMapSyntaxChecker(String string) {
        super(string, NodeType.OBJECT, new NodeType[0]);
    }

    private void collectPointers(Collection<JsonPointer> collection, JsonNode jsonNode) {
        HashSet hashSet = Collections2.newHashSet((Iterator)jsonNode.fieldNames());
        for (String string : NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet)) {
            collection.add((Object)JsonPointer.of(this.keyword, string));
        }
    }

    @Override
    public final void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        this.collectPointers(collection, this.getNode(schemaTree));
        this.extraChecks(processingReport, messageBundle, schemaTree);
    }

    public abstract void extraChecks(ProcessingReport var1, MessageBundle var2, SchemaTree var3) throws ProcessingException;
}

