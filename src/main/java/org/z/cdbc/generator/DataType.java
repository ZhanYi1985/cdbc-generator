/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

/**
 * Created by zhanyi on 2015/12/31 0031.
 */
public enum DataType {
    NUMBER("number", 1), STRING("string", 2),  DATETIME("datetime", 3);

    private String name;
    private int value;
    private DataType(String typeName, int type) {
        this.name = typeName;
        this.value = type;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
