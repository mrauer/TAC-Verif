/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.TreeNode
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jackson.jsonpointer;

import com.fasterxml.jackson.core.TreeNode;
import com.github.fge.jackson.jsonpointer.ReferenceToken;

public abstract class TokenResolver<T extends TreeNode> {
    public final ReferenceToken token;

    public TokenResolver(ReferenceToken referenceToken) {
        this.token = referenceToken;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof TokenResolver)) {
            return false;
        }
        TokenResolver tokenResolver = (TokenResolver)object;
        return this.token.equals(tokenResolver.token);
    }

    public abstract T get(T var1);

    public final int hashCode() {
        return this.token.hashCode();
    }

    public final String toString() {
        return this.token.cooked;
    }
}

