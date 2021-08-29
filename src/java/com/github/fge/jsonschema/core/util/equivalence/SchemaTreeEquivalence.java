/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.base.Equivalence
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.util.equivalence;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.google.common.base.Equivalence;

@Deprecated
public final class SchemaTreeEquivalence
extends Equivalence<SchemaTree> {
    private static final Equivalence<SchemaTree> INSTANCE = new SchemaTreeEquivalence();

    private SchemaTreeEquivalence() {
    }

    public static Equivalence<SchemaTree> getInstance() {
        return INSTANCE;
    }

    public boolean doEquivalent(SchemaTree schemaTree, SchemaTree schemaTree2) {
        return schemaTree.getLoadingRef().equals(schemaTree2.getLoadingRef()) && schemaTree.getContext().equals(schemaTree2.getContext()) && schemaTree.getPointer().equals(schemaTree2.getPointer()) && schemaTree.getBaseNode().equals((Object)schemaTree2.getBaseNode());
    }

    public int doHash(SchemaTree schemaTree) {
        return 31 * (31 * (31 * schemaTree.getLoadingRef().hashCode() + schemaTree.getContext().hashCode()) + schemaTree.getPointer().hashCode()) + schemaTree.getBaseNode().hashCode();
    }
}

