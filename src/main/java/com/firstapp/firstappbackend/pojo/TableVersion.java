package com.firstapp.firstappbackend.pojo;

public class TableVersion {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column table_version.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column table_version.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column table_version.table_name
     *
     * @mbg.generated
     */
    private String tableName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column table_version.version
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column table_version.id
     *
     * @return the value of table_version.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column table_version.id
     *
     * @param id the value for table_version.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column table_version.user_id
     *
     * @return the value of table_version.user_id
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column table_version.user_id
     *
     * @param userId the value for table_version.user_id
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column table_version.table_name
     *
     * @return the value of table_version.table_name
     * @mbg.generated
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column table_version.table_name
     *
     * @param tableName the value for table_version.table_name
     * @mbg.generated
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column table_version.version
     *
     * @return the value of table_version.version
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column table_version.version
     *
     * @param version the value for table_version.version
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}