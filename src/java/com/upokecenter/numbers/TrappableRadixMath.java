/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.upokecenter.numbers;

import com.upokecenter.numbers.EContext;
import com.upokecenter.numbers.ETrapException;
import com.upokecenter.numbers.IRadixMath;
import com.upokecenter.numbers.IRadixMathHelper;

public class TrappableRadixMath<T>
implements IRadixMath<T> {
    public final IRadixMath<T> math;

    public TrappableRadixMath(IRadixMath<T> iRadixMath) {
        this.math = iRadixMath;
    }

    public static EContext GetTrappableContext(EContext eContext) {
        if (eContext == null) {
            return null;
        }
        if (eContext.traps == 0) {
            return eContext;
        }
        return eContext.WithBlankFlags();
    }

    @Override
    public T Abs(T t2, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t3 = this.math.Abs(t2, eContext2);
        this.TriggerTraps(t3, eContext2, eContext);
        return t3;
    }

    @Override
    public T Add(T t2, T t3, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t4 = this.math.Add(t2, t3, eContext2);
        this.TriggerTraps(t4, eContext2, eContext);
        return t4;
    }

    @Override
    public T AddEx(T t2, T t3, EContext eContext, boolean bl) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t4 = this.math.AddEx(t2, t3, eContext, bl);
        this.TriggerTraps(t4, eContext2, eContext);
        return t4;
    }

    @Override
    public T Divide(T t2, T t3, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t4 = this.math.Divide(t2, t3, eContext2);
        this.TriggerTraps(t4, eContext2, eContext);
        return t4;
    }

    @Override
    public IRadixMathHelper<T> GetHelper() {
        return this.math.GetHelper();
    }

    @Override
    public T Multiply(T t2, T t3, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t4 = this.math.Multiply(t2, t3, eContext2);
        this.TriggerTraps(t4, eContext2, eContext);
        return t4;
    }

    @Override
    public T NextPlus(T t2, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t3 = this.math.NextPlus(t2, eContext2);
        this.TriggerTraps(t3, eContext2, eContext);
        return t3;
    }

    @Override
    public T Quantize(T t2, T t3, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t4 = this.math.Quantize(t2, t3, eContext2);
        this.TriggerTraps(t4, eContext2, eContext);
        return t4;
    }

    @Override
    public T RoundToPrecision(T t2, EContext eContext) {
        EContext eContext2 = TrappableRadixMath.GetTrappableContext(eContext);
        T t3 = this.math.RoundToPrecision(t2, eContext2);
        this.TriggerTraps(t3, eContext2, eContext);
        return t3;
    }

    public final T TriggerTraps(T t2, EContext eContext, EContext eContext2) {
        if (eContext != null) {
            int n2;
            int n3;
            int n4;
            int n5 = eContext.flags;
            if (n5 == 0) {
                return t2;
            }
            if (eContext2 != null && eContext2.hasFlags) {
                eContext2.setFlags(n5 | eContext2.flags);
            }
            if ((n4 = (n3 = eContext2 != null ? eContext2.traps : 0) & eContext.flags) == 0) {
                return t2;
            }
            int n6 = n4 & -40;
            if (n6 != 0) {
                for (int i2 = 0; i2 < 32; ++i2) {
                    int n7 = n6 & i2 << 1;
                    if (n7 == 0) {
                        continue;
                    }
                    throw new ETrapException(n7, eContext2, t2);
                }
            }
            if ((n2 = n4 & 4) == 0) {
                int n8 = n4 & 1;
                if (n8 == 0) {
                    int n9 = n4 & 2;
                    if (n9 == 0) {
                        int n10 = n4 & 32;
                        if (n10 == 0) {
                            return t2;
                        }
                        throw new ETrapException(n10, eContext2, t2);
                    }
                    throw new ETrapException(n9, eContext2, t2);
                }
                throw new ETrapException(n8, eContext2, t2);
            }
            throw new ETrapException(n2, eContext2, t2);
        }
        return t2;
    }

    @Override
    public int compareTo(T t2, T t3) {
        return this.math.compareTo(t2, t3);
    }
}

