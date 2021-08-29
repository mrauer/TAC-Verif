/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import dgca.verifier.app.decoder.model.CertificateType;
import dgca.verifier.app.decoder.model.Person;
import dgca.verifier.app.decoder.model.RecoveryStatement;
import dgca.verifier.app.decoder.model.Test;
import dgca.verifier.app.decoder.model.Vaccination;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0017\u001a\u00020\n\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0002\u0012\u0010\b\u0001\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e\u0012\u0010\b\u0001\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u00a2\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u0004J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0011Jd\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0016\u001a\u00020\u00022\b\b\u0003\u0010\u0017\u001a\u00020\n2\b\b\u0003\u0010\u0018\u001a\u00020\u00022\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e2\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010 \u001a\u00020\u001fH\u00d6\u0001\u00a2\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u00d6\u0003\u00a2\u0006\u0004\b%\u0010&R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u0011R!\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b)\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b,\u0010\u0004R!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b-\u0010\u0011R\u0019\u0010\u0017\u001a\u00020\n8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\f\u00a8\u00062"}, d2={"Ldgca/verifier/app/decoder/model/GreenCertificate;", "Ljava/io/Serializable;", "", "getDgci", "()Ljava/lang/String;", "getIssuingCountry", "Ldgca/verifier/app/decoder/model/CertificateType;", "getType", "()Ldgca/verifier/app/decoder/model/CertificateType;", "component1", "Ldgca/verifier/app/decoder/model/Person;", "component2", "()Ldgca/verifier/app/decoder/model/Person;", "component3", "", "Ldgca/verifier/app/decoder/model/Vaccination;", "component4", "()Ljava/util/List;", "Ldgca/verifier/app/decoder/model/Test;", "component5", "Ldgca/verifier/app/decoder/model/RecoveryStatement;", "component6", "schemaVersion", "person", "dateOfBirth", "vaccinations", "tests", "recoveryStatements", "copy", "(Ljava/lang/String;Ldgca/verifier/app/decoder/model/Person;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ldgca/verifier/app/decoder/model/GreenCertificate;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTests", "getRecoveryStatements", "Ljava/lang/String;", "getSchemaVersion", "getDateOfBirth", "getVaccinations", "Ldgca/verifier/app/decoder/model/Person;", "getPerson", "<init>", "(Ljava/lang/String;Ldgca/verifier/app/decoder/model/Person;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class GreenCertificate
implements Serializable {
    private final String dateOfBirth;
    private final Person person;
    private final List<RecoveryStatement> recoveryStatements;
    private final String schemaVersion;
    private final List<Test> tests;
    private final List<Vaccination> vaccinations;

    public GreenCertificate(@JsonProperty(value="ver") String string, @JsonProperty(value="nam") Person person, @JsonProperty(value="dob") String string2, @JsonProperty(value="v") List<Vaccination> list, @JsonProperty(value="t") List<Test> list2, @JsonProperty(value="r") List<RecoveryStatement> list3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"schemaVersion");
        Intrinsics.checkNotNullParameter((Object)person, (String)"person");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"dateOfBirth");
        this.schemaVersion = string;
        this.person = person;
        this.dateOfBirth = string2;
        this.vaccinations = list;
        this.tests = list2;
        this.recoveryStatements = list3;
    }

    public static /* synthetic */ GreenCertificate copy$default(GreenCertificate greenCertificate, String string, Person person, String string2, List list, List list2, List list3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = greenCertificate.schemaVersion;
        }
        if ((n2 & 2) != 0) {
            person = greenCertificate.person;
        }
        Person person2 = person;
        if ((n2 & 4) != 0) {
            string2 = greenCertificate.dateOfBirth;
        }
        String string3 = string2;
        if ((n2 & 8) != 0) {
            list = greenCertificate.vaccinations;
        }
        List<Vaccination> list4 = list;
        if ((n2 & 16) != 0) {
            list2 = greenCertificate.tests;
        }
        List<Test> list5 = list2;
        if ((n2 & 32) != 0) {
            list3 = greenCertificate.recoveryStatements;
        }
        List<RecoveryStatement> list6 = list3;
        return greenCertificate.copy(string, person2, string3, list4, list5, list6);
    }

    public final String component1() {
        return this.schemaVersion;
    }

    public final Person component2() {
        return this.person;
    }

    public final String component3() {
        return this.dateOfBirth;
    }

    public final List<Vaccination> component4() {
        return this.vaccinations;
    }

    public final List<Test> component5() {
        return this.tests;
    }

    public final List<RecoveryStatement> component6() {
        return this.recoveryStatements;
    }

    public final GreenCertificate copy(@JsonProperty(value="ver") String string, @JsonProperty(value="nam") Person person, @JsonProperty(value="dob") String string2, @JsonProperty(value="v") List<Vaccination> list, @JsonProperty(value="t") List<Test> list2, @JsonProperty(value="r") List<RecoveryStatement> list3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"schemaVersion");
        Intrinsics.checkNotNullParameter((Object)person, (String)"person");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"dateOfBirth");
        GreenCertificate greenCertificate = new GreenCertificate(string, person, string2, list, list2, list3);
        return greenCertificate;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GreenCertificate)) {
            return false;
        }
        GreenCertificate greenCertificate = (GreenCertificate)object;
        if (!Intrinsics.areEqual((Object)this.schemaVersion, (Object)greenCertificate.schemaVersion)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.person, (Object)greenCertificate.person)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dateOfBirth, (Object)greenCertificate.dateOfBirth)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.vaccinations, greenCertificate.vaccinations)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.tests, greenCertificate.tests)) {
            return false;
        }
        return Intrinsics.areEqual(this.recoveryStatements, greenCertificate.recoveryStatements);
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /*
     * Exception decompiling
     */
    public final String getDgci() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public final String getIssuingCountry() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public final Person getPerson() {
        return this.person;
    }

    public final List<RecoveryStatement> getRecoveryStatements() {
        return this.recoveryStatements;
    }

    public final String getSchemaVersion() {
        return this.schemaVersion;
    }

    public final List<Test> getTests() {
        return this.tests;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final CertificateType getType() {
        boolean bl;
        List<Vaccination> list = this.vaccinations;
        boolean bl2 = list != null && true ^ list.isEmpty();
        if (bl2) {
            return CertificateType.VACCINATION;
        }
        List<Test> list2 = this.tests;
        boolean bl3 = list2 != null && true ^ list2.isEmpty();
        if (bl3) {
            return CertificateType.TEST;
        }
        List<RecoveryStatement> list3 = this.recoveryStatements;
        if (list3 == null) {
            bl = false;
        } else {
            boolean bl4 = true ^ list3.isEmpty();
            bl = false;
            if (bl4) {
                bl = true;
            }
        }
        if (bl) {
            return CertificateType.RECOVERY;
        }
        return CertificateType.UNKNOWN;
    }

    public final List<Vaccination> getVaccinations() {
        return this.vaccinations;
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.schemaVersion.hashCode() + this.person.hashCode());
        int n3 = GeneratedOutlineSupport.outline3((String)this.dateOfBirth, (int)n2, (int)31);
        List<Vaccination> list = this.vaccinations;
        int n4 = list == null ? 0 : list.hashCode();
        int n5 = 31 * (n3 + n4);
        List<Test> list2 = this.tests;
        int n6 = list2 == null ? 0 : list2.hashCode();
        int n7 = 31 * (n5 + n6);
        List<RecoveryStatement> list3 = this.recoveryStatements;
        int n8 = list3 == null ? 0 : list3.hashCode();
        return n7 + n8;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"GreenCertificate(schemaVersion=");
        stringBuilder.append(this.schemaVersion);
        stringBuilder.append(", person=");
        stringBuilder.append((Object)this.person);
        stringBuilder.append(", dateOfBirth=");
        stringBuilder.append(this.dateOfBirth);
        stringBuilder.append(", vaccinations=");
        stringBuilder.append(this.vaccinations);
        stringBuilder.append(", tests=");
        stringBuilder.append(this.tests);
        stringBuilder.append(", recoveryStatements=");
        stringBuilder.append(this.recoveryStatements);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

