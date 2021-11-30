package com.firstapp.firstappbackend.dao;

import com.firstapp.firstappbackend.pojo.TableVersion;
import java.util.List;

public interface TableVersionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_version
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_version
     *
     * @mbg.generated
     */
    int insert(TableVersion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_version
     *
     * @mbg.generated
     */
    TableVersion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_version
     *
     * @mbg.generated
     */
    List<TableVersion> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table table_version
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TableVersion record);

    int  selectByUserId(Integer userId);
}