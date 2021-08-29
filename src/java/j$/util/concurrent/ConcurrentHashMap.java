/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j$.util.concurrent.ConcurrentHashMap$e
 *  j$.util.concurrent.ConcurrentHashMap$i
 *  j$.util.concurrent.ConcurrentHashMap$u
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.ObjectOutputStream$PutField
 *  java.io.ObjectStreamField
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.lang.reflect.Field
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.AbstractMap
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Enumeration
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.locks.LockSupport
 *  java.util.concurrent.locks.ReentrantLock
 *  java.util.function.BiConsumer
 *  java.util.function.BiFunction
 *  java.util.function.Consumer
 *  java.util.function.Function
 *  java.util.function.Predicate
 *  java.util.stream.Stream
 *  sun.misc.Unsafe
 */
package j$.util.concurrent;

import j$.N;
import j$.T0;
import j$.util.Collection;
import j$.util.Collection$-CC;
import j$.util.Iterator;
import j$.util.Iterator$-CC;
import j$.util.Map$Entry;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.concurrent.ThreadLocalRandom;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.y;
import j$.x;
import j$.y0;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import sun.misc.Unsafe;

/*
 * Exception performing whole class analysis.
 */
public class ConcurrentHashMap<K, V>
extends AbstractMap<K, V>
implements java.util.concurrent.ConcurrentMap<K, V>,
Serializable,
ConcurrentMap {
    private static final long ABASE = 0L;
    private static final int ASHIFT = 0;
    private static final long BASECOUNT = 0L;
    private static final long CELLSBUSY = 0L;
    private static final long CELLVALUE = 0L;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU = 0;
    static final int RESERVED = -3;
    private static int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL = 0L;
    private static final long TRANSFERINDEX = 0L;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient c[] counterCells;
    private transient e entrySet;
    private transient i keySet;
    private volatile transient l[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient l[] table;
    private volatile transient int transferIndex;
    private transient u values;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        int n2;
        NCPU = Runtime.getRuntime().availableProcessors();
        ObjectStreamField[] arrobjectStreamField = new ObjectStreamField[3];
        arrobjectStreamField[0] = new ObjectStreamField("segments", n[].class);
        Class class_ = Integer.TYPE;
        arrobjectStreamField[1] = new ObjectStreamField("segmentMask", class_);
        arrobjectStreamField[2] = new ObjectStreamField("segmentShift", class_);
        serialPersistentFields = arrobjectStreamField;
        try {
            Unsafe unsafe;
            U = unsafe = j$.util.concurrent.b.c();
            SIZECTL = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            BASECOUNT = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            CELLSBUSY = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafe.objectFieldOffset(c.class.getDeclaredField("value"));
            ABASE = unsafe.arrayBaseOffset(l[].class);
            n2 = unsafe.arrayIndexScale(l[].class);
        }
        catch (Exception exception) {
            throw new Error((Throwable)exception);
        }
        if ((n2 & n2 - 1) != 0) throw new Error("data type scale not a power of two");
        ASHIFT = 31 - Integer.numberOfLeadingZeros((int)n2);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int n2) {
        if (n2 >= 0) {
            int n3 = n2 >= 536870912 ? 1073741824 : ConcurrentHashMap.tableSizeFor(1 + (n2 + (n2 >>> 1)));
            this.sizeCtl = n3;
            return;
        }
        throw new IllegalArgumentException();
    }

    public ConcurrentHashMap(int n2, float f2) {
        this(n2, f2, 1);
    }

    public ConcurrentHashMap(int n2, float f2, int n3) {
        if (f2 > 0.0f && n2 >= 0 && n3 > 0) {
            long l2;
            if (n2 < n3) {
                n2 = n3;
            }
            int n4 = (l2 = (long)(1.0 + (double)((float)n2 / f2))) >= 0x40000000L ? 1073741824 : ConcurrentHashMap.tableSizeFor((int)l2);
            this.sizeCtl = n4;
            return;
        }
        throw new IllegalArgumentException();
    }

    public ConcurrentHashMap(Map map) {
        this.sizeCtl = 16;
        this.putAll(map);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void addCount(long l2, int n2) {
        block10 : {
            int n3;
            l[] arrl;
            int n4;
            long l3;
            block11 : {
                int n5;
                block8 : {
                    block7 : {
                        block9 : {
                            long l4;
                            c c2;
                            Unsafe unsafe;
                            long l5;
                            int n6;
                            c[] arrc = this.counterCells;
                            if (arrc == null && (unsafe = U).compareAndSwapLong((Object)this, l5 = BASECOUNT, l4 = this.baseCount, l3 = l4 + l2)) break block7;
                            n5 = 1;
                            if (arrc == null || (n6 = arrc.length - n5) < 0 || (c2 = arrc[n6 & ThreadLocalRandom.b()]) == null) break block8;
                            Unsafe unsafe2 = U;
                            long l6 = CELLVALUE;
                            long l7 = c2.value;
                            int n7 = unsafe2.compareAndSwapLong((Object)c2, l6, l7, l7 + l2);
                            if (n7 != 0) break block9;
                            n5 = n7;
                            break block8;
                        }
                        if (n2 <= n5) {
                            return;
                        }
                        l3 = this.sumCount();
                    }
                    if (n2 < 0) break block10;
                    break block11;
                }
                this.fullAddCount(l2, (boolean)n5);
                return;
            }
            while (l3 >= (long)(n4 = this.sizeCtl) && (arrl = this.table) != null && (n3 = arrl.length) < 1073741824) {
                int n8 = ConcurrentHashMap.resizeStamp(n3);
                if (n4 < 0) {
                    l[] arrl2;
                    if (n4 >>> RESIZE_STAMP_SHIFT != n8 || n4 == n8 + 1 || n4 == n8 + MAX_RESIZERS || (arrl2 = this.nextTable) == null) break;
                    if (this.transferIndex <= 0) {
                        return;
                    }
                    if (U.compareAndSwapInt((Object)this, SIZECTL, n4, n4 + 1)) {
                        this.transfer(arrl, arrl2);
                    }
                } else if (U.compareAndSwapInt((Object)this, SIZECTL, n4, 2 + (n8 << RESIZE_STAMP_SHIFT))) {
                    this.transfer(arrl, null);
                }
                l3 = this.sumCount();
            }
        }
    }

    static final boolean casTabAt(l[] arrl, int n2, l l2, l l3) {
        return U.compareAndSwapObject((Object)arrl, ((long)n2 << ASHIFT) + ABASE, (Object)l2, (Object)l3);
    }

    static Class comparableClassFor(Object object) {
        if (object instanceof Comparable) {
            Class class_ = object.getClass();
            if (class_ == String.class) {
                return class_;
            }
            Type[] arrtype = class_.getGenericInterfaces();
            if (arrtype != null) {
                for (int i2 = 0; i2 < arrtype.length; ++i2) {
                    ParameterizedType parameterizedType;
                    Type[] arrtype2;
                    Type type = arrtype[i2];
                    if (!(type instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getRawType() != Comparable.class || (arrtype2 = parameterizedType.getActualTypeArguments()) == null || arrtype2.length != 1 || arrtype2[0] != class_) continue;
                    return class_;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class class_, Object object, Object object2) {
        if (object2 != null && object2.getClass() == class_) {
            return ((Comparable)object).compareTo(object2);
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private final void fullAddCount(long var1_1, boolean var3_2) {
        var4_3 = ThreadLocalRandom.b();
        if (var4_3 == 0) {
            ThreadLocalRandom.f();
            var5_4 = ThreadLocalRandom.b();
            var6_5 = true;
        } else {
            var5_4 = var4_3;
            var6_5 = var3_2;
        }
        do {
            block30 : {
                var7_6 = var5_4;
                var8_7 = false;
                do {
                    block31 : {
                        block32 : {
                            if ((var9_8 = this.counterCells) == null || (var18_14 = var9_8.length) <= 0) break block31;
                            var19_15 = var9_8[var7_6 & var18_14 - 1];
                            if (var19_15 != null) break block32;
                            if (this.cellsBusy == 0) {
                                var28_21 = new c(var1_1);
                                if (this.cellsBusy == 0 && ConcurrentHashMap.U.compareAndSwapInt((Object)this, ConcurrentHashMap.CELLSBUSY, 0, 1)) {
                                    block29 : {
                                        try {
                                            var30_22 = this.counterCells;
                                            if (var30_22 == null || (var31_23 = var30_22.length) <= 0) break block29;
                                        }
                                        catch (Throwable var29_26) {
                                            this.cellsBusy = 0;
                                            throw var29_26;
                                        }
                                        var33_25 = var7_6 & var31_23 - 1;
                                        if (var30_22[var33_25] != null) break block29;
                                        var30_22[var33_25] = var28_21;
                                        var32_24 = true;
                                    }
                                    var32_24 = false;
                                    this.cellsBusy = 0;
                                    if (!var32_24) continue;
                                    return;
                                }
                            }
                            ** GOTO lbl-1000
                        }
                        if (!var6_5) {
                            var6_5 = true;
                        } else {
                            var20_16 = ConcurrentHashMap.U;
                            var21_17 = ConcurrentHashMap.CELLVALUE;
                            var23_18 = var19_15.value;
                            if (var20_16.compareAndSwapLong((Object)var19_15, var21_17, var23_18, var23_18 + var1_1)) {
                                return;
                            }
                            if (this.counterCells == var9_8 && var18_14 < ConcurrentHashMap.NCPU) {
                                if (!var8_7) {
                                    var8_7 = true;
                                } else if (this.cellsBusy == 0 && var20_16.compareAndSwapInt((Object)this, ConcurrentHashMap.CELLSBUSY, 0, 1)) {
                                    if (this.counterCells == var9_8) {
                                        var26_19 = new c[var18_14 << 1];
                                        break;
                                    }
                                    break block30;
                                }
                            } else lbl-1000: // 2 sources:
                            {
                                var8_7 = false;
                            }
                        }
                        var7_6 = ThreadLocalRandom.a(var7_6);
                        continue;
                    }
                    if (this.cellsBusy == 0 && this.counterCells == var9_8 && ConcurrentHashMap.U.compareAndSwapInt((Object)this, ConcurrentHashMap.CELLSBUSY, 0, 1)) {
                        if (this.counterCells == var9_8) {
                            var17_13 = new c[2];
                            var17_13[var7_6 & 1] = new c(var1_1);
                            this.counterCells = var17_13;
                            var16_12 = true;
                        } else {
                            var16_12 = false;
                        }
                        if (!var16_12) continue;
                        return;
                        finally {
                            this.cellsBusy = 0;
                        }
                    }
                    var10_9 = ConcurrentHashMap.U;
                    var11_10 = ConcurrentHashMap.BASECOUNT;
                    var13_11 = this.baseCount;
                    if (var10_9.compareAndSwapLong((Object)this, var11_10, var13_11, var13_11 + var1_1)) return;
                } while (true);
                for (var27_20 = 0; var27_20 < var18_14; ++var27_20) {
                    var26_19[var27_20] = var9_8[var27_20];
                }
                ** try [egrp 3[TRYBLOCK] [5 : 333->339)] { 
lbl86: // 1 sources:
                this.counterCells = var26_19;
            }
            var5_4 = var7_6;
        } while (true);
lbl90: // 1 sources:
        finally {
            this.cellsBusy = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final l[] initTable() {
        l[] arrl;
        int n2;
        block5 : {
            do {
                l[] arrl2;
                if ((arrl2 = this.table) != null) {
                    if (arrl2.length != 0) return arrl2;
                }
                if ((n2 = this.sizeCtl) < 0) {
                    Thread.yield();
                    continue;
                }
                if (U.compareAndSwapInt((Object)this, SIZECTL, n2, -1)) break;
            } while (true);
            try {
                arrl = this.table;
                if (arrl != null && arrl.length != 0) break block5;
            }
            catch (Throwable throwable) {
                this.sizeCtl = n2;
                throw throwable;
            }
            int n3 = n2 > 0 ? n2 : 16;
            l[] arrl3 = new l[n3];
            this.table = arrl3;
            n2 = n3 - (n3 >>> 2);
            arrl = arrl3;
        }
        this.sizeCtl = n2;
        return arrl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void readObject(ObjectInputStream var1_1) {
        this.sizeCtl = -1;
        var1_1.defaultReadObject();
        var4_3 = var2_2 = 0L;
        var6_4 = null;
        do {
            var7_6 = var1_1.readObject();
            var8_7 = var1_1.readObject();
            var9_8 = 1L;
            if (var7_6 == null || var8_7 == null) break;
            var36_5 = new l(ConcurrentHashMap.spread(var7_6.hashCode()), var7_6, var8_7, var6_4);
            var4_3 += var9_8;
            var6_4 = var36_5;
        } while (true);
        if (var4_3 == var2_2) {
            this.sizeCtl = 0;
            return;
        }
        var11_9 = var4_3 LCMP 0x20000000L;
        var12_10 = 1;
        if (var11_9 >= 0) {
            var14_11 = 1073741824;
        } else {
            var13_12 = (int)var4_3;
            var14_11 = ConcurrentHashMap.tableSizeFor(var12_10 + (var13_12 + (var13_12 >>> 1)));
        }
        var15_13 = new l[var14_11];
        var16_14 = var14_11 - 1;
        do {
            block19 : {
                if (var6_4 == null) {
                    this.table = var15_13;
                    this.sizeCtl = var14_11 - (var14_11 >>> 2);
                    this.baseCount = var2_2;
                    return;
                }
                var17_15 = var6_4.d;
                var18_16 = var6_4.a;
                var19_17 = var18_16 & var16_14;
                var20_18 = ConcurrentHashMap.tabAt(var15_13, var19_17);
                if (var20_18 == null) {
                    var24_22 = var12_10;
                } else {
                    block20 : {
                        var21_19 = var6_4.b;
                        if (var20_18.a >= 0) {
                            var22_20 = var20_18;
                            var23_21 = 0;
                        } else {
                            if (((q)var20_18).f(var18_16, var21_19, var6_4.c) == null) {
                                var2_2 += var9_8;
                            }
lbl46: // 4 sources:
                            do {
                                var24_22 = 0;
                                break block19;
                                break;
                            } while (true);
                        }
                        while (var22_20 != null) {
                            if (var22_20.a == var18_16 && ((var35_30 = var22_20.b) == var21_19 || var35_30 != null && var21_19.equals(var35_30))) {
                                var24_22 = 0;
                                break block20;
                            }
                            ++var23_21;
                            var22_20 = var22_20.d;
                        }
                        var24_22 = 1;
                    }
                    if (var24_22 != 0 && var23_21 >= 8) {
                        ++var2_2;
                        var6_4.d = var20_18;
                        var25_23 = var6_4;
                        var26_24 = null;
                        var27_25 = null;
                        break;
                    }
                }
            }
            if (var24_22 != 0) {
                ++var2_2;
                var6_4.d = var20_18;
                ConcurrentHashMap.setTabAt(var15_13, var19_17, var6_4);
            }
            var9_8 = 1L;
            var6_4 = var17_15;
            var12_10 = 1;
        } while (true);
        while (var25_23 != null) {
            var30_26 = var25_23.a;
            var31_27 = var25_23.b;
            var32_28 = var2_2;
            var34_29 = new r<K, V>(var30_26, var31_27, var25_23.c, null, null);
            var34_29.h = var27_25;
            if (var27_25 == null) {
                var26_24 = var34_29;
            } else {
                var27_25.d = var34_29;
            }
            var25_23 = var25_23.d;
            var27_25 = var34_29;
            var2_2 = var32_28;
        }
        ConcurrentHashMap.setTabAt(var15_13, var19_17, new q<K, V>(var26_24));
        ** while (true)
    }

    static final int resizeStamp(int n2) {
        return Integer.numberOfLeadingZeros((int)n2) | 1 << RESIZE_STAMP_BITS - 1;
    }

    static final void setTabAt(l[] arrl, int n2, l l2) {
        U.putObjectVolatile((Object)arrl, ((long)n2 << ASHIFT) + ABASE, (Object)l2);
    }

    static final int spread(int n2) {
        return Integer.MAX_VALUE & (n2 ^ n2 >>> 16);
    }

    static final l tabAt(l[] arrl, int n2) {
        return (l)U.getObjectVolatile((Object)arrl, ((long)n2 << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int n2) {
        int n3 = n2 - 1;
        int n4 = n3 | n3 >>> 1;
        int n5 = n4 | n4 >>> 2;
        int n6 = n5 | n5 >>> 4;
        int n7 = n6 | n6 >>> 8;
        int n8 = n7 | n7 >>> 16;
        if (n8 < 0) {
            return 1;
        }
        if (n8 >= 1073741824) {
            return 1073741824;
        }
        return 1 + n8;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final void transfer(l[] var1_1, l[] var2_2) {
        block25 : {
            block24 : {
                var3_3 = this;
                var4_4 = var1_1;
                var5_5 = var4_4.length;
                var6_6 = ConcurrentHashMap.NCPU;
                var7_7 = 1;
                var8_8 = var6_6 > var7_7 ? (var5_5 >>> 3) / var6_6 : var5_5;
                var9_9 = var8_8 < 16 ? 16 : var8_8;
                if (var2_2 != null) break block24;
                var69_10 = var5_5 << 1;
                try {
                    var70_11 = new l[var69_10];
                }
                catch (Throwable v0) {
                    var3_3.sizeCtl = Integer.MAX_VALUE;
                    return;
                }
                var3_3.nextTable = var70_11;
                var3_3.transferIndex = var5_5;
                var10_12 = var70_11;
                break block25;
            }
            var10_12 = var2_2;
        }
        var11_13 = var10_12.length;
        var12_14 = new g<K, V>(var10_12);
        var13_15 = var7_7;
        var14_16 = 0;
        var15_17 = 0;
        var16_18 = 0;
        do {
            block31 : {
                block37 : {
                    block39 : {
                        block40 : {
                            block36 : {
                                block38 : {
                                    block35 : {
                                        block32 : {
                                            block34 : {
                                                block27 : {
                                                    block33 : {
                                                        block30 : {
                                                            block29 : {
                                                                block28 : {
                                                                    block26 : {
                                                                        if (var13_15 == 0) break block26;
                                                                        var62_62 = var15_17 - 1;
                                                                        if (var62_62 >= var14_16 || var16_18 != 0) ** GOTO lbl47
                                                                        var63_63 = var3_3.transferIndex;
                                                                        if (var63_63 <= 0) {
                                                                            var15_17 = -1;
                                                                        } else {
                                                                            var64_64 = ConcurrentHashMap.U;
                                                                            var65_65 = ConcurrentHashMap.TRANSFERINDEX;
                                                                            var67_66 = var63_63 > var9_9 ? var63_63 - var9_9 : 0;
                                                                            var68_67 = var14_16;
                                                                            if (var64_64.compareAndSwapInt((Object)this, var65_65, var63_63, var67_66)) {
                                                                                var15_17 = var63_63 - 1;
                                                                                var14_16 = var67_66;
                                                                            } else {
                                                                                var14_16 = var68_67;
                                                                                var15_17 = var62_62;
                                                                                continue;
lbl47: // 1 sources:
                                                                                var15_17 = var62_62;
                                                                            }
                                                                        }
                                                                        var13_15 = 0;
                                                                        continue;
                                                                    }
                                                                    var17_19 = var14_16;
                                                                    var18_20 = null;
                                                                    if (var15_17 < 0 || var15_17 >= var5_5 || (var30_31 = var15_17 + var5_5) >= var11_13) break block27;
                                                                    var31_32 = ConcurrentHashMap.tabAt(var4_4, var15_17);
                                                                    if (var31_32 != null) break block28;
                                                                    var13_15 = ConcurrentHashMap.casTabAt(var4_4, var15_17, null, var12_14) ? 1 : 0;
                                                                    var19_21 = var9_9;
                                                                    var20_22 = var11_13;
                                                                    var23_25 = var7_7;
                                                                    var22_24 = var3_3;
                                                                    break block29;
                                                                }
                                                                var32_33 = var31_32.a;
                                                                if (var32_33 != -1) break block30;
                                                                var13_15 = var7_7;
                                                                var19_21 = var9_9;
                                                                var20_22 = var11_13;
                                                                var22_24 = var3_3;
                                                                var23_25 = var13_15;
                                                            }
                                                            var21_23 = var12_14;
                                                            break block31;
                                                        }
                                                        var71_68 = var31_32;
                                                        // MONITORENTER : var71_68
                                                        if (ConcurrentHashMap.tabAt(var4_4, var15_17) != var31_32) break block32;
                                                        if (var32_33 < 0) break block33;
                                                        var51_51 = var32_33 & var5_5;
                                                        var52_52 = var31_32.d;
                                                        var53_53 = var31_32;
                                                        while (var52_52 != null) {
                                                            var54_54 = var5_5 & var52_52.a;
                                                            if (var54_54 != var51_51) {
                                                                var53_53 = var52_52;
                                                                var51_51 = var54_54;
                                                            }
                                                            var52_52 = var52_52.d;
                                                        }
                                                        break block34;
                                                    }
                                                    var19_21 = var9_9;
                                                    var20_22 = var11_13;
                                                    if (!(var31_32 instanceof q)) break block35;
                                                    break block36;
                                                }
                                                var19_21 = var9_9;
                                                var20_22 = var11_13;
                                                var21_23 = var12_14;
                                                var22_24 = this;
                                                if (var16_18 != 0) {
                                                    var22_24.nextTable = null;
                                                    var22_24.table = var10_12;
                                                    var22_24.sizeCtl = (var5_5 << 1) - (var5_5 >>> 1);
                                                    return;
                                                }
                                                var23_25 = 1;
                                                var24_26 = ConcurrentHashMap.U;
                                                var25_27 = ConcurrentHashMap.SIZECTL;
                                                var27_28 = var22_24.sizeCtl;
                                                var28_29 = var27_28 - 1;
                                                var29_30 = var15_17;
                                                if (!var24_26.compareAndSwapInt((Object)this, var25_27, var27_28, var28_29)) break block37;
                                                if (var27_28 - 2 != ConcurrentHashMap.resizeStamp(var5_5) << ConcurrentHashMap.RESIZE_STAMP_SHIFT) {
                                                    return;
                                                }
                                                var15_17 = var5_5;
                                                var16_18 = var13_15 = var23_25;
                                                break block31;
                                            }
                                            if (var51_51 == 0) {
                                                var18_20 = var53_53;
                                                var55_55 = null;
                                            } else {
                                                var55_55 = var53_53;
                                            }
                                            var56_56 = var31_32;
                                            break block38;
                                        }
                                        var19_21 = var9_9;
                                        var20_22 = var11_13;
                                    }
                                    var21_23 = var12_14;
                                    break block39;
                                }
                                while (var56_56 != var53_53) {
                                    var57_57 = var56_56.a;
                                    var58_58 = var56_56.b;
                                    var59_59 = var9_9;
                                    var60_60 = var56_56.c;
                                    if ((var57_57 & var5_5) == 0) {
                                        var61_61 = var11_13;
                                        var18_20 = new r<K, V>(var57_57, var58_58, var60_60, var18_20);
                                    } else {
                                        var61_61 = var11_13;
                                        var55_55 = new l<K, V>(var57_57, var58_58, var60_60, var55_55);
                                    }
                                    var56_56 = var56_56.d;
                                    var9_9 = var59_59;
                                    var11_13 = var61_61;
                                }
                                var19_21 = var9_9;
                                var20_22 = var11_13;
                                ConcurrentHashMap.setTabAt(var10_12, var15_17, var18_20);
                                ConcurrentHashMap.setTabAt(var10_12, var30_31, var55_55);
                                ConcurrentHashMap.setTabAt(var4_4, var15_17, var12_14);
                                var21_23 = var12_14;
                                break block40;
                            }
                            var34_34 = (q)var31_32;
                            var35_35 = var34_34.h;
                            var36_36 = null;
                            var37_37 = null;
                            var38_38 /* !! */  = var35_35;
                            var39_39 = 0;
                            var40_40 = 0;
                            var41_41 = null;
                            do {
                                block45 : {
                                    block44 : {
                                        block43 : {
                                            block41 : {
                                                block42 : {
                                                    if (var38_38 /* !! */  == null) break block41;
                                                    var46_46 = var34_34;
                                                    var47_47 = var38_38 /* !! */ .a;
                                                    var48_48 = var38_38 /* !! */ .b;
                                                    var49_49 = var12_14;
                                                    var50_50 = new r<K, V>(var47_47, var48_48, var38_38 /* !! */ .c, null, null);
                                                    if ((var47_47 & var5_5) != 0) break block42;
                                                    var50_50.h = var37_37;
                                                    if (var37_37 == null) {
                                                        var18_20 = var50_50;
                                                    } else {
                                                        var37_37.d = var50_50;
                                                    }
                                                    break block43;
                                                }
                                                var50_50.h = var36_36;
                                                if (var36_36 == null) {
                                                    var41_41 = var50_50;
                                                } else {
                                                    var36_36.d = var50_50;
                                                }
                                                break block44;
                                            }
                                            var42_42 = var34_34;
                                            var43_43 = var12_14;
                                            var44_44 = var39_39 <= 6 ? ConcurrentHashMap.untreeify(var18_20) : (var40_40 != 0 ? new q<K, V>(var18_20) : var42_42);
                                            var45_45 = var40_40 <= 6 ? ConcurrentHashMap.untreeify(var41_41) : (var39_39 != 0 ? new q<K, V>(var41_41) : var42_42);
                                            ConcurrentHashMap.setTabAt(var10_12, var15_17, var44_44);
                                            ConcurrentHashMap.setTabAt(var10_12, var30_31, var45_45);
                                            var4_4 = var1_1;
                                            var21_23 = var43_43;
                                            ConcurrentHashMap.setTabAt(var4_4, var15_17, var21_23);
                                            break;
                                        }
                                        ++var39_39;
                                        var37_37 = var50_50;
                                        break block45;
                                    }
                                    ++var40_40;
                                    var36_36 = var50_50;
                                }
                                var38_38 /* !! */  = var38_38 /* !! */ .d;
                                var34_34 = var46_46;
                                var12_14 = var49_49;
                            } while (true);
                        }
                        var13_15 = 1;
                    }
                    // MONITOREXIT : var71_68
                    var22_24 = this;
                    var29_30 = var15_17;
                    var23_25 = 1;
                }
                var15_17 = var29_30;
            }
            var12_14 = var21_23;
            var3_3 = var22_24;
            var7_7 = var23_25;
            var14_16 = var17_19;
            var9_9 = var19_21;
            var11_13 = var20_22;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final void treeifyBin(l[] arrl, int n2) {
        if (arrl == null) return;
        int n3 = arrl.length;
        if (n3 < 64) {
            this.tryPresize(n3 << 1);
            return;
        }
        l l2 = ConcurrentHashMap.tabAt(arrl, n2);
        if (l2 == null) return;
        if (l2.a < 0) return;
        l l3 = l2;
        // MONITORENTER : l3
        if (ConcurrentHashMap.tabAt(arrl, n2) == l2) {
            r r2 = null;
            l l4 = l2;
            r r3 = null;
            while (l4 != null) {
                r r4 = new r(l4.a, l4.b, l4.c, null, null);
                r4.h = r3;
                if (r3 == null) {
                    r2 = r4;
                } else {
                    r3.d = r4;
                }
                l4 = l4.d;
                r3 = r4;
            }
            ConcurrentHashMap.setTabAt(arrl, n2, new q(r2));
        }
        // MONITOREXIT : l3
    }

    private final void tryPresize(int n2) {
        int n3;
        int n4 = n2 >= 536870912 ? 1073741824 : ConcurrentHashMap.tableSizeFor(1 + (n2 + (n2 >>> 1)));
        while ((n3 = this.sizeCtl) >= 0) {
            block7 : {
                int n5;
                l[] arrl = this.table;
                if (arrl != null && (n5 = arrl.length) != 0) {
                    if (n4 <= n3) break;
                    if (n5 >= 1073741824) {
                        return;
                    }
                    if (arrl != this.table) continue;
                    int n6 = ConcurrentHashMap.resizeStamp(n5);
                    if (n3 < 0) {
                        l[] arrl2;
                        if (n3 >>> RESIZE_STAMP_SHIFT != n6 || n3 == n6 + 1 || n3 == n6 + MAX_RESIZERS || (arrl2 = this.nextTable) == null) break;
                        if (this.transferIndex <= 0) {
                            return;
                        }
                        Unsafe unsafe = U;
                        long l2 = SIZECTL;
                        int n7 = n3 + 1;
                        if (!unsafe.compareAndSwapInt((Object)this, l2, n3, n7)) continue;
                        this.transfer(arrl, arrl2);
                        continue;
                    }
                    Unsafe unsafe = U;
                    long l3 = SIZECTL;
                    int n8 = 2 + (n6 << RESIZE_STAMP_SHIFT);
                    if (!unsafe.compareAndSwapInt((Object)this, l3, n3, n8)) continue;
                    this.transfer(arrl, null);
                    continue;
                }
                int n9 = n3 > n4 ? n3 : n4;
                if (!U.compareAndSwapInt((Object)this, SIZECTL, n3, -1)) continue;
                try {
                    if (this.table != arrl) break block7;
                    this.table = new l[n9];
                }
                catch (Throwable throwable) {
                    this.sizeCtl = n3;
                    throw throwable;
                }
                n3 = n9 - (n9 >>> 2);
            }
            this.sizeCtl = n3;
        }
    }

    static l untreeify(l l2) {
        l l3 = null;
        l l4 = null;
        while (l2 != null) {
            l l5 = new l(l2.a, l2.b, l2.c, null);
            if (l4 == null) {
                l3 = l5;
            } else {
                l4.d = l5;
            }
            l2 = l2.d;
            l4 = l5;
        }
        return l3;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int n2;
        int n3 = 0;
        for (n2 = 1; n2 < 16; n2 <<= 1) {
            ++n3;
        }
        int n4 = 32 - n3;
        int n5 = n2 - 1;
        n[] arrn = new n[16];
        for (int i2 = 0; i2 < 16; ++i2) {
            arrn[i2] = new n(0.75f);
        }
        objectOutputStream.putFields().put("segments", (Object)arrn);
        objectOutputStream.putFields().put("segmentShift", n4);
        objectOutputStream.putFields().put("segmentMask", n5);
        objectOutputStream.writeFields();
        l[] arrl = this.table;
        if (arrl != null) {
            l l2;
            p p2 = new p(arrl, arrl.length, 0, arrl.length);
            while ((l2 = p2.a()) != null) {
                objectOutputStream.writeObject(l2.b);
                objectOutputStream.writeObject(l2.c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void clear() {
        l[] arrl = this.table;
        int n2 = 0;
        long l2 = 0L;
        while (arrl != null && n2 < arrl.length) {
            r r2 = ConcurrentHashMap.tabAt(arrl, n2);
            if (r2 == null) {
                ++n2;
                continue;
            }
            int n3 = r2.a;
            if (n3 == -1) {
                arrl = this.helpTransfer(arrl, r2);
                n2 = 0;
                continue;
            }
            r r3 = r2;
            synchronized (r3) {
                if (ConcurrentHashMap.tabAt(arrl, n2) == r2) {
                    r r4 = n3 >= 0 ? r2 : (r2 instanceof q ? ((q)r2).h : null);
                    while (r4 != null) {
                        --l2;
                        r4 = r4.d;
                    }
                    int n4 = n2 + 1;
                    ConcurrentHashMap.setTabAt(arrl, n2, null);
                    n2 = n4;
                }
            }
        }
        if (l2 != 0L) {
            this.addCount(l2, -1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object compute(Object object, j$.util.function.BiFunction biFunction) {
        int n2;
        int n3;
        Object object2;
        block25 : {
            int n4;
            if (object == null || biFunction == null) {
                throw null;
            }
            int n5 = ConcurrentHashMap.spread(object.hashCode());
            l[] arrl = this.table;
            n3 = 0;
            object2 = null;
            n2 = 0;
            do {
                int n6;
                q q2;
                l l2;
                block28 : {
                    block29 : {
                        int n7;
                        m m2;
                        if (arrl == null || (n7 = arrl.length) == 0) break block28;
                        n4 = n5 & n7 - 1;
                        l2 = ConcurrentHashMap.tabAt(arrl, n4);
                        n6 = 1;
                        if (l2 != null) break block29;
                        m m3 = m2 = new m();
                        synchronized (m3) {
                            boolean bl = ConcurrentHashMap.casTabAt(arrl, n4, null, m2);
                            if (bl) {
                                Object object3;
                                l l3;
                                int n8;
                                block24 : {
                                    try {
                                        object3 = biFunction.apply(object, null);
                                        if (object3 != null) {
                                            l3 = new l(n5, object, object3, null);
                                            n8 = n6;
                                            break block24;
                                        }
                                        n8 = n3;
                                        l3 = null;
                                    }
                                    catch (Throwable throwable) {
                                        ConcurrentHashMap.setTabAt(arrl, n4, null);
                                        throw throwable;
                                    }
                                }
                                ConcurrentHashMap.setTabAt(arrl, n4, l3);
                                n3 = n8;
                                object2 = object3;
                                n2 = n6;
                            }
                            if (n2 == 0) continue;
                        }
                        break block25;
                    }
                    int n9 = l2.a;
                    if (n9 == -1) {
                        arrl = this.helpTransfer(arrl, l2);
                        continue;
                    }
                    l l4 = l2;
                    synchronized (l4) {
                        if (ConcurrentHashMap.tabAt(arrl, n4) != l2) break block26;
                        if (n9 >= 0) break block30;
                        if (l2 instanceof q) {
                            q2 = (q)l2;
                        }
                        break block26;
                    }
                }
                arrl = this.initTable();
                continue;
                {
                    block26 : {
                        Object object4;
                        block27 : {
                            block32 : {
                                block30 : {
                                    r r2;
                                    block31 : {
                                        r r3 = q2.g;
                                        r2 = r3 != null ? r3.b(n5, object, null) : null;
                                        Object object5 = r2 == null ? null : r2.c;
                                        object4 = biFunction.apply(object, object5);
                                        if (object4 == null) break block31;
                                        if (r2 != null) {
                                            r2.c = object4;
                                        } else {
                                            q2.f(n5, object, object4);
                                            n3 = n6;
                                        }
                                        break block27;
                                    }
                                    if (r2 == null) break block27;
                                    if (q2.g(r2)) {
                                        ConcurrentHashMap.setTabAt(arrl, n4, ConcurrentHashMap.untreeify(q2.h));
                                    }
                                    break block32;
                                }
                                l l5 = null;
                                l l6 = l2;
                                int n10 = n6;
                                do {
                                    l l7;
                                    block35 : {
                                        block36 : {
                                            Object object6;
                                            block34 : {
                                                block33 : {
                                                    Object object7;
                                                    if (l6.a != n5 || (object7 = l6.b) != object && (object7 == null || !object.equals(object7))) break block33;
                                                    object6 = biFunction.apply(object, l6.c);
                                                    if (object6 != null) {
                                                        l6.c = object6;
                                                        n2 = n10;
                                                        object2 = object6;
                                                        break block26;
                                                    }
                                                    l l8 = l6.d;
                                                    if (l5 != null) {
                                                        l5.d = l8;
                                                    } else {
                                                        ConcurrentHashMap.setTabAt(arrl, n4, l8);
                                                    }
                                                    break block34;
                                                }
                                                l7 = l6.d;
                                                if (l7 != null) break block35;
                                                object4 = biFunction.apply(object, null);
                                                if (object4 == null) break block36;
                                                l6.d = new l(n5, object, object4, null);
                                                n3 = n6;
                                                break block36;
                                            }
                                            object4 = object6;
                                            n6 = n10;
                                            break;
                                        }
                                        n6 = n10;
                                        break block27;
                                    }
                                    ++n10;
                                    l5 = l6;
                                    l6 = l7;
                                } while (true);
                            }
                            n2 = n6;
                            object2 = object4;
                            n3 = -1;
                            break block26;
                        }
                        n2 = n6;
                        object2 = object4;
                    }
                    if (n2 != 0) break;
                }
            } while (true);
            if (n2 >= 8) {
                this.treeifyBin(arrl, n4);
            }
        }
        if (n3 != 0) {
            this.addCount(n3, n2);
        }
        return object2;
    }

    public /* synthetic */ Object compute(Object object, BiFunction biFunction) {
        return this.compute(object, j$.t.a(biFunction));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public Object computeIfAbsent(Object var1_1, Function var2_2) {
        block20 : {
            if (var1_1 == null) throw null;
            if (var2_2 == null) throw null;
            var3_3 = ConcurrentHashMap.spread(var1_1.hashCode());
            var4_4 = this.table;
            var5_5 = null;
            var6_6 = 0;
            do {
                block27 : {
                    block21 : {
                        block25 : {
                            block23 : {
                                block22 : {
                                    block24 : {
                                        if (var4_4 == null || (var7_7 = var4_4.length) == 0) break block22;
                                        var8_8 = var3_3 & var7_7 - 1;
                                        var9_9 = ConcurrentHashMap.tabAt(var4_4, var8_8);
                                        var10_10 = 1;
                                        if (var9_9 == null) {
                                            var27_23 = var11_11 = new m<K, V>();
                                            // MONITORENTER : var27_23
                                            var13_12 = ConcurrentHashMap.casTabAt(var4_4, var8_8, null, var11_11);
                                            if (var13_12) {
                                                try {
                                                    var15_13 = var2_2.apply(var1_1);
                                                    var16_14 = var15_13 != null ? new l<K, V>(var3_3, var1_1, var15_13, null) : null;
                                                }
                                                catch (Throwable var14_25) {
                                                    ConcurrentHashMap.setTabAt(var4_4, var8_8, null);
                                                    throw var14_25;
                                                }
                                                ConcurrentHashMap.setTabAt(var4_4, var8_8, var16_14);
                                                var5_5 = var15_13;
                                                var6_6 = var10_10;
                                            }
                                            // MONITOREXIT : var27_23
                                            if (var6_6 == 0) continue;
                                            break block20;
                                        }
                                        var17_15 = var9_9.a;
                                        if (var17_15 == -1) {
                                            var4_4 = this.helpTransfer(var4_4, var9_9);
                                            continue;
                                        }
                                        var28_24 = var9_9;
                                        // MONITORENTER : var28_24
                                        if (ConcurrentHashMap.tabAt(var4_4, var8_8) != var9_9) break block21;
                                        if (var17_15 >= 0) break block23;
                                        if (!(var9_9 instanceof q)) break block21;
                                        var6_6 = 2;
                                        var19_16 = (q)var9_9;
                                        var20_17 = var19_16.g;
                                        if (var20_17 == null || (var21_18 = var20_17.b(var3_3, var1_1, null)) == null) break block24;
                                        var5_5 = var21_18.c;
                                        break block21;
                                    }
                                    var22_19 = var2_2.apply(var1_1);
                                    if (var22_19 == null) ** GOTO lbl68
                                    var19_16.f(var3_3, var1_1, var22_19);
                                    break block25;
                                }
                                var4_4 = this.initTable();
                                continue;
                            }
                            var24_20 = var9_9;
                            var6_6 = var10_10;
                            do {
                                block26 : {
                                    if (var24_20.a == var3_3 && ((var26_22 = var24_20.b) == var1_1 || var26_22 != null && var1_1.equals(var26_22))) {
                                        var5_5 = var24_20.c;
                                        break block21;
                                    }
                                    var25_21 = var24_20.d;
                                    if (var25_21 == null) {
                                        var22_19 = var2_2.apply(var1_1);
                                        if (var22_19 != null) {
                                            var24_20.d = new l<K, V>(var3_3, var1_1, var22_19, null);
                                            break;
                                        } else {
                                            ** GOTO lbl68
                                        }
                                    }
                                    break block26;
lbl68: // 3 sources:
                                    var10_10 = 0;
                                    break;
                                }
                                ++var6_6;
                                var24_20 = var25_21;
                            } while (true);
                        }
                        var5_5 = var22_19;
                        break block27;
                    }
                    var10_10 = 0;
                }
                // MONITOREXIT : var28_24
                if (var6_6 != 0) break;
            } while (true);
            if (var6_6 >= 8) {
                this.treeifyBin(var4_4, var8_8);
            }
            if (var10_10 == 0) {
                return var5_5;
            }
        }
        if (var5_5 == null) return var5_5;
        this.addCount(1L, var6_6);
        return var5_5;
    }

    public /* synthetic */ Object computeIfAbsent(Object object, java.util.function.Function function) {
        return this.computeIfAbsent(object, N.a(function));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public Object computeIfPresent(Object var1_1, j$.util.function.BiFunction var2_2) {
        if (var1_1 == null) throw null;
        if (var2_2 == null) throw null;
        var3_3 = ConcurrentHashMap.spread(var1_1.hashCode());
        var4_4 = this.table;
        var5_5 = 0;
        var6_6 = null;
        var7_7 = 0;
        do {
            block10 : {
                block9 : {
                    block11 : {
                        if (var4_4 == null || (var8_8 = var4_4.length) == 0) break block9;
                        var9_9 = var3_3 & var8_8 - 1;
                        var10_10 = ConcurrentHashMap.tabAt(var4_4, var9_9);
                        if (var10_10 == null) ** GOTO lbl63
                        var11_11 = var10_10.a;
                        if (var11_11 == -1) {
                            var4_4 = this.helpTransfer(var4_4, var10_10);
                            continue;
                        }
                        var21_20 = var10_10;
                        // MONITORENTER : var21_20
                        if (ConcurrentHashMap.tabAt(var4_4, var9_9) != var10_10) ** GOTO lbl60
                        if (var11_11 >= 0) break block10;
                        if (!(var10_10 instanceof q)) ** GOTO lbl60
                        var7_7 = 2;
                        var13_12 = (q)var10_10;
                        var14_13 = var13_12.g;
                        if (var14_13 == null || (var15_14 = var14_13.b(var3_3, var1_1, null)) == null) ** GOTO lbl60
                        var6_6 = var2_2.apply(var1_1, var15_14.c);
                        if (var6_6 == null) break block11;
                        var15_14.c = var6_6;
                        ** GOTO lbl60
                    }
                    if (!var13_12.g(var15_14)) ** GOTO lbl58
                    var16_15 = ConcurrentHashMap.untreeify(var13_12.h);
                    ** GOTO lbl-1000
                }
                var4_4 = this.initTable();
                continue;
            }
            var7_7 = 1;
            var17_16 = null;
            var18_17 = var10_10;
            do {
                block16 : {
                    block14 : {
                        block15 : {
                            block12 : {
                                block13 : {
                                    if (var18_17.a != var3_3 || (var20_19 = var18_17.b) != var1_1 && (var20_19 == null || !var1_1.equals(var20_19))) break block12;
                                    var6_6 = var2_2.apply(var1_1, var18_17.c);
                                    if (var6_6 == null) break block13;
                                    var18_17.c = var6_6;
                                    break block14;
                                }
                                var16_15 = var18_17.d;
                                if (var17_16 != null) {
                                    var17_16.d = var16_15;
                                } else lbl-1000: // 2 sources:
                                {
                                    ConcurrentHashMap.setTabAt(var4_4, var9_9, var16_15);
                                }
                                break block15;
                            }
                            var19_18 = var18_17.d;
                            if (var19_18 != null) break block16;
                            break block14;
                        }
                        var5_5 = -1;
                    }
                    // MONITOREXIT : var21_20
                    if (var7_7 == 0) ** break;
lbl63: // 2 sources:
                    if (var5_5 == 0) return var6_6;
                    this.addCount(var5_5, var7_7);
                    return var6_6;
                }
                ++var7_7;
                var17_16 = var18_17;
                var18_17 = var19_18;
            } while (true);
            break;
        } while (true);
    }

    public /* synthetic */ Object computeIfPresent(Object object, BiFunction biFunction) {
        return this.computeIfPresent(object, j$.t.a(biFunction));
    }

    public boolean contains(Object object) {
        return this.containsValue(object);
    }

    @Override
    public boolean containsKey(Object object) {
        return this.get(object) != null;
    }

    @Override
    public boolean containsValue(Object object) {
        object.getClass();
        l[] arrl = this.table;
        if (arrl != null) {
            l l2;
            p p2 = new p(arrl, arrl.length, 0, arrl.length);
            while ((l2 = p2.a()) != null) {
                Object object2 = l2.c;
                if (object2 != object && (object2 == null || !object.equals(object2))) continue;
                return true;
            }
        }
        return false;
    }

    public Enumeration elements() {
        l[] arrl = this.table;
        int n2 = arrl == null ? 0 : arrl.length;
        int n3 = n2;
        s s2 = new s(arrl, n3, 0, n3, this);
        return s2;
    }

    @Override
    public Set entrySet() {
        e e2;
        e e3 = this.entrySet;
        if (e3 != null) {
            return e3;
        }
        this.entrySet = e2 = new /* Unavailable Anonymous Inner Class!! */;
        return e2;
    }

    @Override
    public boolean equals(Object object) {
        if (object != this) {
            l l2;
            if (!(object instanceof Map)) {
                return false;
            }
            Map map = (Map)object;
            l[] arrl = this.table;
            int n2 = arrl == null ? 0 : arrl.length;
            p p2 = new p(arrl, n2, 0, n2);
            while ((l2 = p2.a()) != null) {
                Object object2 = l2.c;
                Object object3 = map.get(l2.b);
                if (object3 != null && (object3 == object2 || object3.equals(object2))) continue;
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                Object object4;
                Object object5;
                Object object6 = entry.getKey();
                if (object6 != null && (object4 = entry.getValue()) != null && (object5 = this.get(object6)) != null && (object4 == object5 || object4.equals(object5))) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public void forEach(j$.util.function.BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] arrl = this.table;
        if (arrl != null) {
            l l2;
            p p2 = new p(arrl, arrl.length, 0, arrl.length);
            while ((l2 = p2.a()) != null) {
                biConsumer.accept(l2.b, l2.c);
            }
        }
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        this.forEach(j$.r.b(biConsumer));
    }

    @Override
    public Object get(Object object) {
        l l2;
        int n2;
        int n3 = ConcurrentHashMap.spread(object.hashCode());
        l[] arrl = this.table;
        if (arrl != null && (n2 = arrl.length) > 0 && (l2 = ConcurrentHashMap.tabAt(arrl, n3 & n2 - 1)) != null) {
            int n4 = l2.a;
            if (n4 == n3) {
                Object object2 = l2.b;
                if (object2 == object || object2 != null && object.equals(object2)) {
                    return l2.c;
                }
            } else if (n4 < 0) {
                l l3 = l2.a(n3, object);
                Object object3 = null;
                if (l3 != null) {
                    object3 = l3.c;
                }
                return object3;
            }
            while ((l2 = l2.d) != null) {
                Object object4;
                if (l2.a != n3 || (object4 = l2.b) != object && (object4 == null || !object.equals(object4))) continue;
                return l2.c;
            }
        }
        return null;
    }

    @Override
    public Object getOrDefault(Object object, Object object2) {
        Object object3 = this.get(object);
        if (object3 == null) {
            return object2;
        }
        return object3;
    }

    @Override
    public int hashCode() {
        l[] arrl = this.table;
        int n2 = 0;
        if (arrl != null) {
            l l2;
            p p2 = new p(arrl, arrl.length, 0, arrl.length);
            while ((l2 = p2.a()) != null) {
                n2 += l2.b.hashCode() ^ l2.c.hashCode();
            }
        }
        return n2;
    }

    final l[] helpTransfer(l[] arrl, l l2) {
        l[] arrl2;
        if (arrl != null && l2 instanceof g && (arrl2 = ((g)l2).e) != null) {
            int n2;
            int n3 = ConcurrentHashMap.resizeStamp(arrl.length);
            while (arrl2 == this.nextTable && this.table == arrl && (n2 = this.sizeCtl) < 0 && n2 >>> RESIZE_STAMP_SHIFT == n3 && n2 != n3 + 1 && n2 != n3 + MAX_RESIZERS) {
                if (this.transferIndex <= 0) {
                    return arrl2;
                }
                if (!U.compareAndSwapInt((Object)this, SIZECTL, n2, n2 + 1)) continue;
                this.transfer(arrl, arrl2);
                break;
            }
            return arrl2;
        }
        return this.table;
    }

    @Override
    public boolean isEmpty() {
        return this.sumCount() <= 0L;
    }

    @Override
    public Set keySet() {
        i i2;
        i i4 = this.keySet;
        if (i4 != null) {
            return i4;
        }
        this.keySet = i2 = new /* Unavailable Anonymous Inner Class!! */;
        return i2;
    }

    public Enumeration keys() {
        l[] arrl = this.table;
        int n2 = arrl == null ? 0 : arrl.length;
        int n3 = n2;
        h h2 = new h(arrl, n3, 0, n3, this);
        return h2;
    }

    public long mappingCount() {
        long l2 = this.sumCount();
        if (l2 < 0L) {
            l2 = 0L;
        }
        return l2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public Object merge(Object var1_1, Object var2_2, j$.util.function.BiFunction var3_3) {
        var4_4 = var2_2;
        if (var1_1 == null) throw null;
        if (var4_4 == null) throw null;
        if (var3_3 == null) throw null;
        var5_5 = ConcurrentHashMap.spread(var1_1.hashCode());
        var6_6 = this.table;
        var7_7 = 0;
        var8_8 = null;
        var9_9 = 0;
        do {
            block18 : {
                block19 : {
                    block16 : {
                        block17 : {
                            if (var6_6 == null || (var10_10 = var6_6.length) == 0) break block16;
                            var11_11 = var5_5 & var10_10 - 1;
                            var12_12 = ConcurrentHashMap.tabAt(var6_6, var11_11);
                            var13_13 = 1;
                            if (var12_12 != null) break block17;
                            if (!ConcurrentHashMap.casTabAt(var6_6, var11_11, null, new l<K, V>(var5_5, var1_1, var4_4, null))) continue;
                            ** GOTO lbl89
                        }
                        var14_14 = var12_12.a;
                        if (var14_14 == -1) {
                            var6_6 = this.helpTransfer(var6_6, var12_12);
                            continue;
                        }
                        var28_26 = var12_12;
                        // MONITORENTER : var28_26
                        if (ConcurrentHashMap.tabAt(var6_6, var11_11) != var12_12) ** GOTO lbl82
                        if (var14_14 >= 0) break block18;
                        if (!(var12_12 instanceof q)) ** GOTO lbl82
                        var7_7 = 2;
                        var16_15 = (q)var12_12;
                        var17_16 = var16_15.g;
                        var18_17 = var17_16 == null ? null : var17_16.b(var5_5, var1_1, null);
                        break block19;
                    }
                    var6_6 = this.initTable();
                    continue;
                }
                var19_18 = var18_17 == null ? var4_4 : var3_3.apply(var18_17.c, var4_4);
                if (var19_18 != null) {
                    if (var18_17 != null) {
                        var18_17.c = var19_18;
                    } else {
                        var16_15.f(var5_5, var1_1, var19_18);
                        var9_9 = var13_13;
                    }
                } else if (var18_17 != null) {
                    if (var16_15.g(var18_17)) {
                        ConcurrentHashMap.setTabAt(var6_6, var11_11, ConcurrentHashMap.untreeify(var16_15.h));
                    }
                    var9_9 = -1;
                }
                var8_8 = var19_18;
                ** GOTO lbl82
            }
            var21_19 = null;
            var22_20 = var12_12;
            var23_21 = var13_13;
            do {
                block24 : {
                    block22 : {
                        block23 : {
                            block20 : {
                                block21 : {
                                    if (var22_20.a != var5_5 || (var25_23 = var22_20.b) != var1_1 && (var25_23 == null || !var1_1.equals(var25_23))) break block20;
                                    var26_24 = var3_3.apply(var22_20.c, var4_4);
                                    if (var26_24 == null) break block21;
                                    var22_20.c = var26_24;
                                    var7_7 = var23_21;
                                    var8_8 = var26_24;
                                    break block22;
                                }
                                var27_25 = var22_20.d;
                                if (var21_19 != null) {
                                    var21_19.d = var27_25;
                                } else {
                                    ConcurrentHashMap.setTabAt(var6_6, var11_11, var27_25);
                                }
                                break block23;
                            }
                            var24_22 = var22_20.d;
                            if (var24_22 != null) break block24;
                            var22_20.d = new l<K, V>(var5_5, var1_1, var4_4, null);
                            var7_7 = var23_21;
                            var9_9 = var13_13;
                            var8_8 = var4_4;
                            break block22;
                        }
                        var7_7 = var23_21;
                        var8_8 = var26_24;
                        var9_9 = -1;
                    }
                    // MONITOREXIT : var28_26
                    if (var7_7 == 0) ** break;
                    if (var7_7 >= 8) {
                        this.treeifyBin(var6_6, var11_11);
                    }
                    var13_13 = var9_9;
                    var4_4 = var8_8;
lbl89: // 2 sources:
                    if (var13_13 == 0) return var4_4;
                    this.addCount(var13_13, var7_7);
                    return var4_4;
                }
                ++var23_21;
                var21_19 = var22_20;
                var22_20 = var24_22;
            } while (true);
            break;
        } while (true);
    }

    public /* synthetic */ Object merge(Object object, Object object2, BiFunction biFunction) {
        return this.merge(object, object2, j$.t.a(biFunction));
    }

    @Override
    public Object put(Object object, Object object2) {
        return this.putVal(object, object2, false);
    }

    @Override
    public void putAll(Map map) {
        this.tryPresize(map.size());
        for (Map.Entry entry : map.entrySet()) {
            this.putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        return this.putVal(object, object2, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    final Object putVal(Object var1_1, Object var2_2, boolean var3_3) {
        block13 : {
            if (var1_1 == null) throw null;
            if (var2_2 == null) throw null;
            var4_4 = ConcurrentHashMap.spread(var1_1.hashCode());
            var5_5 = 0;
            var6_6 = this.table;
            do {
                block14 : {
                    block16 : {
                        block17 : {
                            block15 : {
                                if (var6_6 == null || (var7_7 = var6_6.length) == 0) break block15;
                                var8_8 = var4_4 & var7_7 - 1;
                                var9_9 = ConcurrentHashMap.tabAt(var6_6, var8_8);
                                if (var9_9 == null) {
                                    if (!ConcurrentHashMap.casTabAt(var6_6, var8_8, null, new l<K, V>(var4_4, var1_1, var2_2, null))) continue;
                                    break block13;
                                }
                                var10_10 = var9_9.a;
                                if (var10_10 == -1) {
                                    var6_6 = this.helpTransfer(var6_6, var9_9);
                                    continue;
                                }
                                var16_15 = var9_9;
                                // MONITORENTER : var16_15
                                if (ConcurrentHashMap.tabAt(var6_6, var8_8) != var9_9) break block16;
                                if (var10_10 >= 0) break block17;
                                if (!(var9_9 instanceof q)) break block16;
                                var5_5 = 2;
                                var12_11 = ((q)var9_9).f(var4_4, var1_1, var2_2);
                                if (var12_11 == null) break block16;
                                var13_12 = var12_11.c;
                                if (var3_3) break block14;
                                ** GOTO lbl39
                            }
                            var6_6 = this.initTable();
                            continue;
                        }
                        var5_5 = 1;
                        var12_11 = var9_9;
                        do {
                            block18 : {
                                if (var12_11.a == var4_4 && ((var15_14 = var12_11.b) == var1_1 || var15_14 != null && var1_1.equals(var15_14))) {
                                    var13_12 = var12_11.c;
                                    if (var3_3) break block14;
                                }
                                break block18;
lbl39: // 2 sources:
                                var12_11.c = var2_2;
                                break block14;
                            }
                            var14_13 = var12_11.d;
                            if (var14_13 == null) {
                                var12_11.d = new l<K, V>(var4_4, var1_1, var2_2, null);
                                break;
                            }
                            ++var5_5;
                            var12_11 = var14_13;
                        } while (true);
                    }
                    var13_12 = null;
                }
                // MONITOREXIT : var16_15
                if (var5_5 != 0) break;
            } while (true);
            if (var5_5 >= 8) {
                this.treeifyBin(var6_6, var8_8);
            }
            if (var13_12 != null) {
                return var13_12;
            }
        }
        this.addCount(1L, var5_5);
        return null;
    }

    @Override
    public Object remove(Object object) {
        return this.replaceNode(object, null, null);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        object.getClass();
        return object2 != null && this.replaceNode(object, null, object2) != null;
    }

    @Override
    public Object replace(Object object, Object object2) {
        if (object != null && object2 != null) {
            return this.replaceNode(object, object2, null);
        }
        throw null;
    }

    @Override
    public boolean replace(Object object, Object object2, Object object3) {
        if (object != null && object2 != null && object3 != null) {
            return this.replaceNode(object, object3, object2) != null;
        }
        throw null;
    }

    @Override
    public void replaceAll(j$.util.function.BiFunction biFunction) {
        biFunction.getClass();
        l[] arrl = this.table;
        if (arrl != null) {
            l l2;
            p p2 = new p(arrl, arrl.length, 0, arrl.length);
            while ((l2 = p2.a()) != null) {
                Object object;
                Object object2 = l2.c;
                Object object3 = l2.b;
                do {
                    object = biFunction.apply(object3, object2);
                    object.getClass();
                } while (this.replaceNode(object3, object, object2) == null && (object2 = this.get(object3)) != null);
            }
        }
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        this.replaceAll(j$.t.a(biFunction));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    final Object replaceNode(Object var1_1, Object var2_2, Object var3_3) {
        block23 : {
            var4_4 = ConcurrentHashMap.spread(var1_1.hashCode());
            var5_5 = this.table;
            while (var5_5 != null) {
                block22 : {
                    block24 : {
                        block25 : {
                            block26 : {
                                var6_6 = var5_5.length;
                                if (var6_6 == 0) return null;
                                var7_7 = var4_4 & var6_6 - 1;
                                var8_8 = ConcurrentHashMap.tabAt(var5_5, var7_7);
                                if (var8_8 == null) {
                                    return null;
                                }
                                var9_9 = var8_8.a;
                                if (var9_9 == -1) {
                                    var5_5 = this.helpTransfer(var5_5, var8_8);
                                    continue;
                                }
                                var24_23 = var8_8;
                                // MONITORENTER : var24_23
                                var11_10 = ConcurrentHashMap.tabAt(var5_5, var7_7);
                                var12_11 = true;
                                var13_12 = false;
                                if (var11_10 != var8_8) break block24;
                                if (var9_9 >= 0) break block25;
                                var15_14 = var8_8 instanceof q;
                                var13_12 = false;
                                if (!var15_14) break block24;
                                var16_15 = (q)var8_8;
                                var17_16 = var16_15.g;
                                if (var17_16 == null || (var18_17 = var17_16.b(var4_4, var1_1, null)) == null) ** GOTO lbl56
                                var14_13 = var18_17.c;
                                if (var3_3 != null && var3_3 != var14_13 && (var14_13 == null || !var3_3.equals(var14_13))) ** GOTO lbl56
                                if (var2_2 == null) break block26;
                                var18_17.c = var2_2;
                                break block22;
                            }
                            if (!var16_15.g(var18_17)) break block22;
                            var19_18 = ConcurrentHashMap.untreeify(var16_15.h);
                            ** GOTO lbl50
                        }
                        var20_19 = null;
                        var21_20 = var8_8;
                        do {
                            block29 : {
                                block28 : {
                                    block27 : {
                                        if (var21_20.a != var4_4 || (var23_22 = var21_20.b) != var1_1 && (var23_22 == null || !var1_1.equals(var23_22))) break block27;
                                        var14_13 = var21_20.c;
                                        if (var3_3 != null && var3_3 != var14_13 && (var14_13 == null || !var3_3.equals(var14_13))) break block28;
                                        if (var2_2 != null) {
                                            var21_20.c = var2_2;
                                        } else if (var20_19 != null) {
                                            var20_19.d = var21_20.d;
                                        } else {
                                            var19_18 = var21_20.d;
lbl50: // 2 sources:
                                            ConcurrentHashMap.setTabAt(var5_5, var7_7, var19_18);
                                        }
                                        break block22;
                                    }
                                    var22_21 = var21_20.d;
                                    if (var22_21 != null) break block29;
                                }
                                var13_12 = var12_11;
                                break;
                            }
                            var20_19 = var21_20;
                            var21_20 = var22_21;
                        } while (true);
                    }
                    var12_11 = var13_12;
                    var14_13 = null;
                }
                // MONITOREXIT : var24_23
                if (!var12_11) {
                    continue;
                }
                break block23;
            }
            return null;
        }
        if (var14_13 == null) return null;
        if (var2_2 != null) return var14_13;
        this.addCount(-1L, -1);
        return var14_13;
    }

    @Override
    public int size() {
        long l2 = this.sumCount();
        if (l2 < 0L) {
            return 0;
        }
        if (l2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l2;
    }

    final long sumCount() {
        c[] arrc = this.counterCells;
        long l2 = this.baseCount;
        if (arrc != null) {
            for (int i2 = 0; i2 < arrc.length; ++i2) {
                c c2 = arrc[i2];
                if (c2 == null) continue;
                l2 += c2.value;
            }
        }
        return l2;
    }

    public String toString() {
        l[] arrl = this.table;
        int n2 = arrl == null ? 0 : arrl.length;
        p p2 = new p(arrl, n2, 0, n2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        l l2 = p2.a();
        if (l2 != null) {
            do {
                Object object = l2.b;
                Object object2 = l2.c;
                if (object == this) {
                    object = "(this Map)";
                }
                stringBuilder.append(object);
                stringBuilder.append('=');
                if (object2 == this) {
                    object2 = "(this Map)";
                }
                stringBuilder.append(object2);
                l2 = p2.a();
                if (l2 == null) break;
                stringBuilder.append(',');
                stringBuilder.append(' ');
            } while (true);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public java.util.Collection values() {
        u u2;
        u u3 = this.values;
        if (u3 != null) {
            return u3;
        }
        this.values = u2 = new /* Unavailable Anonymous Inner Class!! */;
        return u2;
    }

    static class a<K, V>
    extends p<K, V> {
        final ConcurrentHashMap i;
        l j;

        a(l[] arrl, int n2, int n3, int n4, ConcurrentHashMap concurrentHashMap) {
            super(arrl, n2, n3, n4);
            this.i = concurrentHashMap;
            this.a();
        }

        public final boolean hasMoreElements() {
            return this.b != null;
        }

        public final boolean hasNext() {
            return this.b != null;
        }

        public final void remove() {
            l l2 = this.j;
            if (l2 != null) {
                this.j = null;
                this.i.replaceNode(l2.b, null, null);
                return;
            }
            throw new IllegalStateException();
        }
    }

    static abstract class b<K, V, E>
    implements java.util.Collection<E>,
    Serializable,
    Collection {
        final ConcurrentHashMap a;

        b(ConcurrentHashMap concurrentHashMap) {
            this.a = concurrentHashMap;
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public abstract boolean contains(Object var1);

        @Override
        public final boolean containsAll(java.util.Collection collection) {
            if (collection != this) {
                for (Object object : collection) {
                    if (object != null && this.contains(object)) continue;
                    return false;
                }
            }
            return true;
        }

        @Override
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override
        public abstract java.util.Iterator iterator();

        @Override
        public /* synthetic */ j$.util.stream.Stream parallelStream() {
            return Collection$-CC.$default$parallelStream(this);
        }

        public /* synthetic */ Stream parallelStream() {
            return T0.k0(Collection$-CC.$default$parallelStream(this));
        }

        @Override
        public final boolean removeAll(java.util.Collection collection) {
            collection.getClass();
            java.util.Iterator iterator = this.iterator();
            boolean bl = false;
            while (iterator.hasNext()) {
                if (!collection.contains(iterator.next())) continue;
                iterator.remove();
                bl = true;
            }
            return bl;
        }

        @Override
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection$-CC.$default$removeIf(this, predicate);
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection$-CC.$default$removeIf(this, y0.a(predicate));
        }

        @Override
        public final boolean retainAll(java.util.Collection collection) {
            collection.getClass();
            java.util.Iterator iterator = this.iterator();
            boolean bl = false;
            while (iterator.hasNext()) {
                if (collection.contains(iterator.next())) continue;
                iterator.remove();
                bl = true;
            }
            return bl;
        }

        @Override
        public final int size() {
            return this.a.size();
        }

        @Override
        public /* synthetic */ j$.util.stream.Stream stream() {
            return Collection$-CC.$default$stream(this);
        }

        public /* synthetic */ Stream stream() {
            return T0.k0(Collection$-CC.$default$stream(this));
        }

        @Override
        public final Object[] toArray() {
            long l2 = this.a.mappingCount();
            if (l2 <= 0x7FFFFFF7L) {
                int n2 = (int)l2;
                Object[] arrobject = new Object[n2];
                int n3 = 0;
                java.util.Iterator iterator = this.iterator();
                while (iterator.hasNext()) {
                    Object object = iterator.next();
                    if (n3 == n2) {
                        int n4 = 2147483639;
                        if (n2 < n4) {
                            if (n2 < 1073741819) {
                                n4 = n2 + (1 + (n2 >>> 1));
                            }
                            arrobject = Arrays.copyOf((Object[])arrobject, (int)n4);
                            n2 = n4;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    int n5 = n3 + 1;
                    arrobject[n3] = object;
                    n3 = n5;
                }
                if (n3 == n2) {
                    return arrobject;
                }
                return Arrays.copyOf((Object[])arrobject, (int)n3);
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        @Override
        public Object[] toArray(y y2) {
            return this.toArray((Object[])y2.apply(0));
        }

        @Override
        public final Object[] toArray(Object[] arrobject) {
            long l2 = this.a.mappingCount();
            if (l2 <= 0x7FFFFFF7L) {
                int n2 = (int)l2;
                Object[] arrobject2 = arrobject.length >= n2 ? arrobject : (Object[])Array.newInstance((Class)arrobject.getClass().getComponentType(), (int)n2);
                int n3 = arrobject2.length;
                int n4 = 0;
                java.util.Iterator iterator = this.iterator();
                while (iterator.hasNext()) {
                    Object object = iterator.next();
                    if (n4 == n3) {
                        int n5 = 2147483639;
                        if (n3 < n5) {
                            if (n3 < 1073741819) {
                                n5 = n3 + (1 + (n3 >>> 1));
                            }
                            arrobject2 = Arrays.copyOf((Object[])arrobject2, (int)n5);
                            n3 = n5;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    int n6 = n4 + 1;
                    arrobject2[n4] = object;
                    n4 = n6;
                }
                if (arrobject == arrobject2 && n4 < n3) {
                    arrobject2[n4] = null;
                    return arrobject2;
                }
                if (n4 == n3) {
                    return arrobject2;
                }
                return Arrays.copyOf((Object[])arrobject2, (int)n4);
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            java.util.Iterator iterator = this.iterator();
            if (iterator.hasNext()) {
                do {
                    Object object;
                    if ((object = iterator.next()) == this) {
                        object = "(this Collection)";
                    }
                    stringBuilder.append(object);
                    if (!iterator.hasNext()) break;
                    stringBuilder.append(',');
                    stringBuilder.append(' ');
                } while (true);
            }
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    static final class c {
        volatile long value;

        c(long l2) {
            this.value = l2;
        }
    }

    static final class d<K, V>
    extends a<K, V>
    implements java.util.Iterator<Map.Entry<K, V>>,
    Iterator {
        d(l[] arrl, int n2, int n3, int n4, ConcurrentHashMap concurrentHashMap) {
            super(arrl, n2, n3, n4, concurrentHashMap);
        }

        @Override
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, x.b(consumer));
        }

        @Override
        public Object next() {
            l l2 = this.b;
            if (l2 != null) {
                Object object = l2.b;
                Object object2 = l2.c;
                this.j = l2;
                this.a();
                return new k(object, object2, this.i);
            }
            throw new NoSuchElementException();
        }
    }

    static final class f<K, V>
    extends p<K, V>
    implements Spliterator<Map.Entry<K, V>> {
        final ConcurrentHashMap i;
        long j;

        f(l[] arrl, int n2, int n3, int n4, long l2, ConcurrentHashMap concurrentHashMap) {
            super(arrl, n2, n3, n4);
            this.i = concurrentHashMap;
            this.j = l2;
        }

        @Override
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l l2 = this.a();
            if (l2 == null) {
                return false;
            }
            consumer.accept(new k(l2.b, l2.c, this.i));
            return true;
        }

        @Override
        public int characteristics() {
            return 4353;
        }

        @Override
        public long estimateSize() {
            return this.j;
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            l l2;
            consumer.getClass();
            while ((l2 = this.a()) != null) {
                consumer.accept(new k(l2.b, l2.c, this.i));
            }
        }

        @Override
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.e.g(this);
        }

        @Override
        public /* synthetic */ boolean hasCharacteristics(int n2) {
            return j$.time.e.h(this, n2);
        }

        @Override
        public Spliterator trySplit() {
            long l2;
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2 + n3 >>> 1;
            if (n4 <= n2) {
                return null;
            }
            l[] arrl = this.a;
            int n5 = this.h;
            this.g = n4;
            this.j = l2 = this.j >>> 1;
            f<K, V> f2 = new f<K, V>(arrl, n5, n4, n3, l2, this.i);
            return f2;
        }
    }

    static final class g<K, V>
    extends l<K, V> {
        final l[] e;

        g(l[] arrl) {
            super(-1, null, null, null);
            this.e = arrl;
        }

        @Override
        l a(int n2, Object object) {
            int n3;
            l[] arrl = this.e;
            block0 : while (arrl != null && (n3 = arrl.length) != 0) {
                l l2 = ConcurrentHashMap.tabAt(arrl, n2 & n3 - 1);
                if (l2 == null) {
                    return null;
                }
                do {
                    Object object2;
                    int n4;
                    if ((n4 = l2.a) == n2 && ((object2 = l2.b) == object || object2 != null && object.equals(object2))) {
                        return l2;
                    }
                    if (n4 >= 0) continue;
                    if (l2 instanceof g) {
                        arrl = ((g)l2).e;
                        continue block0;
                    }
                    return l2.a(n2, object);
                } while ((l2 = l2.d) != null);
            }
            return null;
        }
    }

    static final class h<K, V>
    extends a<K, V>
    implements java.util.Iterator<K>,
    Enumeration<K>,
    Iterator {
        h(l[] arrl, int n2, int n3, int n4, ConcurrentHashMap concurrentHashMap) {
            super(arrl, n2, n3, n4, concurrentHashMap);
        }

        @Override
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, x.b(consumer));
        }

        @Override
        public final Object next() {
            l l2 = this.b;
            if (l2 != null) {
                Object object = l2.b;
                this.j = l2;
                this.a();
                return object;
            }
            throw new NoSuchElementException();
        }

        public final Object nextElement() {
            return this.next();
        }
    }

    static final class j<K, V>
    extends p<K, V>
    implements Spliterator<K> {
        long i;

        j(l[] arrl, int n2, int n3, int n4, long l2) {
            super(arrl, n2, n3, n4);
            this.i = l2;
        }

        @Override
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l l2 = this.a();
            if (l2 == null) {
                return false;
            }
            consumer.accept(l2.b);
            return true;
        }

        @Override
        public int characteristics() {
            return 4353;
        }

        @Override
        public long estimateSize() {
            return this.i;
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            l l2;
            consumer.getClass();
            while ((l2 = this.a()) != null) {
                consumer.accept(l2.b);
            }
        }

        @Override
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.e.g(this);
        }

        @Override
        public /* synthetic */ boolean hasCharacteristics(int n2) {
            return j$.time.e.h(this, n2);
        }

        @Override
        public Spliterator trySplit() {
            long l2;
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2 + n3 >>> 1;
            if (n4 <= n2) {
                return null;
            }
            l[] arrl = this.a;
            int n5 = this.h;
            this.g = n4;
            this.i = l2 = this.i >>> 1;
            j<K, V> j2 = new j<K, V>(arrl, n5, n4, n3, l2);
            return j2;
        }
    }

    static final class k<K, V>
    implements Map.Entry<K, V>,
    Map$Entry {
        final Object a;
        Object b;
        final ConcurrentHashMap c;

        k(Object object, Object object2, ConcurrentHashMap concurrentHashMap) {
            this.a = object;
            this.b = object2;
            this.c = concurrentHashMap;
        }

        @Override
        public boolean equals(Object object) {
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            Map.Entry entry;
            return !(!(object instanceof Map.Entry) || (object5 = (entry = (Map.Entry)object).getKey()) == null || (object2 = entry.getValue()) == null || object5 != (object4 = this.a) && !object5.equals(object4) || object2 != (object3 = this.b) && !object2.equals(object3));
        }

        @Override
        public Object getKey() {
            return this.a;
        }

        @Override
        public Object getValue() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override
        public Object setValue(Object object) {
            object.getClass();
            Object object2 = this.b;
            this.b = object;
            this.c.put(this.a, object);
            return object2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("=");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    static class l<K, V>
    implements Map.Entry<K, V>,
    Map$Entry {
        final int a;
        final Object b;
        volatile Object c;
        volatile l d;

        l(int n2, Object object, Object object2, l l2) {
            this.a = n2;
            this.b = object;
            this.c = object2;
            this.d = l2;
        }

        l a(int n2, Object object) {
            l l2 = this;
            do {
                Object object2;
                if (l2.a != n2 || (object2 = l2.b) != object && (object2 == null || !object.equals(object2))) continue;
                return l2;
            } while ((l2 = l2.d) != null);
            return null;
        }

        @Override
        public final boolean equals(Object object) {
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            Map.Entry entry;
            return !(!(object instanceof Map.Entry) || (object5 = (entry = (Map.Entry)object).getKey()) == null || (object2 = entry.getValue()) == null || object5 != (object4 = this.b) && !object5.equals(object4) || object2 != (object3 = this.c) && !object2.equals(object3));
        }

        @Override
        public final Object getKey() {
            return this.b;
        }

        @Override
        public final Object getValue() {
            return this.c;
        }

        @Override
        public final int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override
        public final Object setValue(Object object) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("=");
            stringBuilder.append(this.c);
            return stringBuilder.toString();
        }
    }

    static final class m<K, V>
    extends l<K, V> {
        m() {
            super(-3, null, null, null);
        }

        @Override
        l a(int n2, Object object) {
            return null;
        }
    }

    static class n<K, V>
    extends ReentrantLock
    implements Serializable {
        n(float f2) {
        }
    }

    static final class o<K, V> {
        int a;
        int b;
        l[] c;
        o d;

        o() {
        }
    }

    static class p<K, V> {
        l[] a;
        l b;
        o c;
        o d;
        int e;
        int f;
        int g;
        final int h;

        p(l[] arrl, int n2, int n3, int n4) {
            this.a = arrl;
            this.h = n2;
            this.e = n3;
            this.f = n3;
            this.g = n4;
            this.b = null;
        }

        final l a() {
            r r2 = this.b;
            if (r2 != null) {
                r2 = r2.d;
            }
            do {
                int n2;
                l[] arrl;
                int n3;
                int n4;
                int n5;
                if (r2 != null) {
                    this.b = r2;
                    return r2;
                }
                if (this.f >= this.g || (arrl = this.a) == null || (n5 = arrl.length) <= (n3 = this.e) || n3 < 0) break;
                l l2 = ConcurrentHashMap.tabAt(arrl, n3);
                if (l2 != null && l2.a < 0) {
                    if (l2 instanceof g) {
                        this.a = ((g)l2).e;
                        o o2 = this.d;
                        if (o2 != null) {
                            this.d = o2.d;
                        } else {
                            o2 = new o();
                        }
                        o2.c = arrl;
                        o2.a = n5;
                        o2.b = n3;
                        o2.d = this.c;
                        this.c = o2;
                        r2 = null;
                        continue;
                    }
                    r2 = l2 instanceof q ? ((q)l2).h : null;
                } else {
                    r2 = l2;
                }
                if (this.c != null) {
                    o o3;
                    int n6;
                    int n7;
                    while ((o3 = this.c) != null) {
                        int n8;
                        int n9 = this.e;
                        int n10 = o3.a;
                        this.e = n8 = n9 + n10;
                        if (n8 < n5) break;
                        this.e = o3.b;
                        this.a = o3.c;
                        o3.c = null;
                        o o4 = o3.d;
                        o3.d = this.d;
                        this.c = o4;
                        this.d = o3;
                        n5 = n10;
                    }
                    if (o3 != null) continue;
                    this.e = n7 = this.e + this.h;
                    if (n7 < n5) continue;
                    this.f = n6 = 1 + this.f;
                    this.e = n6;
                    continue;
                }
                this.e = n4 = n3 + this.h;
                if (n4 < n5) continue;
                this.f = n2 = 1 + this.f;
                this.e = n2;
            } while (true);
            this.b = null;
            return null;
        }
    }

    static final class q<K, V>
    extends l<K, V> {
        private static final Unsafe e;
        private static final long f;
        r g;
        volatile r h;
        volatile Thread i;
        volatile int lockState;

        static {
            try {
                Unsafe unsafe;
                e = unsafe = j$.util.concurrent.b.c();
                f = unsafe.objectFieldOffset(q.class.getDeclaredField("lockState"));
                return;
            }
            catch (Exception exception) {
                throw new Error((Throwable)exception);
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        q(r var1_1) {
            super(-2, null, null, null);
            this.h = var1_1;
            var2_2 = null;
            block0 : do {
                if (var1_1 == null) {
                    this.g = var2_2;
                    return;
                }
                var3_3 = (r)var1_1.d;
                var1_1.g = null;
                var1_1.f = null;
                if (var2_2 != null) break;
                var1_1.e = null;
                var1_1.i = false;
lbl14: // 2 sources:
                do {
                    var2_2 = var1_1;
                    var1_1 = var3_3;
                    continue block0;
                    break;
                } while (true);
                break;
            } while (true);
            var4_4 = var1_1.b;
            var5_5 = var1_1.a;
            var6_6 = var2_2;
            var7_7 = null;
            do {
                var8_8 = var6_6.b;
                var9_9 = var6_6.a;
                var11_11 = var9_9 > var5_5 ? -1 : (var9_9 < var5_5 ? 1 : (var7_7 == null && (var7_7 = ConcurrentHashMap.comparableClassFor(var4_4)) == null || (var10_10 = ConcurrentHashMap.compareComparables(var7_7, var4_4, var8_8)) == 0 ? q.j(var4_4, var8_8) : var10_10));
                var12_12 = var11_11 <= 0 ? var6_6.f : var6_6.g;
                if (var12_12 == null) {
                    var1_1.e = var6_6;
                    if (var11_11 <= 0) {
                        var6_6.f = var1_1;
                    } else {
                        var6_6.g = var1_1;
                    }
                    var1_1 = q.c(var2_2, var1_1);
                    ** continue;
                }
                var6_6 = var12_12;
            } while (true);
        }

        /*
         * Enabled aggressive block sorting
         */
        static r b(r r2, r r3) {
            do {
                r r4;
                block32 : {
                    block33 : {
                        block34 : {
                            r r5;
                            void var6_14;
                            void var3_11;
                            block31 : {
                                void var3_8;
                                void var11_22;
                                if (r3 == null) {
                                    return r2;
                                }
                                if (r3 == r2) {
                                    return r2;
                                }
                                r4 = r3.e;
                                if (r4 == null) {
                                    r3.i = false;
                                    return r3;
                                }
                                if (r3.i) {
                                    r3.i = false;
                                    return r2;
                                }
                                r5 = r4.f;
                                if (r5 != r3) break block31;
                                r r6 = r4.g;
                                if (r6 != null && r6.i) {
                                    r6.i = false;
                                    r4.i = true;
                                    r2 = q.h(r2, r4);
                                    r4 = r3.e;
                                    if (r4 == null) {
                                        Object var3_6 = null;
                                    } else {
                                        r r7 = r4.g;
                                    }
                                }
                                if (var3_8 == null) break block32;
                                r r9 = var3_8.f;
                                r r10 = var3_8.g;
                                if ((r10 == null || !r10.i) && (r9 == null || !r9.i)) break block33;
                                if (r10 != null && r10.i) {
                                    void var11_23 = var3_8;
                                } else {
                                    if (r9 != null) {
                                        r9.i = false;
                                    }
                                    var3_8.i = true;
                                    r2 = q.i(r2, (r)var3_8);
                                    r4 = r3.e;
                                    if (r4 == null) {
                                        Object var11_24 = null;
                                    } else {
                                        r r11 = r4.g;
                                    }
                                }
                                if (var11_22 != null) {
                                    boolean bl = r4 == null ? false : r4.i;
                                    var11_22.i = bl;
                                    r r12 = var11_22.g;
                                    if (r12 != null) {
                                        r12.i = false;
                                    }
                                }
                                if (r4 != null) {
                                    r4.i = false;
                                    r2 = q.h(r2, r4);
                                }
                                break block34;
                            }
                            if (r5 != null && r5.i) {
                                r5.i = false;
                                r4.i = true;
                                r2 = q.i(r2, r4);
                                r4 = r3.e;
                                if (r4 == null) {
                                    Object var3_9 = null;
                                } else {
                                    r r13 = r4.f;
                                }
                            }
                            if (var3_11 == null) break block32;
                            r r14 = var3_11.f;
                            r r15 = var3_11.g;
                            if ((r14 == null || !r14.i) && (r15 == null || !r15.i)) break block33;
                            if (r14 != null && r14.i) {
                                void var6_15 = var3_11;
                            } else {
                                if (r15 != null) {
                                    r15.i = false;
                                }
                                var3_11.i = true;
                                r2 = q.h(r2, (r)var3_11);
                                r4 = r3.e;
                                if (r4 == null) {
                                    Object var6_16 = null;
                                } else {
                                    r r16 = r4.f;
                                }
                            }
                            if (var6_14 != null) {
                                boolean bl = r4 == null ? false : r4.i;
                                var6_14.i = bl;
                                r r17 = var6_14.f;
                                if (r17 != null) {
                                    r17.i = false;
                                }
                            }
                            if (r4 != null) {
                                r4.i = false;
                                r2 = q.i(r2, r4);
                            }
                        }
                        r2 = r3 = r2;
                        continue;
                    }
                    var3_3.i = true;
                }
                r3 = r4;
            } while (true);
        }

        static r c(r r2, r r3) {
            r3.i = true;
            do {
                r r4;
                r r5;
                block12 : {
                    block11 : {
                        r r6;
                        block10 : {
                            if ((r4 = r3.e) == null) {
                                r3.i = false;
                                return r3;
                            }
                            if (!r4.i) break;
                            r5 = r4.e;
                            if (r5 == null) {
                                return r2;
                            }
                            r6 = r5.f;
                            if (r4 != r6) break block10;
                            r6 = r5.g;
                            if (r6 == null || !r6.i) {
                                if (r3 == r4.g) {
                                    r2 = q.h(r2, r4);
                                    r r7 = r4.e;
                                    r5 = r7 == null ? null : r7.e;
                                    r r9 = r4;
                                    r4 = r7;
                                    r3 = r9;
                                }
                                if (r4 == null) continue;
                                r4.i = false;
                                if (r5 == null) continue;
                                r5.i = true;
                                r2 = q.i(r2, r5);
                                continue;
                            }
                            break block11;
                        }
                        if (r6 == null || !r6.i) break block12;
                    }
                    r6.i = false;
                    r4.i = false;
                    r5.i = true;
                    r3 = r5;
                    continue;
                }
                if (r3 == r4.f) {
                    r2 = q.i(r2, r4);
                    r r10 = r4.e;
                    r5 = r10 == null ? null : r10.e;
                    r r11 = r4;
                    r4 = r10;
                    r3 = r11;
                }
                if (r4 == null) continue;
                r4.i = false;
                if (r5 == null) continue;
                r5.i = true;
                r2 = q.h(r2, r5);
            } while (true);
            return r2;
        }

        private final void d() {
            boolean bl = false;
            do {
                int n2;
                if (((n2 = this.lockState) & -3) == 0) {
                    if (!e.compareAndSwapInt((Object)this, f, n2, 1)) continue;
                    if (bl) {
                        this.i = null;
                    }
                    return;
                }
                if ((n2 & 2) == 0) {
                    if (!e.compareAndSwapInt((Object)this, f, n2, n2 | 2)) continue;
                    bl = true;
                    this.i = Thread.currentThread();
                    continue;
                }
                if (!bl) continue;
                LockSupport.park((Object)this);
            } while (true);
        }

        private final void e() {
            if (!e.compareAndSwapInt((Object)this, f, 0, 1)) {
                this.d();
            }
        }

        static r h(r r2, r r3) {
            r r4 = r3.g;
            if (r4 != null) {
                r r5;
                r r6;
                r3.g = r6 = r4.f;
                if (r6 != null) {
                    r6.e = r3;
                }
                r4.e = r5 = r3.e;
                if (r5 == null) {
                    r4.i = false;
                    r2 = r4;
                } else if (r5.f == r3) {
                    r5.f = r4;
                } else {
                    r5.g = r4;
                }
                r4.f = r3;
                r3.e = r4;
            }
            return r2;
        }

        static r i(r r2, r r3) {
            r r4 = r3.f;
            if (r4 != null) {
                r r5;
                r r6;
                r3.f = r6 = r4.g;
                if (r6 != null) {
                    r6.e = r3;
                }
                r4.e = r5 = r3.e;
                if (r5 == null) {
                    r4.i = false;
                    r2 = r4;
                } else if (r5.g == r3) {
                    r5.g = r4;
                } else {
                    r5.f = r4;
                }
                r4.g = r3;
                r3.e = r4;
            }
            return r2;
        }

        static int j(Object object, Object object2) {
            int n2;
            if (object == null || object2 == null || (n2 = object.getClass().getName().compareTo(object2.getClass().getName())) == 0) {
                if (System.identityHashCode((Object)object) <= System.identityHashCode((Object)object2)) {
                    return -1;
                }
                n2 = 1;
            }
            return n2;
        }

        @Override
        final l a(int n2, Object object) {
            l l2 = this.h;
            while (l2 != null) {
                Unsafe unsafe;
                r r2;
                long l3;
                r r3;
                block8 : {
                    int n3 = this.lockState;
                    if ((n3 & 3) != 0) {
                        Object object2;
                        if (l2.a == n2 && ((object2 = l2.b) == object || object2 != null && object.equals(object2))) {
                            return l2;
                        }
                        l2 = l2.d;
                        continue;
                    }
                    unsafe = e;
                    l3 = f;
                    if (!unsafe.compareAndSwapInt((Object)this, l3, n3, n3 + 4)) continue;
                    r3 = this.g;
                    if (r3 != null) break block8;
                    r2 = null;
                }
                r2 = r3.b(n2, object, null);
                return r2;
                finally {
                    Thread thread;
                    if (j$.util.concurrent.b.a(unsafe, this, l3, -4) == 6 && (thread = this.i) != null) {
                        LockSupport.unpark((Thread)thread);
                    }
                }
            }
            return null;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        final r f(int var1_1, Object var2_2, Object var3_3) {
            var4_4 = this.g;
            var5_5 = null;
            var6_6 = false;
            do {
                block18 : {
                    if (var4_4 == null) {
                        this.g = var7_16 = new r<K, V>(var1_1, var2_2, var3_3, null, null);
                        this.h = var7_16;
                        return null;
                    }
                    var8_7 = var4_4.a;
                    if (var8_7 <= var1_1) break block18;
                    var16_12 = -1;
                    ** GOTO lbl31
                }
                if (var8_7 < var1_1) {
                    var11_10 = 1;
                } else {
                    var9_8 = var4_4.b;
                    if (var9_8 == var2_2) return var4_4;
                    if (var9_8 != null && var2_2.equals(var9_8)) {
                        return var4_4;
                    }
                    if (var5_5 == null && (var5_5 = ConcurrentHashMap.comparableClassFor(var2_2)) == null || (var10_9 = ConcurrentHashMap.compareComparables(var5_5, var2_2, var9_8)) == 0) {
                        if (!var6_6) {
                            var17_13 = var4_4.f;
                            if (var17_13 != null) {
                                var19_15 = var17_13.b(var1_1, var2_2, var5_5);
                                if (var19_15 != null) return var19_15;
                            }
                            if ((var18_14 = var4_4.g) != null && (var19_15 = var18_14.b(var1_1, var2_2, var5_5)) != null) {
                                return var19_15;
                            }
                            var6_6 = true;
                        }
                        var16_12 = q.j(var2_2, var9_8);
lbl31: // 2 sources:
                        var11_10 = var16_12;
                    } else {
                        var11_10 = var10_9;
                    }
                }
                var12_11 = var11_10 <= 0 ? var4_4.f : var4_4.g;
                if (var12_11 == null) {
                    var13_17 = this.h;
                    this.h = var14_18 = new r<K, V>(var1_1, var2_2, var3_3, var13_17, var4_4);
                    if (var13_17 != null) {
                        var13_17.h = var14_18;
                    }
                    if (var11_10 <= 0) {
                        var4_4.f = var14_18;
                    } else {
                        var4_4.g = var14_18;
                    }
                    if (!var4_4.i) {
                        var14_18.i = true;
                        return null;
                    }
                    this.e();
                    try {
                        this.g = q.c(this.g, var14_18);
                        return null;
                    }
                    finally {
                        this.lockState = 0;
                    }
                }
                var4_4 = var12_11;
            } while (true);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        final boolean g(r var1_1) {
            block34 : {
                var2_2 = (r)var1_1.d;
                var3_3 = var1_1.h;
                if (var3_3 == null) {
                    this.h = var2_2;
                } else {
                    var3_3.d = var2_2;
                }
                if (var2_2 != null) {
                    var2_2.h = var3_3;
                }
                if (this.h == null) {
                    this.g = null;
                    return true;
                }
                var4_4 = this.g;
                if (var4_4 == null) return true;
                if (var4_4.g == null) return true;
                var5_5 = var4_4.f;
                if (var5_5 == null) return true;
                if (var5_5.f == null) {
                    return true;
                }
                this.e();
                var7_6 = var1_1.f;
                var8_7 = var1_1.g;
                if (var7_6 != null && var8_7 != null) {
                    var11_8 = var8_7;
                    while ((var12_9 = var11_8.f) != null) {
                        var11_8 = var12_9;
                    }
                    var13_10 = var11_8.i;
                    var11_8.i = var1_1.i;
                    var1_1.i = var13_10;
                    var14_11 = var11_8.g;
                    var15_12 = var1_1.e;
                    if (var11_8 == var8_7) {
                        var1_1.e = var11_8;
                        var11_8.g = var1_1;
                    } else {
                        var1_1.e = var16_13 = var11_8.e;
                        if (var16_13 != null) {
                            if (var11_8 == var16_13.f) {
                                var16_13.f = var1_1;
                            } else {
                                var16_13.g = var1_1;
                            }
                        }
                        var11_8.g = var8_7;
                        var8_7.e = var11_8;
                    }
                    var1_1.f = null;
                    var1_1.g = var14_11;
                    if (var14_11 != null) {
                        var14_11.e = var1_1;
                    }
                    var11_8.f = var7_6;
                    var7_6.e = var11_8;
                    var11_8.e = var15_12;
                    if (var15_12 == null) {
                        var4_4 = var11_8;
                    } else if (var1_1 == var15_12.f) {
                        var15_12.f = var11_8;
                    } else {
                        var15_12.g = var11_8;
                    }
                    if (var14_11 != null) {
                        var7_6 = var14_11;
                        break block34;
                    }
                } else {
                    if (var7_6 != null) break block34;
                    if (var8_7 != null) {
                        var7_6 = var8_7;
                        break block34;
                    }
                }
                var7_6 = var1_1;
            }
            if (var7_6 == var1_1) ** GOTO lbl84
            var7_6.e = var9_14 = var1_1.e;
            if (var9_14 == null) {
                var4_4 = var7_6;
            } else if (var1_1 == var9_14.f) {
                var9_14.f = var7_6;
            } else {
                var9_14.g = var7_6;
            }
            var1_1.e = null;
            var1_1.g = null;
            var1_1.f = null;
lbl84: // 2 sources:
            if (!var1_1.i) {
                var4_4 = q.b(var4_4, var7_6);
            }
            this.g = var4_4;
            if (var1_1 != var7_6) return false;
            try {
                var10_15 = var1_1.e;
                if (var10_15 == null) return false;
                if (var1_1 == var10_15.f) {
                    var10_15.f = null;
                } else if (var1_1 == var10_15.g) {
                    var10_15.g = null;
                }
                var1_1.e = null;
                return false;
            }
            finally {
                this.lockState = 0;
            }
        }
    }

    static final class r<K, V>
    extends l<K, V> {
        r e;
        r f;
        r g;
        r h;
        boolean i;

        r(int n2, Object object, Object object2, l l2, r r2) {
            super(n2, object, object2, l2);
            this.e = r2;
        }

        @Override
        l a(int n2, Object object) {
            return this.b(n2, object, null);
        }

        /*
         * Enabled aggressive block sorting
         */
        final r b(int n2, Object object, Class class_) {
            if (object == null) return null;
            r r2 = this;
            do {
                r r3;
                block5 : {
                    r r4;
                    block7 : {
                        block6 : {
                            int n3;
                            r3 = r2.f;
                            r4 = r2.g;
                            int n4 = r2.a;
                            if (n4 > n2) break block5;
                            if (n4 < n2) break block6;
                            Object object2 = r2.b;
                            if (object2 == object) return r2;
                            if (object2 != null && object.equals(object2)) {
                                return r2;
                            }
                            if (r3 == null) break block6;
                            if (r4 == null) break block5;
                            if (class_ == null && (class_ = ConcurrentHashMap.comparableClassFor(object)) == null || (n3 = ConcurrentHashMap.compareComparables(class_, object, object2)) == 0) break block7;
                            if (n3 < 0) break block5;
                        }
                        r2 = r4;
                        continue;
                    }
                    r r5 = r4.b(n2, object, class_);
                    if (r5 != null) {
                        return r5;
                    }
                }
                r2 = r3;
            } while (r2 != null);
            return null;
        }
    }

    static final class s<K, V>
    extends a<K, V>
    implements java.util.Iterator<V>,
    Enumeration<V>,
    Iterator {
        s(l[] arrl, int n2, int n3, int n4, ConcurrentHashMap concurrentHashMap) {
            super(arrl, n2, n3, n4, concurrentHashMap);
        }

        @Override
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, x.b(consumer));
        }

        @Override
        public final Object next() {
            l l2 = this.b;
            if (l2 != null) {
                Object object = l2.c;
                this.j = l2;
                this.a();
                return object;
            }
            throw new NoSuchElementException();
        }

        public final Object nextElement() {
            return this.next();
        }
    }

    static final class t<K, V>
    extends p<K, V>
    implements Spliterator<V> {
        long i;

        t(l[] arrl, int n2, int n3, int n4, long l2) {
            super(arrl, n2, n3, n4);
            this.i = l2;
        }

        @Override
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l l2 = this.a();
            if (l2 == null) {
                return false;
            }
            consumer.accept(l2.c);
            return true;
        }

        @Override
        public int characteristics() {
            return 4352;
        }

        @Override
        public long estimateSize() {
            return this.i;
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            l l2;
            consumer.getClass();
            while ((l2 = this.a()) != null) {
                consumer.accept(l2.c);
            }
        }

        @Override
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.e.g(this);
        }

        @Override
        public /* synthetic */ boolean hasCharacteristics(int n2) {
            return j$.time.e.h(this, n2);
        }

        @Override
        public Spliterator trySplit() {
            long l2;
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2 + n3 >>> 1;
            if (n4 <= n2) {
                return null;
            }
            l[] arrl = this.a;
            int n5 = this.h;
            this.g = n4;
            this.i = l2 = this.i >>> 1;
            t<K, V> t2 = new t<K, V>(arrl, n5, n4, n3, l2);
            return t2;
        }
    }

}

