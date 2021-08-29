/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.ImmutableList
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.core.keyword.syntax.checkers.hyperschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.AbstractSyntaxChecker;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class LinksSyntaxChecker
extends AbstractSyntaxChecker {
    private static final SyntaxChecker INSTANCE;
    private static final ImmutableList<String> REQUIRED_LDO_PROPERTIES;

    public static {
        REQUIRED_LDO_PROPERTIES = ImmutableList.of((Object)"href", (Object)"rel");
        INSTANCE = new LinksSyntaxChecker();
    }

    private LinksSyntaxChecker() {
        super("links", NodeType.ARRAY, new NodeType[0]);
    }

    private ProcessingMessage LDOMsg(SchemaTree schemaTree, MessageBundle messageBundle, String string, int n2) {
        return this.newMsg(schemaTree, messageBundle, string).put("index", n2);
    }

    /*
     * Exception decompiling
     */
    private void checkLDO(ProcessingReport var1, MessageBundle var2, SchemaTree var3, int var4) throws ProcessingException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl178 : RETURN : trying to set 0 previously set to 1
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

    private boolean checkLDOProperty(ProcessingReport processingReport, MessageBundle messageBundle, SchemaTree schemaTree, int n2, String string, NodeType nodeType, String string2) throws ProcessingException {
        JsonNode jsonNode = this.getNode(schemaTree).get(n2).get(string);
        if (jsonNode == null) {
            return false;
        }
        NodeType nodeType2 = NodeType.getNodeType(jsonNode);
        if (nodeType2 == nodeType) {
            return true;
        }
        processingReport.error(this.LDOMsg(schemaTree, messageBundle, string2, n2).put("expected", nodeType).putArgument("found", nodeType2));
        return false;
    }

    public static SyntaxChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void checkValue(Collection<JsonPointer> collection, MessageBundle messageBundle, ProcessingReport processingReport, SchemaTree schemaTree) throws ProcessingException {
        int n2 = this.getNode(schemaTree).size();
        for (int i2 = 0; i2 < n2; ++i2) {
            NodeType nodeType;
            JsonNode jsonNode = this.getNode(schemaTree).get(i2);
            NodeType nodeType2 = NodeType.getNodeType(jsonNode);
            if (nodeType2 != (nodeType = NodeType.OBJECT)) {
                processingReport.error(this.LDOMsg(schemaTree, messageBundle, "draftv4.ldo.incorrectType", i2).put("expected", nodeType).putArgument("found", nodeType2));
                continue;
            }
            HashSet hashSet = Collections2.newHashSet((Iterator)jsonNode.fieldNames());
            ImmutableList<String> immutableList = REQUIRED_LDO_PROPERTIES;
            ArrayList arrayList = Collections2.newArrayList(immutableList);
            arrayList.removeAll((Collection)hashSet);
            if (!arrayList.isEmpty()) {
                processingReport.error(this.LDOMsg(schemaTree, messageBundle, "draftv4.ldo.missingRequired", i2).put("required", immutableList).putArgument("missing", arrayList));
                continue;
            }
            if (jsonNode.has("schema")) {
                String string = this.keyword;
                Object[] arrobject = new Object[]{i2, "schema"};
                collection.add((Object)JsonPointer.of(string, arrobject));
            }
            if (jsonNode.has("targetSchema")) {
                String string = this.keyword;
                Object[] arrobject = new Object[]{i2, "targetSchema"};
                collection.add((Object)JsonPointer.of(string, arrobject));
            }
            this.checkLDO(processingReport, messageBundle, schemaTree, i2);
        }
    }
}

