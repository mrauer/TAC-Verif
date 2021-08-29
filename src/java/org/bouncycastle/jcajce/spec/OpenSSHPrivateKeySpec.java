/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.security.spec.EncodedKeySpec
 */
package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

public class OpenSSHPrivateKeySpec
extends EncodedKeySpec {
    public final String format;

    /*
     * Enabled aggressive block sorting
     */
    public OpenSSHPrivateKeySpec(byte[] arrby) {
        String string;
        super(arrby);
        if (arrby[0] == 48) {
            string = "ASN.1";
        } else {
            if (arrby[0] != 111) {
                throw new IllegalArgumentException("unknown byte encoding");
            }
            string = "OpenSSH";
        }
        this.format = string;
    }

    public String getFormat() {
        return this.format;
    }
}

