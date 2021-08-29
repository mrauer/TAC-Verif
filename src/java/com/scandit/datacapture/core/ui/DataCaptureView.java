/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.ui.a
 *  com.scandit.datacapture.core.internal.module.ui.a.a
 *  com.scandit.datacapture.core.internal.module.ui.a.b
 *  com.scandit.datacapture.core.internal.module.ui.a.e
 *  com.scandit.datacapture.core.internal.module.ui.f
 *  com.scandit.datacapture.core.ui.DataCaptureView$$special$
 *  com.scandit.datacapture.core.ui.DataCaptureView$$special$$inlined
 *  com.scandit.datacapture.core.ui.DataCaptureView$$special$$inlined$distinctObservable
 *  com.scandit.datacapture.core.ui.DataCaptureView$$special$$inlined$distinctObservable$1
 *  com.scandit.datacapture.core.ui.DataCaptureView$contextStatusView
 *  com.scandit.datacapture.core.ui.DataCaptureView$contextStatusView$1
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener
 *  com.scandit.datacapture.core.ui.DataCaptureView$dataCaptureContextListener$1
 *  com.scandit.datacapture.core.ui.DataCaptureView$onAttachedToWindow
 *  com.scandit.datacapture.core.ui.DataCaptureView$onAttachedToWindow$1
 *  com.scandit.datacapture.core.ui.gesture.SwipeToZoom
 *  com.scandit.datacapture.core.ui.gesture.TapToFocus
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KDeclarationContainer
 *  kotlin.reflect.KProperty
 */
package com.scandit.datacapture.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.material.R;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextListener;
import com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter;
import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.common.geometry.MarginsWithUnit;
import com.scandit.datacapture.core.common.geometry.MeasureUnit;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.core.internal.module.ui.ErrorOverlay;
import com.scandit.datacapture.core.internal.module.ui.NativeContextStatusListener;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeHintPresenter;
import com.scandit.datacapture.core.internal.module.ui.NativeNotificationPresenter;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.core.internal.module.ui.ViewSize;
import com.scandit.datacapture.core.internal.module.ui.a.a;
import com.scandit.datacapture.core.internal.module.ui.a.b;
import com.scandit.datacapture.core.internal.module.ui.a.c;
import com.scandit.datacapture.core.internal.module.ui.a.d;
import com.scandit.datacapture.core.internal.module.ui.a.e;
import com.scandit.datacapture.core.internal.module.ui.control.ControlLayout;
import com.scandit.datacapture.core.internal.module.ui.f;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusPresenter;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusView;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.core.ui.DataCaptureView$$special$;
import com.scandit.datacapture.core.ui.DataCaptureView$orientationEventListener$1;
import com.scandit.datacapture.core.ui.DataCaptureViewListener;
import com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter;
import com.scandit.datacapture.core.ui.DataCaptureViewSizeListener;
import com.scandit.datacapture.core.ui.LogoStyle;
import com.scandit.datacapture.core.ui.gesture.FocusGesture;
import com.scandit.datacapture.core.ui.gesture.SwipeToZoom;
import com.scandit.datacapture.core.ui.gesture.TapToFocus;
import com.scandit.datacapture.core.ui.gesture.ZoomGesture;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;

@SuppressLint(value={"ViewConstructor"})
public final class DataCaptureView
extends RelativeLayout {
    public static final Companion Companion;
    public static /* synthetic */ KProperty[] a;
    public final CopyOnWriteArraySet<DataCaptureViewListener> b;
    public final CopyOnWriteArraySet<DataCaptureViewSizeListener> c;
    public final Set<?> d;
    public final com.scandit.datacapture.core.internal.module.ui.b e;
    public boolean f;
    public final ControlLayout g;
    public final e h;
    public final f i;
    public final ErrorOverlay j;
    public final contextStatusView.1 k;
    public final DataCaptureView$orientationEventListener$1 l;
    public int m;
    public final ReadWriteProperty n;
    public final dataCaptureContextListener.1 o;
    public DataCaptureContext p;
    public FocusGesture q;
    public ZoomGesture r;
    public boolean s;
    public final ContextStatusPresenter t;
    public final float u;
    public final /* synthetic */ DataCaptureViewProxyAdapter v;

    public static {
        KProperty[] arrkProperty = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass(DataCaptureView.class), "currentSize", "getCurrentSize$scandit_capture_core()Lcom/scandit/datacapture/core/internal/module/ui/ViewSize;"))};
        a = arrkProperty;
        Companion = new Companion(null);
    }

    public DataCaptureView(Context context, DataCaptureContext dataCaptureContext, ContextStatusPresenter contextStatusPresenter, float f2, int n2) {
        com.scandit.datacapture.core.internal.module.ui.b b2;
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter;
        e e2;
        f f3;
        com.scandit.datacapture.core.internal.module.ui.a a2 = (n2 & 4) != 0 ? new com.scandit.datacapture.core.internal.module.ui.a() : null;
        if ((n2 & 8) != 0) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue((Object)resources, (String)"context.resources");
            f2 = resources.getDisplayMetrics().density;
        }
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"contextStatusPresenter");
        super(context);
        NativeDataCaptureView nativeDataCaptureView = NativeDataCaptureView.create(f2);
        Intrinsics.checkNotNullExpressionValue((Object)nativeDataCaptureView, (String)"NativeDataCaptureView.create(pixelsPerDip)");
        this.v = dataCaptureViewProxyAdapter = new DataCaptureViewProxyAdapter(nativeDataCaptureView, null, 2);
        this.t = a2;
        this.u = f2;
        this.b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
        this.d = new CopyOnWriteArraySet();
        this.e = b2 = new com.scandit.datacapture.core.internal.module.ui.b(context, this);
        ControlLayout controlLayout = new ControlLayout(context);
        FrameSource frameSource = dataCaptureContext != null ? dataCaptureContext.a : null;
        controlLayout.a(frameSource);
        this.g = controlLayout;
        this.h = e2 = new e((c)new a((ViewGroup)this), (d)new b(), null, 4);
        this.i = f3 = new f(new WeakReference((Object)this), f2);
        ErrorOverlay errorOverlay = new ErrorOverlay(context);
        errorOverlay.setVisibility(4);
        this.j = errorOverlay;
        this.k = new contextStatusView.1(this, context);
        this.l = new DataCaptureView$orientationEventListener$1(this, context, context);
        this.m = R.style.getRotation((Context)context);
        ViewSize viewSize = new ViewSize(this.getMeasuredWidth(), this.getMeasuredHeight());
        this.n = new $special$$inlined$distinctObservable$1((Object)viewSize, (Object)viewSize, this);
        this.o = new dataCaptureContextListener.1(this);
        this.s = true;
        this.setDataCaptureContext(dataCaptureContext);
        this.setBackgroundColor(-16777216);
        errorOverlay.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.addView((View)b2, (ViewGroup.LayoutParams)layoutParams);
        this.addView((View)errorOverlay, (ViewGroup.LayoutParams)layoutParams);
        this.addView((View)controlLayout, (ViewGroup.LayoutParams)ControlLayout.d);
        dataCaptureViewProxyAdapter.a.setNotificationPresenter((NativeNotificationPresenter)f3);
        dataCaptureViewProxyAdapter.a.setHintPresenter((NativeHintPresenter)e2);
        this.setFocusGesture((FocusGesture)new TapToFocus());
        this.setZoomGesture((ZoomGesture)new SwipeToZoom());
    }

    public static /* synthetic */ void getControlLayout$scandit_capture_core$annotations() {
    }

    public static /* synthetic */ void getCurrentSize$scandit_capture_core$annotations() {
    }

    public static /* synthetic */ void get_overlays$annotations() {
    }

    public final int a() {
        Context context = this.getContext();
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"context");
        return R.style.getRotation((Context)context);
    }

    public final void a(int n2, int n3) {
        this.v.a.setPreviewOrientation(R.style.toAngle((int)this.a()));
        NativeDataCaptureContext nativeDataCaptureContext = this.v.a.getDataCaptureContext();
        if (nativeDataCaptureContext != null) {
            ViewSize viewSize = this.getCurrentSize$scandit_capture_core();
            float f2 = viewSize.a;
            MeasureUnit measureUnit = MeasureUnit.PIXEL;
            nativeDataCaptureContext.setFrameOfReferenceViewSizeAndOrientation(new SizeWithUnit(new FloatWithUnit(f2, measureUnit), new FloatWithUnit(viewSize.b, measureUnit)), this.u, R.style.toAngle((int)this.a()));
        }
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ((DataCaptureViewListener)iterator.next()).onSizeChanged(n2, n3, this.a());
        }
        Iterator iterator2 = this.c.iterator();
        while (iterator2.hasNext()) {
            ((DataCaptureViewSizeListener)iterator2.next()).onSizeChanged(this, n2, n3, this.a());
        }
    }

    public final ControlLayout getControlLayout$scandit_capture_core() {
        return this.g;
    }

    public final List<?> getControls$scandit_capture_core() {
        return this.g.b;
    }

    public final ViewSize getCurrentSize$scandit_capture_core() {
        return (ViewSize)this.n.getValue((Object)this, a[0]);
    }

    public final DataCaptureContext getDataCaptureContext() {
        return this.p;
    }

    public final FocusGesture getFocusGesture() {
        return this.q;
    }

    public final Anchor getLogoAnchor() {
        Anchor anchor = this.v.a.getLogoAnchor();
        Intrinsics.checkNotNullExpressionValue((Object)((Object)anchor), (String)"_0");
        return anchor;
    }

    public final PointWithUnit getLogoOffset() {
        PointWithUnit pointWithUnit = this.v.a.getLogoOffset();
        Intrinsics.checkNotNullExpressionValue((Object)pointWithUnit, (String)"_0");
        return pointWithUnit;
    }

    public final LogoStyle getLogoStyle() {
        LogoStyle logoStyle = this.v.a.getLogoStyle();
        Intrinsics.checkNotNullExpressionValue((Object)((Object)logoStyle), (String)"_0");
        return logoStyle;
    }

    public final PointWithUnit getPointOfInterest() {
        PointWithUnit pointWithUnit = this.v.a.getPointOfInterest();
        Intrinsics.checkNotNullExpressionValue((Object)pointWithUnit, (String)"_0");
        return pointWithUnit;
    }

    public final MarginsWithUnit getScanAreaMargins() {
        MarginsWithUnit marginsWithUnit = this.v.a.getScanAreaMargins();
        Intrinsics.checkNotNullExpressionValue((Object)marginsWithUnit, (String)"_0");
        return marginsWithUnit;
    }

    public final ZoomGesture getZoomGesture() {
        return this.r;
    }

    public final boolean get_optimizesRendering$scandit_capture_core() {
        return this.s;
    }

    public final Set<?> get_overlays() {
        return this.d;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t.setView((ContextStatusView)this.k);
        this.l.enable();
        this.v.a.setContextStatusListener((NativeContextStatusListener)new onAttachedToWindow.1(this));
        this.v.a.attachToWindow();
    }

    public final void onDetachedFromWindow() {
        this.l.disable();
        this.t.setView(null);
        this.v.a.setContextStatusListener(null);
        this.v.a.detachFromWindow();
        super.onDetachedFromWindow();
    }

    public final void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.setCurrentSize$scandit_capture_core(new ViewSize(n2, n3));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onSurfaceTextureAvailable$scandit_capture_core() {
        DataCaptureView dataCaptureView = this;
        synchronized (dataCaptureView) {
            DataCaptureContext dataCaptureContext = this.p;
            if (dataCaptureContext != null) {
                if (!this.f) {
                    dataCaptureContext.addListener((DataCaptureContextListener)this.o);
                }
                this.v.a.setDataCaptureContext(dataCaptureContext.g.b);
                this.a(this.getMeasuredWidth(), this.getMeasuredHeight());
            }
            this.f = true;
            return;
        }
    }

    public final void setCurrentSize$scandit_capture_core(ViewSize viewSize) {
        Intrinsics.checkNotNullParameter((Object)viewSize, (String)"<set-?>");
        this.n.setValue((Object)this, a[0], (Object)viewSize);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setDataCaptureContext(DataCaptureContext dataCaptureContext) {
        DataCaptureView dataCaptureView = this;
        synchronized (dataCaptureView) {
            DataCaptureContext dataCaptureContext2 = this.p;
            if (dataCaptureContext2 != null && this.f && dataCaptureContext2 != null) {
                dataCaptureContext2.removeListener((DataCaptureContextListener)this.o);
            }
            this.p = dataCaptureContext;
            if (dataCaptureContext != null) {
                if (this.f) {
                    if (dataCaptureContext != null) {
                        dataCaptureContext.addListener((DataCaptureContextListener)this.o);
                    }
                    this.a(this.getMeasuredWidth(), this.getMeasuredHeight());
                }
                NativeDataCaptureView nativeDataCaptureView = this.v.a;
                DataCaptureContext dataCaptureContext3 = this.p;
                NativeDataCaptureContext nativeDataCaptureContext = dataCaptureContext3 != null ? dataCaptureContext3.g.b : null;
                nativeDataCaptureView.setDataCaptureContext(nativeDataCaptureContext);
            }
            return;
        }
    }

    public final void setFocusGesture(FocusGesture focusGesture) {
        this.q = focusGesture;
        NativeDataCaptureView nativeDataCaptureView = this.v.a;
        NativeFocusGesture nativeFocusGesture = focusGesture != null ? focusGesture._focusGestureImpl() : null;
        nativeDataCaptureView.setFocusGesture(nativeFocusGesture);
    }

    public final void setLogoAnchor(Anchor anchor) {
        Intrinsics.checkNotNullParameter((Object)((Object)anchor), (String)"<set-?>");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = this.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)((Object)anchor), (String)"p0");
        dataCaptureViewProxyAdapter.a.setLogoAnchor(anchor);
    }

    public final void setLogoOffset(PointWithUnit pointWithUnit) {
        Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"<set-?>");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = this.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"p0");
        dataCaptureViewProxyAdapter.a.setLogoOffset(pointWithUnit);
    }

    public final void setLogoStyle(LogoStyle logoStyle) {
        Intrinsics.checkNotNullParameter((Object)((Object)logoStyle), (String)"<set-?>");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = this.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)((Object)logoStyle), (String)"p0");
        dataCaptureViewProxyAdapter.a.setLogoStyle(logoStyle);
    }

    public final void setPointOfInterest(PointWithUnit pointWithUnit) {
        Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"<set-?>");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = this.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"p0");
        dataCaptureViewProxyAdapter.a.setPointOfInterest(pointWithUnit);
    }

    public final void setScanAreaMargins(MarginsWithUnit marginsWithUnit) {
        Intrinsics.checkNotNullParameter((Object)marginsWithUnit, (String)"<set-?>");
        DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = this.v;
        Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)marginsWithUnit, (String)"p0");
        dataCaptureViewProxyAdapter.a.setScanAreaMargins(marginsWithUnit);
    }

    public final void setZoomGesture(ZoomGesture zoomGesture) {
        this.r = zoomGesture;
        NativeDataCaptureView nativeDataCaptureView = this.v.a;
        NativeZoomGesture nativeZoomGesture = zoomGesture != null ? zoomGesture._zoomGestureImpl() : null;
        nativeDataCaptureView.setZoomGesture(nativeZoomGesture);
    }

    public final void set_optimizesRendering$scandit_capture_core(boolean bl) {
        this.s = bl;
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

}

