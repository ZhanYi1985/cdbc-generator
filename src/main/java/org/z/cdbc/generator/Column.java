/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

public class Column {
    boolean signed = true;
    private String name = null;
    private int type = -1;
    private int scale = 0;
    private int precision;
    private boolean nullable = false;
    private boolean autoIncrement = false;

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Column(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public Column() {

    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Column{" +
                "signed=" + signed +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", scale=" + scale +
                ", precision=" + precision +
                ", nullable=" + nullable +
                ", autoIncrement=" + autoIncrement +
                '}';
    }
}