package de.codecentric.gcp.model;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private String _id;
    private Map<String, Integer> lstPoint;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Map<String, Integer> getLstPoint() {
		return lstPoint;
	}
	public void setLstPoint(Map<String, Integer> lstPoint) {
		this.lstPoint = lstPoint;
	}
    
    public void setPoint(String key, Integer value) {
    	if (lstPoint == null) {
    		lstPoint = new HashMap<>();
    	}
    	lstPoint.put(key, value);
    }
    public Integer getValue(String key) {
    	if (lstPoint == null || !lstPoint.containsKey(key)) {
    		return 0;
    	}
    	return lstPoint.get(key);
    }
}
