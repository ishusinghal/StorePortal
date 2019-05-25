package com.xebia.StorePortal.model;


public enum ProductType {
	
	GROCERY("GROCERY", 1), LUXURY("LUXURY", 2),CLOTHES("CLOTHES",3),UTENSILS("UTENSILS",4);

    private final String key;
    private final Integer value;

    ProductType(String key, Integer value) {
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
