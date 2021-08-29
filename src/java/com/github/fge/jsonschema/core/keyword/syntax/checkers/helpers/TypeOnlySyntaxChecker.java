/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.Collection
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers;

import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;

public final class TypeOnlySyntaxChecker
extends AbstractSyntaxChecker {
    public /* varargs */ TypeOnlySyntaxChecker(String string, NodeType nodeType, NodeType ... arrnodeType) {
        super(string, nodeType, arrnodeType);
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
    }
}

