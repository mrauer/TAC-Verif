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
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0014\u001a\u00020\b\u0012\b\b\u0001\u0010\u0015\u001a\u00020\b\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0004Jt\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0010\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\b2\b\b\u0003\u0010\u0015\u001a\u00020\b2\b\b\u0003\u0010\u0016\u001a\u00020\u00022\b\b\u0003\u0010\u0017\u001a\u00020\u00022\b\b\u0003\u0010\u0018\u001a\u00020\u00022\b\b\u0003\u0010\u0019\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\bH\u00d6\u0001\u00a2\u0006\u0004\b\u001d\u0010\nJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003\u00a2\u0006\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b.\u0010\n\u00a8\u00061"}, d2={"Ldgca/verifier/app/decoder/model/Vaccination;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()I", "component6", "component7", "component8", "component9", "component10", "disease", "vaccine", "medicinalProduct", "manufacturer", "doseNumber", "totalSeriesOfDoses", "dateOfVaccination", "countryOfVaccination", "certificateIssuer", "certificateIdentifier", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldgca/verifier/app/decoder/model/Vaccination;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDisease", "getMedicinalProduct", "getDateOfVaccination", "I", "getTotalSeriesOfDoses", "getVaccine", "getManufacturer", "getCountryOfVaccination", "getCertificateIssuer", "getCertificateIdentifier", "getDoseNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class Vaccination
implements Serializable {
    private final String certificateIdentifier;
    private final String certificateIssuer;
    private final String countryOfVaccination;
    private final String dateOfVaccination;
    private final String disease;
    private final int doseNumber;
    private final String manufacturer;
    private final String medicinalProduct;
    private final int totalSeriesOfDoses;
    private final String vaccine;

    public Vaccination(@JsonProperty(value="tg") String string, @JsonProperty(value="vp") String string2, @JsonProperty(value="mp") String string3, @JsonProperty(value="ma") String string4, @JsonProperty(value="dn") int n2, @JsonProperty(value="sd") int n3, @JsonProperty(value="dt") String string5, @JsonProperty(value="co") String string6, @JsonProperty(value="is") String string7, @JsonProperty(value="ci") String string8) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"vaccine");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"medicinalProduct");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"manufacturer");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"dateOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string6, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string8, (String)"certificateIdentifier");
        this.disease = string;
        this.vaccine = string2;
        this.medicinalProduct = string3;
        this.manufacturer = string4;
        this.doseNumber = n2;
        this.totalSeriesOfDoses = n3;
        this.dateOfVaccination = string5;
        this.countryOfVaccination = string6;
        this.certificateIssuer = string7;
        this.certificateIdentifier = string8;
    }

    public static /* synthetic */ Vaccination copy$default(Vaccination vaccination, String string, String string2, String string3, String string4, int n2, int n3, String string5, String string6, String string7, String string8, int n4, Object object) {
        String string9 = (n4 & 1) != 0 ? vaccination.disease : string;
        String string10 = (n4 & 2) != 0 ? vaccination.vaccine : string2;
        String string11 = (n4 & 4) != 0 ? vaccination.medicinalProduct : string3;
        String string12 = (n4 & 8) != 0 ? vaccination.manufacturer : string4;
        int n5 = (n4 & 16) != 0 ? vaccination.doseNumber : n2;
        int n6 = (n4 & 32) != 0 ? vaccination.totalSeriesOfDoses : n3;
        String string13 = (n4 & 64) != 0 ? vaccination.dateOfVaccination : string5;
        String string14 = (n4 & 128) != 0 ? vaccination.countryOfVaccination : string6;
        String string15 = (n4 & 256) != 0 ? vaccination.certificateIssuer : string7;
        String string16 = (n4 & 512) != 0 ? vaccination.certificateIdentifier : string8;
        return vaccination.copy(string9, string10, string11, string12, n5, n6, string13, string14, string15, string16);
    }

    public final String component1() {
        return this.disease;
    }

    public final String component10() {
        return this.certificateIdentifier;
    }

    public final String component2() {
        return this.vaccine;
    }

    public final String component3() {
        return this.medicinalProduct;
    }

    public final String component4() {
        return this.manufacturer;
    }

    public final int component5() {
        return this.doseNumber;
    }

    public final int component6() {
        return this.totalSeriesOfDoses;
    }

    public final String component7() {
        return this.dateOfVaccination;
    }

    public final String component8() {
        return this.countryOfVaccination;
    }

    public final String component9() {
        return this.certificateIssuer;
    }

    public final Vaccination copy(@JsonProperty(value="tg") String string, @JsonProperty(value="vp") String string2, @JsonProperty(value="mp") String string3, @JsonProperty(value="ma") String string4, @JsonProperty(value="dn") int n2, @JsonProperty(value="sd") int n3, @JsonProperty(value="dt") String string5, @JsonProperty(value="co") String string6, @JsonProperty(value="is") String string7, @JsonProperty(value="ci") String string8) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"disease");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"vaccine");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"medicinalProduct");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"manufacturer");
        Intrinsics.checkNotNullParameter((Object)string5, (String)"dateOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string6, (String)"countryOfVaccination");
        Intrinsics.checkNotNullParameter((Object)string7, (String)"certificateIssuer");
        Intrinsics.checkNotNullParameter((Object)string8, (String)"certificateIdentifier");
        Vaccination vaccination = new Vaccination(string, string2, string3, string4, n2, n3, string5, string6, string7, string8);
        return vaccination;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Vaccination)) {
            return false;
        }
        Vaccination vaccination = (Vaccination)object;
        if (!Intrinsics.areEqual((Object)this.disease, (Object)vaccination.disease)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.vaccine, (Object)vaccination.vaccine)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.medicinalProduct, (Object)vaccination.medicinalProduct)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.manufacturer, (Object)vaccination.manufacturer)) {
            return false;
        }
        if (this.doseNumber != vaccination.doseNumber) {
            return false;
        }
        if (this.totalSeriesOfDoses != vaccination.totalSeriesOfDoses) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dateOfVaccination, (Object)vaccination.dateOfVaccination)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.countryOfVaccination, (Object)vaccination.countryOfVaccination)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.certificateIssuer, (Object)vaccination.certificateIssuer)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.certificateIdentifier, (Object)vaccination.certificateIdentifier);
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

    public final String getDateOfVaccination() {
        return this.dateOfVaccination;
    }

    public final String getDisease() {
        return this.disease;
    }

    public final int getDoseNumber() {
        return this.doseNumber;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getMedicinalProduct() {
        return this.medicinalProduct;
    }

    public final int getTotalSeriesOfDoses() {
        return this.totalSeriesOfDoses;
    }

    public final String getVaccine() {
        return this.vaccine;
    }

    public int hashCode() {
        int n2 = 31 * this.disease.hashCode();
        int n3 = GeneratedOutlineSupport.outline3((String)this.vaccine, (int)n2, (int)31);
        int n4 = GeneratedOutlineSupport.outline3((String)this.medicinalProduct, (int)n3, (int)31);
        int n5 = 31 * (31 * (GeneratedOutlineSupport.outline3((String)this.manufacturer, (int)n4, (int)31) + this.doseNumber) + this.totalSeriesOfDoses);
        int n6 = GeneratedOutlineSupport.outline3((String)this.dateOfVaccination, (int)n5, (int)31);
        int n7 = GeneratedOutlineSupport.outline3((String)this.countryOfVaccination, (int)n6, (int)31);
        return GeneratedOutlineSupport.outline3((String)this.certificateIssuer, (int)n7, (int)31) + this.certificateIdentifier.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Vaccination(disease=");
        stringBuilder.append(this.disease);
        stringBuilder.append(", vaccine=");
        stringBuilder.append(this.vaccine);
        stringBuilder.append(", medicinalProduct=");
        stringBuilder.append(this.medicinalProduct);
        stringBuilder.append(", manufacturer=");
        stringBuilder.append(this.manufacturer);
        stringBuilder.append(", doseNumber=");
        stringBuilder.append(this.doseNumber);
        stringBuilder.append(", totalSeriesOfDoses=");
        stringBuilder.append(this.totalSeriesOfDoses);
        stringBuilder.append(", dateOfVaccination=");
        stringBuilder.append(this.dateOfVaccination);
        stringBuilder.append(", countryOfVaccination=");
        stringBuilder.append(this.countryOfVaccination);
        stringBuilder.append(", certificateIssuer=");
        stringBuilder.append(this.certificateIssuer);
        stringBuilder.append(", certificateIdentifier=");
        stringBuilder.append(this.certificateIdentifier);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

