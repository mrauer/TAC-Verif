/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.framesave.NativeBurstFrameSaveConfiguration$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.framesave.FileFormat;
import com.scandit.datacapture.core.internal.module.framesave.NativeBurstFrameSaveConfiguration;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBurstFrameSaveConfiguration {
    public NativeBurstFrameSaveConfiguration() {
    }

    public static NativeBurstFrameSaveConfiguration forLocalStorage(String string, int n2, FileFormat fileFormat) {
        return CppProxy.forLocalStorage((String)string, (int)n2, (FileFormat)fileFormat);
    }

    public static NativeBurstFrameSaveConfiguration forRemoteStagingStorage(int n2, FileFormat fileFormat) {
        return CppProxy.forRemoteStagingStorage((int)n2, (FileFormat)fileFormat);
    }

    public static NativeBurstFrameSaveConfiguration forRemoteStorage(int n2, FileFormat fileFormat) {
        return CppProxy.forRemoteStorage((int)n2, (FileFormat)fileFormat);
    }
}

