/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Integer
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

public class Phonemetadata$PhoneNumberDesc
implements Externalizable {
    public String exampleNumber_ = "";
    public boolean hasExampleNumber;
    public boolean hasNationalNumberPattern;
    public String nationalNumberPattern_ = "";
    public List<Integer> possibleLengthLocalOnly_ = new ArrayList();
    public List<Integer> possibleLength_ = new ArrayList();

    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasNationalNumberPattern = true;
            this.nationalNumberPattern_ = string;
        }
        int n3 = objectInput.readInt();
        int n4 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            this.possibleLength_.add((Object)objectInput.readInt());
        }
        int n5 = objectInput.readInt();
        while (n4 < n5) {
            this.possibleLengthLocalOnly_.add((Object)objectInput.readInt());
            ++n4;
        }
        if (objectInput.readBoolean()) {
            String string = objectInput.readUTF();
            this.hasExampleNumber = true;
            this.exampleNumber_ = string;
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern) {
            objectOutput.writeUTF(this.nationalNumberPattern_);
        }
        int n3 = this.possibleLength_.size();
        objectOutput.writeInt(n3);
        int n4 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            objectOutput.writeInt(((Integer)this.possibleLength_.get(i3)).intValue());
        }
        int n5 = this.possibleLengthLocalOnly_.size();
        objectOutput.writeInt(n5);
        while (n4 < n5) {
            objectOutput.writeInt(((Integer)this.possibleLengthLocalOnly_.get(n4)).intValue());
            ++n4;
        }
        objectOutput.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber) {
            objectOutput.writeUTF(this.exampleNumber_);
        }
    }
}

