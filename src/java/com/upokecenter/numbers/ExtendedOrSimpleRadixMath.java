/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;
import com.upokecenter.numbers.RadixMath;
import com.upokecenter.numbers.SimpleRadixMath;

public class ExtendedOrSimpleRadixMath<T>
implements IRadixMath<T> {
    public final RadixMath<T> ext;
    public final SimpleRadixMath<T> simp;

    public ExtendedOrSimpleRadixMath(IRadixMathHelper<T> iRadixMathHelper) {
        RadixMath<T> radixMath = new RadixMath<T>(iRadixMathHelper);
        this.ext = radixMath;
        this.simp = new SimpleRadixMath<T>(radixMath);
    }

    @Override
    public T Abs(T t2, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Abs(t2, eContext);
        }
        return this.ext.Abs(t2, eContext);
    }

    @Override
    public T Add(T t2, T t3, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Add(t2, t3, eContext);
        }
        return this.ext.Add(t2, t3, eContext);
    }

    @Override
    public T AddEx(T t2, T t3, EContext eContext, boolean bl) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Add(t2, t3, eContext);
        }
        return this.ext.AddEx(t2, t3, eContext, bl);
    }

    @Override
    public T Divide(T t2, T t3, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Divide(t2, t3, eContext);
        }
        return this.ext.Divide(t2, t3, eContext);
    }

    @Override
    public IRadixMathHelper<T> GetHelper() {
        return this.ext.helper;
    }

    @Override
    public T Multiply(T t2, T t3, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Multiply(t2, t3, eContext);
        }
        return this.ext.Multiply(t2, t3, eContext);
    }

    @Override
    public T NextPlus(T t2, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.NextPlus(t2, eContext);
        }
        return this.ext.NextPlus(t2, eContext);
    }

    @Override
    public T Quantize(T t2, T t3, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.Quantize(t2, t3, eContext);
        }
        return this.ext.Quantize(t2, t3, eContext);
    }

    @Override
    public T RoundToPrecision(T t2, EContext eContext) {
        if (eContext != null && eContext.simplified) {
            return this.simp.RoundToPrecision(t2, eContext);
        }
        return this.ext.RoundToPrecision(t2, eContext);
    }

    @Override
    public int compareTo(T t2, T t3) {
        return this.ext.compareTo(t2, t3);
    }
}

