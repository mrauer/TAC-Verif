/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.KeyPair
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.security.KeyPair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007\u00a8\u0006\u001a"}, d2={"Ldgca/verifier/app/decoder/model/KeyPairData;", "", "", "component1", "()Ljava/lang/String;", "Ljava/security/KeyPair;", "component2", "()Ljava/security/KeyPair;", "algo", "keyPair", "copy", "(Ljava/lang/String;Ljava/security/KeyPair;)Ldgca/verifier/app/decoder/model/KeyPairData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAlgo", "Ljava/security/KeyPair;", "getKeyPair", "<init>", "(Ljava/lang/String;Ljava/security/KeyPair;)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class KeyPairData {
    private final String algo;
    private final KeyPair keyPair;

    public KeyPairData(String string, KeyPair keyPair) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"algo");
        Intrinsics.checkNotNullParameter((Object)keyPair, (String)"keyPair");
        this.algo = string;
        this.keyPair = keyPair;
    }

    public static /* synthetic */ KeyPairData copy$default(KeyPairData keyPairData, String string, KeyPair keyPair, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = keyPairData.algo;
        }
        if ((n2 & 2) != 0) {
            keyPair = keyPairData.keyPair;
        }
        return keyPairData.copy(string, keyPair);
    }

    public final String component1() {
        return this.algo;
    }

    public final KeyPair component2() {
        return this.keyPair;
    }

    public final KeyPairData copy(String string, KeyPair keyPair) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"algo");
        Intrinsics.checkNotNullParameter((Object)keyPair, (String)"keyPair");
        return new KeyPairData(string, keyPair);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof KeyPairData)) {
            return false;
        }
        KeyPairData keyPairData = (KeyPairData)object;
        if (!Intrinsics.areEqual((Object)this.algo, (Object)keyPairData.algo)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.keyPair, (Object)keyPairData.keyPair);
    }

    public final String getAlgo() {
        return this.algo;
    }

    public final KeyPair getKeyPair() {
        return this.keyPair;
    }

    public int hashCode() {
        return 31 * this.algo.hashCode() + this.keyPair.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"KeyPairData(algo=");
        stringBuilder.append(this.algo);
        stringBuilder.append(", keyPair=");
        stringBuilder.append((Object)this.keyPair);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

