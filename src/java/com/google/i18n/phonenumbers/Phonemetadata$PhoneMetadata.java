/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata$NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadata
implements Externalizable {
    public Phonemetadata$PhoneNumberDesc carrierSpecific_ = null;
    public int countryCode_ = 0;
    public Phonemetadata$PhoneNumberDesc emergency_ = null;
    public Phonemetadata$PhoneNumberDesc fixedLine_ = null;
    public Phonemetadata$PhoneNumberDesc generalDesc_ = null;
    public boolean hasCarrierSpecific;
    public boolean hasEmergency;
    public boolean hasFixedLine;
    public boolean hasGeneralDesc;
    public boolean hasLeadingDigits;
    public boolean hasMobile;
    public boolean hasNationalPrefix;
    public boolean hasNationalPrefixForParsing;
    public boolean hasNationalPrefixTransformRule;
    public boolean hasNoInternationalDialling;
    public boolean hasPager;
    public boolean hasPersonalNumber;
    public boolean hasPreferredExtnPrefix;
    public boolean hasPreferredInternationalPrefix;
    public boolean hasPremiumRate;
    public boolean hasSharedCost;
    public boolean hasShortCode;
    public boolean hasSmsServices;
    public boolean hasStandardRate;
    public boolean hasTollFree;
    public boolean hasUan;
    public boolean hasVoicemail;
    public boolean hasVoip;
    public String id_ = "";
    public String internationalPrefix_ = "";
    public List<Phonemetadata$NumberFormat> intlNumberFormat_ = new ArrayList();
    public String leadingDigits_ = "";
    public boolean leadingZeroPossible_ = false;
    public boolean mainCountryForCode_ = false;
    public boolean mobileNumberPortableRegion_ = false;
    public Phonemetadata$PhoneNumberDesc mobile_ = null;
    public String nationalPrefixForParsing_ = "";
    public String nationalPrefixTransformRule_ = "";
    public String nationalPrefix_ = "";
    public Phonemetadata$PhoneNumberDesc noInternationalDialling_ = null;
    public List<Phonemetadata$NumberFormat> numberFormat_ = new ArrayList();
    public Phonemetadata$PhoneNumberDesc pager_ = null;
    public Phonemetadata$PhoneNumberDesc personalNumber_ = null;
    public String preferredExtnPrefix_ = "";
    public String preferredInternationalPrefix_ = "";
    public Phonemetadata$PhoneNumberDesc premiumRate_ = null;
    public boolean sameMobileAndFixedLinePattern_ = false;
    public Phonemetadata$PhoneNumberDesc sharedCost_ = null;
    public Phonemetadata$PhoneNumberDesc shortCode_ = null;
    public Phonemetadata$PhoneNumberDesc smsServices_ = null;
    public Phonemetadata$PhoneNumberDesc standardRate_ = null;
    public Phonemetadata$PhoneNumberDesc tollFree_ = null;
    public Phonemetadata$PhoneNumberDesc uan_ = null;
    public Phonemetadata$PhoneNumberDesc voicemail_ = null;
    public Phonemetadata$PhoneNumberDesc voip_ = null;

    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasGeneralDesc = true;
            this.generalDesc_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasFixedLine = true;
            this.fixedLine_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasMobile = true;
            this.mobile_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasTollFree = true;
            this.tollFree_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasPremiumRate = true;
            this.premiumRate_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasSharedCost = true;
            this.sharedCost_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasPersonalNumber = true;
            this.personalNumber_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasVoip = true;
            this.voip_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasPager = true;
            this.pager_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasUan = true;
            this.uan_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasEmergency = true;
            this.emergency_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasVoicemail = true;
            this.voicemail_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasShortCode = true;
            this.shortCode_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasStandardRate = true;
            this.standardRate_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasCarrierSpecific = true;
            this.carrierSpecific_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasSmsServices = true;
            this.smsServices_ = phonemetadata$PhoneNumberDesc;
        }
        if (objectInput.readBoolean()) {
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = new Phonemetadata$PhoneNumberDesc();
            phonemetadata$PhoneNumberDesc.readExternal(objectInput);
            this.hasNoInternationalDialling = true;
            this.noInternationalDialling_ = phonemetadata$PhoneNumberDesc;
        }
        this.id_ = objectInput.readUTF();
        this.countryCode_ = objectInput.readInt();
        this.internationalPrefix_ = objectInput.readUTF();
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasPreferredInternationalPrefix = true;
            this.preferredInternationalPrefix_ = string;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasNationalPrefix = true;
            this.nationalPrefix_ = string;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasPreferredExtnPrefix = true;
            this.preferredExtnPrefix_ = string;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasNationalPrefixForParsing = true;
            this.nationalPrefixForParsing_ = string;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasNationalPrefixTransformRule = true;
            this.nationalPrefixTransformRule_ = string;
        }
        this.sameMobileAndFixedLinePattern_ = objectInput.readBoolean();
        int n3 = objectInput.readInt();
        int n4 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat.readExternal(objectInput);
            this.numberFormat_.add((Object)phonemetadata$NumberFormat);
        }
        int n5 = objectInput.readInt();
        while (n4 < n5) {
            Phonemetadata$NumberFormat phonemetadata$NumberFormat = new Phonemetadata$NumberFormat();
            phonemetadata$NumberFormat.readExternal(objectInput);
            this.intlNumberFormat_.add((Object)phonemetadata$NumberFormat);
            ++n4;
        }
        this.mainCountryForCode_ = objectInput.readBoolean();
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasLeadingDigits = true;
            this.leadingDigits_ = string;
        }
        this.leadingZeroPossible_ = objectInput.readBoolean();
        this.mobileNumberPortableRegion_ = objectInput.readBoolean();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasGeneralDesc);
        if (this.hasGeneralDesc) {
            this.generalDesc_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasFixedLine);
        if (this.hasFixedLine) {
            this.fixedLine_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasMobile);
        if (this.hasMobile) {
            this.mobile_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasTollFree);
        if (this.hasTollFree) {
            this.tollFree_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPremiumRate);
        if (this.hasPremiumRate) {
            this.premiumRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSharedCost);
        if (this.hasSharedCost) {
            this.sharedCost_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPersonalNumber);
        if (this.hasPersonalNumber) {
            this.personalNumber_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoip);
        if (this.hasVoip) {
            this.voip_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasPager);
        if (this.hasPager) {
            this.pager_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasUan);
        if (this.hasUan) {
            this.uan_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasEmergency);
        if (this.hasEmergency) {
            this.emergency_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasVoicemail);
        if (this.hasVoicemail) {
            this.voicemail_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasShortCode);
        if (this.hasShortCode) {
            this.shortCode_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasStandardRate);
        if (this.hasStandardRate) {
            this.standardRate_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasCarrierSpecific);
        if (this.hasCarrierSpecific) {
            this.carrierSpecific_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasSmsServices);
        if (this.hasSmsServices) {
            this.smsServices_.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.hasNoInternationalDialling);
        if (this.hasNoInternationalDialling) {
            this.noInternationalDialling_.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.id_);
        objectOutput.writeInt(this.countryCode_);
        objectOutput.writeUTF(this.internationalPrefix_);
        objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
        if (this.hasPreferredInternationalPrefix) {
            objectOutput.writeUTF(this.preferredInternationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefix);
        if (this.hasNationalPrefix) {
            objectOutput.writeUTF(this.nationalPrefix_);
        }
        objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
        if (this.hasPreferredExtnPrefix) {
            objectOutput.writeUTF(this.preferredExtnPrefix_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
        if (this.hasNationalPrefixForParsing) {
            objectOutput.writeUTF(this.nationalPrefixForParsing_);
        }
        objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
        if (this.hasNationalPrefixTransformRule) {
            objectOutput.writeUTF(this.nationalPrefixTransformRule_);
        }
        objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
        int n3 = this.numberFormat_.size();
        objectOutput.writeInt(n3);
        int n4 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            ((Phonemetadata$NumberFormat)this.numberFormat_.get(i3)).writeExternal(objectOutput);
        }
        int n5 = this.intlNumberFormat_.size();
        objectOutput.writeInt(n5);
        while (n4 < n5) {
            ((Phonemetadata$NumberFormat)this.intlNumberFormat_.get(n4)).writeExternal(objectOutput);
            ++n4;
        }
        objectOutput.writeBoolean(this.mainCountryForCode_);
        objectOutput.writeBoolean(this.hasLeadingDigits);
        if (this.hasLeadingDigits) {
            objectOutput.writeUTF(this.leadingDigits_);
        }
        objectOutput.writeBoolean(this.leadingZeroPossible_);
        objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
    }
}

