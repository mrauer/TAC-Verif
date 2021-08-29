/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaOrSchemaArraySyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class DraftV3ItemsSyntaxChecker
extends SchemaOrSchemaArraySyntaxChecker {
    private static final SyntaxChecker INSTANCE = new DraftV3ItemsSyntaxChecker();

    private DraftV3ItemsSyntaxChecker() {
        super("items");
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void extraChecks(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree) throws ProcessingException {
    }
}

