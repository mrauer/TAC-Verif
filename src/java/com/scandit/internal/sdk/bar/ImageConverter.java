/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.internal.sdk.bar.ImageConverter$CppProxy
 *  java.lang.Object
 */
package com.scandit.internal.sdk.bar;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import com.scandit.internal.sdk.bar.ImageConverter;
import com.scandit.internal.sdk.bar.ImageConverterInstance;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class ImageConverter {
    public ImageConverter() {
    }

    public static ImageConverterInstance getInstance() {
        return CppProxy.getInstance();
    }

    public static void setInstance(ImageConverterInstance imageConverterInstance) {
        CppProxy.setInstance((ImageConverterInstance)imageConverterInstance);
    }
}

