/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.internal.module.ui.GestureListener;
import com.scandit.datacapture.core.internal.module.ui.GestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureType;
import com.scandit.datacapture.core.internal.module.ui.c;
import java.util.EnumSet;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class d
implements GestureRecognizer {
    public final a a;
    public final GestureDetector b;
    public GestureListener c;
    public EnumSet<NativeGestureType> d;
    public final float e;

    public d(Context context, float f2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        GestureDetector.OnDoubleTapListener onDoubleTapListener = new GestureDetector.OnDoubleTapListener(this){
            public /* synthetic */ d a;
            {
                this.a = d2;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
                if (this.a.d.contains((Object)NativeGestureType.DOUBLE_TAP)) {
                    d d2 = this.a;
                    GestureListener gestureListener = d2.c;
                    if (gestureListener != null) {
                        Point point = d.a(d2, motionEvent);
                        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
                        c c2 = gestureListener.a;
                        Objects.requireNonNull((Object)c2);
                        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
                        return c2.a.onDoubleTap(point);
                    }
                }
                return false;
            }

            public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
                return false;
            }

            public final boolean onDown(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e1");
                Intrinsics.checkNotNullParameter((Object)motionEvent2, (String)"e2");
                EnumSet<NativeGestureType> enumSet = this.a.d;
                NativeGestureType nativeGestureType = NativeGestureType.SWIPE_UP;
                if (enumSet.contains((Object)nativeGestureType) || this.a.d.contains((Object)NativeGestureType.SWIPE_DOWN)) {
                    Point point = d.a(this.a, motionEvent);
                    Point point2 = d.a(this.a, motionEvent2);
                    float f4 = point2.getX() - point.getX();
                    float f5 = point2.getY() - point.getY();
                    if (Math.abs((float)f5) > Math.abs((float)(f4 * 2.0f))) {
                        GestureListener gestureListener;
                        if (f5 > 0.0f && this.a.d.contains((Object)NativeGestureType.SWIPE_DOWN)) {
                            GestureListener gestureListener2 = this.a.c;
                            if (gestureListener2 != null) {
                                return gestureListener2.a.a.onSwipeDown();
                            }
                        } else if (this.a.d.contains((Object)nativeGestureType) && (gestureListener = this.a.c) != null) {
                            return gestureListener.a.a.onSwipeUp();
                        }
                    }
                }
                return false;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e1");
                Intrinsics.checkNotNullParameter((Object)motionEvent2, (String)"e2");
                return false;
            }

            public final void onShowPress(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
                return false;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter((Object)motionEvent, (String)"e");
                if (this.a.d.contains((Object)NativeGestureType.TAP)) {
                    d d2 = this.a;
                    GestureListener gestureListener = d2.c;
                    if (gestureListener != null) {
                        Point point = d.a(d2, motionEvent);
                        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
                        c c2 = gestureListener.a;
                        Objects.requireNonNull((Object)c2);
                        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
                        return c2.a.onTap(point);
                    }
                }
                return false;
            }
        };
        this.a = onDoubleTapListener;
        this.b = new GestureDetector(context, (GestureDetector.OnGestureListener)onDoubleTapListener, new Handler(Looper.getMainLooper()));
        EnumSet enumSet = EnumSet.noneOf(NativeGestureType.class);
        Intrinsics.checkNotNullExpressionValue((Object)enumSet, (String)"EnumSet.noneOf(NativeGestureType::class.java)");
        this.d = enumSet;
        this.e = 1.0f / f2;
    }

    public static final /* synthetic */ Point a(d d2, MotionEvent motionEvent) {
        return new Point(motionEvent.getX() * d2.e, motionEvent.getY() * d2.e);
    }

    @Override
    public final void a(GestureListener gestureListener, EnumSet<NativeGestureType> enumSet) {
        Intrinsics.checkNotNullParameter((Object)gestureListener, (String)"listener");
        Intrinsics.checkNotNullParameter(enumSet, (String)"gestures");
        this.c = gestureListener;
        this.d = enumSet;
        if (enumSet.contains((Object)NativeGestureType.DOUBLE_TAP)) {
            this.b.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)this.a);
            return;
        }
        this.b.setOnDoubleTapListener(null);
    }

}

