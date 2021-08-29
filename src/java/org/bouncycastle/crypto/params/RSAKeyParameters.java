/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Properties;

public class RSAKeyParameters
extends AsymmetricKeyParameter {
    public static final BigInteger ONE;
    public static final BigInteger SMALL_PRIMES_PRODUCT;
    public BigInteger exponent;
    public BigInteger modulus;

    public static {
        SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        ONE = BigInteger.valueOf((long)1L);
    }

    public RSAKeyParameters(boolean bl, BigInteger bigInteger, BigInteger bigInteger2) {
        super(bl);
        if (!bl && (1 & bigInteger2.intValue()) == 0) {
            throw new IllegalArgumentException("RSA publicExponent is even");
        }
        if ((1 & bigInteger.intValue()) != 0) {
            if (Properties.isOverrideSet("org.bouncycastle.rsa.allow_unsafe_mod") || bigInteger.gcd(SMALL_PRIMES_PRODUCT).equals((Object)ONE)) {
                this.modulus = bigInteger;
                this.exponent = bigInteger2;
                return;
            }
            throw new IllegalArgumentException("RSA modulus has a small prime factor");
        }
        throw new IllegalArgumentException("RSA modulus is even");
    }
}

