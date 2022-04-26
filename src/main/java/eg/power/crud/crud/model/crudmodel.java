package eg.power.crud.crud.model;

public class crudmodel {
	
	
	private String lineNo;
	private String eid;
	private String ename;
	private int ephone;
	private String areaNo;
	private String areaName;
	private String startTime;
	private String endTime;
	private String date;
	private String reason;
	
	
	public crudmodel() {
		
	}
	
	
	public crudmodel(String lineNo, String eid, String ename, int ephone, String areaNo, String areaName,
			String startTime, String endTime, String date, String reason) {
		super();
		this.lineNo = lineNo;
		this.eid = eid;
		this.ename = ename;
		this.ephone = ephone;
		this.areaNo = areaNo;
		this.areaName = areaName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.reason = reason;
	}


	public String getLineNo() {
		return lineNo;
	}


	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}


	public String getEid() {
		return eid;
	}


	public void setEid(String eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getEphone() {
		return ephone;
	}


	public void setEphone(int ephone) {
		this.ephone = ephone;
	}


	public String getAreaNo() {
		return areaNo;
	}


	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	

}
