/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeViewfinderDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeViewfinderDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeViewfinderDeserializerHelper;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeViewfinderDeserializer {
    public NativeViewfinderDeserializer() {
    }

    public static NativeViewfinderDeserializer create() {
        return CppProxy.create();
    }

    public abstract NativeViewfinderDeserializerHelper getHelper();

    public abstract ArrayList<String> getWarnings();

    public abstract void setHelper(NativeViewfinderDeserializerHelper var1);

    public abstract NativeViewfinder viewfinderFromJson(NativeJsonValue var1);
}

