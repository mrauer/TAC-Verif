/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.viewbinding.ViewBinding
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.ingroupe.verify.anticovid.adapter.-$$Lambda$ResultScanAdapter$iEvOk6NaTxA3Q60txzqJsvF9lZY;
import com.ingroupe.verify.anticovid.adapter.IAdapterInterfaceClick;
import com.ingroupe.verify.anticovid.adapter.ResultScanAdapter$onBindViewHolder$1;
import com.ingroupe.verify.anticovid.common.model.ResultData;
import com.ingroupe.verify.anticovid.common.model.ResultScan;
import com.ingroupe.verify.anticovid.databinding.ResultDataCheck1ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataCheck2ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataCheck3ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataFormat1ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataFormat2ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataFormat3ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataHiddenViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultDataIcone1ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultHeaderViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultValidityInfoViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultValidityKoViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultValidityOkViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultValidityWarnViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultWarnText1ViewBinding;
import com.ingroupe.verify.anticovid.databinding.ResultWarnWebviewViewBinding;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class ResultScanAdapter
extends RecyclerView.Adapter<MyViewHolder>
implements View.OnClickListener {
    public final IAdapterInterfaceClick adapterInterfaceClick;
    public final ResultScan myDataset;

    public ResultScanAdapter(ResultScan resultScan, IAdapterInterfaceClick iAdapterInterfaceClick) {
        Intrinsics.checkNotNullParameter((Object)resultScan, (String)"myDataset");
        Intrinsics.checkNotNullParameter((Object)iAdapterInterfaceClick, (String)"adapterInterfaceClick");
        this.myDataset = resultScan;
        this.adapterInterfaceClick = iAdapterInterfaceClick;
    }

    public int getItemCount() {
        return this.myDataset.datas.size();
    }

    public int getItemViewType(int n) {
        if (((ResultData)this.myDataset.datas.get((int)n)).isGroupHeader) {
            return 2131492993;
        }
        String string = ((ResultData)this.myDataset.datas.get((int)n)).format;
        switch (string.hashCode()) {
            default: {
                return 2131492988;
            }
            case 538723851: {
                if (!string.equals((Object)"Format_3")) {
                    return 2131492988;
                }
                return 2131492990;
            }
            case 538723850: {
                if (!string.equals((Object)"Format_2")) {
                    return 2131492988;
                }
                return 2131492989;
            }
            case 538723849: {
                string.equals((Object)"Format_1");
                return 2131492988;
            }
            case 156628344: {
                if (!string.equals((Object)"Warn_Text_1")) {
                    return 2131492988;
                }
                return 2131492999;
            }
            case -443134773: {
                if (!string.equals((Object)"Check_global_warn")) {
                    return 2131492988;
                }
                return 2131492998;
            }
            case -443539725: {
                if (!string.equals((Object)"Check_global_info")) {
                    return 2131492988;
                }
                return 2131492995;
            }
            case -991534178: {
                if (!string.equals((Object)"Icone_1")) {
                    return 2131492988;
                }
                return 2131492992;
            }
            case -1617169395: {
                if (!string.equals((Object)"Check_global_2")) {
                    return 2131492988;
                }
                return 2131492996;
            }
            case -1617169396: {
                if (!string.equals((Object)"Check_global_1")) {
                    return 2131492988;
                }
                return 2131492997;
            }
            case -1623935246: {
                if (!string.equals((Object)"Warn_Webview_1")) {
                    return 2131492988;
                }
                return 2131493000;
            }
            case -1709683972: {
                if (!string.equals((Object)"Hidden_1")) {
                    return 2131492988;
                }
                return 2131492991;
            }
            case -1888000356: {
                if (!string.equals((Object)"Check_3")) {
                    return 2131492988;
                }
                return 2131492987;
            }
            case -1888000357: {
                if (!string.equals((Object)"Check_2")) {
                    return 2131492988;
                }
                return 2131492986;
            }
            case -1888000358: 
        }
        if (!string.equals((Object)"Check_1")) {
            return 2131492988;
        }
        return 2131492985;
    }

    public final void isWithBackground(View view, boolean bl) {
        if (bl) {
            view.setBackgroundColor(Color.parseColor((String)"#08000000"));
            return;
        }
        view.setBackgroundColor(Color.parseColor((String)"#00000000"));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        MyViewHolder myViewHolder = (MyViewHolder)viewHolder;
        Intrinsics.checkNotNullParameter((Object)((Object)myViewHolder), (String)"holder");
        ResultData resultData = (ResultData)this.myDataset.datas.get(n);
        ViewBinding viewBinding = myViewHolder.binding;
        if (viewBinding instanceof ResultHeaderViewBinding) {
            ((ResultHeaderViewBinding)viewBinding).textViewGroupName.setText((CharSequence)resultData.label);
        } else if (viewBinding instanceof ResultValidityOkViewBinding) {
            ((ResultValidityOkViewBinding)viewBinding).textViewValidity.setText((CharSequence)resultData.value);
        } else if (viewBinding instanceof ResultValidityKoViewBinding) {
            ((ResultValidityKoViewBinding)viewBinding).textViewValidity.setText((CharSequence)resultData.value);
        } else if (viewBinding instanceof ResultValidityWarnViewBinding) {
            ((ResultValidityWarnViewBinding)viewBinding).textViewValidity.setText((CharSequence)resultData.value);
        } else if (viewBinding instanceof ResultValidityInfoViewBinding) {
            ((ResultValidityInfoViewBinding)viewBinding).textViewValidity.setText((CharSequence)resultData.value);
        } else if (viewBinding instanceof ResultDataCheck1ViewBinding) {
            ((ResultDataCheck1ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataCheck1ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataCheck2ViewBinding) {
            ((ResultDataCheck2ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataCheck2ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataCheck3ViewBinding) {
            ((ResultDataCheck3ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataCheck3ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataIcone1ViewBinding) {
            ((ResultDataIcone1ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataIcone1ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataFormat1ViewBinding) {
            ((ResultDataFormat1ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataFormat1ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataFormat2ViewBinding) {
            ((ResultDataFormat2ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataFormat2ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultDataFormat3ViewBinding) {
            ((ResultDataFormat3ViewBinding)viewBinding).textViewLabel.setText((CharSequence)resultData.label);
            ((ResultDataFormat3ViewBinding)myViewHolder.binding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultWarnText1ViewBinding) {
            ((ResultWarnText1ViewBinding)viewBinding).textViewValue.setText((CharSequence)resultData.value);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
        } else if (viewBinding instanceof ResultWarnWebviewViewBinding) {
            Blacklist.Message message = Blacklist.Message.valueOf(resultData.value);
            ViewBinding viewBinding2 = myViewHolder.binding;
            TextView textView = ((ResultWarnWebviewViewBinding)viewBinding2).textViewMessageTitle;
            Context context = viewBinding2.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"holder.binding.root.context");
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)((Object)message), (String)"messageEnum");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0);
            String string = context.getString(message.getKeyTitle());
            String string2 = "";
            String string3 = sharedPreferences.getString(string, string2);
            if (string3 == null) {
                string3 = string2;
            }
            textView.setText((CharSequence)string3);
            ((ResultWarnWebviewViewBinding)myViewHolder.binding).webViewMessageDetail.setWebViewClient((WebViewClient)new ResultScanAdapter$onBindViewHolder$1(myViewHolder));
            ViewBinding viewBinding3 = myViewHolder.binding;
            WebView webView = ((ResultWarnWebviewViewBinding)viewBinding3).webViewMessageDetail;
            Context context2 = viewBinding3.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"holder.binding.root.context");
            Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
            Intrinsics.checkNotNullParameter((Object)((Object)message), (String)"messageEnum");
            String string4 = context2.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0).getString(context2.getString(message.getKeyDetail()), string2);
            if (string4 != null) {
                string2 = string4;
            }
            webView.loadData(string2, "text/html", "base64");
            ((ResultWarnWebviewViewBinding)myViewHolder.binding).webViewMessageDetail.setBackgroundColor(0);
            View view = myViewHolder.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"holder.binding.root");
            this.isWithBackground(view, resultData.withBackground);
            ((ResultWarnWebviewViewBinding)myViewHolder.binding).constraintLayoutMessage.setOnClickListener((View.OnClickListener)new -$$Lambda$ResultScanAdapter$iEvOk6NaTxA3Q60txzqJsvF9lZY(myViewHolder));
        }
        myViewHolder.binding.getRoot().setTag((Object)n);
        myViewHolder.binding.getRoot().setOnClickListener((View.OnClickListener)this);
    }

    public void onClick(View view) {
        if (view == null) {
            return;
        }
        IAdapterInterfaceClick iAdapterInterfaceClick = this.adapterInterfaceClick;
        Object object = view.getTag();
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Int");
        iAdapterInterfaceClick.onItemClick((Integer)object);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        Intrinsics.checkNotNullParameter((Object)viewGroup, (String)"parent");
        int n2 = 2131296513;
        int n3 = 2131296844;
        int n4 = 2131296512;
        int n5 = 2131296803;
        switch (n) {
            default: {
                ResultDataFormat1ViewBinding resultDataFormat1ViewBinding = ResultDataFormat1ViewBinding.inflate(LayoutInflater.from((Context)viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue((Object)resultDataFormat1ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                return new MyViewHolder(resultDataFormat1ViewBinding);
            }
            case 2131493000: {
                TextView textView;
                WebView webView;
                TextView textView2;
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131493000, (ViewGroup)viewGroup, (boolean)false);
                int n6 = 2131296410;
                ConstraintLayout constraintLayout = (ConstraintLayout)view.findViewById(n6);
                if (constraintLayout != null && (textView2 = (TextView)view.findViewById(n6 = 2131296761)) != null && (textView = (TextView)view.findViewById(n6 = 2131296818)) != null && (webView = (WebView)view.findViewById(n6 = 2131296885)) != null) {
                    ResultWarnWebviewViewBinding resultWarnWebviewViewBinding = new ResultWarnWebviewViewBinding((ConstraintLayout)view, constraintLayout, textView2, textView, webView);
                    Intrinsics.checkNotNullExpressionValue((Object)resultWarnWebviewViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                    return new MyViewHolder(resultWarnWebviewViewBinding);
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n6)));
            }
            case 2131492999: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492999, (ViewGroup)viewGroup, (boolean)false);
                TextView textView = (TextView)view.findViewById(2131296845);
                if (textView != null) {
                    ResultWarnText1ViewBinding resultWarnText1ViewBinding = new ResultWarnText1ViewBinding((ConstraintLayout)view, textView);
                    Intrinsics.checkNotNullExpressionValue((Object)resultWarnText1ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                    return new MyViewHolder(resultWarnText1ViewBinding);
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131296845)));
            }
            case 2131492998: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492998, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n4);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n3);
                    if (textView != null) {
                        ResultValidityWarnViewBinding resultValidityWarnViewBinding = new ResultValidityWarnViewBinding((ConstraintLayout)view, imageView, textView);
                        Intrinsics.checkNotNullExpressionValue((Object)resultValidityWarnViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                        return new MyViewHolder(resultValidityWarnViewBinding);
                    }
                } else {
                    n3 = n4;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
            }
            case 2131492997: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492997, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n4);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n3);
                    if (textView != null) {
                        ResultValidityOkViewBinding resultValidityOkViewBinding = new ResultValidityOkViewBinding((ConstraintLayout)view, imageView, textView);
                        Intrinsics.checkNotNullExpressionValue((Object)resultValidityOkViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                        return new MyViewHolder(resultValidityOkViewBinding);
                    }
                } else {
                    n3 = n4;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
            }
            case 2131492996: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492996, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n4);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n3);
                    if (textView != null) {
                        ResultValidityKoViewBinding resultValidityKoViewBinding = new ResultValidityKoViewBinding((ConstraintLayout)view, imageView, textView);
                        Intrinsics.checkNotNullExpressionValue((Object)resultValidityKoViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                        return new MyViewHolder(resultValidityKoViewBinding);
                    }
                } else {
                    n3 = n4;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
            }
            case 2131492995: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492995, (ViewGroup)viewGroup, (boolean)false);
                TextView textView = (TextView)view.findViewById(n3);
                if (textView != null) {
                    ResultValidityInfoViewBinding resultValidityInfoViewBinding = new ResultValidityInfoViewBinding((ConstraintLayout)view, textView);
                    Intrinsics.checkNotNullExpressionValue((Object)resultValidityInfoViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                    return new MyViewHolder(resultValidityInfoViewBinding);
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n3)));
            }
            case 2131492993: {
                TextView textView;
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492993, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n4);
                if (imageView != null && (textView = (TextView)view.findViewById(n4 = 2131296787)) != null) {
                    ResultHeaderViewBinding resultHeaderViewBinding = new ResultHeaderViewBinding((ConstraintLayout)view, imageView, textView);
                    Intrinsics.checkNotNullExpressionValue((Object)resultHeaderViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                    return new MyViewHolder(resultHeaderViewBinding);
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n4)));
            }
            case 2131492992: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492992, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n2);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n5);
                    if (textView != null) {
                        TextView textView3 = (TextView)view.findViewById(2131296845);
                        if (textView3 != null) {
                            ResultDataIcone1ViewBinding resultDataIcone1ViewBinding = new ResultDataIcone1ViewBinding((ConstraintLayout)view, imageView, textView, textView3);
                            Intrinsics.checkNotNullExpressionValue((Object)resultDataIcone1ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                            return new MyViewHolder(resultDataIcone1ViewBinding);
                        }
                        n2 = 2131296845;
                    } else {
                        n2 = n5;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
            }
            case 2131492991: {
                View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131492991, viewGroup, false);
                Objects.requireNonNull((Object)view, (String)"rootView");
                ResultDataHiddenViewBinding resultDataHiddenViewBinding = new ResultDataHiddenViewBinding((ConstraintLayout)view);
                Intrinsics.checkNotNullExpressionValue((Object)resultDataHiddenViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                return new MyViewHolder(resultDataHiddenViewBinding);
            }
            case 2131492990: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492990, (ViewGroup)viewGroup, (boolean)false);
                TextView textView = (TextView)view.findViewById(n5);
                if (textView != null) {
                    TextView textView4 = (TextView)view.findViewById(2131296845);
                    if (textView4 != null) {
                        ResultDataFormat3ViewBinding resultDataFormat3ViewBinding = new ResultDataFormat3ViewBinding((ConstraintLayout)view, textView, textView4);
                        Intrinsics.checkNotNullExpressionValue((Object)resultDataFormat3ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                        return new MyViewHolder(resultDataFormat3ViewBinding);
                    }
                    n5 = 2131296845;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n5)));
            }
            case 2131492989: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492989, (ViewGroup)viewGroup, (boolean)false);
                TextView textView = (TextView)view.findViewById(n5);
                if (textView != null) {
                    TextView textView5 = (TextView)view.findViewById(2131296845);
                    if (textView5 != null) {
                        ResultDataFormat2ViewBinding resultDataFormat2ViewBinding = new ResultDataFormat2ViewBinding((ConstraintLayout)view, textView, textView5);
                        Intrinsics.checkNotNullExpressionValue((Object)resultDataFormat2ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                        return new MyViewHolder(resultDataFormat2ViewBinding);
                    }
                    n5 = 2131296845;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n5)));
            }
            case 2131492988: {
                ResultDataFormat1ViewBinding resultDataFormat1ViewBinding = ResultDataFormat1ViewBinding.inflate(LayoutInflater.from((Context)viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue((Object)resultDataFormat1ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                return new MyViewHolder(resultDataFormat1ViewBinding);
            }
            case 2131492987: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492987, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n2);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n5);
                    if (textView != null) {
                        TextView textView6 = (TextView)view.findViewById(2131296845);
                        if (textView6 != null) {
                            ResultDataCheck3ViewBinding resultDataCheck3ViewBinding = new ResultDataCheck3ViewBinding((ConstraintLayout)view, imageView, textView, textView6);
                            Intrinsics.checkNotNullExpressionValue((Object)resultDataCheck3ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                            return new MyViewHolder(resultDataCheck3ViewBinding);
                        }
                        n2 = 2131296845;
                    } else {
                        n2 = n5;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
            }
            case 2131492986: {
                View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492986, (ViewGroup)viewGroup, (boolean)false);
                ImageView imageView = (ImageView)view.findViewById(n2);
                if (imageView != null) {
                    TextView textView = (TextView)view.findViewById(n5);
                    if (textView != null) {
                        TextView textView7 = (TextView)view.findViewById(2131296845);
                        if (textView7 != null) {
                            ResultDataCheck2ViewBinding resultDataCheck2ViewBinding = new ResultDataCheck2ViewBinding((ConstraintLayout)view, imageView, textView, textView7);
                            Intrinsics.checkNotNullExpressionValue((Object)resultDataCheck2ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                            return new MyViewHolder(resultDataCheck2ViewBinding);
                        }
                        n2 = 2131296845;
                    } else {
                        n2 = n5;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
            }
            case 2131492985: 
        }
        View view = GeneratedOutlineSupport.outline6((ViewGroup)viewGroup, (int)2131492985, (ViewGroup)viewGroup, (boolean)false);
        ImageView imageView = (ImageView)view.findViewById(2131296517);
        if (imageView != null) {
            TextView textView = (TextView)view.findViewById(n5);
            if (textView != null) {
                TextView textView8 = (TextView)view.findViewById(2131296845);
                if (textView8 != null) {
                    ResultDataCheck1ViewBinding resultDataCheck1ViewBinding = new ResultDataCheck1ViewBinding((ConstraintLayout)view, imageView, textView, textView8);
                    Intrinsics.checkNotNullExpressionValue((Object)resultDataCheck1ViewBinding, (String)"inflate(LayoutInflater.from(parent.context), parent, false)");
                    return new MyViewHolder(resultDataCheck1ViewBinding);
                }
                n5 = 2131296845;
            }
        } else {
            n5 = 2131296517;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n5)));
    }

    public static class MyViewHolder
    extends RecyclerView.ViewHolder {
        public final ViewBinding binding;

        public MyViewHolder(ViewBinding viewBinding) {
            Intrinsics.checkNotNullParameter((Object)viewBinding, (String)"binding");
            super(viewBinding.getRoot());
            this.binding = viewBinding;
        }
    }

}

