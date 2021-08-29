/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$NumberFormat
implements Externalizable {
    public String domesticCarrierCodeFormattingRule_ = "";
    public String format_ = "";
    public boolean hasDomesticCarrierCodeFormattingRule;
    public boolean hasNationalPrefixFormattingRule;
    public List<String> leadingDigitsPattern_ = new ArrayList();
    public String nationalPrefixFormattingRule_ = "";
    public boolean nationalPrefixOptionalWhenFormatting_ = false;
    public String pattern_ = "";

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.pattern_ = objectInput.readUTF();
        this.format_ = objectInput.readUTF();
        int n3 = objectInput.readInt();
        for (int i3 = 0; i3 < n3; ++i3) {
            this.leadingDigitsPattern_.add((Object)objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasNationalPrefixFormattingRule = true;
            this.nationalPrefixFormattingRule_ = string;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasDomesticCarrierCodeFormattingRule = true;
            this.domesticCarrierCodeFormattingRule_ = string;
        }
        this.nationalPrefixOptionalWhenFormatting_ = objectInput.readBoolean();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.pattern_);
        objectOutput.writeUTF(this.format_);
        int n3 = this.leadingDigitsPattern_.size();
        objectOutput.writeInt(n3);
        for (int i3 = 0; i3 < n3; ++i3) {
            objectOutput.writeUTF((String)this.leadingDigitsPattern_.get(i3));
        }
        objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
        if (this.hasNationalPrefixFormattingRule) {
            objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
        }
        objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
        if (this.hasDomesticCarrierCodeFormattingRule) {
            objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
        }
        objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
    }
}

