/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.internal.sdk.bar.Filesystem$CppProxy
 *  java.lang.Object
 */
package com.scandit.internal.sdk.bar;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import com.scandit.internal.sdk.bar.Filesystem;
import com.scandit.internal.sdk.bar.FilesystemInstance;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class Filesystem {
    public Filesystem() {
    }

    public static void setInstance(FilesystemInstance filesystemInstance) {
        CppProxy.setInstance((FilesystemInstance)filesystemInstance);
    }
}

