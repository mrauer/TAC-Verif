/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.actionchoice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.auth.JWTUtils;
import com.ingroupe.verify.anticovid.common.Constants$Criticity;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.databinding.ActionChoicesMainBinding;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import com.ingroupe.verify.anticovid.ui.actionchoice.-$$Lambda$ActionChoiceChildFragment$1l--F5Fqj5HOTKeY51sacp61_Hg;
import com.ingroupe.verify.anticovid.ui.actionchoice.-$$Lambda$ActionChoiceChildFragment$KKt7JlYL64FOt438XGipYVmCm5o;
import com.ingroupe.verify.anticovid.ui.actionchoice.-$$Lambda$ActionChoiceChildFragment$P4utwkjTL4V_HeOzt9MBrEYd8p0;
import com.ingroupe.verify.anticovid.ui.actionchoice.-$$Lambda$ActionChoiceChildFragment$evr_K4ifyJqbY2m6ClCsDa0913k;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoicePresenter;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoicePresenterImpl;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceView;
import dalvik.annotation.SourceDebugExtension;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nActionChoiceChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionChoiceChildFragment.kt\ncom/ingroupe/verify/anticovid/ui/actionchoice/ActionChoiceChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002\u00a2\u0006\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006,"}, d2={"Lcom/ingroupe/verify/anticovid/ui/actionchoice/ActionChoiceChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/ui/actionchoice/ActionChoiceView;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Landroid/content/Context;", "context", "", "isDismissable", "showUpdateAppDialog", "(Landroid/content/Context;Z)V", "Lcom/ingroupe/verify/anticovid/databinding/ActionChoicesMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/ActionChoicesMainBinding;", "Lcom/ingroupe/verify/anticovid/ui/actionchoice/ActionChoicePresenter;", "presenter", "Lcom/ingroupe/verify/anticovid/ui/actionchoice/ActionChoicePresenter;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class ActionChoiceChildFragment
extends FeatureChildFragment
implements ActionChoiceView {
    public static final /* synthetic */ int $r8$clinit;
    public ActionChoicesMainBinding _binding;
    public ActionChoicePresenter presenter;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "V\u00e9rification";
    }

    @Override
    public Integer getTitleId() {
        return 2131820839;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131492892, viewGroup, false);
        int n2 = 2131296396;
        ConstraintLayout constraintLayout2 = (ConstraintLayout)view.findViewById(n2);
        if (constraintLayout2 != null && (constraintLayout = (ConstraintLayout)view.findViewById(n2 = 2131296397)) != null && (imageView = (ImageView)view.findViewById(n2 = 2131296516)) != null && (imageView2 = (ImageView)view.findViewById(n2 = 2131296519)) != null && (textView3 = (TextView)view.findViewById(n2 = 2131296754)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296822)) != null && (textView4 = (TextView)view.findViewById(n2 = 2131296823)) != null && (textView = (TextView)view.findViewById(n2 = 2131296829)) != null) {
            ActionChoicesMainBinding actionChoicesMainBinding;
            ConstraintLayout constraintLayout3 = (ConstraintLayout)view;
            this._binding = actionChoicesMainBinding = new ActionChoicesMainBinding(constraintLayout3, constraintLayout2, constraintLayout, imageView, imageView2, textView3, textView2, textView4, textView);
            Intrinsics.checkNotNull((Object)actionChoicesMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout3, (String)"binding.root");
            return constraintLayout3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public void onResume() {
        boolean bl;
        this.mCalled = bl = true;
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            Context context = this.getContext();
            if (context == null) {
                return;
            }
            SynchronisationUtils.INSTANCE.checkStep(context, false);
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.ingroupe.verify.CONFIG_KEY", 0);
            if (59 > sharedPreferences.getInt("LAST_APP_VERSION_SYNCHRONIZED", 0)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("INFORM_NEW_MINOR_APP_VERSION", false);
                editor.putBoolean("INFORM_NEW_MAJOR_APP_VERSION", false);
                editor.apply();
            }
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.ingroupe.verify.CONFIG_KEY", 0);
            if (!sharedPreferences2.getBoolean("INFORM_NEW_MINOR_APP_VERSION", false) && !sharedPreferences2.getBoolean("INFORM_NEW_MAJOR_APP_VERSION", false)) {
                bl = false;
            }
            if (bl) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                if (context.getSharedPreferences("com.ingroupe.verify.CONFIG_KEY", 0).getBoolean("INFORM_NEW_MAJOR_APP_VERSION", false)) {
                    this.showUpdateAppDialog(context, false);
                    return;
                }
                if (context instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity)context;
                    String string = context.getString(2131820823);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"context.getString(R.string.snackbar_version_needed_line_1)");
                    mainActivity.showSnackBar("SNACKBAR_APP_VERSION", string, context.getString(2131820824), Constants$Criticity.CRITICAL, new -$$Lambda$ActionChoiceChildFragment$P4utwkjTL4V_HeOzt9MBrEYd8p0(this, context));
                    return;
                }
            } else if (context instanceof MainActivity) {
                ((MainActivity)context).hideSnackBar("SNACKBAR_APP_VERSION");
            }
            return;
        }
        throw new Exception("Invalid Activity");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            if (this.presenter == null) {
                ActionChoicePresenterImpl actionChoicePresenterImpl = this.getContext() == null ? null : new ActionChoicePresenterImpl(this);
                this.presenter = actionChoicePresenterImpl;
            }
            ActionChoicesMainBinding actionChoicesMainBinding = this._binding;
            Intrinsics.checkNotNull((Object)actionChoicesMainBinding);
            actionChoicesMainBinding.clScan2ddoc.setOnClickListener((View.OnClickListener)new -$$Lambda$ActionChoiceChildFragment$KKt7JlYL64FOt438XGipYVmCm5o(this));
            Context context = this.getContext();
            if (context != null) {
                SynchronisationUtils synchronisationUtils = SynchronisationUtils.INSTANCE;
                if (synchronisationUtils.getCurrentStep(context) == 3) {
                    ActionChoicesMainBinding actionChoicesMainBinding2 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding2);
                    actionChoicesMainBinding2.clScan2ddoc.setEnabled(false);
                    ActionChoicesMainBinding actionChoicesMainBinding3 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding3);
                    actionChoicesMainBinding3.imageView2ddoc.setImageResource(2131165301);
                    ActionChoicesMainBinding actionChoicesMainBinding4 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding4);
                    actionChoicesMainBinding4.textViewScan2ddoc.setText((CharSequence)this.getString(2131820800));
                } else {
                    synchronisationUtils.checkStep(context, false);
                }
            }
            ActionChoicesMainBinding actionChoicesMainBinding5 = this._binding;
            Intrinsics.checkNotNull((Object)actionChoicesMainBinding5);
            actionChoicesMainBinding5.clOtExpiration.setVisibility(8);
            Context context2 = this.getContext();
            if (context2 == null) {
                return;
            }
            if (SynchronisationUtils.INSTANCE.getCurrentStep(context2) == 3) {
                ActionChoicesMainBinding actionChoicesMainBinding6 = this._binding;
                Intrinsics.checkNotNull((Object)actionChoicesMainBinding6);
                actionChoicesMainBinding6.clScan2ddoc.setEnabled(false);
                ActionChoicesMainBinding actionChoicesMainBinding7 = this._binding;
                Intrinsics.checkNotNull((Object)actionChoicesMainBinding7);
                actionChoicesMainBinding7.imageView2ddoc.setImageResource(2131165301);
                ActionChoicesMainBinding actionChoicesMainBinding8 = this._binding;
                Intrinsics.checkNotNull((Object)actionChoicesMainBinding8);
                actionChoicesMainBinding8.textViewScan2ddoc.setText((CharSequence)this.getString(2131820582));
            }
            if (JWTUtils.isModeOT(context2)) {
                ActionChoicesMainBinding actionChoicesMainBinding9 = this._binding;
                Intrinsics.checkNotNull((Object)actionChoicesMainBinding9);
                actionChoicesMainBinding9.textViewOTMode.setVisibility(0);
                ((MainActivity)context2).changeMode(false);
                int n2 = JWTUtils.daysBeforeExpiration(context2);
                if (n2 == 0) {
                    Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
                    long l2 = (JWTUtils.getDateExpiration(context2) - new Date().getTime()) / (long)3600000;
                    int n3 = l2 < 0L ? 0 : (int)l2;
                    ActionChoicesMainBinding actionChoicesMainBinding10 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding10);
                    TextView textView = actionChoicesMainBinding10.textViewOtExpText1;
                    Object[] arrobject = new Object[]{n3};
                    textView.setText((CharSequence)this.getString(2131820577, arrobject));
                    ActionChoicesMainBinding actionChoicesMainBinding11 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding11);
                    actionChoicesMainBinding11.clOtExpiration.setVisibility(0);
                    return;
                }
                if (n2 <= 20) {
                    ActionChoicesMainBinding actionChoicesMainBinding12 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding12);
                    TextView textView = actionChoicesMainBinding12.textViewOtExpText1;
                    Object[] arrobject = new Object[]{n2};
                    textView.setText((CharSequence)this.getString(2131820576, arrobject));
                    ActionChoicesMainBinding actionChoicesMainBinding13 = this._binding;
                    Intrinsics.checkNotNull((Object)actionChoicesMainBinding13);
                    actionChoicesMainBinding13.clOtExpiration.setVisibility(0);
                    return;
                }
            } else {
                ActionChoicesMainBinding actionChoicesMainBinding14 = this._binding;
                Intrinsics.checkNotNull((Object)actionChoicesMainBinding14);
                actionChoicesMainBinding14.textViewOTMode.setVisibility(8);
                ((MainActivity)context2).changeMode(true);
            }
            return;
        }
        throw new Exception("Invalid Activity");
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.SHOW_SLIDE;
    }

    public final void showUpdateAppDialog(Context context, boolean bl) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper(context, 2131886082));
        String string = this.getString(2131820750);
        AlertController.AlertParams alertParams = builder.P;
        alertParams.mTitle = string;
        alertParams.mView = null;
        alertParams.mViewLayoutResId = 2131492983;
        alertParams.mCancelable = bl;
        builder.setPositiveButton((CharSequence)this.getString(2131820585), (DialogInterface.OnClickListener)new -$$Lambda$ActionChoiceChildFragment$evr_K4ifyJqbY2m6ClCsDa0913k(this, bl));
        if (bl) {
            builder.setNegativeButton((CharSequence)this.getString(2131820572), (DialogInterface.OnClickListener)-$$Lambda$ActionChoiceChildFragment$1l--F5Fqj5HOTKeY51sacp61_Hg.INSTANCE);
        }
        builder.create();
        builder.create().show();
    }
}

