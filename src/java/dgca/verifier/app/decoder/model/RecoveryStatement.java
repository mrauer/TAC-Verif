/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BM\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00103J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0012JV\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0019\u001a\u00020\u00022\b\b\u0003\u0010\u001a\u001a\u00020\u00022\b\b\u0003\u0010\u001b\u001a\u00020\u00022\b\b\u0003\u0010\u001c\u001a\u00020\u00022\b\b\u0003\u0010\u001d\u001a\u00020\u00022\b\b\u0003\u0010\u001e\u001a\u00020\u00022\b\b\u0003\u0010\u001f\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\"\u0010\u0012J\u0010\u0010$\u001a\u00020#H\u00d6\u0001\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010\u0012R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b,\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b-\u0010\u0012R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b.\u0010\u0012R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b/\u0010\u0012R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b0\u0010\u0012R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b1\u0010\u0012\u00a8\u00065"}, d2={"Ldgca/verifier/app/decoder/model/RecoveryStatement;", "Ljava/io/Serializable;", "", "j$/time/ZonedDateTime", "toZonedDateTime", "(Ljava/lang/String;)Lj$/time/ZonedDateTime;", "j$/time/LocalDateTime", "toLocalDateTime", "(Ljava/lang/String;)Lj$/time/LocalDateTime;", "j$/time/LocalDate", "toLocalDate", "(Ljava/lang/String;)Lj$/time/LocalDate;", "toZonedDateTimeOrUtcLocal", "", "isCertificateNotValidAnymore", "()Ljava/lang/Boolean;", "isCertificateNotValidSoFar", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "disease", "dateOfFirstPositiveTest", "countryOfVaccination", "certificateIssuer", "certificateValidFrom", "certificateValidUntil", "certificateIdentifier", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldgca/verifier/app/decoder/model/RecoveryStatement;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCountryOfVaccination", "getCertificateIdentifier", "getDisease", "getCertificateValidUntil", "getCertificateIssuer", "getCertificateValidFrom", "getDateOfFirstPositiveTest", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class RecoveryStatement
implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final ZoneId UTC_ZONE_ID;
    private final String certificateIdentifier;
    private final String certificateIssuer;
    private final String certificateValidFrom;
    private final String certificateValidUntil;
    private final String countryOfVaccination;
    private final String dateOfFirstPositiveTest;
    private final String disease;

    public static {
        ZoneId zoneId = ZoneId.ofOffset("", ZoneOffset.UTC).normalized();
        Intrinsics.checkNotNullExpressionValue((Object)zoneId, (String)"ofOffset(\"\", ZoneOffset.UTC).normalized()");
        UTC_ZONE_ID = zoneId;
    }

    public RecoveryStatement(@JsonProperty(value="tg") String string, @JsonProperty(value="fr") String string2, @JsonProperty(value="co") String string3, @JsonProperty(value="is") String string4, @JsonProperty(value="df") String string5, @JsonProperty(value="du") String string6, @JsonProperty(value="ci") String string7) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"dateOfFirstPositiveTest");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"certificateValidFrom");
        Intrinsics.checkNotNullParameter((Object)string6, (String)"certificateValidUntil");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"certificateIdentifier");
        this.disease = string;
        this.dateOfFirstPositiveTest = string2;
        this.countryOfVaccination = string3;
        this.certificateIssuer = string4;
        this.certificateValidFrom = string5;
        this.certificateValidUntil = string6;
        this.certificateIdentifier = string7;
    }

    public static /* synthetic */ RecoveryStatement copy$default(RecoveryStatement recoveryStatement, String string, String string2, String string3, String string4, String string5, String string6, String string7, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = recoveryStatement.disease;
        }
        if ((n2 & 2) != 0) {
            string2 = recoveryStatement.dateOfFirstPositiveTest;
        }
        String string8 = string2;
        if ((n2 & 4) != 0) {
            string3 = recoveryStatement.countryOfVaccination;
        }
        String string9 = string3;
        if ((n2 & 8) != 0) {
            string4 = recoveryStatement.certificateIssuer;
        }
        String string10 = string4;
        if ((n2 & 16) != 0) {
            string5 = recoveryStatement.certificateValidFrom;
        }
        String string11 = string5;
        if ((n2 & 32) != 0) {
            string6 = recoveryStatement.certificateValidUntil;
        }
        String string12 = string6;
        if ((n2 & 64) != 0) {
            string7 = recoveryStatement.certificateIdentifier;
        }
        String string13 = string7;
        return recoveryStatement.copy(string, string8, string9, string10, string11, string12, string13);
    }

    private final LocalDate toLocalDate(String string) {
        try {
            LocalDate localDate = LocalDate.parse(string);
            return localDate;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private final LocalDateTime toLocalDateTime(String string) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(string);
            return localDateTime;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private final ZonedDateTime toZonedDateTime(String string) {
        try {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(string);
            return zonedDateTime;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private final ZonedDateTime toZonedDateTimeOrUtcLocal(String string) {
        LocalDateTime localDateTime;
        ZonedDateTime zonedDateTime = this.toZonedDateTime(string);
        ZonedDateTime zonedDateTime2 = zonedDateTime == null ? null : zonedDateTime.withZoneSameInstant(UTC_ZONE_ID);
        if (zonedDateTime2 == null && (zonedDateTime2 = (localDateTime = this.toLocalDateTime(string)) == null ? null : localDateTime.atZone(UTC_ZONE_ID)) == null) {
            LocalDate localDate = this.toLocalDate(string);
            if (localDate == null) {
                return null;
            }
            return localDate.atStartOfDay(UTC_ZONE_ID);
        }
        return zonedDateTime2;
    }

    public final String component1() {
        return this.disease;
    }

    public final String component2() {
        return this.dateOfFirstPositiveTest;
    }

    public final String component3() {
        return this.countryOfVaccination;
    }

    public final String component4() {
        return this.certificateIssuer;
    }

    public final String component5() {
        return this.certificateValidFrom;
    }

    public final String component6() {
        return this.certificateValidUntil;
    }

    public final String component7() {
        return this.certificateIdentifier;
    }

    public final RecoveryStatement copy(@JsonProperty(value="tg") String string, @JsonProperty(value="fr") String string2, @JsonProperty(value="co") String string3, @JsonProperty(value="is") String string4, @JsonProperty(value="df") String string5, @JsonProperty(value="du") String string6, @JsonProperty(value="ci") String string7) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"dateOfFirstPositiveTest");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"certificateValidFrom");
        Intrinsics.checkNotNullParameter((Object)string6, (String)"certificateValidUntil");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"certificateIdentifier");
        RecoveryStatement recoveryStatement = new RecoveryStatement(string, string2, string3, string4, string5, string6, string7);
        return recoveryStatement;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RecoveryStatement)) {
            return false;
        }
        RecoveryStatement recoveryStatement = (RecoveryStatement)object;
        if (!Intrinsics.areEqual((Object)this.disease, (Object)recoveryStatement.disease)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dateOfFirstPositiveTest, (Object)recoveryStatement.dateOfFirstPositiveTest)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.countryOfVaccination, (Object)recoveryStatement.countryOfVaccination)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.certificateIssuer, (Object)recoveryStatement.certificateIssuer)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.certificateValidFrom, (Object)recoveryStatement.certificateValidFrom)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.certificateValidUntil, (Object)recoveryStatement.certificateValidUntil)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.certificateIdentifier, (Object)recoveryStatement.certificateIdentifier);
    }

    public final String getCertificateIdentifier() {
        return this.certificateIdentifier;
    }

    public final String getCertificateIssuer() {
        return this.certificateIssuer;
    }

    public final String getCertificateValidFrom() {
        return this.certificateValidFrom;
    }

    public final String getCertificateValidUntil() {
        return this.certificateValidUntil;
    }

    public final String getCountryOfVaccination() {
        return this.countryOfVaccination;
    }

    public final String getDateOfFirstPositiveTest() {
        return this.dateOfFirstPositiveTest;
    }

    public final String getDisease() {
        return this.disease;
    }

    public int hashCode() {
        int n2 = 31 * this.disease.hashCode();
        int n3 = GeneratedOutlineSupport.outline3((String)this.dateOfFirstPositiveTest, (int)n2, (int)31);
        int n4 = GeneratedOutlineSupport.outline3((String)this.countryOfVaccination, (int)n3, (int)31);
        int n5 = GeneratedOutlineSupport.outline3((String)this.certificateIssuer, (int)n4, (int)31);
        int n6 = GeneratedOutlineSupport.outline3((String)this.certificateValidFrom, (int)n5, (int)31);
        return GeneratedOutlineSupport.outline3((String)this.certificateValidUntil, (int)n6, (int)31) + this.certificateIdentifier.hashCode();
    }

    public final Boolean isCertificateNotValidAnymore() {
        ZonedDateTime zonedDateTime = this.toZonedDateTimeOrUtcLocal(this.certificateValidUntil);
        if (zonedDateTime == null) {
            return null;
        }
        return zonedDateTime.isBefore(ZonedDateTime.now());
    }

    public final Boolean isCertificateNotValidSoFar() {
        ZonedDateTime zonedDateTime = this.toZonedDateTimeOrUtcLocal(this.certificateValidFrom);
        if (zonedDateTime == null) {
            return null;
        }
        return zonedDateTime.isAfter(ZonedDateTime.now());
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"RecoveryStatement(disease=");
        stringBuilder.append(this.disease);
        stringBuilder.append(", dateOfFirstPositiveTest=");
        stringBuilder.append(this.dateOfFirstPositiveTest);
        stringBuilder.append(", countryOfVaccination=");
        stringBuilder.append(this.countryOfVaccination);
        stringBuilder.append(", certificateIssuer=");
        stringBuilder.append(this.certificateIssuer);
        stringBuilder.append(", certificateValidFrom=");
        stringBuilder.append(this.certificateValidFrom);
        stringBuilder.append(", certificateValidUntil=");
        stringBuilder.append(this.certificateValidUntil);
        stringBuilder.append(", certificateIdentifier=");
        stringBuilder.append(this.certificateIdentifier);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Ldgca/verifier/app/decoder/model/RecoveryStatement$Companion;", "", "j$/time/ZoneId", "UTC_ZONE_ID", "Lj$/time/ZoneId;", "<init>", "()V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

}

