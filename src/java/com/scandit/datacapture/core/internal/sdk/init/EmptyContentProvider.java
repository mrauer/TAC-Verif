/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.init;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

public abstract class EmptyContentProvider
extends ContentProvider {
    public int delete(Uri uri, String string, String[] arrstring) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return 0;
    }

    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return null;
    }

    public Cursor query(Uri uri, String[] arrstring, String string, String[] arrstring2, String string2) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] arrstring) {
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        return 0;
    }
}

