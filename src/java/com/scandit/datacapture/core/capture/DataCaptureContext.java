/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 *  android.content.res.AssetManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.capture.DataCaptureContext$a
 *  com.scandit.datacapture.core.capture.DataCaptureContext$b
 *  com.scandit.datacapture.core.capture.DataCaptureContext$c
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter
 *  com.scandit.datacapture.core.internal.module.capture.a
 *  com.scandit.datacapture.core.internal.module.capture.a$a
 *  com.scandit.datacapture.core.internal.sdk.capture.AssetResourceLoader
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener$1
 *  java.io.File
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.UUID
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.scandit.datacapture.core.capture;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.provider.Settings;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextFrameListener;
import com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter;
import com.scandit.datacapture.core.capture.DataCaptureContextListener;
import com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter;
import com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter;
import com.scandit.datacapture.core.capture.DataCaptureContextSettings;
import com.scandit.datacapture.core.capture.DataCaptureContextSettingsProxyAdapter;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.internal.module.capture.NativeDeviceIdUtils;
import com.scandit.datacapture.core.internal.module.capture.a;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.datacapture.core.internal.sdk.capture.AssetResourceLoader;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextFrameListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeResourceLoader;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/*
 * Exception performing whole class analysis.
 */
public final class DataCaptureContext {
    public static final Companion Companion;
    public FrameSource a;
    public final Set<DataCaptureMode> b;
    public final Object c;
    public boolean d;
    public final CopyOnWriteArraySet<DataCaptureContextListener> e;
    public final CopyOnWriteArraySet<DataCaptureContextFrameListener> f;
    public final DataCaptureContextProxyAdapter g;

    public static {
        Companion = new Companion(null);
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            String string;
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.scandit.device_id", 0);
            String string2 = sharedPreferences.getString("device_id", null);
            if (string2 == null) {
                String string3 = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
                string = null;
                if (string3 != null) {
                    int n2 = string3.length();
                    string = null;
                    if (n2 >= 16) {
                        string = string3;
                    }
                }
            } else {
                string = string2;
            }
            if (string == null) {
                String string4 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"UUID.randomUUID().toString()");
                string = GeneratedOutlineSupport.outline18((String)"bad1d000", (String)StringsKt__IndentKt.replace$default((String)string4, (String)"-", (String)"", (boolean)false, (int)4));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("device_id", string);
                editor.apply();
            }
            Intrinsics.checkNotNullExpressionValue((Object)NativeDeviceIdUtils.hashDeviceId(string), (String)"NativeDeviceIdUtils.hash\u2026.generate()\n            )");
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }

    public DataCaptureContext(String string, String string2, String string3, String string4, String string5, DataCaptureContextSettings dataCaptureContextSettings, DefaultConstructorMarker defaultConstructorMarker) {
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            File file = context.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue((Object)file, (String)"with(AppAndroidEnvironme\u2026          }\n            }");
            String string6 = file.getAbsolutePath();
            String string7 = Build.VERSION.RELEASE;
            String string8 = Build.MODEL;
            Context context2 = AppAndroidEnvironment.applicationContext;
            if (context2 != null) {
                String string9 = context2.getPackageName();
                Context context3 = AppAndroidEnvironment.applicationContext;
                if (context3 != null) {
                    String string10;
                    Intrinsics.checkNotNullParameter((Object)context3, (String)"context");
                    SharedPreferences sharedPreferences = context3.getSharedPreferences("com.scandit.device_id", 0);
                    String string11 = sharedPreferences.getString("device_id", null);
                    if (string11 == null && ((string11 = Settings.Secure.getString((ContentResolver)context3.getContentResolver(), (String)"android_id")) == null || string11.length() < 16)) {
                        string11 = null;
                    }
                    if (string11 == null) {
                        String string12 = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue((Object)string12, (String)"UUID.randomUUID().toString()");
                        String string13 = GeneratedOutlineSupport.outline18((String)"bad1d000", (String)StringsKt__IndentKt.replace$default((String)string12, (String)"-", (String)"", (boolean)false, (int)4));
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("device_id", string13);
                        editor.apply();
                        string10 = string13;
                    } else {
                        string10 = string11;
                    }
                    String string14 = string4 == null ? "" : string4;
                    String string15 = string5 == null ? "" : string5;
                    Context context4 = AppAndroidEnvironment.applicationContext;
                    if (context4 != null) {
                        Intrinsics.checkNotNullParameter((Object)context4, (String)"context");
                        int n2 = Build.VERSION.SDK_INT;
                        Signature[] arrsignature = null;
                        if (n2 >= 28) {
                            SigningInfo signingInfo = context4.getPackageManager().getPackageInfo((String)context4.getPackageName(), (int)134217728).signingInfo;
                            arrsignature = null;
                            if (signingInfo != null) {
                                if (signingInfo.hasMultipleSigners()) {
                                    arrsignature = signingInfo.getApkContentsSigners();
                                } else {
                                    Object[] arrobject = signingInfo.getSigningCertificateHistory();
                                    Intrinsics.checkNotNullExpressionValue((Object)arrobject, (String)"signingInfo.signingCertificateHistory");
                                    Signature signature = (Signature)R.style.firstOrNull((Object[])arrobject);
                                    arrsignature = null;
                                    if (signature != null) {
                                        arrsignature = new Signature[]{signature};
                                    }
                                }
                            }
                        }
                        if (arrsignature == null) {
                            arrsignature = context4.getPackageManager().getPackageInfo((String)context4.getPackageName(), (int)64).signatures;
                        }
                        if (arrsignature == null) {
                            arrsignature = new Signature[]{};
                        }
                        List list = R.style.filterNotNull(arrsignature);
                        ArrayList arrayList = new ArrayList(R.style.collectionSizeOrDefault((Iterable)list, (int)10));
                        Iterator iterator = ((ArrayList)list).iterator();
                        while (iterator.hasNext()) {
                            Signature signature = (Signature)iterator.next();
                            byte[] arrby = MessageDigest.getInstance((String)"SHA-1").digest(signature.toByteArray());
                            Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"MessageDigest.getInstanc\u2026(signature.toByteArray())");
                            a.a a2 = a.a.a;
                            Intrinsics.checkNotNullParameter((Object)arrby, (String)"$this$joinToString");
                            Intrinsics.checkNotNullParameter((Object)"", (String)"separator");
                            Iterator iterator2 = iterator;
                            Intrinsics.checkNotNullParameter((Object)"", (String)"prefix");
                            Intrinsics.checkNotNullParameter((Object)"", (String)"postfix");
                            String string16 = string15;
                            Intrinsics.checkNotNullParameter((Object)"...", (String)"truncated");
                            String string17 = string14;
                            StringBuilder stringBuilder = new StringBuilder();
                            String string18 = string10;
                            Intrinsics.checkNotNullParameter((Object)arrby, (String)"$this$joinTo");
                            Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"buffer");
                            Intrinsics.checkNotNullParameter((Object)"", (String)"separator");
                            Intrinsics.checkNotNullParameter((Object)"", (String)"prefix");
                            Intrinsics.checkNotNullParameter((Object)"", (String)"postfix");
                            Intrinsics.checkNotNullParameter((Object)"...", (String)"truncated");
                            stringBuilder.append((CharSequence)"");
                            int n3 = arrby.length;
                            int n4 = 0;
                            for (int i2 = 0; i2 < n3; ++i2) {
                                byte by = arrby[i2];
                                if (++n4 > 1) {
                                    stringBuilder.append((CharSequence)"");
                                }
                                if (a2 != null) {
                                    stringBuilder.append((CharSequence)a2.invoke((Object)by));
                                    continue;
                                }
                                stringBuilder.append((CharSequence)String.valueOf((int)by));
                            }
                            stringBuilder.append((CharSequence)"");
                            String string19 = stringBuilder.toString();
                            Intrinsics.checkNotNullExpressionValue((Object)string19, (String)"joinTo(StringBuilder(), \u2026ed, transform).toString()");
                            arrayList.add((Object)string19);
                            iterator = iterator2;
                            string15 = string16;
                            string14 = string17;
                            string10 = string18;
                        }
                        String string20 = string10;
                        String string21 = string14;
                        String string22 = string15;
                        ArrayList arrayList2 = new ArrayList((Collection)arrayList);
                        Context context5 = AppAndroidEnvironment.applicationContext;
                        if (context5 != null) {
                            Object object;
                            CopyOnWriteArraySet copyOnWriteArraySet;
                            AssetManager assetManager = context5.getAssets();
                            Intrinsics.checkNotNullExpressionValue((Object)assetManager, (String)"AppAndroidEnvironment.applicationContext.assets");
                            NativeDataCaptureContext nativeDataCaptureContext = NativeDataCaptureContext.createWithDeviceName(string, string6, string7, string2, string3, string8, string9, string20, string21, string22, (ArrayList<String>)arrayList2, (NativeResourceLoader)new AssetResourceLoader(assetManager), false, dataCaptureContextSettings.a.a);
                            Intrinsics.checkNotNullExpressionValue((Object)nativeDataCaptureContext, (String)"NativeDataCaptureContext\u2026   settings._impl()\n    )");
                            DataCaptureContextProxyAdapter dataCaptureContextProxyAdapter = new DataCaptureContextProxyAdapter(nativeDataCaptureContext, null, 2);
                            Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"impl");
                            Intrinsics.checkNotNullParameter((Object)dataCaptureContextProxyAdapter, (String)"adapter");
                            this.g = dataCaptureContextProxyAdapter;
                            this.b = new LinkedHashSet();
                            this.c = object = new Object();
                            this.e = copyOnWriteArraySet = new CopyOnWriteArraySet();
                            this.f = new CopyOnWriteArraySet();
                            Intrinsics.checkNotNullParameter((Object)this, (String)"dataCaptureContext");
                            Intrinsics.checkNotNullParameter((Object)this, (String)"dataCaptureContext");
                            nativeDataCaptureContext.addListenerAsync((NativeDataCaptureContextListener)new DataCaptureContextListenerReversedAdapter((DataCaptureContextListener)new /* Unavailable Anonymous Inner Class!! */, this, null, 4), NativeDataCaptureContext.getListenerPriorityUser());
                            nativeDataCaptureContext.addFrameListenerAsync((NativeDataCaptureContextFrameListener)new DataCaptureContextFrameListenerReversedAdapter((DataCaptureContextFrameListener)new /* Unavailable Anonymous Inner Class!! */, this, null, 4));
                            Object object2 = object;
                            synchronized (object2) {
                                copyOnWriteArraySet.add((Object)new /* Unavailable Anonymous Inner Class!! */);
                                return;
                            }
                        }
                        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void addListener(DataCaptureContextListener dataCaptureContextListener2) {
        Object object;
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)dataCaptureContextListener2, (String)"listener");
        Object object2 = object = this.c;
        synchronized (object2) {
            if (!this.e.add((Object)dataCaptureContextListener2)) return;
            bl = this.d;
        }
        if (!bl) return;
        ((DataCaptureView.dataCaptureContextListener.1)dataCaptureContextListener2).onObservationStarted(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void removeListener(DataCaptureContextListener dataCaptureContextListener2) {
        Object object;
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)dataCaptureContextListener2, (String)"listener");
        Object object2 = object = this.c;
        synchronized (object2) {
            if (!this.e.remove((Object)dataCaptureContextListener2)) return;
            bl = this.d;
        }
        if (!bl) return;
        ((DataCaptureView.dataCaptureContextListener.1)dataCaptureContextListener2).onObservationStopped(this);
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

}

