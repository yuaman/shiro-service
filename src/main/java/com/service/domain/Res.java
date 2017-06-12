package com.service.domain;

public class Res {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_res.res_id
     *
     * @mbggenerated
     */
    private String resId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_res.res_name
     *
     * @mbggenerated
     */
    private String resName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_res.res_shorthand
     *
     * @mbggenerated
     */
    private String resShorthand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_res.res_disFlag
     *
     * @mbggenerated
     */
    private String resDisflag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_res.res_id
     *
     * @return the value of tab_res.res_id
     *
     * @mbggenerated
     */
    public String getResId() {
        return resId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_res.res_id
     *
     * @param resId the value for tab_res.res_id
     *
     * @mbggenerated
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_res.res_name
     *
     * @return the value of tab_res.res_name
     *
     * @mbggenerated
     */
    public String getResName() {
        return resName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_res.res_name
     *
     * @param resName the value for tab_res.res_name
     *
     * @mbggenerated
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_res.res_shorthand
     *
     * @return the value of tab_res.res_shorthand
     *
     * @mbggenerated
     */
    public String getResShorthand() {
        return resShorthand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_res.res_shorthand
     *
     * @param resShorthand the value for tab_res.res_shorthand
     *
     * @mbggenerated
     */
    public void setResShorthand(String resShorthand) {
        this.resShorthand = resShorthand == null ? null : resShorthand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_res.res_disFlag
     *
     * @return the value of tab_res.res_disFlag
     *
     * @mbggenerated
     */
    public String getResDisflag() {
        return resDisflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_res.res_disFlag
     *
     * @param resDisflag the value for tab_res.res_disFlag
     *
     * @mbggenerated
     */
    public void setResDisflag(String resDisflag) {
        this.resDisflag = resDisflag == null ? null : resDisflag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Res other = (Res) that;
        return (this.getResId() == null ? other.getResId() == null : this.getResId().equals(other.getResId()))
            && (this.getResName() == null ? other.getResName() == null : this.getResName().equals(other.getResName()))
            && (this.getResShorthand() == null ? other.getResShorthand() == null : this.getResShorthand().equals(other.getResShorthand()))
            && (this.getResDisflag() == null ? other.getResDisflag() == null : this.getResDisflag().equals(other.getResDisflag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResId() == null) ? 0 : getResId().hashCode());
        result = prime * result + ((getResName() == null) ? 0 : getResName().hashCode());
        result = prime * result + ((getResShorthand() == null) ? 0 : getResShorthand().hashCode());
        result = prime * result + ((getResDisflag() == null) ? 0 : getResDisflag().hashCode());
        return result;
    }
}