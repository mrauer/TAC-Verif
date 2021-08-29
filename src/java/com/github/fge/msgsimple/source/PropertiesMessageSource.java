/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Properties
 *  java.util.Set
 */
package com.github.fge.msgsimple.source;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.source.MessageSource;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class PropertiesMessageSource
implements MessageSource {
    public static final InternalBundle BUNDLE = InternalBundle.INSTANCE;
    public final Map<String, String> messages = new HashMap();

    public static {
        Charset.forName((String)"UTF-8");
    }

    public PropertiesMessageSource(Properties properties) {
        for (String string : properties.stringPropertyNames()) {
            this.messages.put((Object)string, (Object)properties.getProperty(string));
        }
    }

    @Override
    public String getKey(String string) {
        return (String)this.messages.get((Object)string);
    }
}

