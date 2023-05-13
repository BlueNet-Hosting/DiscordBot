package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonShort extends JsonNumber<Short> {

    public JsonShort(Short value) {
        super(value);
    }

    @Override
    public final ValueType getType() {
        return ValueType.SHORT;
    }

}
