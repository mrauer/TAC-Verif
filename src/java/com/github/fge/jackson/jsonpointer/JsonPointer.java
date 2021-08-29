/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.CharBuffer
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.github.fge.jackson.jsonpointer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.github.fge.jackson.jsonpointer.JsonNodeResolver;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jackson.jsonpointer.ReferenceToken;
import com.github.fge.jackson.jsonpointer.TokenResolver;
import com.github.fge.jackson.jsonpointer.TreePointer;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class JsonPointer
extends TreePointer<JsonNode> {
    public static final JsonPointer EMPTY = new JsonPointer((List<TokenResolver<JsonNode>>)Collections.emptyList());

    public JsonPointer(String string) throws JsonPointerException {
        TreePointer.BUNDLE.checkNotNull(string, "nullInput");
        ArrayList arrayList = new ArrayList();
        while (!string.isEmpty()) {
            if (string.charAt(0) == '/') {
                boolean bl;
                String string2 = string.substring(1);
                int n = string2.indexOf(47);
                String string3 = n == -1 ? string2 : string2.substring(0, n);
                ReferenceToken.BUNDLE.checkNotNull(string3, "nullInput");
                StringBuilder stringBuilder = new StringBuilder(string3.length());
                CharBuffer charBuffer = CharBuffer.wrap((CharSequence)string3);
                block1 : do {
                    bl = false;
                    while (charBuffer.hasRemaining()) {
                        char c2 = charBuffer.get();
                        if (bl) {
                            int n2 = ReferenceToken.ENCODED.indexOf((Object)Character.valueOf((char)c2));
                            if (n2 != -1) {
                                stringBuilder.append(ReferenceToken.DECODED.get(n2));
                                continue block1;
                            }
                            throw new JsonPointerException(ReferenceToken.BUNDLE.getMessage("illegalEscape"));
                        }
                        if (c2 == '~') {
                            bl = true;
                            continue;
                        }
                        stringBuilder.append(c2);
                    }
                    break;
                } while (true);
                if (!bl) {
                    arrayList.add((Object)new ReferenceToken(string3, stringBuilder.toString()));
                    if (n == -1) break;
                    string = string2.substring(n);
                    continue;
                }
                throw new JsonPointerException(ReferenceToken.BUNDLE.getMessage("emptyEscape"));
            }
            throw new JsonPointerException(TreePointer.BUNDLE.getMessage("notSlash"));
        }
        List<TokenResolver<JsonNode>> list = JsonPointer.fromTokens((List<ReferenceToken>)arrayList);
        super(MissingNode.instance, list);
    }

    public JsonPointer(List<TokenResolver<JsonNode>> list) {
        super(MissingNode.instance, list);
    }

    public static List<TokenResolver<JsonNode>> fromTokens(List<ReferenceToken> list) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)new JsonNodeResolver((ReferenceToken)iterator.next()));
        }
        return arrayList;
    }

    public static /* varargs */ JsonPointer of(Object object, Object ... arrobject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)ReferenceToken.fromRaw(object.toString()));
        int n = arrobject.length;
        for (int i = 0; i < n; ++i) {
            arrayList.add((Object)ReferenceToken.fromRaw(arrobject[i].toString()));
        }
        return new JsonPointer(JsonPointer.fromTokens((List<ReferenceToken>)arrayList));
    }

    public JsonPointer append(JsonPointer jsonPointer) {
        TreePointer.BUNDLE.checkNotNull(jsonPointer, "nullInput");
        ArrayList arrayList = new ArrayList();
        for (TokenResolver tokenResolver : this.tokenResolvers) {
            Objects.requireNonNull((Object)tokenResolver);
            arrayList.add((Object)tokenResolver);
        }
        arrayList.addAll(jsonPointer.tokenResolvers);
        return new JsonPointer((List<TokenResolver<JsonNode>>)arrayList);
    }

    public JsonPointer append(String string) {
        JsonNodeResolver jsonNodeResolver = new JsonNodeResolver(ReferenceToken.fromRaw(string));
        ArrayList arrayList = new ArrayList();
        for (TokenResolver tokenResolver : this.tokenResolvers) {
            Objects.requireNonNull((Object)tokenResolver);
            arrayList.add((Object)tokenResolver);
        }
        arrayList.add((Object)jsonNodeResolver);
        return new JsonPointer((List<TokenResolver<JsonNode>>)arrayList);
    }
}

