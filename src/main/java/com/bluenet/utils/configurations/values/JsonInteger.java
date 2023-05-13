package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonInteger extends JsonNumber<Integer> {

    public JsonInteger(Integer value) {
        super(value);
    }

    @Override
    public final ValueType getType() {
        return ValueType.INTEGER;
    }

}
