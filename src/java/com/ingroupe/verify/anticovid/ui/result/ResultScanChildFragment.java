/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.VibrationEffect
 *  android.os.Vibrator
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.ImageView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.result;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.adapter.IAdapterInterfaceClick;
import com.ingroupe.verify.anticovid.adapter.ResultScanAdapter;
import com.ingroupe.verify.anticovid.common.-$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.model.ResultData;
import com.ingroupe.verify.anticovid.common.model.ResultScan;
import com.ingroupe.verify.anticovid.databinding.ResultScanMainBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import com.ingroupe.verify.anticovid.ui.result.-$$Lambda$ResultScanChildFragment$KKCtRPBBiXeBLI5W6n3FI1NZ9Es;
import com.ingroupe.verify.anticovid.ui.result.-$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs;
import com.ingroupe.verify.anticovid.ui.result.ResultScanPresenter;
import com.ingroupe.verify.anticovid.ui.result.ResultScanPresenterImpl;
import com.ingroupe.verify.anticovid.ui.result.ResultScanView;
import dalvik.annotation.SourceDebugExtension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nResultScanChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResultScanChildFragment.kt\ncom/ingroupe/verify/anticovid/ui/result/ResultScanChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,268:1\n1#2:269\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b>\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\u0006\u0012\u0002\b\u00030/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006?"}, d2={"Lcom/ingroupe/verify/anticovid/ui/result/ResultScanChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/ui/result/ResultScanView;", "Lcom/ingroupe/verify/anticovid/adapter/IAdapterInterfaceClick;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onStop", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "position", "onItemClick", "(I)V", "Lcom/ingroupe/verify/anticovid/databinding/ResultScanMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/ResultScanMainBinding;", "Lcom/ingroupe/verify/anticovid/common/model/ResultScan;", "resultScan", "Lcom/ingroupe/verify/anticovid/common/model/ResultScan;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "viewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "model", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "Lcom/ingroupe/verify/anticovid/ui/result/ResultScanPresenter;", "presenter", "Lcom/ingroupe/verify/anticovid/ui/result/ResultScanPresenter;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class ResultScanChildFragment
extends FeatureChildFragment
implements ResultScanView,
IAdapterInterfaceClick {
    public static final /* synthetic */ int $r8$clinit;
    public ResultScanMainBinding _binding;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public SharedViewModel model;
    public ResultScanPresenter presenter;
    public ResultScan resultScan = new ResultScan();
    public RecyclerView.Adapter<?> viewAdapter;
    public RecyclerView.LayoutManager viewManager;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        MenuInflater menuInflater = fragmentActivity.getMenuInflater();
        if (menuInflater == null) {
            return;
        }
        menuInflater.inflate(2131558401, menu);
    }

    @Override
    public String getTitle() {
        return "R\u00e9sultat";
    }

    @Override
    public Integer getTitleId() {
        return 2131820842;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        ImageView imageView;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131492994, viewGroup, false);
        int n2 = 2131296362;
        Button button = (Button)view.findViewById(n2);
        if (button != null && (imageView = (ImageView)view.findViewById(n2 = 2131296519)) != null && (recyclerView = (RecyclerView)view.findViewById(n2 = 2131296652)) != null) {
            ResultScanMainBinding resultScanMainBinding;
            ConstraintLayout constraintLayout = (ConstraintLayout)view;
            this._binding = resultScanMainBinding = new ResultScanMainBinding(constraintLayout, button, imageView, recyclerView);
            Intrinsics.checkNotNull((Object)resultScanMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout, (String)"binding.root");
            if (this.presenter == null) {
                ResultScanPresenterImpl resultScanPresenterImpl = this.getContext() == null ? null : new ResultScanPresenterImpl(this);
                this.presenter = resultScanPresenterImpl;
            }
            return constraintLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    @Override
    public void onItemClick(int n2) {
        String string = ((ResultData)this.resultScan.datas.get((int)n2)).format;
        switch (string.hashCode()) {
            default: {
                return;
            }
            case -991534178: {
                if (!string.equals((Object)"Icone_1")) {
                    return;
                }
                FragmentActivity fragmentActivity = this.getActivity();
                Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ((Activity)fragmentActivity, 2131493028, 2131296395));
                return;
            }
            case -1617169395: {
                if (!string.equals((Object)"Check_global_2")) {
                    return;
                }
                FragmentActivity fragmentActivity = this.getActivity();
                Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ((Activity)fragmentActivity, 2131493026, 2131296392));
                return;
            }
            case -1617169396: {
                if (!string.equals((Object)"Check_global_1")) {
                    return;
                }
                FragmentActivity fragmentActivity = this.getActivity();
                Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ((Activity)fragmentActivity, 2131493027, 2131296393));
                return;
            }
            case -1888000356: {
                if (!string.equals((Object)"Check_3")) {
                    return;
                }
                FragmentActivity fragmentActivity = this.getActivity();
                Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ((Activity)fragmentActivity, 2131493025, 2131296391));
                return;
            }
            case -1888000358: 
        }
        if (!string.equals((Object)"Check_1")) {
            return;
        }
        FragmentActivity fragmentActivity = this.getActivity();
        Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
        Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
        fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$XVDshywCycEp0EY3_-OkrT4ZVlQ((Activity)fragmentActivity, 2131493024, 2131296390));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Boolean bl;
        Intrinsics.checkNotNullParameter((Object)menuItem, (String)"item");
        switch (menuItem.getItemId()) {
            default: {
                return false;
            }
            case 2131296319: {
                FeatureFragment featureFragment = this.featureFragment;
                if (featureFragment == null) {
                    return true;
                }
                FeatureFragment.popToTag$default(featureFragment, "actionChoice", null, false, 6, null);
                return true;
            }
            case 2131296318: 
        }
        Context context = this.getContext();
        if (context == null) {
            bl = null;
        } else {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
            String string = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
            boolean bl2 = string != null;
            bl = bl2;
        }
        if (Intrinsics.areEqual(bl, (Object)Boolean.TRUE)) {
            FeatureFragment featureFragment = this.featureFragment;
            if (featureFragment == null) {
                return true;
            }
            FeatureFragment.replaceFragment$default(featureFragment, "tutorialOTHelp", new Serializable[0], null, 4, null);
            return true;
        }
        FeatureFragment featureFragment = this.featureFragment;
        if (featureFragment == null) {
            return true;
        }
        FeatureFragment.replaceFragment$default(featureFragment, "tutorialResultHelp", new Serializable[0], null, 4, null);
        return true;
    }

    public void onResume() {
        Context context;
        Window window;
        Log.d((String)"resultScanF", (String)"on Resume");
        this.mCalled = true;
        if (this.presenter == null) {
            ResultScanPresenterImpl resultScanPresenterImpl = this.getContext() == null ? null : new ResultScanPresenterImpl(this);
            this.presenter = resultScanPresenterImpl;
        }
        Intrinsics.checkNotNullExpressionValue((Object)Boolean.TRUE, (String)"BLOCK_SCREENSHOT");
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity != null && (window = fragmentActivity.getWindow()) != null) {
            window.setFlags(8192, 8192);
        }
        if ((context = this.getContext()) == null) {
            return;
        }
        SynchronisationUtils.INSTANCE.checkStep(context, true);
    }

    public void onStop() {
        this.mCalled = true;
        this.handler.removeMessages(0);
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        Window window = fragmentActivity.getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(8192);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onViewCreated(View view, Bundle bundle) {
        boolean bl;
        Boolean bl2;
        boolean bl3;
        block35 : {
            boolean bl4;
            block34 : {
                ResultScanPresenter resultScanPresenter;
                ArrayList<DocumentErrorsResult> arrayList;
                Window window;
                Intrinsics.checkNotNullParameter((Object)view, (String)"view");
                bl2 = Boolean.TRUE;
                Intrinsics.checkNotNullExpressionValue((Object)bl2, (String)"BLOCK_SCREENSHOT");
                FragmentActivity fragmentActivity = this.getActivity();
                if (fragmentActivity != null && (window = fragmentActivity.getWindow()) != null) {
                    window.setFlags(8192, 8192);
                }
                ResultScanMainBinding resultScanMainBinding = this._binding;
                Intrinsics.checkNotNull((Object)resultScanMainBinding);
                resultScanMainBinding.buttonNewScan.setOnClickListener((View.OnClickListener)new -$$Lambda$ResultScanChildFragment$KKCtRPBBiXeBLI5W6n3FI1NZ9Es(this));
                FragmentActivity fragmentActivity2 = this.getActivity();
                SharedViewModel sharedViewModel = fragmentActivity2 == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity2).get(SharedViewModel.class);
                if (sharedViewModel == null) {
                    throw new Exception("Invalid Activity");
                }
                this.model = sharedViewModel;
                this.resultScan = new ResultScan();
                SharedViewModel sharedViewModel2 = this.model;
                if (sharedViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                DocumentResult documentResult = sharedViewModel2.currentResponse;
                boolean bl5 = documentResult != null && (arrayList = documentResult.getErrors()) != null && true ^ arrayList.isEmpty();
                if (bl5 && (resultScanPresenter = this.presenter) != null) {
                    ResultScan resultScan = this.resultScan;
                    SharedViewModel sharedViewModel3 = this.model;
                    if (sharedViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                        throw null;
                    }
                    DocumentResult documentResult2 = sharedViewModel3.currentResponse;
                    ArrayList<DocumentErrorsResult> arrayList2 = documentResult2 == null ? null : documentResult2.getErrors();
                    Intrinsics.checkNotNull(arrayList2);
                    Context context = this.requireContext();
                    Intrinsics.checkNotNullExpressionValue((Object)context, (String)"requireContext()");
                    resultScanPresenter.prepareErrorResult(resultScan, arrayList2, context);
                }
                Object[] arrobject = new Object[4];
                SharedViewModel sharedViewModel4 = this.model;
                if (sharedViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                DocumentResult documentResult3 = sharedViewModel4.currentResponse;
                DocumentDataResult documentDataResult = documentResult3 == null ? null : documentResult3.getData();
                arrobject[0] = documentDataResult;
                arrobject[1] = view;
                arrobject[2] = this.presenter;
                arrobject[3] = this.getContext();
                Intrinsics.checkNotNullParameter((Object)arrobject, (String)"elements");
                for (int i2 = 0; i2 < 4; ++i2) {
                    if (arrobject[i2] != null) continue;
                    bl4 = false;
                    break block34;
                }
                bl4 = true;
            }
            if (bl4) {
                ResultScanPresenter resultScanPresenter;
                SharedViewModel sharedViewModel = this.model;
                if (sharedViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                if (sharedViewModel.configuration == null && (resultScanPresenter = this.presenter) != null) {
                    Context context = this.requireContext();
                    Intrinsics.checkNotNullExpressionValue((Object)context, (String)"requireContext()");
                    resultScanPresenter.reloadConf(sharedViewModel, context);
                }
                ResultScanPresenter resultScanPresenter2 = this.presenter;
                Intrinsics.checkNotNull((Object)resultScanPresenter2);
                ResultScan resultScan = this.resultScan;
                SharedViewModel sharedViewModel5 = this.model;
                if (sharedViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                DocumentResult documentResult = sharedViewModel5.currentResponse;
                String string = documentResult == null ? null : documentResult.getResourceType();
                SharedViewModel sharedViewModel6 = this.model;
                if (sharedViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                DocumentResult documentResult4 = sharedViewModel6.currentResponse;
                DocumentDataResult documentDataResult = documentResult4 == null ? null : documentResult4.getData();
                Intrinsics.checkNotNull((Object)documentDataResult);
                SharedViewModel sharedViewModel7 = this.model;
                if (sharedViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                    throw null;
                }
                ConfResult confResult = sharedViewModel7.configuration;
                Context context = this.requireContext();
                Intrinsics.checkNotNullExpressionValue((Object)context, (String)"requireContext()");
                Context context2 = this.requireContext();
                Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"requireContext()");
                Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
                SharedPreferences sharedPreferences = ((Activity)context2).getPreferences(0);
                String string2 = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                boolean bl6 = string2 != null;
                resultScanPresenter2.prepareResult(resultScan, string, documentDataResult, confResult, context, bl6);
            }
            Object[] arrobject = new Object[]{this.resultScan, view};
            Intrinsics.checkNotNullParameter((Object)arrobject, (String)"elements");
            for (int i3 = 0; i3 < 2; ++i3) {
                if (arrobject[i3] != null) continue;
                bl3 = false;
                break block35;
            }
            bl3 = true;
        }
        if (bl3) {
            SharedViewModel sharedViewModel;
            this.viewManager = new LinearLayoutManager((Context)this.getActivity());
            SharedViewModel sharedViewModel8 = this.model;
            if (sharedViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                throw null;
            }
            Boolean bl7 = sharedViewModel8.resultAlreadyViewed;
            if (bl7 != null && !bl7.booleanValue() && this.resultScan.datas.size() >= 1 && Intrinsics.areEqual((Object)"Check_global_2", (Object)((ResultData)this.resultScan.datas.get((int)0)).format)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Context context = this.getContext();
                    Object object = context == null ? null : context.getSystemService("vibrator");
                    Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.os.Vibrator");
                    ((Vibrator)object).vibrate(VibrationEffect.createOneShot((long)500L, (int)-1));
                } else {
                    Context context = this.getContext();
                    Object object = context == null ? null : context.getSystemService("vibrator");
                    Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.os.Vibrator");
                    ((Vibrator)object).vibrate(500L);
                }
            }
            if ((sharedViewModel = this.model) == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                throw null;
            }
            sharedViewModel.resultAlreadyViewed = bl2;
            this.viewAdapter = new ResultScanAdapter(this.resultScan, this);
            ResultScanMainBinding resultScanMainBinding = this._binding;
            Intrinsics.checkNotNull((Object)resultScanMainBinding);
            RecyclerView recyclerView = resultScanMainBinding.recyclerViewResult;
            Intrinsics.checkNotNullExpressionValue((Object)recyclerView, (String)"binding.recyclerViewResult");
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = this.viewManager;
            if (layoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"viewManager");
                throw null;
            }
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter<?> adapter = this.viewAdapter;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"viewAdapter");
                throw null;
            }
            recyclerView.setAdapter(adapter);
        }
        Handler handler = this.handler;
        -$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs -$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs = new -$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs(this);
        SharedViewModel sharedViewModel = this.model;
        if (sharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"model");
            throw null;
        }
        DocumentResult documentResult = sharedViewModel.currentResponse;
        if (documentResult == null) {
            bl = false;
        } else {
            DocumentDataResult documentDataResult = documentResult.getData();
            if (documentDataResult == null) {
                bl = false;
            } else {
                ArrayList<Map<String, String>> arrayList = documentDataResult.getDynamic();
                if (arrayList == null) {
                    bl = false;
                } else {
                    Map map = (Map)arrayList.get(0);
                    if (map == null) {
                        bl = false;
                    } else {
                        Set set = map.keySet();
                        if (set == null) {
                            bl = false;
                        } else {
                            boolean bl8 = set.contains((Object)"blacklist");
                            bl = false;
                            if (bl8) {
                                bl = true;
                            }
                        }
                    }
                }
            }
        }
        long l2 = bl ? 300000L : 30000L;
        handler.postDelayed((Runnable)-$$Lambda$ResultScanChildFragment$mNa08iEVfnLs6_DF72-bgAGJBXs, l2);
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        Context context = this.getContext();
        if (context == null) {
            return MainActivity.NavigationIcon.BACK;
        }
        if (SynchronisationUtils.INSTANCE.getCurrentStep(context) < 3) {
            return MainActivity.NavigationIcon.BACK;
        }
        return MainActivity.NavigationIcon.NO_ICON;
    }
}

