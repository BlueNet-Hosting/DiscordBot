package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonBoolean extends JsonSimple<Boolean> {

    public JsonBoolean(Boolean value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.BOOLEAN;
    }

}
