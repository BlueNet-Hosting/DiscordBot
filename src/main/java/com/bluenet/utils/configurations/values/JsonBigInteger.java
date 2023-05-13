package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

import java.math.BigInteger;


public class JsonBigInteger extends JsonNumber<BigInteger> {

    public JsonBigInteger(BigInteger value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.BIG_INTEGER;
    }

}
