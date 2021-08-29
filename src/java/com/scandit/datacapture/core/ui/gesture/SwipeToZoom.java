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

import com.scandit.datacapture.core.internal.module.ui.NativeSwipeToZoom;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGestureListener;
import com.scandit.datacapture.core.ui.gesture.SwipeToZoomProxyAdapter;
import com.scandit.datacapture.core.ui.gesture.ZoomGesture;
import com.scandit.datacapture.core.ui.gesture.ZoomGestureListener;
import com.scandit.datacapture.core.ui.gesture.ZoomGestureListenerReversedAdapter;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

public final class SwipeToZoom
implements ZoomGesture {
    public final CopyOnWriteArraySet<ZoomGestureListener> a;
    public final /* synthetic */ SwipeToZoomProxyAdapter b;

    public SwipeToZoom() {
        SwipeToZoomProxyAdapter swipeToZoomProxyAdapter;
        NativeSwipeToZoom nativeSwipeToZoom = NativeSwipeToZoom.create();
        Intrinsics.checkNotNullExpressionValue((Object)nativeSwipeToZoom, (String)"NativeSwipeToZoom.create()");
        Intrinsics.checkNotNullParameter((Object)nativeSwipeToZoom, (String)"impl");
        this.b = swipeToZoomProxyAdapter = new SwipeToZoomProxyAdapter(nativeSwipeToZoom, null, 2);
        this.a = new CopyOnWriteArraySet();
        ZoomGestureListenerReversedAdapter zoomGestureListenerReversedAdapter = new ZoomGestureListenerReversedAdapter(new a(this), this, null, 4);
        swipeToZoomProxyAdapter.b.addListener(zoomGestureListenerReversedAdapter);
    }

    @Override
    public final NativeZoomGesture _zoomGestureImpl() {
        return this.b.a;
    }

    public static final class a
    implements ZoomGestureListener {
        public final WeakReference<SwipeToZoom> a;

        public a(SwipeToZoom swipeToZoom) {
            Intrinsics.checkNotNullParameter((Object)swipeToZoom, (String)"owner");
            this.a = new WeakReference((Object)swipeToZoom);
        }

        @Override
        public final void onZoomInGesture(ZoomGesture zoomGesture) {
            CopyOnWriteArraySet<ZoomGestureListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)zoomGesture, (String)"zoomGesture");
            SwipeToZoom swipeToZoom = (SwipeToZoom)this.a.get();
            if (swipeToZoom != null && (copyOnWriteArraySet = swipeToZoom.a) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((ZoomGestureListener)iterator.next()).onZoomInGesture(zoomGesture);
                }
            }
        }

        @Override
        public final void onZoomOutGesture(ZoomGesture zoomGesture) {
            CopyOnWriteArraySet<ZoomGestureListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)zoomGesture, (String)"zoomGesture");
            SwipeToZoom swipeToZoom = (SwipeToZoom)this.a.get();
            if (swipeToZoom != null && (copyOnWriteArraySet = swipeToZoom.a) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((ZoomGestureListener)iterator.next()).onZoomOutGesture(zoomGesture);
                }
            }
        }
    }

}

