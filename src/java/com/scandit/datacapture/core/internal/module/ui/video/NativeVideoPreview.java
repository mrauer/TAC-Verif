/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.ui.video;

import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.ui.video.NativePreviewShaderFormat;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeTextureBinding;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeVideoPreview {
    public abstract void draw(ArrayList<NativeTextureBinding> var1);

    public abstract int getCameraToPreviewRotation();

    public abstract Size2 getFrameSize();

    public abstract Size2 getViewSize();

    public abstract void setCameraToPreviewRotation(int var1);

    public abstract void setFrameSize(Size2 var1);

    public abstract void setInputFormat(NativePreviewShaderFormat var1);

    public abstract void setTextureCoordinateTransformation(ArrayList<Float> var1);

    public abstract void setViewSize(Size2 var1);
}

