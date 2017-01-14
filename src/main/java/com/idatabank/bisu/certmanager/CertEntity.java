package com.idatabank.bisu.certmanager;

public class CertEntity {
    public CertEntity() {
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIssuerDn(String issuerDn) {
        this.issuerDn = issuerDn;
    }

    public String getIssuerDn() {
        return issuerDn;
    }
    
    public void setSubjectDn(String subjectDn) {
        this.subjectDn = subjectDn;
    }

    public String getSubjectDn() {
        return subjectDn;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    public String getSerial() {
        return serial;
    }
    
    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    public String getNotBefore() {
        return notBefore;
    }

    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    public String getNotAfter() {
        return notAfter;
    }
    
    public void setSignAlg(String signAlg) {
        this.signAlg = signAlg;
    }
    
    public String getSignAlg() {
        return signAlg;
    }
    
    public void setCustomerPersonnel(String customerPersonnel) {
        this.customerPersonnel = customerPersonnel;
    }
    
    public String getCustomerPersonnel() {
        return customerPersonnel;
    }
    
    public void setCustomerPersonnelMails(String customerPersonnelMails) {
        this.customerPersonnelMails = customerPersonnelMails;
    }
    
    public String getCustomerPersonnelMails() {
        return customerPersonnelMails;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    
    public String getManager() {
        return manager;
    }
    
    public void setManagerMails(String managerMails) {
        this.managerMails = managerMails;
    }
    
    public String getManagerMails() {
        return managerMails;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getComment() {
        return comment;
    }
    
    private String id = null;
    
    private String name = null;
    private String issuerDn = null;
    private String subjectDn = null;
    private String serial = null;
    private String notBefore = null;
    private String notAfter = null;
    private String signAlg = null;
    
    private String customerPersonnel = null;
    private String customerPersonnelMails = null;
    private String manager = null;
    private String managerMails = null;
    private String comment = null;
}
