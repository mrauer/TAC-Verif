/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package dgca.verifier.app.decoder.cose;

public final class VerificationCryptoService$Algo
extends Enum<VerificationCryptoService$Algo> {
    private static final /* synthetic */ VerificationCryptoService$Algo[] $VALUES;
    public static final /* enum */ VerificationCryptoService$Algo ALGO_ECDSA256;
    public static final /* enum */ VerificationCryptoService$Algo ALGO_RSA256_PSS;
    private final String value;

    public static {
        VerificationCryptoService$Algo verificationCryptoService$Algo;
        VerificationCryptoService$Algo verificationCryptoService$Algo2;
        ALGO_ECDSA256 = verificationCryptoService$Algo = new VerificationCryptoService$Algo("SHA256withECDSA");
        ALGO_RSA256_PSS = verificationCryptoService$Algo2 = new VerificationCryptoService$Algo("SHA256withRSA/PSS");
        $VALUES = new VerificationCryptoService$Algo[]{verificationCryptoService$Algo, verificationCryptoService$Algo2};
    }

    public VerificationCryptoService$Algo(String string2) {
        this.value = string2;
    }

    public static VerificationCryptoService$Algo valueOf(String string) {
        return (VerificationCryptoService$Algo)Enum.valueOf(VerificationCryptoService$Algo.class, (String)string);
    }

    public static VerificationCryptoService$Algo[] values() {
        return (VerificationCryptoService$Algo[])$VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}

