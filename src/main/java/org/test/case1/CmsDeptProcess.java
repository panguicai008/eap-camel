package org.test.case1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.camel.component.sql.SqlComponent;


public class CmsDeptProcess {
	
	@Resource
	private SqlComponent com;
	//INSERT INTO a_cms_dept(COMPANY_CODE,DEPT_CODE,DEPT_NAME,CREATE_DATE,LAST_UPDATE) 
	//VALUES('1234','4567','1211','2014-08-13 05:08:17','2014-08-13 05:08:17')"))
	public Map<String, Object> generateNewCmsDept() {
        Map<String, Object> answer = new HashMap<String, Object>();
        String uuid=UUID.randomUUID().toString().replaceAll("\\-", "");
        String companyCode=uuid.substring(0, 12);
        String deptCode=uuid.substring(0, 20);
        answer.put("COMPANY_CODE", companyCode);
        answer.put("DEPT_CODE", deptCode);
        answer.put("DEPT_NAME",  "dept1" );
        answer.put("CREATE_DATE", new Date());
        answer.put("LAST_UPDATE", new Date());
        return answer;
    }

    /**
     * Processes the cms dept
     * @param data  the cms dept as a {@link Map}
     * @return the transformed cms dept
     */
    public String processCmsDept(Map<String, Object> data) {
        return "Processed COMPANY_CODE " + data.get("COMPANY_CODE") + " DEPT_CODE " 
		+ data.get("DEPT_CODE")+ data.get("EXT1");
    }

}
