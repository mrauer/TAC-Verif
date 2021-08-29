/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.FragmentActivity
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.adapter.StatisticAdapter;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod$itemType$1;
import com.ingroupe.verify.anticovid.databinding.StatisticMainBinding;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticPresenter;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticPresenterImpl;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticView;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\u0006\u0012\u0002\b\u00030&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006+"}, d2={"Lcom/ingroupe/verify/anticovid/ui/statistic/StatisticChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/ui/statistic/StatisticView;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "Lcom/ingroupe/verify/anticovid/ui/statistic/StatisticPresenter;", "presenter", "Lcom/ingroupe/verify/anticovid/ui/statistic/StatisticPresenter;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lcom/ingroupe/verify/anticovid/databinding/StatisticMainBinding;", "_binding", "Lcom/ingroupe/verify/anticovid/databinding/StatisticMainBinding;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "viewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class StatisticChildFragment
extends FeatureChildFragment
implements StatisticView {
    public StatisticMainBinding _binding;
    public StatisticPresenter presenter;
    public RecyclerView.Adapter<?> viewAdapter;
    public RecyclerView.LayoutManager viewManager;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
    }

    @Override
    public String getTitle() {
        return "Statistiques";
    }

    @Override
    public Integer getTitleId() {
        return 2131820845;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = layoutInflater.inflate(2131493006, viewGroup, false);
        int n2 = 2131296519;
        ImageView imageView = (ImageView)view.findViewById(n2);
        if (imageView != null && (recyclerView = (RecyclerView)view.findViewById(n2 = 2131296660)) != null) {
            StatisticMainBinding statisticMainBinding;
            ConstraintLayout constraintLayout = (ConstraintLayout)view;
            this._binding = statisticMainBinding = new StatisticMainBinding(constraintLayout, imageView, recyclerView);
            Intrinsics.checkNotNull((Object)statisticMainBinding);
            Intrinsics.checkNotNullExpressionValue((Object)constraintLayout, (String)"binding.root");
            if (this.presenter == null) {
                this.presenter = new StatisticPresenterImpl(this);
            }
            return constraintLayout;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public void onViewCreated(View view, Bundle bundle) {
        StatisticPresenter statisticPresenter;
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        Context context = this.requireContext();
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"requireContext()");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        String string = context.getSharedPreferences("com.ingroupe.verify.LOCAL_STAT_KEY", 0).getString("STATS_PERIOD", "");
        StatsPeriod statsPeriod = new StatsPeriod();
        if (!Intrinsics.areEqual((Object)string, (Object)"")) {
            Gson gson = new Gson();
            new LinkedHashMap();
            Object object = gson.fromJson(string, new StatsPeriod$Companion$getStatsPeriod$itemType$1().type);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"gson.fromJson(jsonMap, itemType)");
            Map map = (Map)object;
            Intrinsics.checkNotNullParameter((Object)map, (String)"<set-?>");
            statsPeriod.map = map;
        }
        if ((statisticPresenter = this.presenter) == null) {
            return;
        }
        this.viewManager = new LinearLayoutManager((Context)this.getActivity());
        Map<Long, StatsDay> map = statisticPresenter.formatMap(statsPeriod);
        Context context2 = this.requireContext();
        Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"requireContext()");
        this.viewAdapter = new StatisticAdapter(map, context2);
        StatisticMainBinding statisticMainBinding = this._binding;
        Intrinsics.checkNotNull((Object)statisticMainBinding);
        RecyclerView recyclerView = statisticMainBinding.rvStats;
        Intrinsics.checkNotNullExpressionValue((Object)recyclerView, (String)"binding.rvStats");
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = this.viewManager;
        if (layoutManager != null) {
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter<?> adapter = this.viewAdapter;
            if (adapter != null) {
                recyclerView.setAdapter(adapter);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"viewAdapter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"viewManager");
        throw null;
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }
}

