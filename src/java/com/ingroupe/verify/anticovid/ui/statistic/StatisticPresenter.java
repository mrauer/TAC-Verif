/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Map
 */
package com.ingroupe.verify.anticovid.ui.statistic;

import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod;
import java.util.Map;

public interface StatisticPresenter {
    public Map<Long, StatsDay> formatMap(StatsPeriod var1);
}

