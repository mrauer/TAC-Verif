/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;

public final class ETrapException
extends ArithmeticException {
    public final Object result;

    public ETrapException(int n2, EContext eContext, Object object) {
        String string = n2 == 32 ? "Clamped" : (n2 == 128 ? "DivideByZero" : (n2 == 1 ? "Inexact" : (n2 == 64 ? "Invalid" : (n2 == 16 ? "Overflow" : (n2 == 2 ? "Rounded" : (n2 == 4 ? "Subnormal" : (n2 == 8 ? "Underflow" : "Trap")))))));
        super(string);
        if (eContext != null) {
            eContext.Copy();
        }
        this.result = object;
    }
}

