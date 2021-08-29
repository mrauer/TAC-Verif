/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.net.MediaType
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.ImmutableSet;
import com.google.common.net.MediaType;
import java.util.Collection;
import java.util.Objects;

public final class MediaSyntaxChecker
extends AbstractSyntaxChecker {
    private static final ImmutableSet<String> BINARY_ENCODINGS = ImmutableSet.construct((int)5, (Object[])new Object[]{"7bit", "8bit", "binary", "quoted-printable", "base64"});
    private static final String BINARY_ENCODING_FIELDNAME = "binaryEncoding";
    private static final SyntaxChecker INSTANCE = new MediaSyntaxChecker();
    private static final String TYPE_FIELDNAME = "type";

    private MediaSyntaxChecker() {
        super("media", NodeType.OBJECT, new NodeType[0]);
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        NodeType nodeType;
        JsonNode jsonNode = this.getNode(schemaTree);
        JsonNode jsonNode2 = jsonNode.path(BINARY_ENCODING_FIELDNAME);
        Objects.requireNonNull((Object)jsonNode2);
        if (!(jsonNode2 instanceof MissingNode)) {
            NodeType nodeType2 = NodeType.getNodeType(jsonNode2);
            String string = jsonNode2.textValue();
            if (string == null) {
                processingReport.error(this.newMsg(schemaTree, messageBundle, "draftv4.media.binaryEncoding.incorrectType").put("expected", NodeType.STRING).putArgument("found", nodeType2));
            } else {
                ImmutableSet<String> immutableSet = BINARY_ENCODINGS;
                if (!immutableSet.contains((Object)string.toLowerCase())) {
                    processingReport.error(this.newMsg(schemaTree, messageBundle, "draftv4.media.binaryEncoding.invalid").putArgument("value", string).putArgument("valid", immutableSet));
                }
            }
        }
        JsonNode jsonNode3 = jsonNode.path(TYPE_FIELDNAME);
        Objects.requireNonNull((Object)jsonNode3);
        if (jsonNode3 instanceof MissingNode) {
            return;
        }
        NodeType nodeType3 = NodeType.getNodeType(jsonNode3);
        if (nodeType3 != (nodeType = NodeType.STRING)) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "draftv4.media.type.incorrectType").put("expected", nodeType).putArgument("found", nodeType3));
            return;
        }
        String string = jsonNode3.textValue();
        try {
            MediaType.parse((String)string);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            processingReport.error(this.newMsg(schemaTree, messageBundle, "draftv4.media.type.notMediaType").putArgument("value", string));
            return;
        }
    }
}

