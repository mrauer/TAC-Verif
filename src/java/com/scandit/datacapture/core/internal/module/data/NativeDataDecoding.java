/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.data;

import com.scandit.datacapture.core.common.buffer.EncodingRange;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeDataDecoding {
    public abstract String decode(byte[] var1, ArrayList<EncodingRange> var2);
}

