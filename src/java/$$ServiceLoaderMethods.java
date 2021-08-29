/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.ServiceConfigurationError
 *  kotlinx.coroutines.CoroutineExceptionHandler
 *  kotlinx.coroutines.android.AndroidDispatcherFactory
 *  kotlinx.coroutines.android.AndroidExceptionPreHandler
 *  kotlinx.coroutines.internal.MainDispatcherFactory
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class $$ServiceLoaderMethods {
    public static Iterator $load$50514() {
        try {
            Object[] arrobject = new CoroutineExceptionHandler[]{new AndroidExceptionPreHandler()};
            Iterator iterator = Arrays.asList((Object[])arrobject).iterator();
            return iterator;
        }
        catch (Throwable throwable) {
            throw new ServiceConfigurationError(throwable.getMessage(), throwable);
        }
    }

    public static Iterator $load$50517() {
        try {
            Object[] arrobject = new MainDispatcherFactory[]{new AndroidDispatcherFactory()};
            Iterator iterator = Arrays.asList((Object[])arrobject).iterator();
            return iterator;
        }
        catch (Throwable throwable) {
            throw new ServiceConfigurationError(throwable.getMessage(), throwable);
        }
    }
}

