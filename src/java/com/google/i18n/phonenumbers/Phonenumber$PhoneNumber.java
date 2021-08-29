/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.i18n.phonenumbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class Phonenumber$PhoneNumber
implements Serializable {
    public CountryCodeSource countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
    public int countryCode_ = 0;
    public String extension_ = "";
    public boolean hasCountryCodeSource;
    public boolean hasExtension;
    public boolean hasItalianLeadingZero;
    public boolean hasNumberOfLeadingZeros;
    public boolean hasPreferredDomesticCarrierCode;
    public boolean italianLeadingZero_ = false;
    public long nationalNumber_ = 0L;
    public int numberOfLeadingZeros_ = 1;
    public String preferredDomesticCarrierCode_ = "";
    public String rawInput_ = "";

    public boolean equals(Object object) {
        boolean bl;
        Phonenumber$PhoneNumber phonenumber$PhoneNumber;
        return object instanceof Phonenumber$PhoneNumber && (bl = (phonenumber$PhoneNumber = (Phonenumber$PhoneNumber)object) != null && (this == phonenumber$PhoneNumber || this.countryCode_ == phonenumber$PhoneNumber.countryCode_ && this.nationalNumber_ == phonenumber$PhoneNumber.nationalNumber_ && this.extension_.equals((Object)phonenumber$PhoneNumber.extension_) && this.italianLeadingZero_ == phonenumber$PhoneNumber.italianLeadingZero_ && this.numberOfLeadingZeros_ == phonenumber$PhoneNumber.numberOfLeadingZeros_ && this.rawInput_.equals((Object)phonenumber$PhoneNumber.rawInput_) && this.countryCodeSource_ == phonenumber$PhoneNumber.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals((Object)phonenumber$PhoneNumber.preferredDomesticCarrierCode_) && this.hasPreferredDomesticCarrierCode == phonenumber$PhoneNumber.hasPreferredDomesticCarrierCode));
    }

    public int hashCode() {
        int n3 = 53 * (53 * (2173 + this.countryCode_) + Long.valueOf((long)this.nationalNumber_).hashCode());
        int n4 = GeneratedOutlineSupport.outline3((String)this.extension_, (int)n3, (int)53);
        boolean bl = this.italianLeadingZero_;
        int n5 = 1231;
        int n6 = bl ? n5 : 1237;
        int n7 = 53 * (53 * (n4 + n6) + this.numberOfLeadingZeros_);
        int n8 = 53 * (GeneratedOutlineSupport.outline3((String)this.rawInput_, (int)n7, (int)53) + this.countryCodeSource_.hashCode());
        int n9 = GeneratedOutlineSupport.outline3((String)this.preferredDomesticCarrierCode_, (int)n8, (int)53);
        if (!this.hasPreferredDomesticCarrierCode) {
            n5 = 1237;
        }
        return n9 + n5;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Country Code: ");
        stringBuilder.append(this.countryCode_);
        stringBuilder.append(" National Number: ");
        stringBuilder.append(this.nationalNumber_);
        if (this.hasItalianLeadingZero && this.italianLeadingZero_) {
            stringBuilder.append(" Leading Zero(s): true");
        }
        if (this.hasNumberOfLeadingZeros) {
            stringBuilder.append(" Number of leading zeros: ");
            stringBuilder.append(this.numberOfLeadingZeros_);
        }
        if (this.hasExtension) {
            stringBuilder.append(" Extension: ");
            stringBuilder.append(this.extension_);
        }
        if (this.hasCountryCodeSource) {
            stringBuilder.append(" Country Code Source: ");
            stringBuilder.append((Object)this.countryCodeSource_);
        }
        if (this.hasPreferredDomesticCarrierCode) {
            stringBuilder.append(" Preferred Domestic Carrier Code: ");
            stringBuilder.append(this.preferredDomesticCarrierCode_);
        }
        return stringBuilder.toString();
    }

    public static final class CountryCodeSource
    extends Enum<CountryCodeSource> {
        private static final /* synthetic */ CountryCodeSource[] $VALUES;
        public static final /* enum */ CountryCodeSource FROM_DEFAULT_COUNTRY;
        public static final /* enum */ CountryCodeSource FROM_NUMBER_WITHOUT_PLUS_SIGN;
        public static final /* enum */ CountryCodeSource FROM_NUMBER_WITH_IDD;
        public static final /* enum */ CountryCodeSource FROM_NUMBER_WITH_PLUS_SIGN;
        public static final /* enum */ CountryCodeSource UNSPECIFIED;

        public static {
            CountryCodeSource countryCodeSource;
            CountryCodeSource countryCodeSource2;
            CountryCodeSource countryCodeSource3;
            CountryCodeSource countryCodeSource4;
            CountryCodeSource countryCodeSource5;
            FROM_NUMBER_WITH_PLUS_SIGN = countryCodeSource = new CountryCodeSource();
            FROM_NUMBER_WITH_IDD = countryCodeSource5 = new CountryCodeSource();
            FROM_NUMBER_WITHOUT_PLUS_SIGN = countryCodeSource2 = new CountryCodeSource();
            FROM_DEFAULT_COUNTRY = countryCodeSource4 = new CountryCodeSource();
            UNSPECIFIED = countryCodeSource3 = new CountryCodeSource();
            $VALUES = new CountryCodeSource[]{countryCodeSource, countryCodeSource5, countryCodeSource2, countryCodeSource4, countryCodeSource3};
        }

        public static CountryCodeSource valueOf(String string) {
            return (CountryCodeSource)Enum.valueOf(CountryCodeSource.class, (String)string);
        }

        public static CountryCodeSource[] values() {
            return (CountryCodeSource[])$VALUES.clone();
        }
    }

}

