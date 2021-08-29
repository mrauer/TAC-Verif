/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4;

import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;

public final class NotSyntaxChecker
extends AbstractSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new NotSyntaxChecker();

    private NotSyntaxChecker() {
        super("not", NodeType.ARRAY, NodeType.values());
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        collection.add((Object)JsonPointer.of(this.keyword, new Object[0]));
    }
}

