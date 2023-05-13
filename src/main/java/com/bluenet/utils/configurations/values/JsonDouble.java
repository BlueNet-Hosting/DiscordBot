package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonDouble extends JsonNumber<Double> {

    public JsonDouble(Double value) {
        super(value);
    }

    @Override
    public final ValueType getType() {
        return ValueType.DOUBLE;
    }

}
