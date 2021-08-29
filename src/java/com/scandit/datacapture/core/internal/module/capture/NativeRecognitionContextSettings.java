/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.capture;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public final class NativeRecognitionContextSettings {
    public final String applicationId;
    public final boolean delayedRegistration;
    public final String deviceId;
    public final String deviceModelName;
    public final String deviceName;
    public final String externalId;
    public final String frameworkName;
    public final String licenseKey;
    public final String platform;
    public final String platformVersion;
    public final ArrayList<String> signatureHashes;
    public final String writableAbsolutePath;

    public NativeRecognitionContextSettings(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, ArrayList<String> arrayList, boolean bl) {
        this.licenseKey = string;
        this.writableAbsolutePath = string2;
        this.platform = string3;
        this.platformVersion = string4;
        this.frameworkName = string5;
        this.deviceModelName = string6;
        this.applicationId = string7;
        this.deviceName = string8;
        this.deviceId = string9;
        this.externalId = string10;
        this.signatureHashes = arrayList;
        this.delayedRegistration = bl;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeRecognitionContextSettings)) {
            return false;
        }
        NativeRecognitionContextSettings nativeRecognitionContextSettings = (NativeRecognitionContextSettings)object;
        return this.licenseKey.equals((Object)nativeRecognitionContextSettings.licenseKey) && this.writableAbsolutePath.equals((Object)nativeRecognitionContextSettings.writableAbsolutePath) && this.platform.equals((Object)nativeRecognitionContextSettings.platform) && this.platformVersion.equals((Object)nativeRecognitionContextSettings.platformVersion) && this.frameworkName.equals((Object)nativeRecognitionContextSettings.frameworkName) && this.deviceModelName.equals((Object)nativeRecognitionContextSettings.deviceModelName) && this.applicationId.equals((Object)nativeRecognitionContextSettings.applicationId) && this.deviceName.equals((Object)nativeRecognitionContextSettings.deviceName) && this.deviceId.equals((Object)nativeRecognitionContextSettings.deviceId) && this.externalId.equals((Object)nativeRecognitionContextSettings.externalId) && this.signatureHashes.equals(nativeRecognitionContextSettings.signatureHashes) && this.delayedRegistration == nativeRecognitionContextSettings.delayedRegistration;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final boolean getDelayedRegistration() {
        return this.delayedRegistration;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceModelName() {
        return this.deviceModelName;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getFrameworkName() {
        return this.frameworkName;
    }

    public final String getLicenseKey() {
        return this.licenseKey;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getPlatformVersion() {
        return this.platformVersion;
    }

    public final ArrayList<String> getSignatureHashes() {
        return this.signatureHashes;
    }

    public final String getWritableAbsolutePath() {
        return this.writableAbsolutePath;
    }

    public final int hashCode() {
        int n2 = GeneratedOutlineSupport.outline3((String)this.licenseKey, (int)527, (int)31);
        int n3 = GeneratedOutlineSupport.outline3((String)this.writableAbsolutePath, (int)n2, (int)31);
        int n4 = GeneratedOutlineSupport.outline3((String)this.platform, (int)n3, (int)31);
        int n5 = GeneratedOutlineSupport.outline3((String)this.platformVersion, (int)n4, (int)31);
        int n6 = GeneratedOutlineSupport.outline3((String)this.frameworkName, (int)n5, (int)31);
        int n7 = GeneratedOutlineSupport.outline3((String)this.deviceModelName, (int)n6, (int)31);
        int n8 = GeneratedOutlineSupport.outline3((String)this.applicationId, (int)n7, (int)31);
        int n9 = GeneratedOutlineSupport.outline3((String)this.deviceName, (int)n8, (int)31);
        int n10 = GeneratedOutlineSupport.outline3((String)this.deviceId, (int)n9, (int)31);
        return 31 * (GeneratedOutlineSupport.outline3((String)this.externalId, (int)n10, (int)31) + this.signatureHashes.hashCode()) + this.delayedRegistration;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeRecognitionContextSettings{licenseKey=");
        stringBuilder.append(this.licenseKey);
        stringBuilder.append(",writableAbsolutePath=");
        stringBuilder.append(this.writableAbsolutePath);
        stringBuilder.append(",platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(",platformVersion=");
        stringBuilder.append(this.platformVersion);
        stringBuilder.append(",frameworkName=");
        stringBuilder.append(this.frameworkName);
        stringBuilder.append(",deviceModelName=");
        stringBuilder.append(this.deviceModelName);
        stringBuilder.append(",applicationId=");
        stringBuilder.append(this.applicationId);
        stringBuilder.append(",deviceName=");
        stringBuilder.append(this.deviceName);
        stringBuilder.append(",deviceId=");
        stringBuilder.append(this.deviceId);
        stringBuilder.append(",externalId=");
        stringBuilder.append(this.externalId);
        stringBuilder.append(",signatureHashes=");
        stringBuilder.append(this.signatureHashes);
        stringBuilder.append(",delayedRegistration=");
        stringBuilder.append(this.delayedRegistration);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

