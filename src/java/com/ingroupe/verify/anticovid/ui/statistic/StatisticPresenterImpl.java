/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.statistic;

import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticPresenter;
import com.ingroupe.verify.anticovid.ui.statistic.StatisticView;
import j$.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class StatisticPresenterImpl
implements StatisticPresenter {
    public final StatisticView view;

    public StatisticPresenterImpl(StatisticView statisticView) {
        Intrinsics.checkNotNullParameter((Object)statisticView, (String)"view");
        this.view = statisticView;
    }

    @Override
    public Map<Long, StatsDay> formatMap(StatsPeriod statsPeriod) {
        Intrinsics.checkNotNullParameter((Object)statsPeriod, (String)"statPeriod");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long l2 = 0L;
        do {
            long l3 = 1L + l2;
            LocalDate localDate = LocalDate.now().minusDays(l2);
            Long l4 = localDate.toEpochDay();
            Intrinsics.checkNotNullExpressionValue((Object)localDate, (String)"date");
            linkedHashMap.put((Object)l4, (Object)statsPeriod.getStatsDay(localDate));
            if (l3 > 14L) {
                return linkedHashMap;
            }
            l2 = l3;
        } while (true);
    }
}

