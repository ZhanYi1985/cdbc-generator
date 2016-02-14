/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import java.util.List;

/**
 * Created by zhanyi on 2015/12/31 0031.
 */
public class Index {
    private String name;

    private List<Column> columns;

    public Index(String name) {
        this.name = name;
    }

    public Index() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Index{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                '}';
    }
}
