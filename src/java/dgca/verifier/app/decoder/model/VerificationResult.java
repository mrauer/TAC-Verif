/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import dgca.verifier.app.decoder.model.RecoveryVerificationResult;
import dgca.verifier.app.decoder.model.TestVerificationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\bI\u0010JJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00c6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0084\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018H\u00c6\u0001\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(H\u00d6\u0001\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b,\u0010-R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010.\u001a\u0004\b!\u0010\u0004\"\u0004\b/\u00100R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010.\u001a\u0004\b \u0010\u0004\"\u0004\b1\u00100R$\u0010%\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u00102\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u00105R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010.\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00100R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u00100R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010.\u001a\u0004\b\"\u0010\u0004\"\u0004\b:\u00100R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u00100R$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010=\u001a\u0004\b>\u0010\u000b\"\u0004\b?\u0010@R$\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010A\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010DR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010.\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u00100R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010.\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u00100\u00a8\u0006K"}, d2={"Ldgca/verifier/app/decoder/model/VerificationResult;", "", "", "isValid", "()Z", "isTestDateInTheFuture", "isTestWithPositiveResult", "isRecoveryNotValidAnymore", "isRecoveryNotValidSoFar", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "Ldgca/verifier/app/decoder/model/TestVerificationResult;", "component10", "()Ldgca/verifier/app/decoder/model/TestVerificationResult;", "Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;", "component11", "()Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;", "base45Decoded", "contextPrefix", "zlibDecoded", "coseVerified", "cborDecoded", "isSchemaValid", "isIssuedTimeCorrect", "isNotExpired", "rulesValidationFailed", "testVerification", "recoveryVerification", "copy", "(ZLjava/lang/String;ZZZZZZZLdgca/verifier/app/decoder/model/TestVerificationResult;Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;)Ldgca/verifier/app/decoder/model/VerificationResult;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "setIssuedTimeCorrect", "(Z)V", "setSchemaValid", "Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;", "getRecoveryVerification", "setRecoveryVerification", "(Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;)V", "getBase45Decoded", "setBase45Decoded", "getCborDecoded", "setCborDecoded", "setNotExpired", "getCoseVerified", "setCoseVerified", "Ljava/lang/String;", "getContextPrefix", "setContextPrefix", "(Ljava/lang/String;)V", "Ldgca/verifier/app/decoder/model/TestVerificationResult;", "getTestVerification", "setTestVerification", "(Ldgca/verifier/app/decoder/model/TestVerificationResult;)V", "getZlibDecoded", "setZlibDecoded", "getRulesValidationFailed", "setRulesValidationFailed", "<init>", "(ZLjava/lang/String;ZZZZZZZLdgca/verifier/app/decoder/model/TestVerificationResult;Ldgca/verifier/app/decoder/model/RecoveryVerificationResult;)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class VerificationResult {
    private boolean base45Decoded;
    private boolean cborDecoded;
    private String contextPrefix;
    private boolean coseVerified;
    private boolean isIssuedTimeCorrect;
    private boolean isNotExpired;
    private boolean isSchemaValid;
    private RecoveryVerificationResult recoveryVerification;
    private boolean rulesValidationFailed;
    private TestVerificationResult testVerification;
    private boolean zlibDecoded;

    public VerificationResult() {
        this(false, null, false, false, false, false, false, false, false, null, null, 2047, null);
    }

    public VerificationResult(boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, TestVerificationResult testVerificationResult, RecoveryVerificationResult recoveryVerificationResult) {
        this.base45Decoded = bl;
        this.contextPrefix = string;
        this.zlibDecoded = bl2;
        this.coseVerified = bl3;
        this.cborDecoded = bl4;
        this.isSchemaValid = bl5;
        this.isIssuedTimeCorrect = bl6;
        this.isNotExpired = bl7;
        this.rulesValidationFailed = bl8;
        this.testVerification = testVerificationResult;
        this.recoveryVerification = recoveryVerificationResult;
    }

    public /* synthetic */ VerificationResult(boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, TestVerificationResult testVerificationResult, RecoveryVerificationResult recoveryVerificationResult, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        boolean bl9 = (n2 & 1) != 0 ? false : bl;
        String string2 = (n2 & 2) != 0 ? null : string;
        boolean bl10 = (n2 & 4) != 0 ? false : bl2;
        boolean bl11 = (n2 & 8) != 0 ? false : bl3;
        boolean bl12 = (n2 & 16) != 0 ? false : bl4;
        boolean bl13 = (n2 & 32) != 0 ? false : bl5;
        boolean bl14 = (n2 & 64) != 0 ? false : bl6;
        boolean bl15 = (n2 & 128) != 0 ? false : bl7;
        boolean bl16 = (n2 & 256) != 0 ? false : bl8;
        TestVerificationResult testVerificationResult2 = (n2 & 512) != 0 ? null : testVerificationResult;
        RecoveryVerificationResult recoveryVerificationResult2 = (n2 & 1024) != 0 ? null : recoveryVerificationResult;
        this(bl9, string2, bl10, bl11, bl12, bl13, bl14, bl15, bl16, testVerificationResult2, recoveryVerificationResult2);
    }

    public static /* synthetic */ VerificationResult copy$default(VerificationResult verificationResult, boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, TestVerificationResult testVerificationResult, RecoveryVerificationResult recoveryVerificationResult, int n2, Object object) {
        boolean bl9 = (n2 & 1) != 0 ? verificationResult.base45Decoded : bl;
        String string2 = (n2 & 2) != 0 ? verificationResult.contextPrefix : string;
        boolean bl10 = (n2 & 4) != 0 ? verificationResult.zlibDecoded : bl2;
        boolean bl11 = (n2 & 8) != 0 ? verificationResult.coseVerified : bl3;
        boolean bl12 = (n2 & 16) != 0 ? verificationResult.cborDecoded : bl4;
        boolean bl13 = (n2 & 32) != 0 ? verificationResult.isSchemaValid : bl5;
        boolean bl14 = (n2 & 64) != 0 ? verificationResult.isIssuedTimeCorrect : bl6;
        boolean bl15 = (n2 & 128) != 0 ? verificationResult.isNotExpired : bl7;
        boolean bl16 = (n2 & 256) != 0 ? verificationResult.rulesValidationFailed : bl8;
        TestVerificationResult testVerificationResult2 = (n2 & 512) != 0 ? verificationResult.testVerification : testVerificationResult;
        RecoveryVerificationResult recoveryVerificationResult2 = (n2 & 1024) != 0 ? verificationResult.recoveryVerification : recoveryVerificationResult;
        return verificationResult.copy(bl9, string2, bl10, bl11, bl12, bl13, bl14, bl15, bl16, testVerificationResult2, recoveryVerificationResult2);
    }

    public final boolean component1() {
        return this.base45Decoded;
    }

    public final TestVerificationResult component10() {
        return this.testVerification;
    }

    public final RecoveryVerificationResult component11() {
        return this.recoveryVerification;
    }

    public final String component2() {
        return this.contextPrefix;
    }

    public final boolean component3() {
        return this.zlibDecoded;
    }

    public final boolean component4() {
        return this.coseVerified;
    }

    public final boolean component5() {
        return this.cborDecoded;
    }

    public final boolean component6() {
        return this.isSchemaValid;
    }

    public final boolean component7() {
        return this.isIssuedTimeCorrect;
    }

    public final boolean component8() {
        return this.isNotExpired;
    }

    public final boolean component9() {
        return this.rulesValidationFailed;
    }

    public final VerificationResult copy(boolean bl, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, TestVerificationResult testVerificationResult, RecoveryVerificationResult recoveryVerificationResult) {
        VerificationResult verificationResult = new VerificationResult(bl, string, bl2, bl3, bl4, bl5, bl6, bl7, bl8, testVerificationResult, recoveryVerificationResult);
        return verificationResult;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof VerificationResult)) {
            return false;
        }
        VerificationResult verificationResult = (VerificationResult)object;
        if (this.base45Decoded != verificationResult.base45Decoded) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.contextPrefix, (Object)verificationResult.contextPrefix)) {
            return false;
        }
        if (this.zlibDecoded != verificationResult.zlibDecoded) {
            return false;
        }
        if (this.coseVerified != verificationResult.coseVerified) {
            return false;
        }
        if (this.cborDecoded != verificationResult.cborDecoded) {
            return false;
        }
        if (this.isSchemaValid != verificationResult.isSchemaValid) {
            return false;
        }
        if (this.isIssuedTimeCorrect != verificationResult.isIssuedTimeCorrect) {
            return false;
        }
        if (this.isNotExpired != verificationResult.isNotExpired) {
            return false;
        }
        if (this.rulesValidationFailed != verificationResult.rulesValidationFailed) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.testVerification, (Object)verificationResult.testVerification)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.recoveryVerification, (Object)verificationResult.recoveryVerification);
    }

    public final boolean getBase45Decoded() {
        return this.base45Decoded;
    }

    public final boolean getCborDecoded() {
        return this.cborDecoded;
    }

    public final String getContextPrefix() {
        return this.contextPrefix;
    }

    public final boolean getCoseVerified() {
        return this.coseVerified;
    }

    public final RecoveryVerificationResult getRecoveryVerification() {
        return this.recoveryVerification;
    }

    public final boolean getRulesValidationFailed() {
        return this.rulesValidationFailed;
    }

    public final TestVerificationResult getTestVerification() {
        return this.testVerification;
    }

    public final boolean getZlibDecoded() {
        return this.zlibDecoded;
    }

    public int hashCode() {
        int n2 = this.base45Decoded;
        int n3 = 1;
        if (n2 != 0) {
            n2 = n3;
        }
        int n4 = n2 * 31;
        String string = this.contextPrefix;
        int n5 = string == null ? 0 : string.hashCode();
        int n6 = 31 * (n4 + n5);
        int n7 = this.zlibDecoded;
        if (n7 != 0) {
            n7 = n3;
        }
        int n8 = 31 * (n6 + n7);
        int n9 = this.coseVerified;
        if (n9 != 0) {
            n9 = n3;
        }
        int n10 = 31 * (n8 + n9);
        int n11 = this.cborDecoded;
        if (n11 != 0) {
            n11 = n3;
        }
        int n12 = 31 * (n10 + n11);
        int n13 = this.isSchemaValid;
        if (n13 != 0) {
            n13 = n3;
        }
        int n14 = 31 * (n12 + n13);
        int n15 = this.isIssuedTimeCorrect;
        if (n15 != 0) {
            n15 = n3;
        }
        int n16 = 31 * (n14 + n15);
        int n17 = this.isNotExpired;
        if (n17 != 0) {
            n17 = n3;
        }
        int n18 = 31 * (n16 + n17);
        boolean bl = this.rulesValidationFailed;
        if (!bl) {
            n3 = bl ? 1 : 0;
        }
        int n19 = 31 * (n18 + n3);
        TestVerificationResult testVerificationResult = this.testVerification;
        int n20 = testVerificationResult == null ? 0 : testVerificationResult.hashCode();
        int n21 = 31 * (n19 + n20);
        RecoveryVerificationResult recoveryVerificationResult = this.recoveryVerification;
        int n22 = recoveryVerificationResult == null ? 0 : recoveryVerificationResult.hashCode();
        return n21 + n22;
    }

    public final boolean isIssuedTimeCorrect() {
        return this.isIssuedTimeCorrect;
    }

    public final boolean isNotExpired() {
        return this.isNotExpired;
    }

    public final boolean isRecoveryNotValidAnymore() {
        RecoveryVerificationResult recoveryVerificationResult = this.recoveryVerification;
        if (recoveryVerificationResult == null) {
            return false;
        }
        Intrinsics.checkNotNull((Object)recoveryVerificationResult);
        return recoveryVerificationResult.isNotValidAnymore();
    }

    public final boolean isRecoveryNotValidSoFar() {
        RecoveryVerificationResult recoveryVerificationResult = this.recoveryVerification;
        if (recoveryVerificationResult == null) {
            return false;
        }
        Intrinsics.checkNotNull((Object)recoveryVerificationResult);
        return recoveryVerificationResult.isNotValidSoFar();
    }

    public final boolean isSchemaValid() {
        return this.isSchemaValid;
    }

    public final boolean isTestDateInTheFuture() {
        TestVerificationResult testVerificationResult = this.testVerification;
        if (testVerificationResult == null) {
            return false;
        }
        Intrinsics.checkNotNull((Object)testVerificationResult);
        boolean bl = testVerificationResult.isTestDateInThePast();
        boolean bl2 = false;
        if (!bl) {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean isTestWithPositiveResult() {
        TestVerificationResult testVerificationResult = this.testVerification;
        if (testVerificationResult == null) {
            return false;
        }
        Intrinsics.checkNotNull((Object)testVerificationResult);
        boolean bl = testVerificationResult.isTestResultNegative();
        boolean bl2 = false;
        if (!bl) {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean isValid() {
        TestVerificationResult testVerificationResult = this.testVerification;
        boolean bl = testVerificationResult == null ? true : testVerificationResult.isTestValid();
        RecoveryVerificationResult recoveryVerificationResult = this.recoveryVerification;
        boolean bl2 = recoveryVerificationResult == null ? true : recoveryVerificationResult.isRecoveryValid();
        return this.base45Decoded && this.zlibDecoded && this.coseVerified && this.cborDecoded && this.isSchemaValid && bl && this.isIssuedTimeCorrect && this.isNotExpired && !this.rulesValidationFailed && bl2;
    }

    public final void setBase45Decoded(boolean bl) {
        this.base45Decoded = bl;
    }

    public final void setCborDecoded(boolean bl) {
        this.cborDecoded = bl;
    }

    public final void setContextPrefix(String string) {
        this.contextPrefix = string;
    }

    public final void setCoseVerified(boolean bl) {
        this.coseVerified = bl;
    }

    public final void setIssuedTimeCorrect(boolean bl) {
        this.isIssuedTimeCorrect = bl;
    }

    public final void setNotExpired(boolean bl) {
        this.isNotExpired = bl;
    }

    public final void setRecoveryVerification(RecoveryVerificationResult recoveryVerificationResult) {
        this.recoveryVerification = recoveryVerificationResult;
    }

    public final void setRulesValidationFailed(boolean bl) {
        this.rulesValidationFailed = bl;
    }

    public final void setSchemaValid(boolean bl) {
        this.isSchemaValid = bl;
    }

    public final void setTestVerification(TestVerificationResult testVerificationResult) {
        this.testVerification = testVerificationResult;
    }

    public final void setZlibDecoded(boolean bl) {
        this.zlibDecoded = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"VerificationResult: \nbase45Decoded: ");
        stringBuilder.append(this.base45Decoded);
        stringBuilder.append(" \ncontextPrefix: ");
        stringBuilder.append((Object)this.contextPrefix);
        stringBuilder.append(" \nzlibDecoded: ");
        stringBuilder.append(this.zlibDecoded);
        stringBuilder.append(" \ncoseVerified: ");
        stringBuilder.append(this.coseVerified);
        stringBuilder.append(" \ncborDecoded: ");
        stringBuilder.append(this.cborDecoded);
        stringBuilder.append(" \nisSchemaValid: ");
        stringBuilder.append(this.isSchemaValid);
        return stringBuilder.toString();
    }
}

