/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.processors.data;

import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.google.common.collect.ImmutableList;
import j$.lang.Iterable$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ValidatorList
implements Iterable<KeywordValidator>,
MessageProvider,
j$.lang.Iterable {
    private final SchemaContext context;
    private final List<KeywordValidator> validators;

    public ValidatorList(SchemaContext schemaContext, Collection<KeywordValidator> collection) {
        this.context = schemaContext;
        this.validators = ImmutableList.copyOf(collection);
    }

    @Override
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable$-CC.$default$forEach(this, consumer);
    }

    public SchemaContext getContext() {
        return this.context;
    }

    public Iterator<KeywordValidator> iterator() {
        return this.validators.iterator();
    }

    @Override
    public ProcessingMessage newMessage() {
        return this.context.newMessage();
    }

    @Override
    public /* synthetic */ Spliterator spliterator() {
        return Iterable$-CC.$default$spliterator(this);
    }
}

