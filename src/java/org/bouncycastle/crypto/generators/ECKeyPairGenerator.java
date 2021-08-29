/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.SecureRandom
 */
package org.bouncycastle.crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECConstants;

public class ECKeyPairGenerator
implements ECConstants {
    public ECDomainParameters params;
    public SecureRandom random;
}

