/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.internal.sdk.data;

import com.scandit.datacapture.barcode.data.CompositeFlag;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.core.common.buffer.EncodingRange;
import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeBarcode {
    public abstract String getAddOnData();

    public abstract String getCompositeData();

    public abstract CompositeFlag getCompositeFlag();

    public abstract byte[] getCompositeRawData();

    public abstract byte[] getData();

    public abstract ArrayList<EncodingRange> getDataEncoding();

    public abstract int getFrameId();

    public abstract Quadrilateral getLocation();

    public abstract int getSymbolCount();

    public abstract Symbology getSymbology();

    public abstract String getUtf8String();

    public abstract boolean isColorInverted();

    public abstract boolean isGs1DataCarrier();

    public abstract String toJson();
}

