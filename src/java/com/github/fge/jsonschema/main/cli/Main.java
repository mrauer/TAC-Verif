/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration
 *  com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder
 *  com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration
 *  com.github.fge.jsonschema.core.load.uri.URITranslatorConfigurationBuilder
 *  com.github.fge.jsonschema.main.JsonSchemaFactory
 *  com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder
 *  com.github.fge.jsonschema.main.cli.CustomHelpFormatter
 *  com.github.fge.jsonschema.main.cli.Reporters
 *  com.google.common.base.Joiner
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  joptsimple.AbstractOptionSpec
 *  joptsimple.HelpFormatter
 *  joptsimple.MultipleArgumentsForOptionException
 *  joptsimple.OptionException
 *  joptsimple.OptionParser
 *  joptsimple.OptionSet
 *  joptsimple.OptionSpec
 *  joptsimple.OptionSpecBuilder
 *  joptsimple.RequiredArgumentOptionSpec
 *  joptsimple.internal.OptionNameMap
 */
package com.github.fge.jsonschema.main.cli;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfigurationBuilder;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration;
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfigurationBuilder;
import com.github.fge.jsonschema.core.util.URIUtils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonSchemaFactoryBuilder;
import com.github.fge.jsonschema.main.cli.CustomHelpFormatter;
import com.github.fge.jsonschema.main.cli.Reporter;
import com.github.fge.jsonschema.main.cli.Reporters;
import com.github.fge.jsonschema.main.cli.RetCode;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;
import com.google.common.base.Joiner;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import joptsimple.AbstractOptionSpec;
import joptsimple.HelpFormatter;
import joptsimple.MultipleArgumentsForOptionException;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.OptionSpecBuilder;
import joptsimple.RequiredArgumentOptionSpec;
import joptsimple.internal.OptionNameMap;

public final class Main {
    private static final HelpFormatter HELP = new CustomHelpFormatter();
    private static final ObjectMapper MAPPER = JacksonUtils.newMapper();
    private final JsonSchemaFactory factory;
    private final SyntaxValidator syntaxValidator;

    public Main(String string) throws IOException {
        JsonSchemaFactory jsonSchemaFactory;
        URITranslatorConfigurationBuilder uRITranslatorConfigurationBuilder = URITranslatorConfiguration.newBuilder().setNamespace(Main.getCwd());
        if (string != null) {
            uRITranslatorConfigurationBuilder.addPathRedirect(string, Main.getCwd());
        }
        LoadingConfiguration loadingConfiguration = LoadingConfiguration.newBuilder().setURITranslatorConfiguration(uRITranslatorConfigurationBuilder.freeze()).freeze();
        this.factory = jsonSchemaFactory = JsonSchemaFactory.newBuilder().setLoadingConfiguration(loadingConfiguration).freeze();
        this.syntaxValidator = jsonSchemaFactory.getSyntaxValidator();
    }

    private RetCode doSyntax(Reporter reporter, List<File> list) throws IOException {
        RetCode retCode = RetCode.ALL_OK;
        for (File file : list) {
            JsonNode jsonNode;
            String string = file.toString();
            RetCode retCode2 = reporter.validateSchema(this.syntaxValidator, string, jsonNode = MAPPER.readTree(file));
            if (retCode2 == RetCode.ALL_OK) continue;
            retCode = retCode2;
        }
        return retCode;
    }

    private RetCode doValidation(Reporter reporter, List<File> list) throws IOException, ProcessingException {
        File file = (File)list.remove(0);
        String string = file.toURI().normalize().toString();
        JsonNode jsonNode = MAPPER.readTree(file);
        if (!this.syntaxValidator.schemaIsValid(jsonNode)) {
            System.err.println("Schema is invalid! Aborting...");
            return RetCode.SCHEMA_SYNTAX_ERROR;
        }
        JsonSchema jsonSchema = this.factory.getJsonSchema(string);
        RetCode retCode = RetCode.ALL_OK;
        for (File file2 : list) {
            JsonNode jsonNode2 = MAPPER.readTree(file2);
            RetCode retCode2 = reporter.validateInstance(jsonSchema, file2.toString(), jsonNode2);
            if (retCode2 == RetCode.ALL_OK) continue;
            retCode = retCode2;
        }
        return retCode;
    }

    private static String getCwd() throws IOException {
        return URIUtils.normalizeURI(new File(System.getProperty((String)"user.dir", (String)".")).getCanonicalFile().toURI()).toString();
    }

    public static /* varargs */ void main(String ... arrstring) throws IOException, ProcessingException {
        boolean bl;
        int n3;
        OptionSet optionSet;
        OptionParser optionParser = new OptionParser();
        OptionSpecBuilder optionSpecBuilder = optionParser.accepts("help", "show this help");
        optionSpecBuilder.forHelp = n3 = 1;
        optionParser.acceptsAll(Arrays.asList((Object[])new String[]{"s", "brief"}), "only show validation status (OK/NOT OK)");
        optionParser.acceptsAll(Arrays.asList((Object[])new String[]{"q", "quiet"}), "no output; exit with the relevant return code (see below)");
        optionParser.accepts("syntax", "check the syntax of schema(s) given as argument(s)");
        OptionSpecBuilder optionSpecBuilder2 = optionParser.accepts("fakeroot", "pretend that the current directory is absolute URI \"uri\"");
        RequiredArgumentOptionSpec requiredArgumentOptionSpec = new RequiredArgumentOptionSpec(optionSpecBuilder2.options(), optionSpecBuilder2.description);
        OptionParser optionParser2 = optionSpecBuilder2.parser;
        optionParser2.recognizedOptions.putAll((Iterable)requiredArgumentOptionSpec.options(), (Object)requiredArgumentOptionSpec);
        optionParser2.trainingOrder.add((Object)requiredArgumentOptionSpec);
        HelpFormatter helpFormatter = HELP;
        Objects.requireNonNull((Object)helpFormatter);
        optionParser.helpFormatter = helpFormatter;
        Reporters reporters = Reporters.DEFAULT;
        try {
            optionSet = optionParser.parse(arrstring);
        }
        catch (OptionException optionException) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unrecognized option(s): ");
            stringBuilder.append(CustomHelpFormatter.OPTIONS_JOINER.join((Iterable)Collections.unmodifiableList((List)optionException.options)));
            printStream.println(stringBuilder.toString());
            optionParser.printHelpOn((OutputStream)System.err);
            System.exit((int)RetCode.CMD_ERROR.get());
            throw new IllegalStateException("WTF??");
        }
        if (optionSet.detectedOptions.containsKey((Object)"help")) {
            optionParser.printHelpOn((OutputStream)System.out);
            System.exit((int)RetCode.ALL_OK.get());
        }
        if (optionSet.detectedOptions.containsKey((Object)"s") && optionSet.detectedOptions.containsKey((Object)"q")) {
            System.err.println("cannot specify both \"--brief\" and \"--quiet\"");
            optionParser.printHelpOn((OutputStream)System.err);
            System.exit((int)RetCode.CMD_ERROR.get());
        }
        boolean bl2 = optionSet.detectedOptions.containsKey((Object)"fakeroot");
        String string = null;
        if (bl2) {
            Object object;
            AbstractOptionSpec abstractOptionSpec = (AbstractOptionSpec)optionSet.detectedOptions.get((Object)"fakeroot");
            if (abstractOptionSpec == null) {
                List list = optionSet.defaultValuesFor("fakeroot");
                object = list.isEmpty() ? null : list.get(0);
            } else {
                List list = optionSet.valuesOf((OptionSpec)abstractOptionSpec);
                int n4 = list.size();
                object = null;
                if (n4 != 0) {
                    if (n4 == n3) {
                        object = list.get(0);
                    } else {
                        throw new MultipleArgumentsForOptionException((OptionSpec)abstractOptionSpec);
                    }
                }
            }
            string = (String)object;
        }
        if (!(bl = optionSet.detectedOptions.containsKey((Object)"syntax"))) {
            n3 = 2;
        }
        List list = optionSet.valuesOf((OptionSpec)((AbstractOptionSpec)optionSet.detectedOptions.get((Object)"[arguments]")));
        if (list.size() < n3) {
            System.err.println("missing arguments");
            optionParser.printHelpOn((OutputStream)System.err);
            System.exit((int)RetCode.CMD_ERROR.get());
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)new File((String)iterator.next()).getCanonicalFile());
        }
        if (optionSet.detectedOptions.containsKey((Object)"brief")) {
            reporters = Reporters.BRIEF;
        } else if (optionSet.detectedOptions.containsKey((Object)"quiet")) {
            System.out.close();
            System.err.close();
            reporters = Reporters.QUIET;
        }
        new Main(string).proceed((Reporter)reporters, (List<File>)arrayList, bl);
        return;
    }

    private void proceed(Reporter reporter, List<File> list, boolean bl) throws IOException, ProcessingException {
        RetCode retCode = bl ? this.doSyntax(reporter, list) : this.doValidation(reporter, list);
        System.exit((int)retCode.get());
    }
}

