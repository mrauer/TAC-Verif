/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ExceptionProvider;
import com.github.fge.jsonschema.core.exceptions.InvalidSchemaException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;
import java.util.EnumSet;

public abstract class AbstractSyntaxChecker
implements SyntaxChecker {
    private static final ExceptionProvider EXCEPTION_PROVIDER = new ExceptionProvider(){

        @Override
        public ProcessingException doException(ProcessingMessage processingMessage) {
            return new InvalidSchemaException(processingMessage);
        }
    };
    public final String keyword;
    private final EnumSet<NodeType> types;

    public /* varargs */ AbstractSyntaxChecker(String string, NodeType nodeType, NodeType ... arrnodeType) {
        this.keyword = string;
        this.types = EnumSet.of((Enum)nodeType, (Enum[])arrnodeType);
    }

    @Override
    public final void checkSyntax(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        NodeType nodeType = NodeType.getNodeType(this.getNode(schemaTree));
        if (!this.types.contains((Object)nodeType)) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "common.incorrectType").putArgument("found", nodeType).putArgument("expected", this.types));
            return;
        }
        this.checkValue(collection, messageBundle, processingReport, schemaTree);
    }

    public abstract void checkValue(Collection<JsonPointer> var1, MessageBundle var2, ProcessingReport var3, SchemaTree var4) throws ProcessingException;

    public final JsonNode getNode(SchemaTree schemaTree) {
        return schemaTree.getNode().get(this.keyword);
    }

    @Override
    public final EnumSet<NodeType> getValidTypes() {
        return EnumSet.copyOf(this.types);
    }

    public final ProcessingMessage newMsg(SchemaTree schemaTree, MessageBundle messageBundle, String string) {
        return new ProcessingMessage().setMessage(messageBundle.getMessage(string)).put("domain", "syntax").put("schema", (AsJson)schemaTree).put("keyword", this.keyword).setExceptionProvider(EXCEPTION_PROVIDER);
    }

}

