/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.internal.module.common.date.NativeDate;
import com.scandit.datacapture.core.internal.sdk.capture.NativeExpirationDateStatus;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeLicenseInfo {
    public abstract NativeDate getExpirationDate();

    public abstract NativeExpirationDateStatus getExpirationDateStatus();

    public abstract String toJson();
}

