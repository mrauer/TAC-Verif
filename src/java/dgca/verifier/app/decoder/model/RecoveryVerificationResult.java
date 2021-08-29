/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00d6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\b\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0017"}, d2={"Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;", "", "", "isRecoveryValid", "()Z", "component1", "component2", "isNotValidSoFar", "isNotValidAnymore", "copy", "(ZZ)Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZ)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class RecoveryVerificationResult {
    private final boolean isNotValidAnymore;
    private final boolean isNotValidSoFar;

    public RecoveryVerificationResult(boolean bl, boolean bl2) {
        this.isNotValidSoFar = bl;
        this.isNotValidAnymore = bl2;
    }

    public static /* synthetic */ RecoveryVerificationResult copy$default(RecoveryVerificationResult recoveryVerificationResult, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = recoveryVerificationResult.isNotValidSoFar;
        }
        if ((n2 & 2) != 0) {
            bl2 = recoveryVerificationResult.isNotValidAnymore;
        }
        return recoveryVerificationResult.copy(bl, bl2);
    }

    public final boolean component1() {
        return this.isNotValidSoFar;
    }

    public final boolean component2() {
        return this.isNotValidAnymore;
    }

    public final RecoveryVerificationResult copy(boolean bl, boolean bl2) {
        return new RecoveryVerificationResult(bl, bl2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RecoveryVerificationResult)) {
            return false;
        }
        RecoveryVerificationResult recoveryVerificationResult = (RecoveryVerificationResult)object;
        if (this.isNotValidSoFar != recoveryVerificationResult.isNotValidSoFar) {
            return false;
        }
        return this.isNotValidAnymore == recoveryVerificationResult.isNotValidAnymore;
    }

    public int hashCode() {
        int n2 = this.isNotValidSoFar;
        int n3 = 1;
        if (n2 != 0) {
            n2 = n3;
        }
        int n4 = n2 * 31;
        boolean bl = this.isNotValidAnymore;
        if (!bl) {
            n3 = bl ? 1 : 0;
        }
        return n4 + n3;
    }

    public final boolean isNotValidAnymore() {
        return this.isNotValidAnymore;
    }

    public final boolean isNotValidSoFar() {
        return this.isNotValidSoFar;
    }

    public final boolean isRecoveryValid() {
        return !this.isNotValidSoFar && !this.isNotValidAnymore;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"RecoveryVerificationResult(isNotValidSoFar=");
        stringBuilder.append(this.isNotValidSoFar);
        stringBuilder.append(", isNotValidAnymore=");
        stringBuilder.append(this.isNotValidAnymore);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

