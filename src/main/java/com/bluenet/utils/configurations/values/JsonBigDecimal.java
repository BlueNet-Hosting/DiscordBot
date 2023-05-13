package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

import java.math.BigDecimal;


public class JsonBigDecimal extends JsonNumber<BigDecimal> {

    public JsonBigDecimal(BigDecimal value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.BIG_DECIMAL;
    }

}
