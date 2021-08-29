/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.upokecenter.cbor;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public final class StringOutput {
    public final StringBuilder builder;

    public StringOutput(StringBuilder stringBuilder) {
        this.builder = stringBuilder;
    }

    public void WriteCodePoint(int n2) throws IOException {
        if (n2 >= 0) {
            if (n2 <= 1114111) {
                if ((16775168 & n2) != 55296) {
                    if (n2 <= 65535) {
                        this.builder.append((char)n2);
                        return;
                    }
                    if (n2 <= 1114111) {
                        StringBuilder stringBuilder = this.builder;
                        int n3 = n2 - 65536;
                        stringBuilder.append((char)(55296 | 1023 & n3 >> 10));
                        this.builder.append((char)(56320 | n3 & 1023));
                    }
                    return;
                }
                throw new IllegalArgumentException("ch is a surrogate");
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline13((String)"codePoint (", (int)n2, (String)") is more than ", (int)1114111));
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"codePoint (", (int)n2, (String)") is less than 0"));
    }
}

