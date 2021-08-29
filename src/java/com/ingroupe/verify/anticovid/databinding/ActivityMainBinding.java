/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.navigation.NavigationView
 *  dalvik.annotation.MethodParameters
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.navigation.NavigationView;
import com.ingroupe.verify.anticovid.databinding.AppBarMainBinding;
import dalvik.annotation.MethodParameters;

public final class ActivityMainBinding
implements ViewBinding {
    public final AppBarMainBinding appBarMain;
    public final DrawerLayout drawerLayout;
    public final NavigationView navView;
    public final DrawerLayout rootView;

    @MethodParameters(accessFlags={0, 0, 0, 0, 0}, names={"rootView", "appBarMain", "drawerLayout", "imageViewLogoIN", "navView"})
    public ActivityMainBinding(DrawerLayout drawerLayout, AppBarMainBinding appBarMainBinding, DrawerLayout drawerLayout2, ImageView imageView, NavigationView navigationView) {
        this.rootView = drawerLayout;
        this.appBarMain = appBarMainBinding;
        this.drawerLayout = drawerLayout2;
        this.navView = navigationView;
    }

    public View getRoot() {
        return this.rootView;
    }
}

