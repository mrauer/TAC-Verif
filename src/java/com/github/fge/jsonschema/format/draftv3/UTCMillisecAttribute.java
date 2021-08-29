/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.math.BigInteger
 */
package com.github.fge.jsonschema.format.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.math.BigInteger;

public final class UTCMillisecAttribute
extends AbstractFormatAttribute {
    private static final int EPOCH_BITLENGTH = 31;
    private static final FormatAttribute INSTANCE;
    private static final BigInteger ONE_THOUSAND;

    public static {
        ONE_THOUSAND = new BigInteger("1000");
        INSTANCE = new UTCMillisecAttribute();
    }

    private UTCMillisecAttribute() {
        NodeType nodeType = NodeType.INTEGER;
        NodeType[] arrnodeType = new NodeType[]{NodeType.NUMBER};
        super("utc-millisec", nodeType, arrnodeType);
    }

    public static FormatAttribute getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        BigInteger bigInteger = jsonNode.bigIntegerValue();
        if (bigInteger.signum() == -1) {
            processingReport.warn(this.newMsg(fullData, messageBundle, "warn.format.epoch.negative").putArgument("value", jsonNode));
            return;
        }
        if (bigInteger.divide(ONE_THOUSAND).bitLength() > 31) {
            processingReport.warn(this.newMsg(fullData, messageBundle, "warn.format.epoch.overflow").putArgument("value", jsonNode));
        }
    }
}

