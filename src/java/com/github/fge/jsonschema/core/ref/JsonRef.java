/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.github.fge.jsonschema.core.exceptions.JsonReferenceException
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.ref.EmptyJsonRef
 *  com.github.fge.jsonschema.core.ref.HierarchicalJsonRef
 *  com.github.fge.jsonschema.core.ref.JarJsonRef
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URISyntaxException
 */
package com.github.fge.jsonschema.core.ref;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.ref.EmptyJsonRef;
import com.github.fge.jsonschema.core.ref.HierarchicalJsonRef;
import com.github.fge.jsonschema.core.ref.JarJsonRef;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class JsonRef {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final URI EMPTY_URI = URI.create((String)"");
    public static final URI HASHONLY_URI = URI.create((String)"#");
    private final String asString;
    private final int hashCode;
    public final boolean legal;
    public final URI locator;
    public final JsonPointer pointer;
    public final URI uri;

    /*
     * Exception decompiling
     */
    public JsonRef(URI var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static JsonRef emptyRef() {
        return EmptyJsonRef.getInstance();
    }

    public static JsonRef fromString(String string) throws JsonReferenceException {
        BUNDLE.checkNotNull((Object)string, "jsonRef.nullInput");
        try {
            JsonRef jsonRef = JsonRef.fromURI(new URI(string));
            return jsonRef;
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new JsonReferenceException(new ProcessingMessage().setMessage(BUNDLE.getMessage("jsonRef.invalidURI")).putArgument("input", (Object)string), (Throwable)uRISyntaxException);
        }
    }

    public static JsonRef fromURI(URI uRI) {
        BUNDLE.checkNotNull((Object)uRI, "jsonRef.nullURI");
        URI uRI2 = URIUtils.normalizeURI(uRI);
        if (!HASHONLY_URI.equals((Object)uRI2) && !EMPTY_URI.equals((Object)uRI2)) {
            if ("jar".equals((Object)uRI2.getScheme())) {
                return new JarJsonRef(uRI2);
            }
            return new HierarchicalJsonRef(uRI2);
        }
        return EmptyJsonRef.getInstance();
    }

    public final boolean contains(JsonRef jsonRef) {
        return this.locator.equals((Object)jsonRef.locator);
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof JsonRef)) {
            return false;
        }
        JsonRef jsonRef = (JsonRef)object;
        return this.asString.equals((Object)jsonRef.asString);
    }

    public final URI getLocator() {
        return this.locator;
    }

    public final JsonPointer getPointer() {
        return this.pointer;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public abstract boolean isAbsolute();

    public final boolean isLegal() {
        return this.legal;
    }

    public abstract JsonRef resolve(JsonRef var1);

    public final String toString() {
        return this.asString;
    }

    public final URI toURI() {
        return this.uri;
    }
}

