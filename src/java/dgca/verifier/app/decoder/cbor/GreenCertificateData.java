/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.cbor;

import com.android.tools.r8.GeneratedOutlineSupport;
import dgca.verifier.app.decoder.model.GreenCertificate;
import j$.time.ZonedDateTime;
import kotlin.jvm.internal.Intrinsics;

public final class GreenCertificateData {
    public final ZonedDateTime expirationTime;
    public final GreenCertificate greenCertificate;
    public final String hcertJson;
    public final ZonedDateTime issuedAt;
    public final String issuingCountry;

    public GreenCertificateData(String string, String string2, GreenCertificate greenCertificate, ZonedDateTime zonedDateTime, ZonedDateTime zonedDateTime2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"hcertJson");
        Intrinsics.checkNotNullParameter((Object)greenCertificate, (String)"greenCertificate");
        Intrinsics.checkNotNullParameter((Object)zonedDateTime, (String)"issuedAt");
        Intrinsics.checkNotNullParameter((Object)zonedDateTime2, (String)"expirationTime");
        this.issuingCountry = string;
        this.hcertJson = string2;
        this.greenCertificate = greenCertificate;
        this.issuedAt = zonedDateTime;
        this.expirationTime = zonedDateTime2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GreenCertificateData)) {
            return false;
        }
        GreenCertificateData greenCertificateData = (GreenCertificateData)object;
        if (!Intrinsics.areEqual((Object)this.issuingCountry, (Object)greenCertificateData.issuingCountry)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hcertJson, (Object)greenCertificateData.hcertJson)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.greenCertificate, (Object)greenCertificateData.greenCertificate)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.issuedAt, (Object)greenCertificateData.issuedAt)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.expirationTime, (Object)greenCertificateData.expirationTime);
    }

    public int hashCode() {
        String string = this.issuingCountry;
        int n2 = string == null ? 0 : string.hashCode();
        int n3 = n2 * 31;
        return 31 * (31 * (GeneratedOutlineSupport.outline3((String)this.hcertJson, (int)n3, (int)31) + this.greenCertificate.hashCode()) + this.issuedAt.hashCode()) + this.expirationTime.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"GreenCertificateData(issuingCountry=");
        stringBuilder.append((Object)this.issuingCountry);
        stringBuilder.append(", hcertJson=");
        stringBuilder.append(this.hcertJson);
        stringBuilder.append(", greenCertificate=");
        stringBuilder.append((Object)this.greenCertificate);
        stringBuilder.append(", issuedAt=");
        stringBuilder.append((Object)this.issuedAt);
        stringBuilder.append(", expirationTime=");
        stringBuilder.append((Object)this.expirationTime);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

