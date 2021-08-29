/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.SpannableString
 *  android.text.style.UnderlineSpan
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContracts
 *  androidx.activity.result.contract.ActivityResultContracts$RequestPermission
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.arch.core.util.Function
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.content.ContextCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$6
 *  androidx.fragment.app.Fragment$8
 *  androidx.fragment.app.Fragment$9
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.concurrent.atomic.AtomicReference
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.arch.core.util.Function;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.databinding.InitMainBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$GJOAp1mWP5Q_N3PZ_1SxCsV7gXo;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$S-1ScxFMjA0CnPs5JYnAUccx6ZI;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$ZG4IvpI2na5IQbHRGZ1UF-U0qnQ;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$fgu5JOBMiNwOCLNQ8Hnb9yb9AQQ;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$y2BZ5rZiU64mMuXpQ-s_B8RSkl0;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$zcbCeBvq5AujLL02z72DLr4B2NU;
import com.ingroupe.verify.anticovid.ui.init.InitPresenter;
import com.ingroupe.verify.anticovid.ui.init.InitPresenterImpl;
import com.ingroupe.verify.anticovid.ui.init.InitView;
import dalvik.annotation.SourceDebugExtension;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nInitChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitChildFragment.kt\ncom/ingroupe/verify/anticovid/ui/init/InitChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006,"}, d2={"Lcom/ingroupe/verify/anticovid/ui/init/InitChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/ui/init/InitView;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "checkCameraPermission", "()V", "Lcom/ingroupe/verify/anticovid/ui/init/InitPresenter;", "presenter", "Lcom/ingroupe/verify/anticovid/ui/init/InitPresenter;", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "model", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "Lcom/ingroupe/verify/anticovid/databinding/InitMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/InitMainBinding;", "Landroidx/activity/result/ActivityResultLauncher;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class InitChildFragment
extends FeatureChildFragment
implements InitView {
    public static final /* synthetic */ int $r8$clinit;
    public InitMainBinding _binding;
    public SharedViewModel model;
    public InitPresenter presenter;
    public ActivityResultLauncher<String> requestPermissionLauncher;

    public InitChildFragment() {
        ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
        -$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg -$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg = new -$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg(this);
        Fragment.6 var3_3 = new Fragment.6((Fragment)this);
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            Fragment.8 var5_5 = new Fragment.8((Fragment)this, (Function)var3_3, atomicReference, (ActivityResultContract)requestPermission, (ActivityResultCallback)-$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg);
            if (this.mState >= 0) {
                var5_5.onPreAttached();
            } else {
                this.mOnPreAttachedListeners.add((Object)var5_5);
            }
            Fragment.9 var7_6 = new Fragment.9((Fragment)this, atomicReference, (ActivityResultContract)requestPermission);
            Intrinsics.checkNotNullExpressionValue((Object)var7_6, (String)"registerForActivityResult(ActivityResultContracts.RequestPermission()\n    ){ isGranted: Boolean ->\n        if (isGranted) {\n            goToNextPage()\n        } else {\n            requestCameraPermission()\n        }\n    }");
            this.requestPermissionLauncher = var7_6;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append((Object)this);
        stringBuilder.append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission((Context)this.requireActivity(), (String)"android.permission.CAMERA") != 0) {
            int n2;
            View view = LayoutInflater.from((Context)this.getContext()).inflate(2131492979, null, false);
            Button button = (Button)view.findViewById(n2 = 2131296360);
            if (button != null && (TextView)view.findViewById(n2 = 2131296757) != null && (TextView)view.findViewById(n2 = 2131296758) != null && (TextView)view.findViewById(n2 = 2131296759) != null) {
                ScrollView scrollView = (ScrollView)view;
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this.getActivity(), 2131886082));
                AlertController.AlertParams alertParams = builder.P;
                alertParams.mView = scrollView;
                alertParams.mViewLayoutResId = 0;
                AlertDialog alertDialog = builder.create();
                Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(ContextThemeWrapper(activity,\n                R.style.AlertDialogCustom\n            ))\n                .setView(bindingDialog.root)\n                .create()");
                alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)new -$$Lambda$InitChildFragment$ZG4IvpI2na5IQbHRGZ1UF-U0qnQ(this));
                alertDialog.show();
                button.setOnClickListener((View.OnClickListener)new -$$Lambda$InitChildFragment$zcbCeBvq5AujLL02z72DLr4B2NU(alertDialog));
                return;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new -$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE(this), 500L);
    }

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "Initialisation";
    }

    @Override
    public Integer getTitleId() {
        return 2131820841;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131492918, viewGroup, false);
        int n2 = 2131296520;
        ImageView imageView = (ImageView)view.findViewById(n2);
        if (imageView != null && (textView = (TextView)view.findViewById(n2 = 2131296837)) != null) {
            InitMainBinding initMainBinding;
            ConstraintLayout constraintLayout = (ConstraintLayout)view;
            this._binding = initMainBinding = new InitMainBinding(constraintLayout, imageView, textView);
            Intrinsics.checkNotNull((Object)initMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout, (String)"binding.root");
            return constraintLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public void onViewCreated(View view, Bundle bundle) {
        block8 : {
            block9 : {
                block11 : {
                    FragmentActivity fragmentActivity;
                    block10 : {
                        Context context;
                        InitPresenter initPresenter;
                        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
                        FragmentActivity fragmentActivity2 = this.getActivity();
                        SharedViewModel sharedViewModel = fragmentActivity2 == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity2).get(SharedViewModel.class);
                        if (sharedViewModel == null) break block8;
                        this.model = sharedViewModel;
                        if (sharedViewModel == null) break block9;
                        sharedViewModel.configuration = null;
                        if (this.presenter == null) {
                            InitPresenterImpl initPresenterImpl = this.getContext() == null ? null : new InitPresenterImpl(this);
                            this.presenter = initPresenterImpl;
                        }
                        if ((context = this.getContext()) == null || (initPresenter = this.presenter) == null) break block10;
                        SharedViewModel sharedViewModel2 = this.model;
                        if (sharedViewModel2 == null) break block11;
                        initPresenter.loadAssets(context, sharedViewModel2);
                    }
                    SharedPreferences sharedPreferences = (fragmentActivity = this.getActivity()) == null ? null : fragmentActivity.getPreferences(0);
                    boolean bl = sharedPreferences == null ? false : sharedPreferences.getBoolean(Constants$SavedItems.INFO_CGU_POLICY_SHOWN_V2.getText(), false);
                    if (sharedPreferences != null && !bl) {
                        TextView textView;
                        int n2;
                        TextView textView2;
                        TextView textView3;
                        TextView textView4;
                        View view2 = LayoutInflater.from((Context)this.getContext()).inflate(2131492984, null, false);
                        Button button = (Button)view2.findViewById(n2 = 2131296360);
                        if (button != null && (textView = (TextView)view2.findViewById(n2 = 2131296764)) != null && (textView4 = (TextView)view2.findViewById(n2 = 2131296765)) != null && (TextView)view2.findViewById(n2 = 2131296766) != null && (TextView)view2.findViewById(n2 = 2131296767) != null && (TextView)view2.findViewById(n2 = 2131296768) != null && (TextView)view2.findViewById(n2 = 2131296769) != null && (TextView)view2.findViewById(n2 = 2131296770) != null && (TextView)view2.findViewById(n2 = 2131296771) != null && (TextView)view2.findViewById(n2 = 2131296804) != null && (textView2 = (TextView)view2.findViewById(n2 = 2131296805)) != null && (TextView)view2.findViewById(n2 = 2131296806) != null && (textView3 = (TextView)view2.findViewById(n2 = 2131296807)) != null && (TextView)view2.findViewById(n2 = 2131296808) != null) {
                            ScrollView scrollView = (ScrollView)view2;
                            AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this.getActivity(), 2131886082));
                            builder.setView((View)scrollView);
                            AlertDialog alertDialog = builder.create();
                            Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(ContextThemeWrapper(activity,\n                    R.style.AlertDialogCustom\n            ))\n                    .setView(bindingDialog.root)\n                    .create()");
                            alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)new -$$Lambda$InitChildFragment$y2BZ5rZiU64mMuXpQ-s_B8RSkl0(this));
                            alertDialog.show();
                            Context context = this.getContext();
                            if (context != null) {
                                Utils.Companion companion = Utils.Companion;
                                Intrinsics.checkNotNullExpressionValue((Object)textView2, (String)"bindingDialog.textViewLegal2");
                                companion.addLinktoTextView(textView2, 2131820648, 2131820649, context);
                                Intrinsics.checkNotNullExpressionValue((Object)textView3, (String)"bindingDialog.textViewLegal4");
                                companion.addLinktoTextView(textView3, 2131820651, 2131820652, context);
                            }
                            button.setOnClickListener((View.OnClickListener)new -$$Lambda$InitChildFragment$fgu5JOBMiNwOCLNQ8Hnb9yb9AQQ(this, sharedPreferences, alertDialog));
                            SharedViewModel sharedViewModel = this.model;
                            if (sharedViewModel != null) {
                                ConfResult confResult = sharedViewModel.configuration;
                                ConfAbout confAbout = confResult == null ? null : confResult.getConfAbout();
                                textView4.setOnClickListener((View.OnClickListener)new -$$Lambda$InitChildFragment$GJOAp1mWP5Q_N3PZ_1SxCsV7gXo(confAbout, this));
                                textView.setOnClickListener((View.OnClickListener)new -$$Lambda$InitChildFragment$S-1ScxFMjA0CnPs5JYnAUccx6ZI(confAbout, this));
                                SpannableString spannableString = new SpannableString(textView4.getText());
                                spannableString.setSpan((Object)new UnderlineSpan(), 0, spannableString.length(), 0);
                                textView4.setText((CharSequence)spannableString);
                                SpannableString spannableString2 = new SpannableString(textView.getText());
                                spannableString2.setSpan((Object)new UnderlineSpan(), 0, spannableString2.length(), 0);
                                textView.setText((CharSequence)spannableString2);
                                return;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                            throw null;
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(n2)));
                    }
                    this.checkCameraPermission();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"model");
            throw null;
        }
        throw new Exception("Invalid Activity");
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.NO_MENU;
    }
}

