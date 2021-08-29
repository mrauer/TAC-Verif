/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeLocationSelectionDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeLocationSelectionDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeLocationSelectionDeserializerHelper;
import com.scandit.datacapture.core.internal.sdk.area.NativeLocationSelection;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeLocationSelectionDeserializer {
    public NativeLocationSelectionDeserializer() {
    }

    public static NativeLocationSelectionDeserializer create() {
        return CppProxy.create();
    }

    public abstract NativeLocationSelectionDeserializerHelper getHelper();

    public abstract ArrayList<String> getWarnings();

    public abstract NativeLocationSelection locationSelectionFromJson(NativeJsonValue var1);

    public abstract void setHelper(NativeLocationSelectionDeserializerHelper var1);
}

