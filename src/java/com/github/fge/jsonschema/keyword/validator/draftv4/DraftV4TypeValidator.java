/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.EnumSet
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.EnumSet;
import java.util.Iterator;

public final class DraftV4TypeValidator
extends AbstractKeywordValidator {
    private final EnumSet<NodeType> types = EnumSet.noneOf(NodeType.class);

    public DraftV4TypeValidator(JsonNode jsonNode) {
        super("type");
        Iterator iterator = jsonNode.get(this.keyword).elements();
        while (iterator.hasNext()) {
            JsonNode jsonNode2 = (JsonNode)iterator.next();
            this.types.add((Object)NodeType.fromName(jsonNode2.textValue()));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.types);
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        NodeType nodeType = NodeType.getNodeType(fullData.getInstance().getNode());
        if (!this.types.contains((Object)nodeType)) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.typeNoMatch").putArgument("found", nodeType).putArgument("expected", AbstractKeywordValidator.toArrayNode(this.types)));
        }
    }
}

