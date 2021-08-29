/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeAimerViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeLaserlineViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeNoViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeSpotlightViewfinder;
import com.scandit.datacapture.core.ui.viewfinder.LaserlineViewfinderStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderLineStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderStyle;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeViewfinderDeserializerHelper {
    public abstract NativeAimerViewfinder createAimerViewfinder();

    public abstract NativeLaserlineViewfinder createLaserlineViewfinder(LaserlineViewfinderStyle var1);

    public abstract NativeNoViewfinder createNoViewfinder();

    public abstract NativeRectangularViewfinder createRectangularViewfinder(RectangularViewfinderStyle var1, RectangularViewfinderLineStyle var2);

    public abstract NativeSpotlightViewfinder createSpotlightViewfinder();
}

