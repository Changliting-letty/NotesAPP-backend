package com.firstapp.firstappbackend.pojo;

import java.util.Date;

public class Notes {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.sub_title
     *
     * @mbg.generated
     */
    private String subTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.note_text
     *
     * @mbg.generated
     */
    private String noteText;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.date_time
     *
     * @mbg.generated
     */
    private Date dateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.img_path
     *
     * @mbg.generated
     */
    private String imgPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.web_link
     *
     * @mbg.generated
     */
    private String webLink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Notes.color
     *
     * @mbg.generated
     */
    private String color;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.id
     *
     * @return the value of Notes.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.id
     *
     * @param id the value for Notes.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.user_id
     *
     * @return the value of Notes.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.user_id
     *
     * @param userId the value for Notes.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.title
     *
     * @return the value of Notes.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.title
     *
     * @param title the value for Notes.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.sub_title
     *
     * @return the value of Notes.sub_title
     *
     * @mbg.generated
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.sub_title
     *
     * @param subTitle the value for Notes.sub_title
     *
     * @mbg.generated
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.note_text
     *
     * @return the value of Notes.note_text
     *
     * @mbg.generated
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.note_text
     *
     * @param noteText the value for Notes.note_text
     *
     * @mbg.generated
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText == null ? null : noteText.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.create_time
     *
     * @return the value of Notes.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.create_time
     *
     * @param createTime the value for Notes.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.date_time
     *
     * @return the value of Notes.date_time
     *
     * @mbg.generated
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.date_time
     *
     * @param dateTime the value for Notes.date_time
     *
     * @mbg.generated
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.img_path
     *
     * @return the value of Notes.img_path
     *
     * @mbg.generated
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.img_path
     *
     * @param imgPath the value for Notes.img_path
     *
     * @mbg.generated
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.web_link
     *
     * @return the value of Notes.web_link
     *
     * @mbg.generated
     */
    public String getWebLink() {
        return webLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.web_link
     *
     * @param webLink the value for Notes.web_link
     *
     * @mbg.generated
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink == null ? null : webLink.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Notes.color
     *
     * @return the value of Notes.color
     *
     * @mbg.generated
     */
    public String getColor() {
        return color;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Notes.color
     *
     * @param color the value for Notes.color
     *
     * @mbg.generated
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}