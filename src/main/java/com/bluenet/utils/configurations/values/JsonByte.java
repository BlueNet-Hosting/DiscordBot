package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.ValueType;

public class JsonByte extends JsonNumber<Byte> {

    public JsonByte(Byte value) {
        super(value);
    }

    @Override
    public ValueType getType() {
        return ValueType.BYTE;
    }

}
