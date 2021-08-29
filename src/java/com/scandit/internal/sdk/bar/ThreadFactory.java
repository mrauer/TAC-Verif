/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.internal.sdk.bar.ThreadFactory$CppProxy
 *  java.lang.Object
 */
package com.scandit.internal.sdk.bar;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import com.scandit.internal.sdk.bar.HandlerThreadCreator;
import com.scandit.internal.sdk.bar.ThreadFactory;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class ThreadFactory {
    public ThreadFactory() {
    }

    public static HandlerThreadCreator getFactory() {
        return CppProxy.getFactory();
    }

    public static void setFactory(HandlerThreadCreator handlerThreadCreator) {
        CppProxy.setFactory((HandlerThreadCreator)handlerThreadCreator);
    }
}

