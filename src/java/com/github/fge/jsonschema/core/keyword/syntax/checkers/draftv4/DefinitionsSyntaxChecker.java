/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv4;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaMapSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class DefinitionsSyntaxChecker
extends SchemaMapSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new DefinitionsSyntaxChecker();

    private DefinitionsSyntaxChecker() {
        super("definitions");
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void extraChecks(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree) throws ProcessingException {
    }
}

