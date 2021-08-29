/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.framesave.NativeSequenceFrameSaveConfiguration$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.framesave.FileFormat;
import com.scandit.datacapture.core.internal.module.framesave.NativeSequenceFrameSaveConfiguration;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSequenceFrameSaveConfiguration {
    public NativeSequenceFrameSaveConfiguration() {
    }

    public static NativeSequenceFrameSaveConfiguration forLocalStorage(String string, String string2, FileFormat fileFormat) {
        return CppProxy.forLocalStorage((String)string, (String)string2, (FileFormat)fileFormat);
    }

    public static NativeSequenceFrameSaveConfiguration forRemoteStagingStorage(String string, FileFormat fileFormat) {
        return CppProxy.forRemoteStagingStorage((String)string, (FileFormat)fileFormat);
    }

    public static NativeSequenceFrameSaveConfiguration forRemoteStorage(String string, FileFormat fileFormat) {
        return CppProxy.forRemoteStorage((String)string, (FileFormat)fileFormat);
    }
}

