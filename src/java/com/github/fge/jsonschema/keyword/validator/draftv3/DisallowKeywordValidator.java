/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.validator.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.helpers.DraftV3TypeKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class DisallowKeywordValidator
extends DraftV3TypeKeywordValidator {
    public DisallowKeywordValidator(JsonNode jsonNode) {
        super("disallow", jsonNode);
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        NodeType nodeType = NodeType.getNodeType(fullData.getInstance().getNode());
        if (this.types.contains((Object)nodeType)) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.draftv3.disallow.type").putArgument("found", nodeType).putArgument("disallowed", AbstractKeywordValidator.toArrayNode(this.types)));
            return;
        }
        SchemaTree schemaTree = fullData.getSchema();
        JsonPointer jsonPointer = schemaTree.getPointer();
        JsonNodeFactory jsonNodeFactory = DraftV3TypeKeywordValidator.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        Iterator iterator = this.schemas.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            ListProcessingReport listProcessingReport = new ListProcessingReport(processingReport.getLogLevel(), LogLevel.FATAL);
            String string = this.keyword;
            Object[] arrobject = new Object[]{n3};
            JsonPointer jsonPointer2 = jsonPointer.append(JsonPointer.of(string, arrobject));
            processor.process(listProcessingReport, fullData.withSchema(schemaTree.setPointer(jsonPointer2)));
            objectNode.set(jsonPointer2.toString(), listProcessingReport.asJson());
            if (!listProcessingReport.isSuccess()) continue;
            ++n2;
        }
        if (n2 != 0) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.draftv3.disallow.schema").putArgument("matched", n2).putArgument("nrSchemas", this.schemas.size()).put("reports", (JsonNode)objectNode));
        }
    }
}

