package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonLong extends JsonNumber<Long> {

    public JsonLong(Long value) {
        super(value);
    }

    @Override
    public final ValueType getType() {
        return ValueType.LONG;
    }

}
