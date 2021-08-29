/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.bouncycastle.asn1.ASN1OctetStringParser
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1StreamParser;

public class ConstructedOctetStream
extends InputStream {
    public InputStream _currentStream;
    public boolean _first = true;
    public final ASN1StreamParser _parser;

    public ConstructedOctetStream(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public final ASN1OctetStringParser getNextParser() throws IOException {
        ASN1Encodable aSN1Encodable = this._parser.readObject();
        if (aSN1Encodable == null) {
            return null;
        }
        if (aSN1Encodable instanceof ASN1OctetStringParser) {
            return (ASN1OctetStringParser)aSN1Encodable;
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object encountered: ");
        stringBuilder.append((Object)aSN1Encodable.getClass());
        throw new IOException(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int read() throws IOException {
        block5 : {
            if (this._currentStream != null) break block5;
            if (!this._first) {
                return -1;
            }
            var2_1 = this.getNextParser();
            if (var2_1 == null) {
                return -1;
            }
            this._first = false;
            ** GOTO lbl17
        }
        do {
            if ((var1_2 = this._currentStream.read()) >= 0) {
                return var1_2;
            }
            var2_1 = this.getNextParser();
            if (var2_1 == null) {
                this._currentStream = null;
                return -1;
            }
lbl17: // 3 sources:
            this._currentStream = var2_1.getOctetStream();
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int read(byte[] var1_1, int var2_2, int var3_3) throws IOException {
        var4_4 = this._currentStream;
        var5_5 = 0;
        if (var4_4 != null) ** GOTO lbl12
        if (!this._first) {
            return -1;
        }
        var7_6 = this.getNextParser();
        if (var7_6 == null) {
            return -1;
        }
        this._first = false;
        do {
            this._currentStream = var7_6.getOctetStream();
lbl12: // 3 sources:
            while ((var6_7 = this._currentStream.read(var1_1, var2_2 + var5_5, var3_3 - var5_5)) >= 0) {
                if ((var5_5 += var6_7) != var3_3) continue;
                return var5_5;
            }
        } while ((var7_6 = this.getNextParser()) != null);
        this._currentStream = null;
        if (var5_5 >= 1) return var5_5;
        return -1;
    }
}

