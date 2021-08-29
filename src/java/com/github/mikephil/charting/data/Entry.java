/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelFormatException
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;

public class Entry
extends BaseEntry
implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>(){

        public Object createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        public Object[] newArray(int n) {
            return new Entry[n];
        }
    };
    public float x = 0.0f;

    public Entry() {
    }

    public Entry(float f, float f2) {
        super(f2);
        this.x = f;
    }

    public Entry(Parcel parcel) {
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        if (parcel.readInt() == 1) {
            this.mData = parcel.readParcelable(Object.class.getClassLoader());
        }
    }

    public int describeContents() {
        return 0;
    }

    public float getX() {
        return this.x;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Entry, x: ");
        stringBuilder.append(this.x);
        stringBuilder.append(" y: ");
        stringBuilder.append(this.getY());
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.getY());
        Object object = this.mData;
        if (object != null) {
            if (object instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable)this.mData, n);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }
}

