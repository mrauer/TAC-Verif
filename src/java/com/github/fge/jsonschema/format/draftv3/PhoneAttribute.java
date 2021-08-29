/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.i18n.phonenumbers.Phonenumber
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.github.fge.jsonschema.format.draftv3;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.android.material.R;
import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.MultiFileMetadataSourceImpl;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import java.util.List;
import java.util.Map;

public final class PhoneAttribute
extends AbstractFormatAttribute {
    private static final FormatAttribute INSTANCE;
    private static final PhoneNumberUtil PARSER;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static {
        Class<PhoneNumberUtil> class_ = PhoneNumberUtil.class;
        // MONITORENTER : com.google.i18n.phonenumbers.PhoneNumberUtil.class
        if (PhoneNumberUtil.instance == null) {
            PhoneNumberUtil phoneNumberUtil = new PhoneNumberUtil(new MultiFileMetadataSourceImpl(MetadataManager.DEFAULT_METADATA_LOADER), (Map<Integer, List<String>>)R.style.getCountryCodeToRegionCodeMap());
            class_ = PhoneNumberUtil.class;
            // MONITORENTER : com.google.i18n.phonenumbers.PhoneNumberUtil.class
            PhoneNumberUtil.instance = phoneNumberUtil;
            // MONITOREXIT : class_
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.instance;
        // MONITOREXIT : class_
        PARSER = phoneNumberUtil;
        INSTANCE = new PhoneAttribute();
    }

    private PhoneAttribute() {
        super("phone", NodeType.STRING, new NodeType[0]);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        try {
            if (string.startsWith("+")) {
                PARSER.parse(string, "ZZ");
                return;
            }
            PARSER.parse(string, "FR");
            return;
        }
        catch (NumberParseException numberParseException) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.format.invalidPhoneNumber").putArgument("value", string));
            return;
        }
    }
}

