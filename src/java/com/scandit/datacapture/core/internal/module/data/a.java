/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CoderResult
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.data;

import com.scandit.datacapture.core.common.buffer.EncodingRange;
import com.scandit.datacapture.core.internal.module.data.NativeDataDecoding;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class a
extends NativeDataDecoding {
    @Override
    public final String decode(byte[] arrby, ArrayList<EncodingRange> arrayList) {
        Intrinsics.checkNotNullParameter((Object)arrby, (String)"rawData");
        Intrinsics.checkNotNullParameter(arrayList, (String)"dataEncoding");
        boolean bl = arrby.length == 0;
        boolean bl2 = bl || true ^ arrayList.isEmpty();
        if (bl2) {
            CharBuffer charBuffer = CharBuffer.allocate((int)(4 * arrby.length));
            for (EncodingRange encodingRange : arrayList) {
                ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby, (int)encodingRange.getStartIndex(), (int)(encodingRange.getEndIndex() - encodingRange.getStartIndex()));
                try {
                    Charset.forName((String)encodingRange.getIanaName()).newDecoder().decode(byteBuffer, charBuffer, true);
                }
                catch (Exception exception) {
                    return null;
                }
            }
            char[] arrc = charBuffer.array();
            Intrinsics.checkNotNullExpressionValue((Object)arrc, (String)"outBuffer.array()");
            return new String(arrc, 0, charBuffer.position());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

