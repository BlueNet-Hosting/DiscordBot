package com.bluenet.utils.configurations.values;

public abstract class JsonNumber<E extends Number> extends JsonSimple<E> {

    public JsonNumber(E value) {
        super(value);
    }

}
