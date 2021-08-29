/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.spec.EncodedKeySpec
 */
package org.bouncycastle.jcajce.spec;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.security.spec.EncodedKeySpec;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Strings;

public class OpenSSHPublicKeySpec
extends EncodedKeySpec {
    public static final String[] allowedTypes = new String[]{"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    public final String type;

    public OpenSSHPublicKeySpec(byte[] arrby) {
        super(arrby);
        int n2 = 4 + ((255 & arrby[0]) << 24 | (255 & arrby[1]) << 16 | (255 & arrby[2]) << 8 | 255 & arrby[3]);
        if (n2 < arrby.length) {
            String string;
            String[] arrstring;
            this.type = string = Strings.fromByteArray(Nat576.copyOfRange(arrby, 4, n2));
            boolean bl = string.startsWith("ecdsa");
            if (bl) {
                return;
            }
            for (int i2 = 0; i2 < (arrstring = allowedTypes).length; ++i2) {
                if (!arrstring[i2].equals((Object)this.type)) continue;
                return;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unrecognised public key type ");
            stringBuilder.append(this.type);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
    }

    public String getFormat() {
        return "OpenSSH";
    }
}

