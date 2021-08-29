/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Base64
 *  com.auth0.android.jwt.BaseClaim
 *  com.auth0.android.jwt.JWT$2
 *  com.auth0.android.jwt.JWTDeserializer
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.gson.FieldNamingPolicy
 *  com.google.gson.FieldNamingStrategy
 *  com.google.gson.Gson
 *  com.google.gson.InstanceCreator
 *  com.google.gson.JsonSerializer
 *  com.google.gson.LongSerializationPolicy
 *  com.google.gson.TypeAdapter
 *  com.google.gson.internal.Excluder
 *  com.google.gson.internal.bind.TreeTypeAdapter
 *  com.google.gson.internal.bind.TreeTypeAdapter$SingleTypeFactory
 *  com.google.gson.internal.bind.TypeAdapters
 *  com.google.gson.internal.bind.TypeAdapters$31
 *  com.google.gson.reflect.TypeToken
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.auth0.android.jwt;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.auth0.android.jwt.BaseClaim;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.DecodeException;
import com.auth0.android.jwt.JWT;
import com.auth0.android.jwt.JWTDeserializer;
import com.auth0.android.jwt.JWTPayload;
import com.google.android.material.R;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JWT
implements Parcelable {
    public static final Parcelable.Creator<JWT> CREATOR = new Parcelable.Creator<JWT>(){

        public Object createFromParcel(Parcel parcel) {
            return new JWT(parcel.readString());
        }

        public Object[] newArray(int n3) {
            return new JWT[n3];
        }
    };
    public Map<String, String> header;
    public JWTPayload payload;
    public final String token;

    public JWT(String string) {
        String[] arrstring = string.split("\\.");
        if (arrstring.length == 2 && string.endsWith(".")) {
            String[] arrstring2 = new String[]{arrstring[0], arrstring[1], ""};
            arrstring = arrstring2;
        }
        if (arrstring.length == 3) {
            Object object;
            Object object2;
            Type type = new 2((JWT)this).type;
            String string2 = this.base64Decode(arrstring[0]);
            try {
                object2 = JWT.getGson().fromJson(string2, type);
            }
            catch (Exception exception) {
                throw new DecodeException("The token's payload had an invalid JSON format.", exception);
            }
            this.header = (Map)object2;
            String string3 = this.base64Decode(arrstring[1]);
            try {
                object = JWT.getGson().fromJson(string3, JWTPayload.class);
            }
            catch (Exception exception) {
                throw new DecodeException("The token's payload had an invalid JSON format.", exception);
            }
            this.payload = (JWTPayload)object;
            arrstring[2];
            this.token = string;
            return;
        }
        Object[] arrobject = new Object[]{arrstring.length};
        throw new DecodeException(String.format((String)"The token was expected to have 3 parts, but got %s.", (Object[])arrobject));
    }

    public static Gson getGson() {
        Excluder excluder = Excluder.DEFAULT;
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JWTDeserializer jWTDeserializer = new JWTDeserializer();
        jWTDeserializer instanceof JsonSerializer;
        boolean bl = true;
        R.style.checkArgument1((boolean)bl);
        if (jWTDeserializer instanceof InstanceCreator) {
            hashMap.put(JWTPayload.class, (Object)((InstanceCreator)jWTDeserializer));
        }
        TypeToken typeToken = new TypeToken(JWTPayload.class);
        if (typeToken.type != typeToken.rawType) {
            bl = false;
        }
        arrayList.add((Object)new TreeTypeAdapter.SingleTypeFactory((Object)jWTDeserializer, typeToken, bl, null));
        if (jWTDeserializer instanceof TypeAdapter) {
            TypeToken typeToken2 = new TypeToken(JWTPayload.class);
            TypeAdapter typeAdapter = (TypeAdapter)jWTDeserializer;
            arrayList.add((Object)new TypeAdapters.31(typeToken2, typeAdapter));
        }
        ArrayList arrayList3 = new ArrayList(3 + (arrayList.size() + arrayList2.size()));
        arrayList3.addAll((Collection)arrayList);
        Collections.reverse((List)arrayList3);
        ArrayList arrayList4 = new ArrayList((Collection)arrayList2);
        Collections.reverse((List)arrayList4);
        arrayList3.addAll((Collection)arrayList4);
        Gson gson = new Gson(excluder, (FieldNamingStrategy)fieldNamingPolicy, (Map)hashMap, false, false, false, true, false, false, false, longSerializationPolicy, null, 2, 2, (List)arrayList, (List)arrayList2, (List)arrayList3);
        return gson;
    }

    public final String base64Decode(String string) {
        try {
            String string2 = new String(Base64.decode((String)string, (int)11), Charset.defaultCharset());
            return string2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new DecodeException("Received bytes didn't correspond to a valid Base64 encoded string.", illegalArgumentException);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Claim getClaim(String string) {
        Claim claim = (Claim)this.payload.tree.get((Object)string);
        if (claim != null) {
            return claim;
        }
        return new BaseClaim();
    }

    public boolean isExpired(long l3) {
        block3 : {
            boolean bl;
            block5 : {
                block4 : {
                    if (l3 < 0L) break block3;
                    long l4 = (long)(1000.0 * Math.floor((double)(new Date().getTime() / 1000L)));
                    long l5 = l3 * 1000L;
                    Date date = new Date(l4 + l5);
                    Date date2 = new Date(l4 - l5);
                    Date date3 = this.payload.exp;
                    boolean bl2 = date3 == null || !date2.after(date3);
                    Date date4 = this.payload.iat;
                    boolean bl3 = date4 == null || !date.before(date4);
                    if (!bl2) break block4;
                    bl = false;
                    if (bl3) break block5;
                }
                bl = true;
            }
            return bl;
        }
        throw new IllegalArgumentException("The leeway must be a positive value.");
    }

    public String toString() {
        return this.token;
    }

    public void writeToParcel(Parcel parcel, int n3) {
        parcel.writeString(this.token);
    }

}

