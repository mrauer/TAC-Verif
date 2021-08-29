/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import j$.util.concurrent.ConcurrentHashMap;

public final class MultiFileMetadataSourceImpl {
    public final ConcurrentHashMap<String, Phonemetadata$PhoneMetadata> geographicalRegions = new ConcurrentHashMap();
    public final MetadataLoader metadataLoader;
    public final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> nonGeographicalRegions = new ConcurrentHashMap();
    public final String phoneNumberMetadataFilePrefix = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";

    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this.metadataLoader = metadataLoader;
    }
}

