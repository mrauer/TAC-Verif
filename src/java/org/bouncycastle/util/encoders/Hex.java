/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayOutputStream
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package org.bouncycastle.util.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
import org.bouncycastle.util.encoders.DecoderException;
import org.bouncycastle.util.encoders.EncoderException;
import org.bouncycastle.util.encoders.HexEncoder;

public class Hex {
    public static final HexEncoder encoder = new HexEncoder();

    public static byte[] decodeStrict(String string) {
        try {
            byte[] arrby = encoder.decodeStrict(string, 0, string.length());
            return arrby;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"exception decoding Hex string: ");
            stringBuilder.append(exception.getMessage());
            throw new DecoderException(stringBuilder.toString(), exception);
        }
    }

    public static byte[] encode(byte[] arrby, int n2, int n3) {
        HexEncoder hexEncoder;
        byte[] arrby2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            hexEncoder = encoder;
            Objects.requireNonNull((Object)hexEncoder);
            arrby2 = new byte[72];
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"exception encoding Hex string: ");
            stringBuilder.append(exception.getMessage());
            throw new EncoderException(stringBuilder.toString(), exception);
        }
        while (n3 > 0) {
            int n4 = Math.min((int)36, (int)n3);
            int n5 = n4 + n2;
            int n6 = 0;
            while (n2 < n5) {
                int n7 = n2 + 1;
                int n8 = 255 & arrby[n2];
                int n9 = n6 + 1;
                byte[] arrby3 = hexEncoder.encodingTable;
                arrby2[n6] = arrby3[n8 >>> 4];
                n6 = n9 + 1;
                arrby2[n9] = arrby3[n8 & 15];
                n2 = n7;
            }
            byteArrayOutputStream.write(arrby2, 0, n6 + 0);
            n3 -= n4;
            n2 = n5;
        }
        return byteArrayOutputStream.toByteArray();
    }
}

