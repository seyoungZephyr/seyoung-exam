package seyoung.zephyr.common.service;

/**
 * @Class Name : ComtccmmndetailcodeVO.java
 * @Description : Comtccmmndetailcode VO class
 * @Modification Information
 *
 * @author testCRUD
 * @since 2016.11.25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ComtccmmndetailcodeVO extends ComtccmmndetailcodeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** CODE_ID */
    private java.lang.String codeId;
    
    /** CODE */
    private java.lang.String code;
    
    /** CODE_NM */
    private java.lang.String codeNm;
    
    /** CODE_DC */
    private java.lang.String codeDc;
    
    /** USE_AT */
    private java.lang.String useAt;
    
    /** FRST_REGIST_PNTTM */
    private java.sql.Date frstRegistPnttm;
    
    /** FRST_REGISTER_ID */
    private java.lang.String frstRegisterId;
    
    /** LAST_UPDT_PNTTM */
    private java.sql.Date lastUpdtPnttm;
    
    /** LAST_UPDUSR_ID */
    private java.lang.String lastUpdusrId;
    
    public java.lang.String getCodeId() {
        return this.codeId;
    }
    
    public void setCodeId(java.lang.String codeId) {
        this.codeId = codeId;
    }
    
    public java.lang.String getCode() {
        return this.code;
    }
    
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    
    public java.lang.String getCodeNm() {
        return this.codeNm;
    }
    
    public void setCodeNm(java.lang.String codeNm) {
        this.codeNm = codeNm;
    }
    
    public java.lang.String getCodeDc() {
        return this.codeDc;
    }
    
    public void setCodeDc(java.lang.String codeDc) {
        this.codeDc = codeDc;
    }
    
    public java.lang.String getUseAt() {
        return this.useAt;
    }
    
    public void setUseAt(java.lang.String useAt) {
        this.useAt = useAt;
    }
    
    public java.sql.Date getFrstRegistPnttm() {
        return this.frstRegistPnttm;
    }
    
    public void setFrstRegistPnttm(java.sql.Date frstRegistPnttm) {
        this.frstRegistPnttm = frstRegistPnttm;
    }
    
    public java.lang.String getFrstRegisterId() {
        return this.frstRegisterId;
    }
    
    public void setFrstRegisterId(java.lang.String frstRegisterId) {
        this.frstRegisterId = frstRegisterId;
    }
    
    public java.sql.Date getLastUpdtPnttm() {
        return this.lastUpdtPnttm;
    }
    
    public void setLastUpdtPnttm(java.sql.Date lastUpdtPnttm) {
        this.lastUpdtPnttm = lastUpdtPnttm;
    }
    
    public java.lang.String getLastUpdusrId() {
        return this.lastUpdusrId;
    }
    
    public void setLastUpdusrId(java.lang.String lastUpdusrId) {
        this.lastUpdusrId = lastUpdusrId;
    }
    
}
