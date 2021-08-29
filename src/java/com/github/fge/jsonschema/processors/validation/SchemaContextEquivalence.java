/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.base.Equivalence
 *  java.lang.Object
 */
package com.github.fge.jsonschema.processors.validation;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.google.common.base.Equivalence;

public final class SchemaContextEquivalence
extends Equivalence<SchemaContext> {
    private static final Equivalence<SchemaContext> INSTANCE = new SchemaContextEquivalence();

    public static Equivalence<SchemaContext> getInstance() {
        return INSTANCE;
    }

    public boolean doEquivalent(SchemaContext schemaContext, SchemaContext schemaContext2) {
        return schemaContext.getSchema().equals((Object)schemaContext2.getSchema()) && schemaContext.getInstanceType() == schemaContext2.getInstanceType();
    }

    public int doHash(SchemaContext schemaContext) {
        return schemaContext.getSchema().hashCode() ^ schemaContext.getInstanceType().hashCode();
    }
}

