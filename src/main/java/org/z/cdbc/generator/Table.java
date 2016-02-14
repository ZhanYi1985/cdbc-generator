/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;
    private List<Index>  indexes;

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

    public List<Index> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Index> indexes) {
        this.indexes = indexes;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                ", indexes=" + indexes +
                '}';
    }
}
