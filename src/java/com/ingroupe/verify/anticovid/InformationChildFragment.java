/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.style.UnderlineSpan
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ingroupe.verify.anticovid.-$$Lambda$InformationChildFragment$DT-AQa0NOc6hRbGI3By0AYdW23U;
import com.ingroupe.verify.anticovid.-$$Lambda$InformationChildFragment$ZWoD0E8zY5tDmi8uumsoMd5bltw;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.adapter.ContactAdapter;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.databinding.InformationMainBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfContact;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u0006\u0012\u0002\b\u00030%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006*"}, d2={"Lcom/ingroupe/verify/anticovid/InformationChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "model", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "Lcom/ingroupe/verify/anticovid/databinding/InformationMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/InformationMainBinding;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "viewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class InformationChildFragment
extends FeatureChildFragment {
    public static final /* synthetic */ int $r8$clinit;
    public InformationMainBinding _binding;
    public SharedViewModel model;
    public RecyclerView.Adapter<?> viewAdapter;
    public RecyclerView.LayoutManager viewManager;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "Informations et confidentialit\u00e9s";
    }

    @Override
    public Integer getTitleId() {
        return 2131820840;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView textView10;
        TextView textView11;
        RecyclerView recyclerView;
        TextView textView12;
        ImageView imageView2;
        ScrollView scrollView;
        TextView textView13;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131492917, viewGroup, false);
        int n2 = 2131296408;
        ConstraintLayout constraintLayout2 = (ConstraintLayout)view.findViewById(n2);
        if (constraintLayout2 != null && (constraintLayout = (ConstraintLayout)view.findViewById(n2 = 2131296411)) != null && (imageView = (ImageView)view.findViewById(n2 = 2131296519)) != null && (imageView2 = (ImageView)view.findViewById(n2 = 2131296525)) != null && (recyclerView = (RecyclerView)view.findViewById(n2 = 2131296651)) != null && (scrollView = (ScrollView)view.findViewById(n2 = 2131296670)) != null && (textView8 = (TextView)view.findViewById(n2 = 2131296760)) != null && (textView3 = (TextView)view.findViewById(n2 = 2131296776)) != null && (textView12 = (TextView)view.findViewById(n2 = 2131296804)) != null && (textView13 = (TextView)view.findViewById(n2 = 2131296805)) != null && (textView10 = (TextView)view.findViewById(n2 = 2131296806)) != null && (textView4 = (TextView)view.findViewById(n2 = 2131296807)) != null && (textView6 = (TextView)view.findViewById(n2 = 2131296808)) != null && (textView5 = (TextView)view.findViewById(n2 = 2131296813)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296814)) != null && (textView7 = (TextView)view.findViewById(n2 = 2131296815)) != null && (textView9 = (TextView)view.findViewById(n2 = 2131296816)) != null && (textView11 = (TextView)view.findViewById(n2 = 2131296817)) != null && (textView = (TextView)view.findViewById(n2 = 2131296828)) != null) {
            InformationMainBinding informationMainBinding;
            ConstraintLayout constraintLayout3 = (ConstraintLayout)view;
            this._binding = informationMainBinding = new InformationMainBinding(constraintLayout3, constraintLayout2, constraintLayout, imageView, imageView2, recyclerView, scrollView, textView8, textView3, textView12, textView13, textView10, textView4, textView6, textView5, textView2, textView7, textView9, textView11, textView);
            Intrinsics.checkNotNull((Object)informationMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout3, (String)"binding.root");
            return constraintLayout3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public void onViewCreated(View view, Bundle bundle) {
        block7 : {
            block8 : {
                block10 : {
                    block11 : {
                        SharedViewModel sharedViewModel;
                        block9 : {
                            ArrayList<ConfContact> arrayList;
                            Intrinsics.checkNotNullParameter((Object)view, (String)"view");
                            FragmentActivity fragmentActivity = this.getActivity();
                            SharedViewModel sharedViewModel2 = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
                            if (sharedViewModel2 == null) break block7;
                            this.model = sharedViewModel2;
                            if (sharedViewModel2 == null) break block8;
                            ConfResult confResult = sharedViewModel2.configuration;
                            if (confResult == null || (arrayList = confResult.getContacts()) == null) break block9;
                            if (arrayList.isEmpty()) {
                                InformationMainBinding informationMainBinding = this._binding;
                                Intrinsics.checkNotNull((Object)informationMainBinding);
                                informationMainBinding.textViewContactTitle.setVisibility(8);
                            }
                            this.viewManager = new LinearLayoutManager((Context)this.getActivity());
                            this.viewAdapter = new ContactAdapter(arrayList);
                            InformationMainBinding informationMainBinding = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding);
                            RecyclerView recyclerView = informationMainBinding.recyclerViewContact;
                            Intrinsics.checkNotNullExpressionValue((Object)recyclerView, (String)"binding.recyclerViewContact");
                            recyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager layoutManager = this.viewManager;
                            if (layoutManager == null) break block10;
                            recyclerView.setLayoutManager(layoutManager);
                            RecyclerView.Adapter<?> adapter = this.viewAdapter;
                            if (adapter == null) break block11;
                            recyclerView.setAdapter(adapter);
                        }
                        if ((sharedViewModel = this.model) != null) {
                            ConfAbout confAbout;
                            ConfResult confResult = sharedViewModel.configuration;
                            if (confResult != null && (confAbout = confResult.getConfAbout()) != null) {
                                InformationMainBinding informationMainBinding = this._binding;
                                Intrinsics.checkNotNull((Object)informationMainBinding);
                                informationMainBinding.textViewLinkPolConf.setOnClickListener((View.OnClickListener)new -$$Lambda$InformationChildFragment$DT-AQa0NOc6hRbGI3By0AYdW23U(confAbout, this));
                                InformationMainBinding informationMainBinding2 = this._binding;
                                Intrinsics.checkNotNull((Object)informationMainBinding2);
                                informationMainBinding2.textViewLinkCgu.setOnClickListener((View.OnClickListener)new -$$Lambda$InformationChildFragment$ZWoD0E8zY5tDmi8uumsoMd5bltw(confAbout, this));
                            }
                            InformationMainBinding informationMainBinding = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding);
                            SpannableString spannableString = new SpannableString(informationMainBinding.textViewLinkPolConf.getText());
                            spannableString.setSpan((Object)new UnderlineSpan(), 0, spannableString.length(), 0);
                            InformationMainBinding informationMainBinding3 = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding3);
                            informationMainBinding3.textViewLinkPolConf.setText((CharSequence)spannableString);
                            InformationMainBinding informationMainBinding4 = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding4);
                            SpannableString spannableString2 = new SpannableString(informationMainBinding4.textViewLinkCgu.getText());
                            spannableString2.setSpan((Object)new UnderlineSpan(), 0, spannableString2.length(), 0);
                            InformationMainBinding informationMainBinding5 = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding5);
                            informationMainBinding5.textViewLinkCgu.setText((CharSequence)spannableString2);
                            Context context = this.getContext();
                            if (context == null) {
                                return;
                            }
                            Utils.Companion companion = Utils.Companion;
                            InformationMainBinding informationMainBinding6 = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding6);
                            TextView textView = informationMainBinding6.textViewLegal2;
                            Intrinsics.checkNotNullExpressionValue((Object)textView, (String)"binding.textViewLegal2");
                            companion.addLinktoTextView(textView, 2131820648, 2131820649, context);
                            InformationMainBinding informationMainBinding7 = this._binding;
                            Intrinsics.checkNotNull((Object)informationMainBinding7);
                            TextView textView2 = informationMainBinding7.textViewLegal4;
                            Intrinsics.checkNotNullExpressionValue((Object)textView2, (String)"binding.textViewLegal4");
                            companion.addLinktoTextView(textView2, 2131820651, 2131820652, context);
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException((String)"viewAdapter");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"viewManager");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"model");
            throw null;
        }
        throw new Exception("Invalid Activity");
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

