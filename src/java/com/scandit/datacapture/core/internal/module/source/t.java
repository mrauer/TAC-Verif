/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  java.lang.Enum
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;

@TargetApi(value=21)
public final class t {
    public int f;
    public float g;
    public float h;
    public int i = a.a;
    public int j;
    public boolean k;

    public static final class a
    extends Enum<a> {
        public static final int a;
        public static final int b;
        public static final int c;
        private static final /* synthetic */ int[] d;

        public static {
            int[] arrn = new int[]{1, 2, 3};
            a = 1;
            b = 2;
            c = 3;
            d = arrn;
        }

        public static int[] a() {
            return (int[])d.clone();
        }
    }

}

