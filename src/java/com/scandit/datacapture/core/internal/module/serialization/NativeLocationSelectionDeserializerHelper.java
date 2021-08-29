/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.sdk.area.NativeNoLocationSelection;
import com.scandit.datacapture.core.internal.sdk.area.NativeRadiusLocationSelection;
import com.scandit.datacapture.core.internal.sdk.area.NativeRectangularLocationSelection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeLocationSelectionDeserializerHelper {
    public abstract NativeNoLocationSelection createNoLocationSelection();

    public abstract NativeRadiusLocationSelection createRadiusLocationSelection();

    public abstract NativeRectangularLocationSelection createRectangularLocationSelection();
}

