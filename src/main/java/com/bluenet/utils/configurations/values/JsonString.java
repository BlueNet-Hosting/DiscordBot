package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonString extends JsonSimple<String> {

    public JsonString(String value) {
        super(value);
    }

    @Override
    public final ValueType getType() {
        return ValueType.STRING;
    }

}
