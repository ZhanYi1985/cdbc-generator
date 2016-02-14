/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanyi on 2015/12/30 0030.
 */
public class MetaDataParser {
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private String url;
    private String userName;
    private String password;
    private String driverClassName = MYSQL_DRIVER;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public MetaDataParser(String url, String un, String pass) {
        this.url = url;
        this.userName = un;
        this.password = pass;
    }

    public Table parse(String tableName) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Table table = null;
        try {
            con = DriverManager.getConnection(url,
                    userName, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery( "select * from " + tableName + " where 1 = 0 ");
            ResultSetMetaData metaData = rs.getMetaData();
            table = new Table();

            table.setName(tableName.toLowerCase());
            List<Column> columns = new ArrayList<Column>(metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                Column c = new Column();
                c.setName( metaData.getColumnName(i).toUpperCase() );
                c.setNullable( metaData.isNullable(i) == ResultSetMetaData.columnNullable ? true : false );
                c.setScale( metaData.getScale(i) );
                c.setPrecision(metaData.getPrecision(i));
                c.setType(DataTypeUtil.mapType(metaData.getColumnType(i)).getValue());
                c.setSigned(metaData.isSigned(i));
                c.setAutoIncrement(metaData.isAutoIncrement(i));
                columns.add(c);
            }
            table.setColumns(columns);

            List<Index> indexes = getIndexInfo(con, table);
            table.setIndexes(indexes);

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return table;
    }


    private List<Index> getIndexInfo(Connection con, Table table) throws SQLException {
        List<Index> indexes = new ArrayList<Index>();

        ResultSet pkrs = null;
        ResultSet iRs = null;
        pkrs = con.getMetaData().getPrimaryKeys(con.getCatalog(), null, table.getName());
        List<Column> columns = null;

        /*Index pk = new Index();
        columns = new ArrayList<Column>();
        pk.setColumns(columns);

        while (pkrs.next()) {
            String columnName = pkrs.getString("COLUMN_NAME");
            pk.setName(pkrs.getString("PK_NAME"));
            for (Column c : table.getColumns()) {
                if (columnName.equalsIgnoreCase(c.getName())) {
                    columns.add(c);
                    break;
                }
            }
        }
        indexes.add(pk);*/

        iRs =  con.getMetaData().getIndexInfo(con.getCatalog(), null, table.getName(), true, false);
        String indexName = "";
        Index idx = null;
        columns = null;
        while (iRs.next()) {
            if (iRs.getInt("TYPE") == java.sql.DatabaseMetaData.tableIndexStatistic) {
                continue;
            }
            if (!indexName.equalsIgnoreCase(iRs.getString("INDEX_NAME"))) {
                idx = new Index();
                indexName = iRs.getString("INDEX_NAME").toLowerCase();
                idx.setName(indexName);
                columns = new ArrayList<Column>();
                idx.setColumns(columns);
                indexes.add(idx);
            }

            String columnName = iRs.getString("COLUMN_NAME").toUpperCase();
            for (Column c : table.getColumns()) {
                if (columnName.equalsIgnoreCase(c.getName())) {
                    columns.add(c);
                    break;
                }
            }
        }

        return indexes;
    }
}
