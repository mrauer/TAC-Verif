/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.a.a.d$aa
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.scandit.datacapture.tools.internal.a.a;

import com.scandit.datacapture.tools.internal.a.a.d;
import j$.util.Map$Entry;
import java.util.Map;

public abstract class a<K, V>
implements Map.Entry<K, V>,
Map$Entry {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        d.aa aa2 = this;
        stringBuilder.append(aa2.a);
        stringBuilder.append("=");
        stringBuilder.append(aa2.b);
        return stringBuilder.toString();
    }
}

