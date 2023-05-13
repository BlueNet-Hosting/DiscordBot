package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.JsonValue;
import com.bluenet.utils.configurations.tools.ValueType;

public abstract class JsonSimple<E> extends JsonValue<E> {

    protected final E value;

    public JsonSimple(E value) {
        this.value = value;
    }

    @Override
    public E getValue() {
        return value;
    }

}
