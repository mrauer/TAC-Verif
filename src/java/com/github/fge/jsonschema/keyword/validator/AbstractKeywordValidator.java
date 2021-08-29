/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.keyword.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonschema.core.exceptions.ExceptionProvider;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.exceptions.InvalidInstanceException;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractKeywordValidator
implements KeywordValidator {
    private static final ExceptionProvider EXCEPTION_PROVIDER = new ExceptionProvider(){

        @Override
        public ProcessingException doException(ProcessingMessage processingMessage) {
            return new InvalidInstanceException(processingMessage);
        }
    };
    public final String keyword;

    public AbstractKeywordValidator(String string) {
        this.keyword = string;
    }

    public static <T> JsonNode toArrayNode(Collection<T> collection) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            arrayNode.add(iterator.next().toString());
        }
        return arrayNode;
    }

    public final ProcessingMessage newMsg(FullData fullData) {
        return fullData.newMessage().put("domain", "validation").put("keyword", this.keyword).setExceptionProvider(EXCEPTION_PROVIDER);
    }

    public final ProcessingMessage newMsg(FullData fullData, MessageBundle messageBundle, String string) {
        return fullData.newMessage().put("domain", "validation").put("keyword", this.keyword).setMessage(messageBundle.getMessage(string)).setExceptionProvider(EXCEPTION_PROVIDER);
    }

    public abstract String toString();

}

