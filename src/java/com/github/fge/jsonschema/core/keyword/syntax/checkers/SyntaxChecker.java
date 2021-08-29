/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers;

import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;
import java.util.EnumSet;

public interface SyntaxChecker {
    public void checkSyntax(Collection<JsonPointer> var1, MessageBundle var2, ProcessingReport var3, SchemaTree var4) throws ProcessingException;

    public EnumSet<NodeType> getValidTypes();
}

