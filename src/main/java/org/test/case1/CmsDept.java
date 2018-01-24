package org.test.case1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="a_cms_dept")
public class CmsDept {
	/*  `COMPANY_CODE` varchar(12) NOT NULL,
	  `DEPT_CODE` varchar(20) NOT NULL,
	  `DEPT_NAME` varchar(50) NOT NULL,
	  `CREATE_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	  `LAST_UPDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	  `CMS_DEPT_ID` int(11) NOT NULL DEFAULT '1',
	  `CMS_NOTE_ID` int(11) DEFAULT NULL,
	  `IS_MA` tinyint(4) DEFAULT '0',
	  `EXT1` varchar(100) DEFAULT NULL,
	  `EXT2` varchar(100) DEFAULT NULL,
	  `EXT3` varchar(100) DEFAULT NULL,
	  `EXT4` varchar(100) DEFAULT NULL,
	  `EXT5*/
	@Column(name="COMPANY_CODE")
	private String companyCode;
	
	@Column(name="DEPT_CODE")
	private String deptCode;
	
	@Column(name="DEPT_NAME")
	private String deptName;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="LAST_DATE")
	private Date lastDate;
	
	@Column(name="CMS_DEPT_ID")
	private Integer cmsDeptId;
	
	@Column(name="CMS_NOTE_ID")
	private Integer cmsNoteId;
	
	@Column(name="IS_MA")
	private Boolean ma;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getCmsDeptId() {
		return cmsDeptId;
	}
	public void setCmsDeptId(Integer cmsDeptId) {
		this.cmsDeptId = cmsDeptId;
	}
	public Integer getCmsNoteId() {
		return cmsNoteId;
	}
	public void setCmsNoteId(Integer cmsNoteId) {
		this.cmsNoteId = cmsNoteId;
	}
	public Boolean getMa() {
		return ma;
	}
	public void setMa(Boolean ma) {
		this.ma = ma;
	} 
	
	
}
