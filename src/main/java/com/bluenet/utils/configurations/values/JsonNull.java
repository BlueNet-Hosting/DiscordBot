package com.bluenet.utils.configurations.values;

import com.bluenet.utils.configurations.tools.JsonValue;
import com.bluenet.utils.configurations.tools.ValueType;

public class JsonNull<E> extends JsonValue<E> {

    private static JsonNull<?> INSTANCE = new JsonNull<>();

    @SuppressWarnings("unchecked")
    public static <E> JsonNull<E> get() {
        return (JsonNull<E>) INSTANCE;
    }

    private JsonNull() {}

    @Override
    public ValueType getType() {
        return ValueType.NULL;
    }

    @Override
    public E getValue() {
        return null;
    }

}
