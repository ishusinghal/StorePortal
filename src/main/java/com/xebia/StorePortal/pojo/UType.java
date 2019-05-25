package com.xebia.StorePortal.pojo;

public enum UType {
	
	EMPLOYEE("EMPLOYEE",1),AFFILIATE("AFFILIATE",2),CUSTOMER("CUSTOMER",3);
	
	private final String key;
    private final Integer value;

    UType(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
    
}
