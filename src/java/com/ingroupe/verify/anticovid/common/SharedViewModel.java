/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 *  java.lang.Boolean
 */
package com.ingroupe.verify.anticovid.common;

import androidx.lifecycle.ViewModel;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;

public final class SharedViewModel
extends ViewModel {
    public ConfResult configuration;
    public DocumentResult currentResponse;
    public boolean reloadConfiguration;
    public Boolean resultAlreadyViewed;
}

