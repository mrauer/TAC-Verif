/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui.gesture;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeTapToFocus;
import com.scandit.datacapture.core.ui.gesture.FocusGesture;
import com.scandit.datacapture.core.ui.gesture.FocusGestureListener;
import com.scandit.datacapture.core.ui.gesture.FocusGestureListenerReversedAdapter;
import com.scandit.datacapture.core.ui.gesture.TapToFocusProxyAdapter;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

public final class TapToFocus
implements FocusGesture {
    public final CopyOnWriteArraySet<FocusGestureListener> a;
    public final /* synthetic */ TapToFocusProxyAdapter b;

    public TapToFocus() {
        TapToFocusProxyAdapter tapToFocusProxyAdapter;
        NativeTapToFocus nativeTapToFocus = NativeTapToFocus.create();
        Intrinsics.checkNotNullExpressionValue((Object)nativeTapToFocus, (String)"NativeTapToFocus.create()");
        Intrinsics.checkNotNullParameter((Object)nativeTapToFocus, (String)"impl");
        this.b = tapToFocusProxyAdapter = new TapToFocusProxyAdapter(nativeTapToFocus, null, 2);
        this.a = new CopyOnWriteArraySet();
        FocusGestureListenerReversedAdapter focusGestureListenerReversedAdapter = new FocusGestureListenerReversedAdapter(new a(this), this, null, 4);
        tapToFocusProxyAdapter.b.addListener(focusGestureListenerReversedAdapter);
    }

    @Override
    public final NativeFocusGesture _focusGestureImpl() {
        return this.b.a;
    }

    public static final class a
    implements FocusGestureListener {
        public final WeakReference<TapToFocus> a;

        public a(TapToFocus tapToFocus) {
            Intrinsics.checkNotNullParameter((Object)tapToFocus, (String)"owner");
            this.a = new WeakReference((Object)tapToFocus);
        }

        @Override
        public final void onFocusGesture(FocusGesture focusGesture, PointWithUnit pointWithUnit) {
            CopyOnWriteArraySet<FocusGestureListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)focusGesture, (String)"focusGesture");
            Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"point");
            TapToFocus tapToFocus = (TapToFocus)this.a.get();
            if (tapToFocus != null && (copyOnWriteArraySet = tapToFocus.a) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((FocusGestureListener)iterator.next()).onFocusGesture(focusGesture, pointWithUnit);
                }
            }
        }
    }

}

