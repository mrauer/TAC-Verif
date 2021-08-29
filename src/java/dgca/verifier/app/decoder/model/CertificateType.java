/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 */
package dgca.verifier.app.decoder.model;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Ldgca/verifier/app/decoder/model/CertificateType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "VACCINATION", "RECOVERY", "TEST", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class CertificateType
extends Enum<CertificateType> {
    private static final /* synthetic */ CertificateType[] $VALUES;
    public static final /* enum */ CertificateType RECOVERY;
    public static final /* enum */ CertificateType TEST;
    public static final /* enum */ CertificateType UNKNOWN;
    public static final /* enum */ CertificateType VACCINATION;

    public static {
        UNKNOWN = new CertificateType();
        VACCINATION = new CertificateType();
        RECOVERY = new CertificateType();
        TEST = new CertificateType();
        $VALUES = arrcertificateType = new CertificateType[]{CertificateType.UNKNOWN, CertificateType.VACCINATION, CertificateType.RECOVERY, CertificateType.TEST};
    }

    public static CertificateType valueOf(String string) {
        return (CertificateType)Enum.valueOf(CertificateType.class, (String)string);
    }

    public static CertificateType[] values() {
        return (CertificateType[])$VALUES.clone();
    }
}

