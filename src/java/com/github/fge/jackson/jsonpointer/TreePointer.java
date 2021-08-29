/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.TreeNode
 *  com.fasterxml.jackson.databind.annotation.JsonSerialize
 *  com.github.fge.jackson.jsonpointer.JsonPointerMessages
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  j
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jackson.jsonpointer;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.fge.jackson.jsonpointer.JsonPointerMessages;
import com.github.fge.jackson.jsonpointer.TokenResolver;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import j$.lang.Iterable$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@JsonSerialize(using="Lcom/fasterxml/jackson/databind/ser/std/ToStringSerializer;")
public abstract class TreePointer<T extends TreeNode>
implements Iterable<TokenResolver<T>>,
j$.lang.Iterable {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonPointerMessages.class);
    public final T missing;
    public final List<TokenResolver<T>> tokenResolvers;

    public TreePointer(T t3, List<TokenResolver<T>> list) {
        this.missing = t3;
        this.tokenResolvers = Collections.unmodifiableList((List)new ArrayList(list));
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof TreePointer)) {
            return false;
        }
        TreePointer treePointer = (TreePointer)object;
        return this.tokenResolvers.equals(treePointer.tokenResolvers);
    }

    @Override
    public /* synthetic */ void forEach(j.Consumer consumer) {
        Iterable$-CC.$default$forEach(this, consumer);
    }

    public final int hashCode() {
        return this.tokenResolvers.hashCode();
    }

    public final Iterator<TokenResolver<T>> iterator() {
        return this.tokenResolvers.iterator();
    }

    public final T path(T t3) {
        for (TokenResolver tokenResolver : this.tokenResolvers) {
            if (t3 == null) break;
            t3 = tokenResolver.get(t3);
        }
        if (t3 == null) {
            t3 = this.missing;
        }
        return t3;
    }

    @Override
    public /* synthetic */ j.Spliterator spliterator() {
        return Iterable$-CC.$default$spliterator(this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TokenResolver tokenResolver : this.tokenResolvers) {
            stringBuilder.append('/');
            stringBuilder.append((Object)tokenResolver);
        }
        return stringBuilder.toString();
    }
}

