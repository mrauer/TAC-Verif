/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.report.ListReportProvider
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.main;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.report.ListReportProvider;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ReportProvider;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

public final class JsonSchemaFactoryBuilder
implements Thawed<JsonSchemaFactory> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
    public LoadingConfiguration loadingCfg;
    public ReportProvider reportProvider;
    public ValidationConfiguration validationCfg;

    public JsonSchemaFactoryBuilder() {
        this.reportProvider = new ListReportProvider(LogLevel.INFO, LogLevel.FATAL);
        this.loadingCfg = LoadingConfiguration.byDefault();
        this.validationCfg = ValidationConfiguration.byDefault();
    }

    public JsonSchemaFactoryBuilder(JsonSchemaFactory jsonSchemaFactory) {
    }

    public JsonSchemaFactory freeze() {
        if (this.reportProvider == null) {
            this.reportProvider = new ListReportProvider(LogLevel.INFO, LogLevel.FATAL);
        }
        if (this.loadingCfg == null) {
            this.loadingCfg = LoadingConfiguration.byDefault();
        }
        if (this.validationCfg == null) {
            this.validationCfg = ValidationConfiguration.byDefault();
        }
        return new JsonSchemaFactory(this);
    }

    public JsonSchemaFactoryBuilder setLoadingConfiguration(LoadingConfiguration loadingConfiguration) {
        BUNDLE.checkNotNull(loadingConfiguration, "nullLoadingCfg");
        this.loadingCfg = loadingConfiguration;
        return this;
    }

    public JsonSchemaFactoryBuilder setReportProvider(ReportProvider reportProvider) {
        BUNDLE.checkNotNull(reportProvider, "nullReportProvider");
        this.reportProvider = reportProvider;
        return this;
    }

    public JsonSchemaFactoryBuilder setValidationConfiguration(ValidationConfiguration validationConfiguration) {
        BUNDLE.checkNotNull(validationConfiguration, "nullValidationCfg");
        this.validationCfg = validationConfiguration;
        return this;
    }
}

