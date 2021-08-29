/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.IdentityHashMap
 *  java.util.Map
 */
package com.github.fge.msgsimple.load;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundleLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.IdentityHashMap;
import java.util.Map;

public final class MessageBundles {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public static final Map<Class<? extends MessageBundleLoader>, MessageBundle> BUNDLES = new IdentityHashMap();

    public static MessageBundle doGetBundle(Class<? extends MessageBundleLoader> class_) {
        Constructor constructor;
        MessageBundleLoader messageBundleLoader;
        InternalBundle internalBundle = BUNDLE;
        String string = (String)internalBundle.messages.get((Object)"factory.noConstructor");
        try {
            constructor = class_.getConstructor(new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException(string, (Throwable)noSuchMethodException);
        }
        String string2 = (String)internalBundle.messages.get((Object)"factory.cannotInstantiate");
        try {
            messageBundleLoader = (MessageBundleLoader)constructor.newInstance(new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(string2, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(string2, (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(string2, (Throwable)instantiationException);
        }
        MessageBundle messageBundle = messageBundleLoader.getBundle();
        internalBundle.checkNotNull(messageBundle, "factory.illegalProvider");
        return messageBundle;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MessageBundle getBundle(Class<? extends MessageBundleLoader> class_) {
        Class<MessageBundles> class_2 = MessageBundles.class;
        synchronized (MessageBundles.class) {
            Map<Class<? extends MessageBundleLoader>, MessageBundle> map = BUNDLES;
            MessageBundle messageBundle = (MessageBundle)map.get(class_);
            if (messageBundle == null) {
                messageBundle = MessageBundles.doGetBundle(class_);
                map.put(class_, (Object)messageBundle);
            }
            // ** MonitorExit[var5_1] (shouldn't be in output)
            return messageBundle;
        }
    }
}

