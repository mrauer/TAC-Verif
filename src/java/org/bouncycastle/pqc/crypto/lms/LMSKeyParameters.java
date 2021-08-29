/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Encodable;

public abstract class LMSKeyParameters
extends AsymmetricKeyParameter
implements Encodable {
    public LMSKeyParameters(boolean bl) {
        super(bl);
    }

    @Override
    public abstract byte[] getEncoded() throws IOException;
}

