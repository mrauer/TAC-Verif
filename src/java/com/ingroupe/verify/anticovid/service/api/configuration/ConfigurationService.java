/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.Unit
 *  retrofit2.Call
 *  retrofit2.http.Body
 *  retrofit2.http.GET
 *  retrofit2.http.POST
 *  retrofit2.http.Url
 */
package com.ingroupe.verify.anticovid.service.api.configuration;

import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(bv={1, 0, 3}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH'\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u000e\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lcom/ingroupe/verify/anticovid/service/api/configuration/ConfigurationService;", "", "", "url", "Lretrofit2/Call;", "Lcom/ingroupe/verify/anticovid/service/api/configuration/sync/SyncResult;", "callSync", "(Ljava/lang/String;)Lretrofit2/Call;", "", "analytics", "", "sendAnalytics", "(Ljava/lang/String;Ljava/util/List;)Lretrofit2/Call;", "Lcom/ingroupe/verify/anticovid/service/api/configuration/conf/ConfResult;", "callConfiguration", "app_prodRelease"}, k=1, mv={1, 5, 1})
public interface ConfigurationService {
    @GET
    public Call<ConfResult> callConfiguration(@Url String var1);

    @GET
    public Call<SyncResult> callSync(@Url String var1);

    @POST
    public Call<Unit> sendAnalytics(@Url String var1, @Body List<String> var2);
}

