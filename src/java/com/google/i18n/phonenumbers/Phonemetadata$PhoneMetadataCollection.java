/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadataCollection
implements Externalizable {
    public List<Phonemetadata$PhoneMetadata> metadata_ = new ArrayList();

    public void readExternal(ObjectInput objectInput) throws IOException {
        int n3 = objectInput.readInt();
        for (int i3 = 0; i3 < n3; ++i3) {
            Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = new Phonemetadata$PhoneMetadata();
            phonemetadata$PhoneMetadata.readExternal(objectInput);
            this.metadata_.add((Object)phonemetadata$PhoneMetadata);
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int n3 = this.metadata_.size();
        objectOutput.writeInt(n3);
        for (int i3 = 0; i3 < n3; ++i3) {
            ((Phonemetadata$PhoneMetadata)this.metadata_.get(i3)).writeExternal(objectOutput);
        }
    }
}

