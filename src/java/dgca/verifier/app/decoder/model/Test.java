/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import dgca.verifier.app.decoder.model.-$$Lambda$VPr89HQOq67u9uM-TeQCxfrmwTA;
import j$.time.OffsetDateTime;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalQuery;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0001=B{\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010 \u001a\u00020\u0002\u0012\b\b\u0001\u0010!\u001a\u00020\u0002\u0012\b\b\u0001\u0010\"\u001a\u00020\u0002\u0012\b\b\u0001\u0010#\u001a\u00020\u0002\u0012\b\b\u0001\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010<J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\tJ\r\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u000fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u000fJ\u0010\u0010\u0018\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u000fJ\u0084\u0001\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u001a\u001a\u00020\u00022\b\b\u0003\u0010\u001b\u001a\u00020\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u001e\u001a\u00020\u00022\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010 \u001a\u00020\u00022\b\b\u0003\u0010!\u001a\u00020\u00022\b\b\u0003\u0010\"\u001a\u00020\u00022\b\b\u0003\u0010#\u001a\u00020\u00022\b\b\u0003\u0010$\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b'\u0010\u000fJ\u0010\u0010)\u001a\u00020(H\u00d6\u0001\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+H\u00d6\u0003\u00a2\u0006\u0004\b-\u0010.R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b$\u0010/\u001a\u0004\b0\u0010\u000fR\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b1\u0010\u000fR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b2\u0010\u000fR\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b3\u0010\u000fR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b4\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b5\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b6\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b7\u0010\u000fR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b8\u0010\u000fR\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b \u0010/\u001a\u0004\b9\u0010\u000fR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b:\u0010\u000f\u00a8\u0006>"}, d2={"Ldgca/verifier/app/decoder/model/Test;", "Ljava/io/Serializable;", "", "value", "j$/time/OffsetDateTime", "parseToUtcTimestamp", "(Ljava/lang/String;)Lj$/time/OffsetDateTime;", "", "isResultNegative", "()Z", "isDateInThePast", "Ldgca/verifier/app/decoder/model/Test$TestResult;", "getTestResultType", "()Ldgca/verifier/app/decoder/model/Test$TestResult;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "disease", "typeOfTest", "testName", "testNameAndManufacturer", "dateTimeOfCollection", "dateTimeOfTestResult", "testResult", "testingCentre", "countryOfVaccination", "certificateIssuer", "certificateIdentifier", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldgca/verifier/app/decoder/model/Test;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCertificateIdentifier", "getDisease", "getTestNameAndManufacturer", "getCertificateIssuer", "getDateTimeOfCollection", "getTypeOfTest", "getTestName", "getDateTimeOfTestResult", "getCountryOfVaccination", "getTestResult", "getTestingCentre", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TestResult", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class Test
implements Serializable {
    private final String certificateIdentifier;
    private final String certificateIssuer;
    private final String countryOfVaccination;
    private final String dateTimeOfCollection;
    private final String dateTimeOfTestResult;
    private final String disease;
    private final String testName;
    private final String testNameAndManufacturer;
    private final String testResult;
    private final String testingCentre;
    private final String typeOfTest;

    public Test(@JsonProperty(value="tg") String string, @JsonProperty(value="tt") String string2, @JsonProperty(value="nm") String string3, @JsonProperty(value="ma") String string4, @JsonProperty(value="sc") String string5, @JsonProperty(value="dr") String string6, @JsonProperty(value="tr") String string7, @JsonProperty(value="tc") String string8, @JsonProperty(value="co") String string9, @JsonProperty(value="is") String string10, @JsonProperty(value="ci") String string11) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"typeOfTest");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"dateTimeOfCollection");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"testResult");
        Intrinsics.checkNotNullParameter((Object)string8, (String)"testingCentre");
        Intrinsics.checkNotNullParameter((Object)string9, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string10, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string11, (String)"certificateIdentifier");
        this.disease = string;
        this.typeOfTest = string2;
        this.testName = string3;
        this.testNameAndManufacturer = string4;
        this.dateTimeOfCollection = string5;
        this.dateTimeOfTestResult = string6;
        this.testResult = string7;
        this.testingCentre = string8;
        this.countryOfVaccination = string9;
        this.certificateIssuer = string10;
        this.certificateIdentifier = string11;
    }

    public static /* synthetic */ Test copy$default(Test test, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, int n2, Object object) {
        String string12 = (n2 & 1) != 0 ? test.disease : string;
        String string13 = (n2 & 2) != 0 ? test.typeOfTest : string2;
        String string14 = (n2 & 4) != 0 ? test.testName : string3;
        String string15 = (n2 & 8) != 0 ? test.testNameAndManufacturer : string4;
        String string16 = (n2 & 16) != 0 ? test.dateTimeOfCollection : string5;
        String string17 = (n2 & 32) != 0 ? test.dateTimeOfTestResult : string6;
        String string18 = (n2 & 64) != 0 ? test.testResult : string7;
        String string19 = (n2 & 128) != 0 ? test.testingCentre : string8;
        String string20 = (n2 & 256) != 0 ? test.countryOfVaccination : string9;
        String string21 = (n2 & 512) != 0 ? test.certificateIssuer : string10;
        String string22 = (n2 & 1024) != 0 ? test.certificateIdentifier : string11;
        return test.copy(string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22);
    }

    private final OffsetDateTime parseToUtcTimestamp(String string) {
        boolean bl = string == null || string.length() == 0;
        if (bl) {
            OffsetDateTime offsetDateTime = OffsetDateTime.MAX;
            Intrinsics.checkNotNullExpressionValue((Object)offsetDateTime, (String)"MAX");
            return offsetDateTime;
        }
        try {
            OffsetDateTime offsetDateTime = ((OffsetDateTime)DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(string, -$$Lambda$VPr89HQOq67u9uM-TeQCxfrmwTA.INSTANCE)).withOffsetSameInstant(ZoneOffset.UTC);
            Intrinsics.checkNotNullExpressionValue((Object)offsetDateTime, (String)"{\n            DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value, OffsetDateTime::from).withOffsetSameInstant(ZoneOffset.UTC)\n        }");
            return offsetDateTime;
        }
        catch (Exception exception) {
            OffsetDateTime offsetDateTime = OffsetDateTime.MAX;
            Intrinsics.checkNotNullExpressionValue((Object)offsetDateTime, (String)"{\n            OffsetDateTime.MAX\n        }");
            return offsetDateTime;
        }
    }

    public final String component1() {
        return this.disease;
    }

    public final String component10() {
        return this.certificateIssuer;
    }

    public final String component11() {
        return this.certificateIdentifier;
    }

    public final String component2() {
        return this.typeOfTest;
    }

    public final String component3() {
        return this.testName;
    }

    public final String component4() {
        return this.testNameAndManufacturer;
    }

    public final String component5() {
        return this.dateTimeOfCollection;
    }

    public final String component6() {
        return this.dateTimeOfTestResult;
    }

    public final String component7() {
        return this.testResult;
    }

    public final String component8() {
        return this.testingCentre;
    }

    public final String component9() {
        return this.countryOfVaccination;
    }

    public final Test copy(@JsonProperty(value="tg") String string, @JsonProperty(value="tt") String string2, @JsonProperty(value="nm") String string3, @JsonProperty(value="ma") String string4, @JsonProperty(value="sc") String string5, @JsonProperty(value="dr") String string6, @JsonProperty(value="tr") String string7, @JsonProperty(value="tc") String string8, @JsonProperty(value="co") String string9, @JsonProperty(value="is") String string10, @JsonProperty(value="ci") String string11) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"typeOfTest");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"dateTimeOfCollection");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"testResult");
        Intrinsics.checkNotNullParameter((Object)string8, (String)"testingCentre");
        Intrinsics.checkNotNullParameter((Object)string9, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string10, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string11, (String)"certificateIdentifier");
        Test test = new Test(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
        return test;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Test)) {
            return false;
        }
        Test test = (Test)object;
        if (!Intrinsics.areEqual((Object)this.disease, (Object)test.disease)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.typeOfTest, (Object)test.typeOfTest)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.testName, (Object)test.testName)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.testNameAndManufacturer, (Object)test.testNameAndManufacturer)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dateTimeOfCollection, (Object)test.dateTimeOfCollection)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dateTimeOfTestResult, (Object)test.dateTimeOfTestResult)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.testResult, (Object)test.testResult)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.testingCentre, (Object)test.testingCentre)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.countryOfVaccination, (Object)test.countryOfVaccination)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.certificateIssuer, (Object)test.certificateIssuer)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.certificateIdentifier, (Object)test.certificateIdentifier);
    }

    public final String getCertificateIdentifier() {
        return this.certificateIdentifier;
    }

    public final String getCertificateIssuer() {
        return this.certificateIssuer;
    }

    public final String getCountryOfVaccination() {
        return this.countryOfVaccination;
    }

    public final String getDateTimeOfCollection() {
        return this.dateTimeOfCollection;
    }

    public final String getDateTimeOfTestResult() {
        return this.dateTimeOfTestResult;
    }

    public final String getDisease() {
        return this.disease;
    }

    public final String getTestName() {
        return this.testName;
    }

    public final String getTestNameAndManufacturer() {
        return this.testNameAndManufacturer;
    }

    public final String getTestResult() {
        return this.testResult;
    }

    public final TestResult getTestResultType() {
        String string = this.testResult;
        TestResult testResult = TestResult.DETECTED;
        if (Intrinsics.areEqual((Object)string, (Object)testResult.getValue())) {
            return testResult;
        }
        TestResult testResult2 = TestResult.NOT_DETECTED;
        Intrinsics.areEqual((Object)string, (Object)testResult2.getValue());
        return testResult2;
    }

    public final String getTestingCentre() {
        return this.testingCentre;
    }

    public final String getTypeOfTest() {
        return this.typeOfTest;
    }

    public int hashCode() {
        int n2 = 31 * this.disease.hashCode();
        int n3 = GeneratedOutlineSupport.outline3((String)this.typeOfTest, (int)n2, (int)31);
        String string = this.testName;
        int n4 = string == null ? 0 : string.hashCode();
        int n5 = 31 * (n3 + n4);
        String string2 = this.testNameAndManufacturer;
        int n6 = string2 == null ? 0 : string2.hashCode();
        int n7 = 31 * (n5 + n6);
        int n8 = GeneratedOutlineSupport.outline3((String)this.dateTimeOfCollection, (int)n7, (int)31);
        String string3 = this.dateTimeOfTestResult;
        int n9 = string3 == null ? 0 : string3.hashCode();
        int n10 = 31 * (n8 + n9);
        int n11 = GeneratedOutlineSupport.outline3((String)this.testResult, (int)n10, (int)31);
        int n12 = GeneratedOutlineSupport.outline3((String)this.testingCentre, (int)n11, (int)31);
        int n13 = GeneratedOutlineSupport.outline3((String)this.countryOfVaccination, (int)n12, (int)31);
        return GeneratedOutlineSupport.outline3((String)this.certificateIssuer, (int)n13, (int)31) + this.certificateIdentifier.hashCode();
    }

    public final boolean isDateInThePast() {
        return this.parseToUtcTimestamp(this.dateTimeOfCollection).isBefore(OffsetDateTime.now());
    }

    public final boolean isResultNegative() {
        return Intrinsics.areEqual((Object)this.testResult, (Object)TestResult.NOT_DETECTED.getValue());
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Test(disease=");
        stringBuilder.append(this.disease);
        stringBuilder.append(", typeOfTest=");
        stringBuilder.append(this.typeOfTest);
        stringBuilder.append(", testName=");
        stringBuilder.append((Object)this.testName);
        stringBuilder.append(", testNameAndManufacturer=");
        stringBuilder.append((Object)this.testNameAndManufacturer);
        stringBuilder.append(", dateTimeOfCollection=");
        stringBuilder.append(this.dateTimeOfCollection);
        stringBuilder.append(", dateTimeOfTestResult=");
        stringBuilder.append((Object)this.dateTimeOfTestResult);
        stringBuilder.append(", testResult=");
        stringBuilder.append(this.testResult);
        stringBuilder.append(", testingCentre=");
        stringBuilder.append(this.testingCentre);
        stringBuilder.append(", countryOfVaccination=");
        stringBuilder.append(this.countryOfVaccination);
        stringBuilder.append(", certificateIssuer=");
        stringBuilder.append(this.certificateIssuer);
        stringBuilder.append(", certificateIdentifier=");
        stringBuilder.append(this.certificateIdentifier);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Ldgca/verifier/app/decoder/model/Test$TestResult;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DETECTED", "NOT_DETECTED", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
    public static final class TestResult
    extends Enum<TestResult> {
        private static final /* synthetic */ TestResult[] $VALUES;
        public static final /* enum */ TestResult DETECTED = new TestResult("260373001");
        public static final /* enum */ TestResult NOT_DETECTED = new TestResult("260415000");
        private final String value;

        public static {
            $VALUES = arrtestResult = new TestResult[]{TestResult.DETECTED, TestResult.NOT_DETECTED};
        }

        private TestResult(String string2) {
            this.value = string2;
        }

        public static TestResult valueOf(String string) {
            return (TestResult)Enum.valueOf(TestResult.class, (String)string);
        }

        public static TestResult[] values() {
            return (TestResult[])$VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

}

