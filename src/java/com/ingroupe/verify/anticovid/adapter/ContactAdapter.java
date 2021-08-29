/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.CharSequence
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ingroupe.verify.anticovid.databinding.ContactViewBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfContact;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class ContactAdapter
extends RecyclerView.Adapter<MyViewHolder> {
    public final ArrayList<ConfContact> contacts;

    public ContactAdapter(ArrayList<ConfContact> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String)"contacts");
        this.contacts = arrayList;
    }

    public int getItemCount() {
        return this.contacts.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        MyViewHolder myViewHolder = (MyViewHolder)viewHolder;
        Intrinsics.checkNotNullParameter((Object)((Object)myViewHolder), (String)"holder");
        myViewHolder.binding.textViewContactName.setText((CharSequence)((ConfContact)this.contacts.get(n)).getName());
        String string = ((ConfContact)this.contacts.get(n)).getTel();
        boolean bl = true;
        boolean bl2 = string != null && string.length() != 0 ? false : bl;
        if (bl2) {
            myViewHolder.binding.textViewContactTel.setVisibility(8);
        } else {
            myViewHolder.binding.textViewContactTel.setVisibility(0);
            myViewHolder.binding.textViewContactTel.setText((CharSequence)((ConfContact)this.contacts.get(n)).getTel());
        }
        String string2 = ((ConfContact)this.contacts.get(n)).getMail();
        boolean bl3 = string2 != null && string2.length() != 0 ? false : bl;
        if (bl3) {
            myViewHolder.binding.textViewContactMail.setVisibility(8);
        } else {
            myViewHolder.binding.textViewContactMail.setVisibility(0);
            myViewHolder.binding.textViewContactMail.setText((CharSequence)((ConfContact)this.contacts.get(n)).getMail());
        }
        String string3 = ((ConfContact)this.contacts.get(n)).getDetails();
        if (string3 != null && string3.length() != 0) {
            bl = false;
        }
        if (bl) {
            myViewHolder.binding.textViewContactDetails.setVisibility(8);
            return;
        }
        myViewHolder.binding.textViewContactDetails.setVisibility(0);
        myViewHolder.binding.textViewContactDetails.setText((CharSequence)((ConfContact)this.contacts.get(n)).getDetails());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter((Object)viewGroup, (String)"parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131492895, viewGroup, false);
        int n2 = 2131296772;
        TextView textView4 = (TextView)view.findViewById(n2);
        if (textView4 != null && (textView3 = (TextView)view.findViewById(n2 = 2131296773)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296774)) != null && (textView = (TextView)view.findViewById(n2 = 2131296775)) != null) {
            ContactViewBinding contactViewBinding = new ContactViewBinding((ConstraintLayout)view, textView4, textView3, textView2, textView);
            Intrinsics.checkNotNullExpressionValue((Object)contactViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
            return new MyViewHolder(contactViewBinding);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public static final class MyViewHolder
    extends RecyclerView.ViewHolder {
        public final ContactViewBinding binding;

        public MyViewHolder(ContactViewBinding contactViewBinding) {
            Intrinsics.checkNotNullParameter((Object)contactViewBinding, (String)"binding");
            super((View)contactViewBinding.rootView);
            this.binding = contactViewBinding;
        }
    }

}

