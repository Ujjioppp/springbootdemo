package com.sb.sbdemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class FfaDemand {
    private Long id;

    private String uuid;

    private Date gmtCreated;

    private Date gmtModified;

    private Long userCreated;

    private Long userModified;

    private Integer aliveFlag;

    private Long version;

    private String serialNumber;

    private String ffaDemandTypeCode;

    private String ffaRouteCode;

    private String ffaPeriodTypeCode;

    private String ffaPeriod;

    private String tonnage;

    private Long enterpriseId;

    private String ffaOrderTypeCode;

    private BigDecimal ws;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Long userCreated) {
        this.userCreated = userCreated;
    }

    public Long getUserModified() {
        return userModified;
    }

    public void setUserModified(Long userModified) {
        this.userModified = userModified;
    }

    public Integer getAliveFlag() {
        return aliveFlag;
    }

    public void setAliveFlag(Integer aliveFlag) {
        this.aliveFlag = aliveFlag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getFfaDemandTypeCode() {
        return ffaDemandTypeCode;
    }

    public void setFfaDemandTypeCode(String ffaDemandTypeCode) {
        this.ffaDemandTypeCode = ffaDemandTypeCode == null ? null : ffaDemandTypeCode.trim();
    }

    public String getFfaRouteCode() {
        return ffaRouteCode;
    }

    public void setFfaRouteCode(String ffaRouteCode) {
        this.ffaRouteCode = ffaRouteCode == null ? null : ffaRouteCode.trim();
    }

    public String getFfaPeriodTypeCode() {
        return ffaPeriodTypeCode;
    }

    public void setFfaPeriodTypeCode(String ffaPeriodTypeCode) {
        this.ffaPeriodTypeCode = ffaPeriodTypeCode == null ? null : ffaPeriodTypeCode.trim();
    }

    public String getFfaPeriod() {
        return ffaPeriod;
    }

    public void setFfaPeriod(String ffaPeriod) {
        this.ffaPeriod = ffaPeriod == null ? null : ffaPeriod.trim();
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage == null ? null : tonnage.trim();
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFfaOrderTypeCode() {
        return ffaOrderTypeCode;
    }

    public void setFfaOrderTypeCode(String ffaOrderTypeCode) {
        this.ffaOrderTypeCode = ffaOrderTypeCode == null ? null : ffaOrderTypeCode.trim();
    }

    public BigDecimal getWs() {
        return ws;
    }

    public void setWs(BigDecimal ws) {
        this.ws = ws;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}