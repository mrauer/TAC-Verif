/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.barcode.capture.BarcodeCapture
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureSettings
 *  com.scandit.datacapture.core.capture.DataCaptureContext
 *  com.scandit.datacapture.core.capture.DataCaptureContext$d
 *  com.scandit.datacapture.core.capture.DataCaptureContext$g
 *  com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter
 *  com.scandit.datacapture.core.capture.DataCaptureContextSettings
 *  com.scandit.datacapture.core.capture.DataCaptureMode
 *  com.scandit.datacapture.core.internal.module.source.CameraFactory
 *  com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy
 *  com.scandit.datacapture.core.internal.module.source.NativeFrameSource
 *  com.scandit.datacapture.core.internal.module.source.ab
 *  com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext
 *  com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode
 *  com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture
 *  com.scandit.datacapture.core.source.Camera
 *  com.scandit.datacapture.core.source.CameraPosition
 *  com.scandit.datacapture.core.source.CameraSettings
 *  com.scandit.datacapture.core.source.FocusGestureStrategy
 *  com.scandit.datacapture.core.source.FrameSource
 *  com.scandit.datacapture.tools.internal.sdk.ProxyCache
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Objects
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.ingroupe.verify.anticovid.camera;

import android.os.Build;
import com.google.android.material.R;
import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettings;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter;
import com.scandit.datacapture.core.capture.DataCaptureContextSettings;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.internal.module.source.CameraFactory;
import com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.module.source.ab;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.source.Camera;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.CameraSettings;
import com.scandit.datacapture.core.source.FocusGestureStrategy;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class DataCaptureManager {
    public static final DataCaptureManager CURRENT = new DataCaptureManager();
    public static final DataCaptureManager Companion;
    public final BarcodeCapture barcodeCapture;
    public Camera camera;
    public final DataCaptureContext dataCaptureContext;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public DataCaptureManager() {
        super();
        Intrinsics.checkNotNullParameter((Object)"AVZw+TifGjghLUEhqw/9cSIJ0uLrRopdL20rStN3H596YNrgQHrdWvVXF2bSY1ANJ0dnHIJgFFXdRJcko1W3RxhEDd3lfqKsmBK9tF1HFfpqWWZAHkL6HCBnmiYpTlxrCm2f9/MpZ1+lK9UlNBrEKmcKpP++C7H3JTjird3n0YmCvr0hIBXMtiaf60LzXE3vLAWHkcO1nmIM36HB4dwX3kRImr3ekwClxHGYjQPT9i3wsBnDEGGdfy86u9SvQL43Lzm7jvUtZvYpnwjn3pHUpp4OrvSdlhev0A6FvFJ0/y9gVIrVOLI+k9eLcgyjwb7IHlj602CuBaSGXkhGv0JT739D/Vn55wRx610Q1zZ599JCqTFJ8Fw3CWeh/7uHOYHmwZNty5e86ywiyVXxODlilo+6OKi7VZayk1w13WMISeH5c2J1tFyQWJ4acUY+xyUHEqD/6vxzH/nlns7aDXHXh/do8hm5Dxy8DM3Ec9ufx+dkU8x4ESt90VQChrSAyp0snFrhWy8Be43yT0+x1vg8SbYIv/u85sD1V+JZUAN+BUAloYF2PY+DcB8ypTTSaNFRSV++brLLc+z89kAJRzNujxShW6aojGvwuB1FZlUSZCbYMsK+f5xLb+boaX0MioLEudlJTzqLAzS1t0ZPd/vvemHksLZJoM74vrKJZMAmTdqlnKcd/6rnKPDI578tEaRXTNExUR5nZgqKrCqRWZD4Jb5itmIjkijwKy/G5htz2DEGNgZcJInpiEFKiZdOLgAMcHUGNfEEWsiOXpLwf2mlNVQQKfob3raDF0FopuvolBMkQTSZLgTnnP808Tykt0Yd1QIDb0SW", (String)"licenseKey");
        Intrinsics.checkNotNullParameter((Object)"AVZw+TifGjghLUEhqw/9cSIJ0uLrRopdL20rStN3H596YNrgQHrdWvVXF2bSY1ANJ0dnHIJgFFXdRJcko1W3RxhEDd3lfqKsmBK9tF1HFfpqWWZAHkL6HCBnmiYpTlxrCm2f9/MpZ1+lK9UlNBrEKmcKpP++C7H3JTjird3n0YmCvr0hIBXMtiaf60LzXE3vLAWHkcO1nmIM36HB4dwX3kRImr3ekwClxHGYjQPT9i3wsBnDEGGdfy86u9SvQL43Lzm7jvUtZvYpnwjn3pHUpp4OrvSdlhev0A6FvFJ0/y9gVIrVOLI+k9eLcgyjwb7IHlj602CuBaSGXkhGv0JT739D/Vn55wRx610Q1zZ599JCqTFJ8Fw3CWeh/7uHOYHmwZNty5e86ywiyVXxODlilo+6OKi7VZayk1w13WMISeH5c2J1tFyQWJ4acUY+xyUHEqD/6vxzH/nlns7aDXHXh/do8hm5Dxy8DM3Ec9ufx+dkU8x4ESt90VQChrSAyp0snFrhWy8Be43yT0+x1vg8SbYIv/u85sD1V+JZUAN+BUAloYF2PY+DcB8ypTTSaNFRSV++brLLc+z89kAJRzNujxShW6aojGvwuB1FZlUSZCbYMsK+f5xLb+boaX0MioLEudlJTzqLAzS1t0ZPd/vvemHksLZJoM74vrKJZMAmTdqlnKcd/6rnKPDI578tEaRXTNExUR5nZgqKrCqRWZD4Jb5itmIjkijwKy/G5htz2DEGNgZcJInpiEFKiZdOLgAMcHUGNfEEWsiOXpLwf2mlNVQQKfob3raDF0FopuvolBMkQTSZLgTnnP808Tykt0Yd1QIDb0SW", (String)"licenseKey");
        Intrinsics.checkNotNullParameter((Object)"AVZw+TifGjghLUEhqw/9cSIJ0uLrRopdL20rStN3H596YNrgQHrdWvVXF2bSY1ANJ0dnHIJgFFXdRJcko1W3RxhEDd3lfqKsmBK9tF1HFfpqWWZAHkL6HCBnmiYpTlxrCm2f9/MpZ1+lK9UlNBrEKmcKpP++C7H3JTjird3n0YmCvr0hIBXMtiaf60LzXE3vLAWHkcO1nmIM36HB4dwX3kRImr3ekwClxHGYjQPT9i3wsBnDEGGdfy86u9SvQL43Lzm7jvUtZvYpnwjn3pHUpp4OrvSdlhev0A6FvFJ0/y9gVIrVOLI+k9eLcgyjwb7IHlj602CuBaSGXkhGv0JT739D/Vn55wRx610Q1zZ599JCqTFJ8Fw3CWeh/7uHOYHmwZNty5e86ywiyVXxODlilo+6OKi7VZayk1w13WMISeH5c2J1tFyQWJ4acUY+xyUHEqD/6vxzH/nlns7aDXHXh/do8hm5Dxy8DM3Ec9ufx+dkU8x4ESt90VQChrSAyp0snFrhWy8Be43yT0+x1vg8SbYIv/u85sD1V+JZUAN+BUAloYF2PY+DcB8ypTTSaNFRSV++brLLc+z89kAJRzNujxShW6aojGvwuB1FZlUSZCbYMsK+f5xLb+boaX0MioLEudlJTzqLAzS1t0ZPd/vvemHksLZJoM74vrKJZMAmTdqlnKcd/6rnKPDI578tEaRXTNExUR5nZgqKrCqRWZD4Jb5itmIjkijwKy/G5htz2DEGNgZcJInpiEFKiZdOLgAMcHUGNfEEWsiOXpLwf2mlNVQQKfob3raDF0FopuvolBMkQTSZLgTnnP808Tykt0Yd1QIDb0SW", (String)"licenseKey");
        var2_1 = new DataCaptureContextSettings();
        Intrinsics.checkNotNullParameter((Object)"AVZw+TifGjghLUEhqw/9cSIJ0uLrRopdL20rStN3H596YNrgQHrdWvVXF2bSY1ANJ0dnHIJgFFXdRJcko1W3RxhEDd3lfqKsmBK9tF1HFfpqWWZAHkL6HCBnmiYpTlxrCm2f9/MpZ1+lK9UlNBrEKmcKpP++C7H3JTjird3n0YmCvr0hIBXMtiaf60LzXE3vLAWHkcO1nmIM36HB4dwX3kRImr3ekwClxHGYjQPT9i3wsBnDEGGdfy86u9SvQL43Lzm7jvUtZvYpnwjn3pHUpp4OrvSdlhev0A6FvFJ0/y9gVIrVOLI+k9eLcgyjwb7IHlj602CuBaSGXkhGv0JT739D/Vn55wRx610Q1zZ599JCqTFJ8Fw3CWeh/7uHOYHmwZNty5e86ywiyVXxODlilo+6OKi7VZayk1w13WMISeH5c2J1tFyQWJ4acUY+xyUHEqD/6vxzH/nlns7aDXHXh/do8hm5Dxy8DM3Ec9ufx+dkU8x4ESt90VQChrSAyp0snFrhWy8Be43yT0+x1vg8SbYIv/u85sD1V+JZUAN+BUAloYF2PY+DcB8ypTTSaNFRSV++brLLc+z89kAJRzNujxShW6aojGvwuB1FZlUSZCbYMsK+f5xLb+boaX0MioLEudlJTzqLAzS1t0ZPd/vvemHksLZJoM74vrKJZMAmTdqlnKcd/6rnKPDI578tEaRXTNExUR5nZgqKrCqRWZD4Jb5itmIjkijwKy/G5htz2DEGNgZcJInpiEFKiZdOLgAMcHUGNfEEWsiOXpLwf2mlNVQQKfob3raDF0FopuvolBMkQTSZLgTnnP808Tykt0Yd1QIDb0SW", (String)"licenseKey");
        Intrinsics.checkNotNullParameter((Object)"native", (String)"frameworkName");
        Intrinsics.checkNotNullParameter((Object)var2_1, (String)"settings");
        this.dataCaptureContext = var3_2 = new DataCaptureContext("AVZw+TifGjghLUEhqw/9cSIJ0uLrRopdL20rStN3H596YNrgQHrdWvVXF2bSY1ANJ0dnHIJgFFXdRJcko1W3RxhEDd3lfqKsmBK9tF1HFfpqWWZAHkL6HCBnmiYpTlxrCm2f9/MpZ1+lK9UlNBrEKmcKpP++C7H3JTjird3n0YmCvr0hIBXMtiaf60LzXE3vLAWHkcO1nmIM36HB4dwX3kRImr3ekwClxHGYjQPT9i3wsBnDEGGdfy86u9SvQL43Lzm7jvUtZvYpnwjn3pHUpp4OrvSdlhev0A6FvFJ0/y9gVIrVOLI+k9eLcgyjwb7IHlj602CuBaSGXkhGv0JT739D/Vn55wRx610Q1zZ599JCqTFJ8Fw3CWeh/7uHOYHmwZNty5e86ywiyVXxODlilo+6OKi7VZayk1w13WMISeH5c2J1tFyQWJ4acUY+xyUHEqD/6vxzH/nlns7aDXHXh/do8hm5Dxy8DM3Ec9ufx+dkU8x4ESt90VQChrSAyp0snFrhWy8Be43yT0+x1vg8SbYIv/u85sD1V+JZUAN+BUAloYF2PY+DcB8ypTTSaNFRSV++brLLc+z89kAJRzNujxShW6aojGvwuB1FZlUSZCbYMsK+f5xLb+boaX0MioLEudlJTzqLAzS1t0ZPd/vvemHksLZJoM74vrKJZMAmTdqlnKcd/6rnKPDI578tEaRXTNExUR5nZgqKrCqRWZD4Jb5itmIjkijwKy/G5htz2DEGNgZcJInpiEFKiZdOLgAMcHUGNfEEWsiOXpLwf2mlNVQQKfob3raDF0FopuvolBMkQTSZLgTnnP808Tykt0Yd1QIDb0SW", "native", null, null, null, var2_1, null);
        var4_3 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue((Object)var4_3, (String)"MANUFACTURER");
        var5_4 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue((Object)var5_4, (String)"MODEL");
        var6_5 = new CameraSettings();
        var7_6 = FocusGestureStrategy.MANUAL_UNTIL_CAPTURE;
        Intrinsics.checkNotNullParameter((Object)var7_6, (String)"<set-?>");
        var6_5.h = var7_6;
        var8_7 = Locale.ROOT;
        var9_8 = var4_3.toLowerCase(var8_7);
        Intrinsics.checkNotNullExpressionValue((Object)var9_8, (String)"(this as java.lang.Strin\u2026.toLowerCase(Locale.ROOT)");
        if (!Intrinsics.areEqual((Object)var9_8, (Object)"samsung")) ** GOTO lbl-1000
        var26_9 = var5_4.toLowerCase(var8_7);
        Intrinsics.checkNotNullExpressionValue((Object)var26_9, (String)"(this as java.lang.Strin\u2026.toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object)var26_9, (Object)"sm-g389f")) {
            var27_10 = 2;
            Intrinsics.checkNotNullParameter((Object)"api", (String)"name");
            if (Intrinsics.areEqual((Object)"api", (Object)"focusStrategy") && var27_10 instanceof NativeFocusStrategy) {
                var27_11 = ab.a((NativeFocusStrategy)((NativeFocusStrategy)var27_10));
            }
            var6_5.b.put((Object)"api", (Object)var27_12);
            var29_13 = ab.a((NativeFocusStrategy)NativeFocusStrategy.FORCE_CONTINUOUS);
            if (Intrinsics.areEqual((Object)"api", (Object)"focusStrategy") && Intrinsics.areEqual((Object)var27_12, (Object)var29_13)) {
                var6_5.b.put((Object)"macroAutofocusMode", (Object)"off");
            }
            if ((var12_15 = (var31_14 = Camera.e).a(CameraPosition.WORLD_FACING, var6_5)) == null) {
                var12_15 = var31_14.a(CameraPosition.USER_FACING, var6_5);
            }
        } else if ((var12_15 = (var11_16 = Camera.e).a(CameraPosition.WORLD_FACING, var6_5)) == null) {
            var12_15 = var11_16.a(CameraPosition.USER_FACING, var6_5);
        }
        this.camera = var12_15;
        if (var12_15 == null) throw new IllegalStateException("Sample depends on a camera, which failed to initialize.");
        var13_17 = new DataCaptureContext.g(var3_2, (FrameSource)var12_15, null);
        var14_18 = var3_2.g;
        Objects.requireNonNull((Object)var14_18);
        if (var12_15 != null) {
            var16_19 = var12_15._frameSourceImpl();
            var14_18.c.put(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), null, (Object)var16_19, (Object)var12_15);
        } else {
            var16_19 = null;
        }
        var17_20 = var14_18.b.setFrameSourceAsyncWrapped(var16_19);
        Intrinsics.checkNotNullExpressionValue((Object)var17_20, (String)"_2");
        R.style.andThen((NativeWrappedFuture)var17_20, (Runnable)var13_17);
        var19_21 = new BarcodeCaptureSettings();
        Intrinsics.checkNotNullParameter((Object)var19_21, (String)"settings");
        var20_22 = new BarcodeCapture(var3_2, var19_21, null);
        if (var3_2 != null) {
            Intrinsics.checkNotNullParameter((Object)var20_22, (String)"mode");
            Intrinsics.checkNotNullParameter((Object)var20_22, (String)"mode");
            var21_23 = var3_2.g;
            Objects.requireNonNull((Object)var21_23);
            Intrinsics.checkNotNullParameter((Object)var20_22, (String)"mode");
            var23_24 = var20_22._dataCaptureModeImpl();
            var21_23.c.put(Reflection.getOrCreateKotlinClass(NativeDataCaptureMode.class), null, (Object)var23_24, (Object)var20_22);
            var24_25 = var21_23.b.addModeAsyncWrapped(var23_24);
            Intrinsics.checkNotNullExpressionValue((Object)var24_25, (String)"_1");
            R.style.andThen((NativeWrappedFuture)var24_25, (Runnable)new DataCaptureContext.d(var3_2, (DataCaptureMode)var20_22));
        }
        this.barcodeCapture = var20_22;
    }
}

