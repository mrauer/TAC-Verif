/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlarmManager
 *  android.app.Application
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.net.NetworkRequest
 *  android.net.NetworkRequest$Builder
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.activity.ComponentActivity
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBarDrawerToggle
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$DrawerListener
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$OpGenerator
 *  androidx.fragment.app.FragmentManager$PopBackStackState
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.fragment.app.FragmentTransaction$Op
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.Observer
 *  androidx.lifecycle.ProcessLifecycleOwner
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.work.Constraints
 *  androidx.work.Constraints$Builder
 *  androidx.work.ExistingPeriodicWorkPolicy
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.NetworkType
 *  androidx.work.Operation
 *  androidx.work.PeriodicWorkRequest
 *  androidx.work.PeriodicWorkRequest$Builder
 *  androidx.work.WorkRequest
 *  androidx.work.WorkRequest$Builder
 *  androidx.work.impl.WorkContinuationImpl
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.WorkSpec
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.navigation.NavigationView
 *  com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Calendar
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.Stack
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Level
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.Logger
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.SubscriberMethodFinder
 *  org.greenrobot.eventbus.SubscriberMethodFinder$FindState
 *  org.greenrobot.eventbus.Subscription
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.meta.SubscriberInfo
 */
package com.ingroupe.verify.anticovid;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.ingroupe.verify.anticovid.-$$Lambda$MainActivity$GrRBUyUzMCoOQ5rumf-HS5SUIYI;
import com.ingroupe.verify.anticovid.-$$Lambda$MainActivity$S4_CKgSrjUkU_DTH_ECDvK6DnIk;
import com.ingroupe.verify.anticovid.-$$Lambda$MainActivity$vuILBI8Sv7zK7ASdq5f03yNA7bM;
import com.ingroupe.verify.anticovid.-$$Lambda$MainActivity$z2xoq5y0JZOkQFtVgxslC3eLBao;
import com.ingroupe.verify.anticovid.NavigationFragment;
import com.ingroupe.verify.anticovid.common.Constants$Criticity;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.ShowLoadingAnimEvent;
import com.ingroupe.verify.anticovid.databinding.ActivityMainBinding;
import com.ingroupe.verify.anticovid.databinding.AppBarMainBinding;
import com.ingroupe.verify.anticovid.databinding.ContentMainBinding;
import com.ingroupe.verify.anticovid.observer.BackgroundObserver;
import com.ingroupe.verify.anticovid.observer.BackgroundObserverListener;
import com.ingroupe.verify.anticovid.observer.DailyReceiver;
import com.ingroupe.verify.anticovid.observer.LocaleChangedBroadcastReceiver;
import com.ingroupe.verify.anticovid.observer.NetworkLiveData;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.SyncWorker;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import dalvik.annotation.SourceDebugExtension;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.Subscription;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SubscriberInfo;

@SourceDebugExtension(value="SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/ingroupe/verify/anticovid/MainActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,418:1\n1#2:419\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001OB\u0007\u00a2\u0006\u0004\bN\u0010\fJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\fJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001f\u0010 J;\u0010)\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b+\u0010,J\u001f\u00100\u001a\u00020\b2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0016\u00a2\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0016\u00a2\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b7\u0010 J\u000f\u00108\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b8\u0010\fJ\u0017\u0010:\u001a\u00020\u00112\u0006\u00109\u001a\u00020!H\u0002\u00a2\u0006\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006P"}, d2={"Lcom/ingroupe/verify/anticovid/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "Lcom/ingroupe/verify/anticovid/observer/BackgroundObserverListener;", "Lcom/ingroupe/verify/anticovid/synchronization/ConfServiceUtils$ConfServiceListener;", "Lcom/ingroupe/verify/anticovid/synchronization/SynchronisationUtils$SyncListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "onDestroy", "onBackPressed", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onNavigationItemSelected", "Lcom/ingroupe/verify/anticovid/common/ShowLoadingAnimEvent;", "showLoadingAnimEvent", "onShowLoadingAnimEvent", "(Lcom/ingroupe/verify/anticovid/common/ShowLoadingAnimEvent;)V", "hasComeBackFromBackground", "isModeLite", "changeMode", "(Z)V", "", "identifier", "messageLine1", "messageLine2", "Lcom/ingroupe/verify/anticovid/common/Constants$Criticity;", "criticity", "Landroid/view/View$OnClickListener;", "listener", "showSnackBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ingroupe/verify/anticovid/common/Constants$Criticity;Landroid/view/View$OnClickListener;)V", "hideSnackBar", "(Ljava/lang/String;)V", "", "title", "message", "showErrorMessage", "(II)V", "Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;", "syncResult", "saveResult", "(Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;)V", "show", "showLoading", "onSynchronizationDone", "tag", "replaceFragment", "(Ljava/lang/String;)Z", "snackBarIdentifier", "Ljava/lang/String;", "Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "currentFeatureFragment", "Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "currentTag", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "toggleSave", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "Lcom/ingroupe/verify/anticovid/observer/LocaleChangedBroadcastReceiver;", "localeBr", "Lcom/ingroupe/verify/anticovid/observer/LocaleChangedBroadcastReceiver;", "Lcom/ingroupe/verify/anticovid/databinding/ActivityMainBinding;", "binding", "Lcom/ingroupe/verify/anticovid/databinding/ActivityMainBinding;", "Landroid/os/Handler;", "showProgressBarHandler", "Landroid/os/Handler;", "<init>", "NavigationIcon", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class MainActivity
extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener,
BackgroundObserverListener,
ConfServiceUtils.ConfServiceListener,
SynchronisationUtils.SyncListener {
    public static final /* synthetic */ int $r8$clinit;
    public ActivityMainBinding binding;
    public FeatureFragment currentFeatureFragment;
    public String currentTag = "NO_FRAGMENT";
    public final LocaleChangedBroadcastReceiver localeBr = new LocaleChangedBroadcastReceiver();
    public final Handler showProgressBarHandler = new Handler(Looper.getMainLooper());
    public String snackBarIdentifier;
    public DrawerLayout.DrawerListener toggleSave;

    public final void changeMode(boolean bl) {
        block13 : {
            block14 : {
                block15 : {
                    block16 : {
                        block12 : {
                            block6 : {
                                block7 : {
                                    block8 : {
                                        block9 : {
                                            block10 : {
                                                block11 : {
                                                    if (!bl) break block6;
                                                    ActivityMainBinding activityMainBinding = this.binding;
                                                    if (activityMainBinding == null) break block7;
                                                    activityMainBinding.appBarMain.appBarLayout.setBackgroundColor(this.getColor(2131034226));
                                                    ActivityMainBinding activityMainBinding2 = this.binding;
                                                    if (activityMainBinding2 == null) break block8;
                                                    activityMainBinding2.appBarMain.appBarLayout.getContext().setTheme(2131886090);
                                                    ActivityMainBinding activityMainBinding3 = this.binding;
                                                    if (activityMainBinding3 == null) break block9;
                                                    activityMainBinding3.appBarMain.toolbar.setTitleTextColor(this.getColor(2131034221));
                                                    ActivityMainBinding activityMainBinding4 = this.binding;
                                                    if (activityMainBinding4 == null) break block10;
                                                    activityMainBinding4.appBarMain.appBarLayout.invalidate();
                                                    ActivityMainBinding activityMainBinding5 = this.binding;
                                                    if (activityMainBinding5 == null) break block11;
                                                    Drawable drawable = activityMainBinding5.appBarMain.toolbar.getNavigationIcon();
                                                    if (drawable != null) {
                                                        drawable.mutate().setTint(this.getColor(2131034221));
                                                        ActivityMainBinding activityMainBinding6 = this.binding;
                                                        if (activityMainBinding6 != null) {
                                                            activityMainBinding6.appBarMain.toolbar.setNavigationIcon(drawable);
                                                            return;
                                                        }
                                                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                                        throw null;
                                                    }
                                                    break block12;
                                                }
                                                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                                throw null;
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                            throw null;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                throw null;
                            }
                            ActivityMainBinding activityMainBinding = this.binding;
                            if (activityMainBinding == null) break block13;
                            activityMainBinding.appBarMain.appBarLayout.setBackgroundColor(this.getColor(2131034221));
                            ActivityMainBinding activityMainBinding7 = this.binding;
                            if (activityMainBinding7 == null) break block14;
                            activityMainBinding7.appBarMain.appBarLayout.getContext().setTheme(2131886091);
                            ActivityMainBinding activityMainBinding8 = this.binding;
                            if (activityMainBinding8 == null) break block15;
                            activityMainBinding8.appBarMain.toolbar.setTitleTextColor(this.getColor(2131034226));
                            ActivityMainBinding activityMainBinding9 = this.binding;
                            if (activityMainBinding9 == null) break block16;
                            activityMainBinding9.appBarMain.appBarLayout.invalidate();
                        }
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
        throw null;
    }

    @Override
    public void hasComeBackFromBackground() {
        FeatureFragment featureFragment = this.currentFeatureFragment;
        if (featureFragment == null) {
            return;
        }
        Log.d((String)"FeatureFragment", (String)"forceToActionChoice");
        Stack<String> stack = featureFragment.tagStack;
        if (stack != null) {
            if (stack.contains((Object)"Scan")) {
                FeatureFragment.popToTag$default(featureFragment, "actionChoice", null, false, 6, null);
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
        throw null;
    }

    public final void hideSnackBar(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"identifier");
        if (Intrinsics.areEqual((Object)this.snackBarIdentifier, (Object)string)) {
            ActivityMainBinding activityMainBinding = this.binding;
            if (activityMainBinding != null) {
                activityMainBinding.appBarMain.contentMain.clCustomSnackbar.setVisibility(8);
                ActivityMainBinding activityMainBinding2 = this.binding;
                if (activityMainBinding2 != null) {
                    activityMainBinding2.appBarMain.contentMain.clCustomSnackbar.setOnClickListener(null);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
            throw null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onBackPressed() {
        block21 : {
            block20 : {
                var1_1 = this.binding;
                if (var1_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                    throw null;
                }
                if (var1_1.drawerLayout.isDrawerOpen(8388611)) {
                    var23_2 = this.binding;
                    if (var23_2 != null) {
                        var23_2.drawerLayout.closeDrawer(8388611);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                    throw null;
                }
                var2_3 = this.currentFeatureFragment;
                var3_4 = var2_3 == null ? null : var2_3.currentTag;
                if (Intrinsics.areEqual((Object)var3_4, (Object)"Scan")) {
                    var22_5 = this.currentFeatureFragment;
                    if (var22_5 == null) {
                        return;
                    }
                    FeatureFragment.popToTag$default(var22_5, "actionChoice", null, false, 6, null);
                    return;
                }
                var4_6 = this.currentFeatureFragment;
                var5_7 = var4_6 == null ? null : var4_6.currentTag;
                if (Intrinsics.areEqual((Object)var5_7, (Object)"resultScanF")) {
                    var21_8 = this.currentFeatureFragment;
                    if (var21_8 == null) {
                        return;
                    }
                    FeatureFragment.popToTag$default(var21_8, "Scan", null, false, 6, null);
                    return;
                }
                var6_9 = this.currentFeatureFragment;
                var7_10 = 1;
                if (var6_9 == null) break block20;
                var8_11 = var6_9.getChildFragmentManager().findFragmentByTag(var6_9.currentTag);
                if (!(var8_11 instanceof FeatureChildFragment)) ** GOTO lbl-1000
                Objects.requireNonNull((Object)((FeatureChildFragment)var8_11));
                var11_12 = var6_9.tagStack;
                if (var11_12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                    throw null;
                }
                if (var11_12.isEmpty()) ** GOTO lbl-1000
                var12_13 = var6_9.tagStack;
                if (var12_13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                    throw null;
                }
                if (var12_13.size() <= var7_10) ** GOTO lbl-1000
                var13_14 = var6_9.tagStack;
                if (var13_14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                    throw null;
                }
                if (!Intrinsics.areEqual((Object)((String)var13_14.get(-2 + var13_14.size())), (Object)"NO_FRAGMENT")) {
                    var14_15 = var6_9.tagStack;
                    if (var14_15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                        throw null;
                    }
                    var14_15.pop();
                    var16_16 = var6_9.getChildFragmentManager();
                    var16_16.enqueueAction((FragmentManager.OpGenerator)new FragmentManager.PopBackStackState(var16_16, null, -1, 0), false);
                    var17_17 = var6_9.tagStack;
                    if (var17_17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                        throw null;
                    }
                    var6_9.currentTag = (String)var17_17.peek();
                    var18_18 = var6_9.getChildFragmentManager().findFragmentByTag(var6_9.currentTag);
                    if (var18_18 instanceof FeatureChildFragment) {
                        var6_9.currentFragment = var20_19 = (FeatureChildFragment)var18_18;
                        if (var20_19 != null) {
                            var20_19.featureFragment = var6_9;
                        }
                    }
                    var6_9.initFeatureFragment();
                    var19_20 = var6_9.getActivity();
                    if (var19_20 != null) {
                        var19_20.invalidateOptionsMenu();
                    }
                    var9_21 = var7_10;
                } else lbl-1000: // 4 sources:
                {
                    var9_21 = 0;
                }
                if (var9_21 == 0) break block21;
            }
            var7_10 = 0;
        }
        if (var7_10 == 0) return;
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        View view;
        int n2;
        block9 : {
            int n3;
            View view2;
            block10 : {
                int n4;
                View view3;
                block11 : {
                    block12 : {
                        ConstraintLayout constraintLayout;
                        TextView textView;
                        NavigationView navigationView;
                        TextView textView2;
                        FragmentActivity.super.onCreate(bundle);
                        view = this.getLayoutInflater().inflate(2131492893, null, false);
                        n2 = 2131296340;
                        view2 = view.findViewById(n2);
                        if (view2 == null) break block9;
                        n3 = 2131296339;
                        AppBarLayout appBarLayout = (AppBarLayout)view2.findViewById(n3);
                        if (appBarLayout == null || (view3 = view2.findViewById(n3 = 2131296418)) == null) break block10;
                        n4 = 2131296394;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout)view3.findViewById(n4);
                        if (constraintLayout2 == null || (constraintLayout = (ConstraintLayout)view3.findViewById(n4 = 2131296547)) == null || (textView = (TextView)view3.findViewById(n4 = 2131296779)) == null || (textView2 = (TextView)view3.findViewById(n4 = 2131296780)) == null) break block11;
                        ContentMainBinding contentMainBinding = new ContentMainBinding((ConstraintLayout)view3, constraintLayout2, constraintLayout, textView, textView2);
                        Toolbar toolbar = (Toolbar)view2.findViewById(2131296860);
                        if (toolbar == null) break block12;
                        AppBarMainBinding appBarMainBinding = new AppBarMainBinding((ConstraintLayout)view2, appBarLayout, contentMainBinding, toolbar);
                        DrawerLayout drawerLayout = (DrawerLayout)view;
                        int n5 = 2131296519;
                        ImageView imageView = (ImageView)view.findViewById(n5);
                        if (imageView != null && (navigationView = (NavigationView)view.findViewById(n5 = 2131296610)) != null) {
                            ActivityMainBinding activityMainBinding = new ActivityMainBinding(drawerLayout, appBarMainBinding, drawerLayout, imageView, navigationView);
                            Intrinsics.checkNotNullExpressionValue((Object)activityMainBinding, (String)"inflate(layoutInflater)");
                            this.binding = activityMainBinding;
                            this.setContentView((View)drawerLayout);
                            ActivityMainBinding activityMainBinding2 = this.binding;
                            if (activityMainBinding2 != null) {
                                Toolbar toolbar2 = activityMainBinding2.appBarMain.toolbar;
                                this.getDelegate().setSupportActionBar(toolbar2);
                                ActivityMainBinding activityMainBinding3 = this.binding;
                                if (activityMainBinding3 != null) {
                                    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle((Activity)this, activityMainBinding3.drawerLayout, activityMainBinding3.appBarMain.toolbar, 2131820733, 2131820732);
                                    ActivityMainBinding activityMainBinding4 = this.binding;
                                    if (activityMainBinding4 != null) {
                                        activityMainBinding4.drawerLayout.addDrawerListener((DrawerLayout.DrawerListener)actionBarDrawerToggle);
                                        actionBarDrawerToggle.syncState();
                                        ActivityMainBinding activityMainBinding5 = this.binding;
                                        if (activityMainBinding5 != null) {
                                            activityMainBinding5.navView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener)this);
                                            this.toggleSave = actionBarDrawerToggle;
                                            Serializable serializable = bundle == null ? null : bundle.getSerializable("CURRENT_TAG");
                                            boolean bl = serializable instanceof String;
                                            String string = null;
                                            if (bl) {
                                                string = (String)serializable;
                                            }
                                            this.currentTag = string;
                                            this.localeBr.main = this;
                                            IntentFilter intentFilter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
                                            this.registerReceiver((BroadcastReceiver)this.localeBr, intentFilter);
                                            boolean bl2 = Intrinsics.areEqual((Object)"NO_FRAGMENT", (Object)this.currentTag);
                                            String string2 = "init";
                                            if (bl2) {
                                                this.replaceFragment(string2);
                                            } else {
                                                String string3 = this.currentTag;
                                                if (string3 != null) {
                                                    string2 = string3;
                                                }
                                                this.replaceFragment(string2);
                                            }
                                            ProcessLifecycleOwner.sInstance.mRegistry.addObserver((LifecycleObserver)new BackgroundObserver(this));
                                            NetworkLiveData networkLiveData = NetworkLiveData.INSTANCE;
                                            Application application = this.getApplication();
                                            Intrinsics.checkNotNullExpressionValue((Object)application, (String)"this.application");
                                            Objects.requireNonNull((Object)((Object)networkLiveData));
                                            Intrinsics.checkNotNullParameter((Object)application, (String)"application");
                                            NetworkLiveData.application = application;
                                            NetworkRequest networkRequest = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                                            Intrinsics.checkNotNullExpressionValue((Object)networkRequest, (String)"Builder()\n            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)\n            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)\n            .build()");
                                            NetworkLiveData.networkRequest = networkRequest;
                                            networkLiveData.observe((LifecycleOwner)this, (Observer)new -$$Lambda$MainActivity$vuILBI8Sv7zK7ASdq5f03yNA7bM(this));
                                            Intrinsics.checkNotNullParameter((Object)this, (String)"context");
                                            Object object = this.getSystemService("alarm");
                                            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.app.AlarmManager");
                                            AlarmManager alarmManager = (AlarmManager)object;
                                            Calendar calendar = Calendar.getInstance();
                                            Intrinsics.checkNotNullExpressionValue((Object)calendar, (String)"getInstance()");
                                            calendar.set(11, 0);
                                            calendar.set(12, 2);
                                            Intent intent = new Intent((Context)this, DailyReceiver.class);
                                            intent.getAction();
                                            PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this, (int)11, (Intent)intent, (int)134217728);
                                            Intrinsics.checkNotNullExpressionValue((Object)pendingIntent, (String)"getBroadcast(\n                context,\n                Constants.DAILY_RECEIVER_RC,\n                intent,\n                PendingIntent.FLAG_UPDATE_CURRENT\n            )");
                                            alarmManager.setInexactRepeating(1, calendar.getTimeInMillis(), 86400000L, pendingIntent);
                                            Intrinsics.checkNotNullParameter((Object)this, (String)"context");
                                            Constraints.Builder builder = new Constraints.Builder();
                                            builder.mRequiredNetworkType = NetworkType.CONNECTED;
                                            Constraints constraints = new Constraints(builder);
                                            Intrinsics.checkNotNullExpressionValue((Object)constraints, (String)"Builder()\n            .setRequiredNetworkType(NetworkType.CONNECTED)\n            .build()");
                                            PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(SyncWorker.class, 15L, TimeUnit.MINUTES);
                                            builder2.mWorkSpec.constraints = constraints;
                                            builder2.mTags.add((Object)"tacvSyncTag");
                                            WorkRequest workRequest = builder2.build();
                                            Intrinsics.checkNotNullExpressionValue((Object)workRequest, (String)"PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)\n                .setConstraints(constraints)\n                .addTag(TAG)\n                .build()");
                                            PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest)workRequest;
                                            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance((Context)this);
                                            ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE;
                                            Objects.requireNonNull((Object)workManagerImpl);
                                            ExistingWorkPolicy existingWorkPolicy = existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE;
                                            ExistingWorkPolicy existingWorkPolicy2 = existingWorkPolicy;
                                            WorkContinuationImpl workContinuationImpl = new WorkContinuationImpl(workManagerImpl, "tacvSyncWorkName", existingWorkPolicy2, Collections.singletonList((Object)periodicWorkRequest), null);
                                            workContinuationImpl.enqueue();
                                            return;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                            throw null;
                        }
                        n2 = n5;
                        break block9;
                    }
                    n3 = 2131296860;
                    break block10;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view3.getResources().getResourceName(n4)));
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(n3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        block23 : {
            block29 : {
                block30 : {
                    block31 : {
                        ActivityMainBinding activityMainBinding;
                        block28 : {
                            block24 : {
                                block25 : {
                                    block27 : {
                                        ActivityMainBinding activityMainBinding2;
                                        block26 : {
                                            FeatureChildFragment featureChildFragment;
                                            Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
                                            FeatureFragment featureFragment = this.currentFeatureFragment;
                                            if (featureFragment != null) {
                                                Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
                                                FeatureChildFragment featureChildFragment2 = featureFragment.currentFragment;
                                                if (featureChildFragment2 != null) {
                                                    featureChildFragment2.createOptionsMenu(menu);
                                                }
                                            }
                                            ActivityMainBinding activityMainBinding3 = this.binding;
                                            if (activityMainBinding3 == null) break block23;
                                            activityMainBinding3.appBarMain.toolbar.setNavigationOnClickListener(null);
                                            ActionBar actionBar = this.getSupportActionBar();
                                            if (actionBar != null) {
                                                actionBar.show();
                                            }
                                            FeatureFragment featureFragment2 = this.currentFeatureFragment;
                                            NavigationIcon navigationIcon = featureFragment2 == null || (featureChildFragment = featureFragment2.currentFragment) == null ? null : featureChildFragment.showNavigation();
                                            int n2 = navigationIcon == null ? -1 : WhenMappings.$EnumSwitchMapping$0[navigationIcon.ordinal()];
                                            if (n2 == 1) break block24;
                                            if (n2 == 2) break block25;
                                            if (n2 != 3) {
                                                if (n2 != 4) {
                                                    return true;
                                                }
                                                ActionBar actionBar2 = this.getSupportActionBar();
                                                if (actionBar2 == null) {
                                                    return true;
                                                }
                                                actionBar2.hide();
                                                return true;
                                            }
                                            Log.d((String)"nav", (String)"none");
                                            ActionBar actionBar3 = this.getSupportActionBar();
                                            if (actionBar3 != null) {
                                                actionBar3.setHomeAsUpIndicator(17170445);
                                            }
                                            ActionBar actionBar4 = this.getSupportActionBar();
                                            if (actionBar4 != null) {
                                                actionBar4.setDisplayHomeAsUpEnabled(true);
                                            }
                                            DrawerLayout.DrawerListener drawerListener = this.toggleSave;
                                            if (drawerListener == null) break block26;
                                            ActivityMainBinding activityMainBinding4 = this.binding;
                                            if (activityMainBinding4 == null) break block27;
                                            DrawerLayout drawerLayout = activityMainBinding4.drawerLayout;
                                            Objects.requireNonNull((Object)drawerLayout);
                                            List list = drawerLayout.mListeners;
                                            if (list != null) {
                                                list.remove((Object)drawerListener);
                                            }
                                        }
                                        if ((activityMainBinding2 = this.binding) != null) {
                                            activityMainBinding2.drawerLayout.setDrawerLockMode(1);
                                            return true;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                    throw null;
                                }
                                Log.d((String)"nav", (String)"back");
                                ActionBar actionBar = this.getSupportActionBar();
                                if (actionBar != null) {
                                    actionBar.setHomeAsUpIndicator(2131165211);
                                }
                                ActionBar actionBar5 = this.getSupportActionBar();
                                if (actionBar5 != null) {
                                    actionBar5.setDisplayHomeAsUpEnabled(true);
                                }
                                ActionBar actionBar6 = this.getSupportActionBar();
                                if (actionBar6 != null) {
                                    actionBar6.setDisplayShowHomeEnabled(true);
                                }
                                ActivityMainBinding activityMainBinding5 = this.binding;
                                if (activityMainBinding5 != null) {
                                    activityMainBinding5.appBarMain.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$MainActivity$GrRBUyUzMCoOQ5rumf-HS5SUIYI(this));
                                    ActivityMainBinding activityMainBinding6 = this.binding;
                                    if (activityMainBinding6 != null) {
                                        activityMainBinding6.drawerLayout.setDrawerLockMode(1);
                                        return true;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                                throw null;
                            }
                            Log.d((String)"nav", (String)"menu");
                            ActionBar actionBar = this.getSupportActionBar();
                            if (actionBar != null) {
                                actionBar.setDisplayHomeAsUpEnabled(false);
                            }
                            DrawerLayout.DrawerListener drawerListener = this.toggleSave;
                            if (drawerListener == null) break block28;
                            ActivityMainBinding activityMainBinding7 = this.binding;
                            if (activityMainBinding7 == null) break block29;
                            activityMainBinding7.drawerLayout.addDrawerListener(drawerListener);
                            ((ActionBarDrawerToggle)drawerListener).syncState();
                            ActivityMainBinding activityMainBinding8 = this.binding;
                            if (activityMainBinding8 == null) break block30;
                            activityMainBinding8.drawerLayout.setDrawerLockMode(3);
                            ActivityMainBinding activityMainBinding9 = this.binding;
                            if (activityMainBinding9 == null) break block31;
                            activityMainBinding9.appBarMain.toolbar.setNavigationIcon(2131165292);
                        }
                        if ((activityMainBinding = this.binding) != null) {
                            activityMainBinding.appBarMain.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$MainActivity$S4_CKgSrjUkU_DTH_ECDvK6DnIk(this));
                            return true;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
        throw null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onDestroy() {
        Log.d((String)"MainActivity", (String)"on destroy");
        super.onDestroy();
        this.unregisterReceiver((BroadcastReceiver)this.localeBr);
        var21_2 = var2_1 = EventBus.getDefault();
        // MONITORENTER : var21_2
        var4_3 = var2_1.typesBySubscriber.containsKey((Object)this);
        // MONITOREXIT : var21_2
        if (var4_3 == false) return;
        var22_5 = var5_4 = EventBus.getDefault();
        // MONITORENTER : var22_5
        var7_6 = (List)var5_4.typesBySubscriber.get((Object)this);
        if (var7_6 == null) {
            var16_13 = var5_4.logger;
            var17_14 = Level.WARNING;
            var18_15 = new StringBuilder();
            var18_15.append("Subscriber to unregister was not registered before: ");
            var18_15.append((Object)this.getClass());
            var16_13.log(var17_14, var18_15.toString());
            // MONITOREXIT : var22_5
            return;
        }
        var8_7 = var7_6.iterator();
        block5 : do lbl-1000: // 3 sources:
        {
            if (!var8_7.hasNext()) {
                var5_4.typesBySubscriber.remove((Object)this);
                return;
            }
            var10_8 = (Class)var8_7.next();
            var11_9 = (List)var5_4.subscriptionsByEventType.get((Object)var10_8);
            if (var11_9 == null) ** GOTO lbl-1000
            var12_10 = var11_9.size();
            var13_11 = 0;
            do {
                if (var13_11 >= var12_10) continue block5;
                var14_12 = (Subscription)var11_9.get(var13_11);
                if (var14_12.subscriber == this) {
                    var14_12.active = false;
                    var11_9.remove(var13_11);
                    --var13_11;
                    --var12_10;
                }
                ++var13_11;
            } while (true);
            break;
        } while (true);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter((Object)menuItem, (String)"item");
        switch (menuItem.getItemId()) {
            default: {
                break;
            }
            case 2131296609: {
                Log.d((String)"nav", (String)"statistic");
                FeatureFragment featureFragment = this.currentFeatureFragment;
                if (featureFragment == null) break;
                FeatureFragment.replaceFragment$default(featureFragment, "Statistic", new Serializable[0], null, 4, null);
                break;
            }
            case 2131296608: {
                Log.d((String)"nav", (String)"settings");
                FeatureFragment featureFragment = this.currentFeatureFragment;
                if (featureFragment == null) break;
                FeatureFragment.replaceFragment$default(featureFragment, "settings", new Serializable[0], null, 4, null);
                break;
            }
            case 2131296607: {
                Log.d((String)"nav", (String)"information");
                FeatureFragment featureFragment = this.currentFeatureFragment;
                if (featureFragment == null) break;
                FeatureFragment.replaceFragment$default(featureFragment, "information", new Serializable[0], null, 4, null);
                break;
            }
            case 2131296606: {
                Log.d((String)"nav", (String)"home");
                FeatureFragment featureFragment = this.currentFeatureFragment;
                if (featureFragment == null) break;
                FeatureFragment.replaceFragment$default(featureFragment, "actionChoice", new Serializable[0], null, 4, null);
                break;
            }
            case 2131296605: {
                String string;
                Log.d((String)"nav", (String)"help");
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this, 2131886082));
                String string2 = this.getString(2131820640);
                AlertController.AlertParams alertParams = builder.P;
                alertParams.mTitle = string2;
                alertParams.mView = null;
                alertParams.mViewLayoutResId = 2131492915;
                builder.setPositiveButton((CharSequence)this.getString(2131820575), null);
                AlertDialog alertDialog = builder.create();
                Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(ContextThemeWrapper(this,\n                    R.style.AlertDialogCustom\n                ))\n                    .setTitle(getString(R.string.help_title))\n                    .setView(R.layout.help_view)\n                    .setPositiveButton(getString(R.string.action_ok), null)\n                    .create()");
                alertDialog.show();
                SharedViewModel sharedViewModel = (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)this).get(SharedViewModel.class);
                Intrinsics.checkNotNullExpressionValue((Object)((Object)sharedViewModel), (String)"run {\n                    ViewModelProvider(this).get(SharedViewModel::class.java)\n                }");
                ConfResult confResult = sharedViewModel.configuration;
                ConfAbout confAbout = confResult == null ? null : confResult.getConfAbout();
                TextView textView = (TextView)alertDialog.findViewById(2131296788);
                if (textView != null) {
                    Object[] arrobject = new Object[1];
                    String string3 = confAbout == null ? null : confAbout.getUrl();
                    arrobject[0] = string3;
                    textView.setText((CharSequence)this.getString(2131820639, arrobject));
                }
                try {
                    string = this.getPackageManager().getPackageInfo((String)this.getPackageName(), (int)0).versionName;
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pInfo.versionName");
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    nameNotFoundException.printStackTrace();
                    string = "";
                }
                TextView textView2 = (TextView)alertDialog.findViewById(2131296755);
                if (textView2 == null) break;
                textView2.setText((CharSequence)this.getString(2131820641, new Object[]{string}));
            }
        }
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding != null) {
            activityMainBinding.drawerLayout.closeDrawer(8388611);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
        throw null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter((Object)menuItem, (String)"item");
        FeatureFragment featureFragment = this.currentFeatureFragment;
        if (featureFragment == null) {
            return true;
        }
        return featureFragment.onOptionsItemSelected(menuItem);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onResume() {
        EventBus eventBus2;
        Log.d((String)"MainActivity", (String)"on resume");
        FragmentActivity.super.onResume();
        EventBus eventBus3 = eventBus2 = EventBus.getDefault();
        // MONITORENTER : eventBus3
        boolean bl = eventBus2.typesBySubscriber.containsKey((Object)this);
        // MONITOREXIT : eventBus3
        if (bl) return;
        EventBus eventBus = EventBus.getDefault();
        Objects.requireNonNull((Object)eventBus);
        SubscriberMethodFinder subscriberMethodFinder = eventBus.subscriberMethodFinder;
        Objects.requireNonNull((Object)subscriberMethodFinder);
        List list = (List)SubscriberMethodFinder.METHOD_CACHE.get(MainActivity.class);
        if (list == null) {
            SubscriberMethodFinder.FindState findState = subscriberMethodFinder.prepareFindState();
            findState.clazz = MainActivity.class;
            findState.skipSuperClasses = false;
            findState.subscriberInfo = null;
            while (findState.clazz != null) {
                SubscriberInfo subscriberInfo;
                SubscriberInfo subscriberInfo2 = findState.subscriberInfo;
                if (subscriberInfo2 == null || subscriberInfo2.getSuperSubscriberInfo() == null || findState.clazz != (subscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo()).getSubscriberClass()) {
                    subscriberInfo = null;
                }
                findState.subscriberInfo = subscriberInfo;
                if (subscriberInfo != null) {
                    for (SubscriberMethod subscriberMethod : subscriberInfo.getSubscriberMethods()) {
                        if (!findState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) continue;
                        findState.subscriberMethods.add((Object)subscriberMethod);
                    }
                } else {
                    subscriberMethodFinder.findUsingReflectionInSingleClass(findState);
                }
                findState.moveToSuperclass();
            }
            list = subscriberMethodFinder.getMethodsAndRelease(findState);
            if (((ArrayList)list).isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Subscriber ");
                stringBuilder.append(MainActivity.class);
                stringBuilder.append(" and its super classes have no public methods with the @Subscribe annotation");
                throw new EventBusException(stringBuilder.toString());
            }
            SubscriberMethodFinder.METHOD_CACHE.put(MainActivity.class, (Object)list);
        }
        EventBus eventBus4 = eventBus;
        // MONITORENTER : eventBus4
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : eventBus4
                return;
            }
            eventBus.subscribe((Object)this, (SubscriberMethod)iterator.next());
        } while (true);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public final void onShowLoadingAnimEvent(ShowLoadingAnimEvent showLoadingAnimEvent) {
        Intrinsics.checkNotNullParameter((Object)showLoadingAnimEvent, (String)"showLoadingAnimEvent");
        Log.d((String)"MainActivity", (String)Intrinsics.stringPlus((String)"show loading anim event ", (Object)showLoadingAnimEvent.show));
        this.runOnUiThread((Runnable)new -$$Lambda$MainActivity$z2xoq5y0JZOkQFtVgxslC3eLBao(showLoadingAnimEvent, this));
    }

    @Override
    public void onSynchronizationDone() {
    }

    public final boolean replaceFragment(String string) {
        FeatureChildFragment featureChildFragment;
        String string2;
        FeatureFragment featureFragment;
        Log.d((String)"MainActivity", (String)"replace fragment");
        Fragment fragment = this.getSupportFragmentManager().findFragmentByTag(string);
        BackStackRecord backStackRecord = new BackStackRecord(this.getSupportFragmentManager());
        Intrinsics.checkNotNullExpressionValue((Object)backStackRecord, (String)"supportFragmentManager.beginTransaction()");
        List list = this.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"supportFragmentManager.fragments");
        for (Fragment fragment2 : list) {
            FragmentManager fragmentManager = fragment2.mFragmentManager;
            if (fragmentManager != null && fragmentManager != backStackRecord.mManager) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Cannot hide Fragment attached to a different FragmentManager. Fragment ");
                stringBuilder.append(fragment2.toString());
                stringBuilder.append(" is already attached to a FragmentManager.");
                throw new IllegalStateException(stringBuilder.toString());
            }
            backStackRecord.addOp(new FragmentTransaction.Op(4, fragment2));
        }
        boolean bl = true;
        if (fragment == null) {
            fragment = Intrinsics.areEqual((Object)string, (Object)"NavigationFragment") ? new NavigationFragment() : new NavigationFragment();
            backStackRecord.doAddOp(2131296547, fragment, string, (int)bl);
            backStackRecord.commit();
        } else {
            FragmentManager fragmentManager = fragment.mFragmentManager;
            if (fragmentManager != null && fragmentManager != backStackRecord.mManager) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Cannot show Fragment attached to a different FragmentManager. Fragment ");
                stringBuilder.append(fragment.toString());
                stringBuilder.append(" is already attached to a FragmentManager.");
                throw new IllegalStateException(stringBuilder.toString());
            }
            backStackRecord.addOp(new FragmentTransaction.Op(5, fragment));
            backStackRecord.commit();
            bl = false;
        }
        if (fragment instanceof FeatureFragment) {
            this.currentFeatureFragment = (FeatureFragment)fragment;
        }
        if ((featureFragment = this.currentFeatureFragment) != null && (string2 = (featureChildFragment = featureFragment.currentFragment) == null ? null : featureChildFragment.getTitle()) != null) {
            this.setTitle((CharSequence)string2);
        }
        this.currentTag = string;
        return bl;
    }

    @Override
    public void saveResult(SyncResult syncResult) {
        SynchronisationUtils.INSTANCE.saveSynchronization(syncResult, (Context)this, this, this, "MainActivity", true);
    }

    @Override
    public void showErrorMessage(int n2, int n3) {
        Log.i((String)"MainActivity", (String)"Error during sync (network available)");
    }

    @Override
    public void showLoading(boolean bl) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void showSnackBar(String string, String string2, String string3, Constants$Criticity constants$Criticity, View.OnClickListener onClickListener) {
        block8 : {
            block12 : {
                block13 : {
                    int n2;
                    block11 : {
                        block9 : {
                            block10 : {
                                Intrinsics.checkNotNullParameter((Object)string, (String)"identifier");
                                Intrinsics.checkNotNullParameter((Object)string2, (String)"messageLine1");
                                Intrinsics.checkNotNullParameter((Object)((Object)constants$Criticity), (String)"criticity");
                                this.snackBarIdentifier = string;
                                ActivityMainBinding activityMainBinding = this.binding;
                                if (activityMainBinding == null) break block8;
                                activityMainBinding.appBarMain.contentMain.textViewCsLine1.setText((CharSequence)string2);
                                if (string3 != null) break block9;
                                ActivityMainBinding activityMainBinding2 = this.binding;
                                if (activityMainBinding2 == null) break block10;
                                activityMainBinding2.appBarMain.contentMain.textViewCsLine2.setVisibility(8);
                                break block11;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                            throw null;
                        }
                        ActivityMainBinding activityMainBinding = this.binding;
                        if (activityMainBinding == null) break block12;
                        activityMainBinding.appBarMain.contentMain.textViewCsLine2.setVisibility(0);
                        ActivityMainBinding activityMainBinding3 = this.binding;
                        if (activityMainBinding3 == null) break block13;
                        activityMainBinding3.appBarMain.contentMain.textViewCsLine2.setText((CharSequence)string3);
                    }
                    int n3 = constants$Criticity.ordinal();
                    if (n3 != 0) {
                        if (n3 != 1) throw new NoWhenBranchMatchedException();
                        n2 = this.getResources().getColor(2131034210, null);
                    } else {
                        n2 = this.getResources().getColor(2131034209, null);
                    }
                    ActivityMainBinding activityMainBinding = this.binding;
                    if (activityMainBinding != null) {
                        activityMainBinding.appBarMain.contentMain.clCustomSnackbar.setBackgroundColor(n2);
                        ActivityMainBinding activityMainBinding4 = this.binding;
                        if (activityMainBinding4 != null) {
                            activityMainBinding4.appBarMain.contentMain.clCustomSnackbar.setVisibility(0);
                            ActivityMainBinding activityMainBinding5 = this.binding;
                            if (activityMainBinding5 != null) {
                                activityMainBinding5.appBarMain.contentMain.clCustomSnackbar.setOnClickListener(onClickListener);
                                return;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
        throw null;
    }

}

