package com.bluenet.database;

public enum SQLTable {

    TEST(""), TEST_2("")
    ;

    private final String defaultTable;
    private String tableName;

    SQLTable(final String defaultTable) {
        this.defaultTable = defaultTable;
    }

    public String getDefaultTable() {
        return defaultTable;
    }

    public String tableName() {
        if(tableName == null) {
            return (tableName = defaultTable);
        }
        return tableName;
    }

    public void tableName(String tableName){
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return tableName;
    }
}
