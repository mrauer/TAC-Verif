/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.keyword.syntax.SyntaxProcessor
 *  com.github.fge.jsonschema.core.load.RefResolver
 *  com.github.fge.jsonschema.core.report.ListProcessingReport
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.base.Equivalence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.jsonschema.processors.validation;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.keyword.syntax.SyntaxProcessor;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.core.load.RefResolver;
import com.github.fge.jsonschema.core.processing.CachingProcessor;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.processing.ProcessorChain;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.core.util.ValueHolder;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.processors.build.ValidatorBuilder;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.ValidatorList;
import com.github.fge.jsonschema.processors.digest.SchemaDigester;
import com.github.fge.jsonschema.processors.format.FormatProcessor;
import com.github.fge.jsonschema.processors.validation.SchemaContextEquivalence;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;

public final class ValidationChain
implements Processor<SchemaContext, ValidatorList> {
    private final Processor<SchemaContext, ValidatorList> builder;
    private final Processor<ValueHolder<SchemaTree>, ValueHolder<SchemaTree>> resolver;

    public ValidationChain(RefResolver refResolver, Library library, ValidationConfiguration validationConfiguration) {
        SyntaxProcessor syntaxProcessor = new SyntaxProcessor(validationConfiguration.getSyntaxMessages(), library.getSyntaxCheckers());
        this.resolver = new CachingProcessor(ProcessorChain.startWith(refResolver).chainWith(syntaxProcessor).getProcessor(), SchemaHolderEquivalence.INSTANCE, validationConfiguration.getCacheSize());
        SchemaDigester schemaDigester = new SchemaDigester(library);
        ValidatorBuilder validatorBuilder = new ValidatorBuilder(library);
        ProcessorChain<SchemaContext, ValidatorList> processorChain = ProcessorChain.startWith(schemaDigester).chainWith(validatorBuilder);
        if (validationConfiguration.getUseFormat()) {
            processorChain = processorChain.chainWith(new FormatProcessor(library, validationConfiguration));
        }
        this.builder = new CachingProcessor<SchemaContext, ValidatorList>(processorChain.getProcessor(), SchemaContextEquivalence.getInstance(), validationConfiguration.getCacheSize());
    }

    @Override
    public ValidatorList process(ProcessingReport processingReport, SchemaContext schemaContext) throws ProcessingException {
        ValueHolder<SchemaTree> valueHolder = ValueHolder.hold("schema", schemaContext.getSchema());
        ListProcessingReport listProcessingReport = new ListProcessingReport(processingReport);
        ValueHolder<SchemaTree> valueHolder2 = this.resolver.process((ProcessingReport)listProcessingReport, valueHolder);
        processingReport.mergeWith((ProcessingReport)listProcessingReport);
        if (!listProcessingReport.isSuccess()) {
            return null;
        }
        SchemaContext schemaContext2 = new SchemaContext(valueHolder2.getValue(), schemaContext.getInstanceType());
        return this.builder.process(processingReport, schemaContext2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.resolver);
        stringBuilder.append(" -> ");
        stringBuilder.append(this.builder);
        return stringBuilder.toString();
    }

    public static final class SchemaHolderEquivalence
    extends Equivalence<ValueHolder<SchemaTree>> {
        private static final Equivalence<ValueHolder<SchemaTree>> INSTANCE = new SchemaHolderEquivalence();

        private SchemaHolderEquivalence() {
        }

        public boolean doEquivalent(ValueHolder<SchemaTree> valueHolder, ValueHolder<SchemaTree> valueHolder2) {
            return valueHolder.getValue().equals((Object)valueHolder2.getValue());
        }

        public int doHash(ValueHolder<SchemaTree> valueHolder) {
            return valueHolder.getValue().hashCode();
        }
    }

}

