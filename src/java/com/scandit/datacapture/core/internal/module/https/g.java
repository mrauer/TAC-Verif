/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Headers
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 */
package com.scandit.datacapture.core.internal.module.https;

import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsError;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsRequest;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsResponse;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSession;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionDelegate;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsTask;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsTaskState;
import com.scandit.datacapture.core.internal.module.https.e;
import com.scandit.datacapture.core.internal.module.https.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class g
extends NativeHttpsTask
implements Callback {
    public NativeHttpsResponse b;
    public Throwable c;
    public NativeHttpsTaskState d;
    public final e e;
    public final NativeHttpsRequest f;
    public final Call g;
    public final int h;

    public g(e e2, NativeHttpsRequest nativeHttpsRequest, Call call, int n2, byte by) {
        this.e = e2;
        this.f = nativeHttpsRequest;
        this.g = call;
        this.h = n2;
        this.d = NativeHttpsTaskState.ACTIVE;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void cancel() {
        g g2 = this;
        synchronized (g2) {
            NativeHttpsTaskState nativeHttpsTaskState = this.d;
            NativeHttpsTaskState nativeHttpsTaskState2 = NativeHttpsTaskState.COMPLETED;
            if (nativeHttpsTaskState == nativeHttpsTaskState2) {
                return;
            }
            this.d = NativeHttpsTaskState.CANCELLED;
        }
        this.g.cancel();
    }

    @Override
    public final NativeHttpsError getError() {
        g g2 = this;
        synchronized (g2) {
            if (this.c != null) {
                NativeHttpsError nativeHttpsError = new NativeHttpsError();
                return nativeHttpsError;
            }
            return null;
        }
    }

    @Override
    public final int getId() {
        return this.h;
    }

    @Override
    public final float getProgress() {
        NativeHttpsTaskState nativeHttpsTaskState = this.d;
        if (h.a[nativeHttpsTaskState.ordinal()] != 1) {
            return 0.0f;
        }
        return 1.0f;
    }

    @Override
    public final NativeHttpsRequest getRequest() {
        return this.f;
    }

    @Override
    public final NativeHttpsResponse getResponse() {
        g g2 = this;
        synchronized (g2) {
            NativeHttpsResponse nativeHttpsResponse = this.b;
            return nativeHttpsResponse;
        }
    }

    @Override
    public final NativeHttpsTaskState getState() {
        g g2 = this;
        synchronized (g2) {
            NativeHttpsTaskState nativeHttpsTaskState = this.d;
            return nativeHttpsTaskState;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"e");
        g g2 = this;
        synchronized (g2) {
            NativeHttpsTaskState nativeHttpsTaskState = this.d;
            NativeHttpsTaskState nativeHttpsTaskState2 = NativeHttpsTaskState.CANCELLED;
            if (nativeHttpsTaskState == nativeHttpsTaskState2) {
                return;
            }
            this.c = iOException;
            this.d = NativeHttpsTaskState.COMPLETED;
        }
        e e2 = this.e;
        NativeHttpsSessionDelegate nativeHttpsSessionDelegate = e2.c;
        if (nativeHttpsSessionDelegate != null) {
            nativeHttpsSessionDelegate.didComplete(e2, this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        g g2 = this;
        synchronized (g2) {
            NativeHttpsTaskState nativeHttpsTaskState = this.d;
            NativeHttpsTaskState nativeHttpsTaskState2 = NativeHttpsTaskState.CANCELLED;
            if (nativeHttpsTaskState == nativeHttpsTaskState2) {
                return;
            }
            TreeMap treeMap = (TreeMap)response.headers.toMultimap();
            LinkedHashMap linkedHashMap = new LinkedHashMap(R.style.mapCapacity((int)treeMap.size()));
            for (Object object : treeMap.entrySet()) {
                linkedHashMap.put(((Map.Entry)object).getKey(), (Object)ArraysKt___ArraysJvmKt.joinToString$default((Iterable)((Iterable)((Map.Entry)object).getValue()), (CharSequence)", ", null, null, (int)0, null, null, (int)62));
            }
            int n2 = response.code;
            HashMap hashMap = new HashMap((Map)linkedHashMap);
            ResponseBody responseBody = response.body;
            byte[] arrby = responseBody != null ? responseBody.bytes() : null;
            this.b = new NativeHttpsResponse(n2, (HashMap<String, String>)hashMap, arrby);
            this.d = NativeHttpsTaskState.COMPLETED;
        }
        e e2 = this.e;
        NativeHttpsSessionDelegate nativeHttpsSessionDelegate = e2.c;
        if (nativeHttpsSessionDelegate != null) {
            nativeHttpsSessionDelegate.didComplete(e2, this);
        }
    }

    @Override
    public final void start() {
        throw new UnsupportedOperationException();
    }
}

