/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.appbar.AppBarLayout
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.ingroupe.verify.anticovid.databinding.ContentMainBinding;
import dalvik.annotation.MethodParameters;

public final class AppBarMainBinding
implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final ContentMainBinding contentMain;
    public final ConstraintLayout rootView;
    public final Toolbar toolbar;

    @MethodParameters(accessFlags={0, 0, 0, 0}, names={"rootView", "appBarLayout", "contentMain", "toolbar"})
    public AppBarMainBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ContentMainBinding contentMainBinding, Toolbar toolbar) {
        this.rootView = constraintLayout;
        this.appBarLayout = appBarLayout;
        this.contentMain = contentMainBinding;
        this.toolbar = toolbar;
    }

    public View getRoot() {
        return this.rootView;
    }
}

