/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.bundle.PropertiesBundle$1
 *  com.github.fge.msgsimple.provider.LoadingMessageSourceProvider
 *  com.github.fge.msgsimple.source.PropertiesMessageSource
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URL
 *  java.nio.charset.Charset
 *  java.util.Formatter
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Properties
 *  java.util.concurrent.Callable
 */
package com.github.fge.msgsimple.provider;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider;
import com.github.fge.msgsimple.provider.MessageSourceLoader;
import com.github.fge.msgsimple.source.MessageSource;
import com.github.fge.msgsimple.source.PropertiesMessageSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

public class LoadingMessageSourceProvider$2
implements Callable<MessageSource> {
    public final /* synthetic */ LoadingMessageSourceProvider this$0;
    public final /* synthetic */ Locale val$locale;

    public LoadingMessageSourceProvider$2(LoadingMessageSourceProvider loadingMessageSourceProvider, Locale locale) {
        this.this$0 = loadingMessageSourceProvider;
        this.val$locale = locale;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object call() throws Exception {
        var1_1 = this.this$0.loader;
        var2_2 = this.val$locale;
        var3_3 = (PropertiesBundle.1)var1_1;
        var4_4 = new StringBuilder(var3_3.val$realPath);
        if (!var2_2.equals((Object)Locale.ROOT)) {
            var4_4.append('_');
            var4_4.append(var2_2.toString());
        }
        var4_4.append(".properties");
        var6_5 = var4_4.toString();
        var7_6 = var3_3.val$charset;
        var8_7 = PropertiesMessageSource.BUNDLE;
        var8_7.checkNotNull(var6_5, "cfg.nullResourcePath");
        var10_8 = PropertiesMessageSource.class.getResource(var6_5);
        if (var10_8 == null) {
            var11_15 = new Object[]{var6_5};
            throw new IOException(new Formatter().format((String)var8_7.messages.get((Object)"properties.resource.notFound"), var11_15).toString());
        }
        var12_9 = var10_8.openStream();
        var8_7.checkNotNull(var12_9, "cfg.nullInputStream");
        var16_10 = new InputStreamReader(var12_9, var7_6);
        {
            catch (Throwable var13_14) {
                try {
                    var12_9.close();
                    throw var13_14;
                }
                catch (IOException v0) {}
                throw var13_14;
            }
        }
        try {
            var17_11 = new Properties();
            var17_11.load((Reader)var16_10);
            var20_12 = new PropertiesMessageSource(var17_11);
        }
        catch (Throwable var18_13) {
            try {
                var16_10.close();
                throw var18_13;
            }
            catch (IOException v1) {}
            throw var18_13;
        }
        try {
            var16_10.close();
            ** GOTO lbl-1000
        }
        catch (IOException v2) {
            try lbl-1000: // 2 sources:
            {
                var12_9.close();
                return var20_12;
            }
            catch (IOException v3) {}
        }
        return var20_12;
    }
}

