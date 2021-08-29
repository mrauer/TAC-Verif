/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonNull
 *  com.google.gson.JsonPrimitive
 *  com.google.gson.JsonSyntaxException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package com.auth0.android.jwt;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.auth0.android.jwt.BaseClaim;
import com.auth0.android.jwt.DecodeException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.util.Objects;

public class ClaimImpl
extends BaseClaim {
    public final JsonElement value;

    public ClaimImpl(JsonElement jsonElement) {
        this.value = jsonElement;
    }

    @Override
    public <T> T asObject(Class<T> class_) throws DecodeException {
        block3 : {
            try {
                JsonElement jsonElement = this.value;
                Objects.requireNonNull((Object)jsonElement);
                if (!(jsonElement instanceof JsonNull)) break block3;
            }
            catch (JsonSyntaxException jsonSyntaxException) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Failed to decode claim as ");
                stringBuilder.append(class_.getSimpleName());
                throw new DecodeException(stringBuilder.toString(), jsonSyntaxException);
            }
            return null;
        }
        Object object = new Gson().fromJson(this.value, class_);
        return (T)object;
    }

    @Override
    public String asString() {
        JsonElement jsonElement = this.value;
        Objects.requireNonNull((Object)jsonElement);
        if (!(jsonElement instanceof JsonPrimitive)) {
            return null;
        }
        return this.value.getAsString();
    }
}

