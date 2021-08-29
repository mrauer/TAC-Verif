/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.uritemplate;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import com.github.fge.msgsimple.load.MessageBundleLoader;

public final class URITemplateMessageBundle
implements MessageBundleLoader {
    @Override
    public MessageBundle getBundle() {
        return PropertiesBundle.forPath("/com/github/fge/uritemplate/messages");
    }
}

