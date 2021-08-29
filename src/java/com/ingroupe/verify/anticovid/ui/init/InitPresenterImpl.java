/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.AssetManager
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.ui.init.InitPresenterImpl$loadAssets$
 *  com.ingroupe.verify.anticovid.ui.init.InitPresenterImpl$loadAssets$$inlined
 *  com.ingroupe.verify.anticovid.ui.init.InitPresenterImpl$loadAssets$$inlined$loadFromAsset
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.List
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.barcode.database.BarcodeLoader;
import com.ingroupe.verify.anticovid.service.barcode.database.BarcodeLoader$loadAssets$$inlined$loadFromAsset$1;
import com.ingroupe.verify.anticovid.service.barcode.database.BarcodeLoader$loadAssets$$inlined$loadFromAsset$2;
import com.ingroupe.verify.anticovid.service.barcode.database.BarcodeLoader$loadAssets$$inlined$loadFromAsset$3;
import com.ingroupe.verify.anticovid.service.barcode.database.BarcodeLoader$loadAssets$$inlined$loadFromAsset$4;
import com.ingroupe.verify.anticovid.service.barcode.database.entity.DocumentType;
import com.ingroupe.verify.anticovid.service.barcode.database.entity.DocumentTypeField;
import com.ingroupe.verify.anticovid.service.barcode.database.entity.Header;
import com.ingroupe.verify.anticovid.service.barcode.database.entity.HeaderField;
import com.ingroupe.verify.anticovid.service.document.database.DocumentLoader;
import com.ingroupe.verify.anticovid.service.document.database.DocumentLoader$loadAssets$$inlined$loadFromAsset$1;
import com.ingroupe.verify.anticovid.service.document.database.entity.ConfigBarcode2DDoc;
import com.ingroupe.verify.anticovid.ui.init.InitPresenter;
import com.ingroupe.verify.anticovid.ui.init.InitPresenterImpl$loadAssets$;
import com.ingroupe.verify.anticovid.ui.init.InitView;
import dalvik.annotation.SourceDebugExtension;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nInitPresenterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/init/InitPresenterImpl\n+ 2 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n*L\n1#1,29:1\n130#2,15:30\n*S KotlinDebug\n*F\n+ 1 InitPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/init/InitPresenterImpl\n*L\n25#1:30,15\n*E\n")
public final class InitPresenterImpl
implements InitPresenter {
    public final InitView view;

    public InitPresenterImpl(InitView initView) {
        Intrinsics.checkNotNullParameter((Object)initView, (String)"view");
        this.view = initView;
    }

    @Override
    public void loadAssets(Context context, SharedViewModel sharedViewModel) {
        String string;
        SharedPreferences sharedPreferences;
        ConfResult confResult;
        String string2;
        String string3;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)sharedViewModel), (String)"model");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        boolean bl = BarcodeLoader.initialized;
        Object object = null;
        if (!bl) {
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            try {
                InputStream inputStream = context.getAssets().open("headers.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new BarcodeLoader$loadAssets$$inlined$loadFromAsset$1().type;
                object3 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object3 = null;
            }
            BarcodeLoader.headers = (List)object3;
            try {
                InputStream inputStream = context.getAssets().open("headers-fields.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new BarcodeLoader$loadAssets$$inlined$loadFromAsset$2().type;
                object4 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object4 = null;
            }
            BarcodeLoader.headerFields = (List)object4;
            try {
                InputStream inputStream = context.getAssets().open("document-types.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new BarcodeLoader$loadAssets$$inlined$loadFromAsset$3().type;
                object5 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object5 = null;
            }
            BarcodeLoader.documentTypes = (List)object5;
            try {
                InputStream inputStream = context.getAssets().open("document-types-fields.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new BarcodeLoader$loadAssets$$inlined$loadFromAsset$4().type;
                object2 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object2 = null;
            }
            BarcodeLoader.documentTypeFields = (List)object2;
            BarcodeLoader.initialized = true;
        }
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (!DocumentLoader.initialized) {
            Object object6;
            try {
                InputStream inputStream = context.getAssets().open("config-barcode-2ddoc.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new DocumentLoader$loadAssets$$inlined$loadFromAsset$1().type;
                object6 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object6 = null;
            }
            DocumentLoader.configBarcode2DDoc = (List)object6;
            DocumentLoader.initialized = true;
        }
        if ((string3 = (sharedPreferences = ((Activity)context).getPreferences(0)).getString(string = Constants$SavedItems.CONF_NAME.getText(), string2 = "conf.json")) != null) {
            string2 = string3;
        }
        try {
            InputStream inputStream = context.getAssets().open(string2);
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Type type = new TypeToken<ConfResult>(){}.type;
            Object object7 = new Gson().fromJson((Reader)inputStreamReader, type);
            Intrinsics.checkNotNullExpressionValue((Object)object7, (String)"Gson().fromJson(isr, itemType)");
            inputStream.close();
            inputStreamReader.close();
            object = object7;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        sharedViewModel.configuration = confResult = (ConfResult)object;
        Utils.Companion.sortConf(confResult);
    }
}

