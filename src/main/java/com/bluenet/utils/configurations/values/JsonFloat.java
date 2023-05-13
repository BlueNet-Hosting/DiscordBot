package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonFloat extends JsonNumber<Float> {

    public JsonFloat(Float value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.FLOAT;
    }

}
