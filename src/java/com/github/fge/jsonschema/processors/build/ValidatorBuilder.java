/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.github.fge.jsonschema.processors.build;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.SchemaDigest;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class ValidatorBuilder
implements Processor<SchemaDigest, ValidatorList> {
    private final Map<String, KeywordValidatorFactory> factories;

    public ValidatorBuilder(Dictionary<KeywordValidatorFactory> dictionary) {
        this.factories = dictionary.entries();
    }

    public ValidatorBuilder(Library library) {
        this.factories = library.getValidators().entries();
    }

    @Override
    public ValidatorList process(ProcessingReport processingReport, SchemaDigest schemaDigest) throws ProcessingException {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : schemaDigest.getDigests().entrySet()) {
            String string = (String)entry.getKey();
            JsonNode jsonNode = (JsonNode)entry.getValue();
            treeMap.put((Object)string, (Object)((KeywordValidatorFactory)this.factories.get((Object)string)).getKeywordValidator(jsonNode));
        }
        return new ValidatorList(schemaDigest.getContext(), (Collection<KeywordValidator>)treeMap.values());
    }

    public String toString() {
        return "validator builder";
    }
}

