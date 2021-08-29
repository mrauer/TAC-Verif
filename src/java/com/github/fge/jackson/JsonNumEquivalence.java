/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.base.Equivalence
 *  java.lang.Object
 */
package com.github.fge.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonNumEquals;
import com.google.common.base.Equivalence;

public final class JsonNumEquivalence
extends Equivalence<JsonNode> {
    public static final Equivalence<JsonNode> INSTANCE = new JsonNumEquivalence();

    public boolean doEquivalent(Object object, Object object2) {
        return JsonNumEquals.equivalent((JsonNode)object, (JsonNode)object2);
    }

    public int doHash(Object object) {
        return JsonNumEquals.hash((JsonNode)object);
    }
}

