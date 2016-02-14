/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import java.sql.Types;

/**
 * Created by zhanyi on 2015/12/31 0031.
 */
public class DataTypeUtil {
    public static DataType mapType(int type) {
        switch (type) {
            case Types.BIGINT:
            case Types.DECIMAL:
            case Types.DOUBLE:
            case Types.FLOAT:
            case Types.INTEGER:
            case Types.NUMERIC:
            case Types.SMALLINT:
            case Types.TINYINT:
                return DataType.NUMBER;
            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
                return DataType.DATETIME;
            default:
                return DataType.STRING;
        }
    }
}
