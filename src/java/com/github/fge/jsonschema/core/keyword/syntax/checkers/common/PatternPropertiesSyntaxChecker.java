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
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.helpers.SchemaMapSyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.RegexECMA262Helper;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class PatternPropertiesSyntaxChecker
extends SchemaMapSyntaxChecker {
    private static final SyntaxChecker INSTANCE = new PatternPropertiesSyntaxChecker();

    private PatternPropertiesSyntaxChecker() {
        super("patternProperties");
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void extraChecks(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree) throws ProcessingException {
        HashSet hashSet = Collections2.newHashSet((Iterator)this.getNode(schemaTree).fieldNames());
        for (String string : NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet)) {
            if (RegexECMA262Helper.regexIsValid(string)) continue;
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.patternProperties.member.notRegex").putArgument("propertyName", string));
        }
    }
}

