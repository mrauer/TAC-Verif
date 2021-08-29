/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.d;

public final class a
extends Enum<a> {
    public static final a a;
    private static final /* synthetic */ a[] b;
    private final int c;
    private final String d;

    public static {
        a[] arra = new a[]{new a(12288, "The last function succeeded without error."), new a(12289, "EGL is not initialized, or could not be initialized, for the specified EGL display connection."), new a(12290, "EGL cannot access a requested resource (for example a context is bound in another thread)."), new a(12291, "EGL failed to allocate resources for the requested operation."), new a(12292, "An unrecognized attribute or attribute value was passed in the attribute list."), new a(12293, "An EGLConfig argument does not name a valid EGL frame buffer configuration."), new a(12294, "An EGLContext argument does not name a valid EGL rendering context."), new a(12295, "The current surface of the calling thread is a window, pixel buffer or pixmap that is no longer valid."), new a(12296, "An EGLDisplay argument does not name a valid EGL display connection."), new a(12297, "Arguments are inconsistent (for example, a valid context requires buffers not supplied by a valid surface)."), new a(12298, "A NativePixmapType argument does not refer to a valid native pixmap."), new a(12299, "A NativeWindowType argument does not refer to a valid native window."), new a(12300, "One or more argument values are invalid."), new a(12301, "An EGLSurface argument does not name a valid surface (window, pixel buffer or pixmap) configured for GL rendering."), new a(12302, "A power management event has occurred. The application must destroy all contexts and reinitialise OpenGL ES state and objects to continue rendering.")};
        b = arra;
        a = new a(0);
    }

    public a(int n3, String string2) {
        this.c = n3;
        this.d = string2;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])b.clone();
    }

    public static final class a {
        public a(byte by) {
        }
    }

}

