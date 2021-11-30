package com.firstapp.firstappbackend.dao;

import com.firstapp.firstappbackend.pojo.ChangeLog;

import java.util.Date;
import java.util.List;

public interface ChangeLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table change_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table change_log
     *
     * @mbg.generated
     */
    int insert(ChangeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table change_log
     *
     * @mbg.generated
     */
    ChangeLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table change_log
     *
     * @mbg.generated
     */
    List<ChangeLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table change_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ChangeLog record);

    List<ChangeLog> selectByTime(Date date_time);
}