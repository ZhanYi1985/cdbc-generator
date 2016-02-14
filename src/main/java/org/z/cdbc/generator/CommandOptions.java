/*
 * Copyright (c) 2016 Zhan Yi
 * All Rights Reserved
 * Licensed Materials - Property of Zhan Yi.
 *
 */

package org.z.cdbc.generator;

import com.beust.jcommander.Parameter;

/**
 * Created by zhanyi on 2015/10/30 0030.
 */
public class CommandOptions {

    @Parameter(names = "--user", description = "Database user name.", required = true)
    private String user;

    @Parameter(names = "--password", description = "Password of user.", required = true)
    private String password;

    @Parameter(names = "--url", description = "Database connection url.", required = true)
    private String url;

    @Parameter(names = "--out", description = "Output dir.")
    private String outDir = "./out";

    public String getTablelist() {
        return tablelist;
    }

    public void setTablelist(String tablelist) {
        this.tablelist = tablelist;
    }

    @Parameter(names = "--tables", description = "Table list, delimit by ','.", required = true)
    private String tablelist;

    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    @Parameter(names = "--driver",
            description = "JDBC driver class name.")
    private String jdbcDriver = MetaDataParser.MYSQL_DRIVER;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Parameter(names = "--package", description = "Such as the short name of system. Such as edu/xswap.", required = true)
    private String packageName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
