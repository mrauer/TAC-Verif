/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.text.SpannableString
 *  android.text.style.UnderlineSpan
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Date
 *  java.util.Objects
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.greenrobot.eventbus.EventBus
 */
package com.ingroupe.verify.anticovid;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$8zQ3X4zARmy80hAYO6_3iEiMrfg;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$BYfw3Y8CHFNK-v8GFcrhYy2LhEg;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$LBiE3Y9S_vBHW1xm33Q3Lfs1GGw;
import com.ingroupe.verify.anticovid.-$$Lambda$SettingsChildFragment$LYBYEkRz6th6EDlBi8Ifz7jiifw;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import com.ingroupe.verify.anticovid.common.-$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.ShowLoadingAnimEvent;
import com.ingroupe.verify.anticovid.databinding.SettingsMainBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import dalvik.annotation.SourceDebugExtension;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@SourceDebugExtension(value="SMAP\nSettingsChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsChildFragment.kt\ncom/ingroupe/verify/anticovid/SettingsChildFragment\n+ 2 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n*L\n1#1,233:1\n130#2,15:234\n*S KotlinDebug\n*F\n+ 1 SettingsChildFragment.kt\ncom/ingroupe/verify/anticovid/SettingsChildFragment\n*L\n148#1:234,15\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b2\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010 H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(H\u0016\u00a2\u0006\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00063"}, d2={"Lcom/ingroupe/verify/anticovid/SettingsChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/synchronization/SynchronisationUtils$SyncListener;", "Lcom/ingroupe/verify/anticovid/synchronization/ConfServiceUtils$ConfServiceListener;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "onSynchronizationDone", "()V", "Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;", "syncResult", "saveResult", "(Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;)V", "title", "message", "showErrorMessage", "(II)V", "", "show", "showLoading", "(Z)V", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "model", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "Lcom/ingroupe/verify/anticovid/databinding/SettingsMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/SettingsMainBinding;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class SettingsChildFragment
extends FeatureChildFragment
implements SynchronisationUtils.SyncListener,
ConfServiceUtils.ConfServiceListener {
    public static final /* synthetic */ int $r8$clinit;
    public SettingsMainBinding _binding;
    public SharedViewModel model;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "Param\u00e8tres";
    }

    @Override
    public Integer getTitleId() {
        return 2131820844;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131493004, viewGroup, false);
        int n2 = 2131296361;
        Button button = (Button)view.findViewById(n2);
        if (button != null) {
            TextView textView;
            TextView textView2;
            SwitchCompat switchCompat;
            ImageView imageView;
            TextView textView3;
            ImageView imageView2;
            TextView textView4;
            TextView textView5;
            ConstraintLayout constraintLayout;
            ImageView imageView3;
            TextView textView6;
            TextView textView7;
            ScrollView scrollView;
            TextView textView8;
            SwitchCompat switchCompat2;
            ImageView imageView4;
            TextView textView9;
            TextView textView10;
            SwitchCompat switchCompat3;
            ImageView imageView5;
            ConstraintLayout constraintLayout2;
            ConstraintLayout constraintLayout3 = (ConstraintLayout)view;
            int n3 = 2131296409;
            ConstraintLayout constraintLayout4 = (ConstraintLayout)view.findViewById(n3);
            if (constraintLayout4 != null && (constraintLayout2 = (ConstraintLayout)view.findViewById(n3 = 2131296412)) != null && (constraintLayout = (ConstraintLayout)view.findViewById(n3 = 2131296413)) != null && (imageView = (ImageView)view.findViewById(n3 = 2131296519)) != null && (imageView4 = (ImageView)view.findViewById(n3 = 2131296521)) != null && (imageView2 = (ImageView)view.findViewById(n3 = 2131296522)) != null && (imageView3 = (ImageView)view.findViewById(n3 = 2131296523)) != null && (imageView5 = (ImageView)view.findViewById(n3 = 2131296524)) != null && (scrollView = (ScrollView)view.findViewById(n3 = 2131296670)) != null && (switchCompat = (SwitchCompat)view.findViewById(n3 = 2131296724)) != null && (switchCompat2 = (SwitchCompat)view.findViewById(n3 = 2131296725)) != null && (switchCompat3 = (SwitchCompat)view.findViewById(n3 = 2131296726)) != null && (textView5 = (TextView)view.findViewById(n3 = 2131296762)) != null && (textView9 = (TextView)view.findViewById(n3 = 2131296763)) != null && (textView7 = (TextView)view.findViewById(n3 = 2131296831)) != null && (textView = (TextView)view.findViewById(n3 = 2131296832)) != null && (textView6 = (TextView)view.findViewById(n3 = 2131296838)) != null && (textView10 = (TextView)view.findViewById(n3 = 2131296839)) != null && (textView3 = (TextView)view.findViewById(n3 = 2131296840)) != null && (textView8 = (TextView)view.findViewById(n3 = 2131296841)) != null && (textView2 = (TextView)view.findViewById(n3 = 2131296842)) != null && (textView4 = (TextView)view.findViewById(n3 = 2131296843)) != null) {
                SettingsMainBinding settingsMainBinding;
                this._binding = settingsMainBinding = new SettingsMainBinding(constraintLayout3, button, constraintLayout3, constraintLayout4, constraintLayout2, constraintLayout, imageView, imageView4, imageView2, imageView3, imageView5, scrollView, switchCompat, switchCompat2, switchCompat3, textView5, textView9, textView7, textView, textView6, textView10, textView3, textView8, textView2, textView4);
                Intrinsics.checkNotNull((Object)settingsMainBinding);
                Intrinsics.checkNotNullExpressionValue((Object)constraintLayout3, (String)"binding.root");
                return constraintLayout3;
            }
            n2 = n3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    @Override
    public void onSynchronizationDone() {
        Context context = this.getContext();
        if (context != null) {
            SettingsMainBinding settingsMainBinding = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding);
            TextView textView = settingsMainBinding.textViewSyncLabel;
            Object[] arrobject = new Object[1];
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
            Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
            arrobject[0] = new Date(sharedPreferences.getLong("LAST_SYNC_DATE_V1_8_1", 0L));
            textView.setText((CharSequence)this.getString(2131820815, arrobject));
        }
        FragmentActivity fragmentActivity = this.getActivity();
        Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
        String string = this.getString(2131820813);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(R.string.settings_sync_done)");
        4 & 4;
        Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
        Intrinsics.checkNotNullParameter((Object)string, (String)"text");
        fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string, 0));
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            Context context;
            this.model = sharedViewModel;
            FragmentActivity fragmentActivity2 = this.getActivity();
            SharedPreferences sharedPreferences = fragmentActivity2 == null ? null : fragmentActivity2.getPreferences(0);
            boolean bl = sharedPreferences == null ? true : sharedPreferences.getBoolean(Constants$SavedItems.SHOW_SCAN_TUTO.getText(), true);
            boolean bl2 = sharedPreferences == null ? true : sharedPreferences.getBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), true);
            String string = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
            SettingsMainBinding settingsMainBinding = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding);
            settingsMainBinding.switchTutoScan.setChecked(bl);
            SettingsMainBinding settingsMainBinding2 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding2);
            settingsMainBinding2.switchTutoResult.setChecked(bl2);
            SettingsMainBinding settingsMainBinding3 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding3);
            settingsMainBinding3.switchTutoScan.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new RadioGroup.OnCheckedChangeListener(sharedPreferences, this){
                public final /* synthetic */ SharedPreferences $sharedPref;
                public final /* synthetic */ SettingsChildFragment this$0;
                {
                    this.$sharedPref = sharedPreferences;
                    this.this$0 = settingsChildFragment;
                }

                public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                    SharedPreferences sharedPreferences = this.$sharedPref;
                    if (sharedPreferences == null) {
                        return;
                    }
                    SettingsChildFragment settingsChildFragment = this.this$0;
                    android.content.SharedPreferences$Editor editor = sharedPreferences.edit();
                    editor.putBoolean(Constants$SavedItems.SHOW_SCAN_TUTO.getText(), bl);
                    editor.apply();
                    FragmentActivity fragmentActivity = settingsChildFragment.getActivity();
                    Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                    String string = settingsChildFragment.getString(2131820803);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(R.string.settings_change_saved)");
                    4 & 4;
                    Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                    Intrinsics.checkNotNullParameter((Object)string, (String)"text");
                    fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string, 0));
                }

                public void onCheckedChanged(RadioGroup radioGroup, int n2) {
                }
            });
            SettingsMainBinding settingsMainBinding4 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding4);
            settingsMainBinding4.switchTutoResult.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new RadioGroup.OnCheckedChangeListener(sharedPreferences, this){
                public final /* synthetic */ SharedPreferences $sharedPref;
                public final /* synthetic */ SettingsChildFragment this$0;
                {
                    this.$sharedPref = sharedPreferences;
                    this.this$0 = settingsChildFragment;
                }

                public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                    SharedPreferences sharedPreferences = this.$sharedPref;
                    if (sharedPreferences == null) {
                        return;
                    }
                    SettingsChildFragment settingsChildFragment = this.this$0;
                    android.content.SharedPreferences$Editor editor = sharedPreferences.edit();
                    editor.putBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), bl);
                    editor.apply();
                    FragmentActivity fragmentActivity = settingsChildFragment.getActivity();
                    Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                    String string = settingsChildFragment.getString(2131820803);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(R.string.settings_change_saved)");
                    4 & 4;
                    Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                    Intrinsics.checkNotNullParameter((Object)string, (String)"text");
                    fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string, 0));
                }

                public void onCheckedChanged(RadioGroup radioGroup, int n2) {
                }
            });
            SettingsMainBinding settingsMainBinding5 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding5);
            SpannableString spannableString = new SpannableString(settingsMainBinding5.textViewConfTitle.getText());
            spannableString.setSpan((Object)new UnderlineSpan(), 0, spannableString.length(), 0);
            SettingsMainBinding settingsMainBinding6 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding6);
            settingsMainBinding6.textViewConfTitle.setText((CharSequence)spannableString);
            SettingsMainBinding settingsMainBinding7 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding7);
            settingsMainBinding7.constraintLayoutConfAccess.setOnClickListener((View.OnClickListener)new -$$Lambda$SettingsChildFragment$BYfw3Y8CHFNK-v8GFcrhYy2LhEg(this));
            if (string != null) {
                SettingsMainBinding settingsMainBinding8 = this._binding;
                Intrinsics.checkNotNull((Object)settingsMainBinding8);
                settingsMainBinding8.constraintLayoutToken.setVisibility(0);
                SettingsMainBinding settingsMainBinding9 = this._binding;
                Intrinsics.checkNotNull((Object)settingsMainBinding9);
                TextView textView = settingsMainBinding9.textViewTokenText3;
                Object[] arrobject = new Object[1];
                Context context2 = this.requireContext();
                Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"requireContext()");
                Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
                SharedPreferences sharedPreferences2 = ((Activity)context2).getPreferences(0);
                long l2 = sharedPreferences2 == null ? 0L : sharedPreferences2.getLong(Constants$SavedItems.CONF_DATE_EXP.getText(), 0L);
                long l3 = (l2 - new Date().getTime()) / (long)86400000;
                int n2 = l3 < 0L ? 0 : (int)l3;
                arrobject[0] = n2;
                textView.setText((CharSequence)this.getString(2131820807, arrobject));
                SettingsMainBinding settingsMainBinding10 = this._binding;
                Intrinsics.checkNotNull((Object)settingsMainBinding10);
                settingsMainBinding10.switchOtMode.setChecked(true);
                SettingsMainBinding settingsMainBinding11 = this._binding;
                Intrinsics.checkNotNull((Object)settingsMainBinding11);
                settingsMainBinding11.switchOtMode.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new -$$Lambda$SettingsChildFragment$LYBYEkRz6th6EDlBi8Ifz7jiifw(this, sharedPreferences));
            }
            if ((context = this.getContext()) == null) {
                return;
            }
            SettingsMainBinding settingsMainBinding12 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding12);
            TextView textView = settingsMainBinding12.textViewSyncLabel;
            Object[] arrobject = new Object[1];
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SharedPreferences sharedPreferences3 = PreferenceManager.getDefaultSharedPreferences((Context)context);
            Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences3, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
            arrobject[0] = new Date(sharedPreferences3.getLong("LAST_SYNC_DATE_V1_8_1", 0L));
            textView.setText((CharSequence)this.getString(2131820815, arrobject));
            SettingsMainBinding settingsMainBinding13 = this._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding13);
            settingsMainBinding13.buttonDoSync.setOnClickListener((View.OnClickListener)new -$$Lambda$SettingsChildFragment$LBiE3Y9S_vBHW1xm33Q3Lfs1GGw(context, this));
            return;
        }
        throw new Exception("Invalid Activity");
    }

    @Override
    public void saveResult(SyncResult syncResult) {
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        SynchronisationUtils.INSTANCE.saveSynchronization(syncResult, context, this, this, "settings", false);
    }

    @Override
    public void showErrorMessage(int n2, int n3) {
        Log.e((String)"settings", (String)"showErrorMessage");
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String string = this.getResources().getString(n2);
        builder.P.mTitle = string;
        String string2 = this.getResources().getString(n3);
        AlertController.AlertParams alertParams = builder.P;
        alertParams.mMessage = string2;
        -$$Lambda$SettingsChildFragment$8zQ3X4zARmy80hAYO6_3iEiMrfg -$$Lambda$SettingsChildFragment$8zQ3X4zARmy80hAYO6_3iEiMrfg = -$$Lambda$SettingsChildFragment$8zQ3X4zARmy80hAYO6_3iEiMrfg.INSTANCE;
        alertParams.mNegativeButtonText = "OK";
        alertParams.mNegativeButtonListener = -$$Lambda$SettingsChildFragment$8zQ3X4zARmy80hAYO6_3iEiMrfg;
        AlertDialog alertDialog = builder.create();
        Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(context).setTitle(getString(title)).setMessage(getString(message))\n                .setNegativeButton(\"OK\") { dialog, _ -> dialog.dismiss() }.create()");
        alertDialog.show();
    }

    @Override
    public void showLoading(boolean bl) {
        Log.d((String)"settings", (String)Intrinsics.stringPlus((String)"show loading ", (Object)bl));
        EventBus.getDefault().post((Object)new ShowLoadingAnimEvent((Activity)this.getActivity(), bl));
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

