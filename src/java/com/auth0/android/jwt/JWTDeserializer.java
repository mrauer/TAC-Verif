/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.auth0.android.jwt.ClaimImpl
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonNull
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParseException
 *  com.google.gson.internal.LinkedTreeMap
 *  com.google.gson.internal.LinkedTreeMap$EntrySet
 *  com.google.gson.internal.LinkedTreeMap$Node
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.ConcurrentModificationException
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.NoSuchElementException
 *  java.util.Objects
 *  java.util.Set
 */
package com.auth0.android.jwt;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.ClaimImpl;
import com.auth0.android.jwt.DecodeException;
import com.auth0.android.jwt.JWTPayload;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class JWTDeserializer
implements JsonDeserializer<JWTPayload> {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public JWTPayload deserialize(JsonElement var1_1) throws JsonParseException {
        Objects.requireNonNull((Object)var1_1);
        if (var1_1 instanceof JsonNull != false) throw new DecodeException("The token's payload had an invalid JSON format.");
        if (var1_1 instanceof JsonObject == false) throw new DecodeException("The token's payload had an invalid JSON format.");
        var3_2 = var1_1.getAsJsonObject();
        var4_3 = this.getString(var3_2, "iss");
        var5_4 = this.getString(var3_2, "sub");
        var6_5 = this.getDate(var3_2, "exp");
        var7_6 = this.getDate(var3_2, "nbf");
        var8_7 = this.getDate(var3_2, "iat");
        var9_8 = this.getString(var3_2, "jti");
        var10_9 = Collections.emptyList();
        if (!var3_2.has("aud")) ** GOTO lbl23
        var21_10 = var3_2.get("aud");
        Objects.requireNonNull((Object)var21_10);
        if (!(var21_10 instanceof JsonArray)) {
            var11_13 = Collections.singletonList((Object)var21_10.getAsString());
        } else {
            var23_11 = var21_10.getAsJsonArray();
            var10_9 = new ArrayList(var23_11.elements.size());
            for (var24_12 = 0; var24_12 < var23_11.elements.size(); ++var24_12) {
                var10_9.add((Object)((JsonElement)var23_11.elements.get(var24_12)).getAsString());
            }
lbl23: // 2 sources:
            var11_13 = var10_9;
        }
        var12_14 = new HashMap();
        var13_15 = ((LinkedTreeMap.EntrySet)var3_2.entrySet()).this$0;
        var14_16 = var13_15.header.next;
        var15_17 = var13_15.modCount;
        do {
            if (!(var17_19 = var14_16 != (var16_18 = var13_15.header))) {
                return new JWTPayload(var4_3, var5_4, var6_5, var7_6, var8_7, var9_8, (List<String>)var11_13, (Map<String, Claim>)var12_14);
            }
            if (var14_16 == var16_18) throw new NoSuchElementException();
            if (var13_15.modCount != var15_17) throw new ConcurrentModificationException();
            var19_20 = var14_16.next;
            var12_14.put(var14_16.key, (Object)new ClaimImpl((JsonElement)var14_16.value));
            var14_16 = var19_20;
        } while (true);
    }

    public final Date getDate(JsonObject jsonObject, String string) {
        if (!jsonObject.has(string)) {
            return null;
        }
        return new Date(1000L * jsonObject.get(string).getAsLong());
    }

    public final String getString(JsonObject jsonObject, String string) {
        if (!jsonObject.has(string)) {
            return null;
        }
        return jsonObject.get(string).getAsString();
    }
}

