package com.firstapp.firstappbackend.dao;

import com.firstapp.firstappbackend.pojo.Notes;
import java.util.List;

public interface NotesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Notes
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    int deleteByTitleAndUserId(String title,Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Notes
     *
     * @mbg.generated
     */
    int insert(Notes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Notes
     *
     * @mbg.generated
     */
    Notes selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Notes
     *
     * @mbg.generated
     */
    List<Notes> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Notes
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Notes record);
    int updateByUserIdAndTitle(Notes record);
}