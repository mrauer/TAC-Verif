/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.os.Build
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.scandit.datacapture.core.internal.module.b.a.a;

import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public interface b {
    public String a();

    public void a(Camera.Parameters var1, float var2, float var3);

    public boolean a(String var1);

    public e b();

    public NativeCameraApi c();

    public boolean d();

    public boolean e();

    public static final class a {
        public final EGLDisplay a;
        public final EGLContext b;
        public final EGLConfig c;
        public final EGLSurface d;

        public a() {
            EGLDisplay eGLDisplay = EGL14.eglGetDisplay((int)0);
            Intrinsics.checkNotNullExpressionValue((Object)eGLDisplay, (String)"eglGetDisplay(EGL_DEFAULT_DISPLAY)");
            this.a = eGLDisplay;
            boolean bl = eGLDisplay != EGL14.EGL_NO_DISPLAY;
            if (bl) {
                int[] arrn = new int[2];
                if (EGL14.eglInitialize((EGLDisplay)eGLDisplay, (int[])arrn, (int)0, (int[])arrn, (int)1)) {
                    int[] arrn2 = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 8, 12352, 4, 12344};
                    EGLConfig[] arreGLConfig = new EGLConfig[1];
                    EGLConfig eGLConfig = EGL14.eglChooseConfig((EGLDisplay)eGLDisplay, (int[])arrn2, (int)0, (EGLConfig[])arreGLConfig, (int)0, (int)1, (int[])new int[1], (int)0) ? arreGLConfig[0] : null;
                    if (eGLConfig != null) {
                        this.c = eGLConfig;
                        int[] arrn3 = new int[]{12440, 2, 12344};
                        EGLContext eGLContext = EGL14.eglCreateContext((EGLDisplay)eGLDisplay, (EGLConfig)eGLConfig, (EGLContext)EGL14.EGL_NO_CONTEXT, (int[])arrn3, (int)0);
                        Intrinsics.checkNotNullExpressionValue((Object)eGLContext, (String)"eglCreateContext(display\u2026_CONTEXT, attrib2List, 0)");
                        this.b = eGLContext;
                        a.w("eglCreateContext");
                        EGLSurface eGLSurface = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (EGLConfig)eGLConfig, (int[])new int[]{12375, 32, 12374, 32, 12344}, (int)0);
                        a.w("createOffscreenSurface");
                        Intrinsics.checkNotNullExpressionValue((Object)eGLSurface, (String)"surface");
                        this.d = eGLSurface;
                        return;
                    }
                    throw new IllegalStateException("Unable to find a suitable EGLConfig".toString());
                }
                throw new IllegalStateException("unable to initialize EGL14".toString());
            }
            throw new IllegalStateException("unable to get EGL14 display".toString());
        }

        public static String a() {
            String string = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"Build.MODEL");
            return a.a(string);
        }

        public static String a(String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"modelName");
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"Locale.ENGLISH");
            String string2 = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.String).toLowerCase(locale)");
            return StringsKt__IndentKt.trim((CharSequence)StringsKt__IndentKt.replace$default((String)string2, (String)"samsung-", (String)"", (boolean)false, (int)4)).toString();
        }

        public static boolean v(String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"model");
            return StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g715fn", (boolean)false, (int)2) || StringsKt__IndentKt.startsWith$default((String)string, (String)"sm-g715u1", (boolean)false, (int)2);
            {
            }
        }

        public static void w(String string) {
            int n2 = EGL14.eglGetError();
            boolean bl = n2 == 12288;
            if (bl) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(": ");
            com.scandit.datacapture.core.internal.module.d.a.values();
            StringBuilder stringBuilder2 = new StringBuilder("Unknown EGL error code: ");
            StringBuilder stringBuilder3 = new StringBuilder("0x");
            stringBuilder3.append(Integer.toHexString((int)n2));
            stringBuilder2.append(stringBuilder3.toString());
            throw new IllegalStateException(stringBuilder2.toString().toString());
        }

        public void c() {
            EGLDisplay eGLDisplay = this.a;
            EGLSurface eGLSurface = this.d;
            EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (EGLSurface)eGLSurface, (EGLSurface)eGLSurface, (EGLContext)this.b);
            a.w("makeCurrentWithoutSurface");
        }
    }

}

