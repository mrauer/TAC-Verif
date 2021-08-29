/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Date
 *  java.util.List
 *  java.util.Map
 */
package com.auth0.android.jwt;

import com.auth0.android.jwt.Claim;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JWTPayload {
    public final List<String> aud;
    public final Date exp;
    public final Date iat;
    public final Map<String, Claim> tree;

    public JWTPayload(String string, String string2, Date date, Date date2, Date date3, String string3, List<String> list, Map<String, Claim> map) {
        this.exp = date;
        this.iat = date3;
        this.aud = list;
        this.tree = Collections.unmodifiableMap(map);
    }
}

