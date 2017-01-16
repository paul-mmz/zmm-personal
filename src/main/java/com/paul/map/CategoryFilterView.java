/**
 * Copyright 2014-2015, NetEase, Inc. All Rights Reserved.
 * 
 * Date: Nov 20, 2015
 */

package com.paul.map;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Preference->Java->Code Style->Code templates Type XXX<hzXXXX@corp.netease.com>
 * @since Nov 20, 2015
 */
public class CategoryFilterView implements Serializable {

    private static final long serialVersionUID = 7247232084154847940L;

    private long categoryId;

    private String categoryName;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    @Override
    public boolean equals(Object c){
    	CategoryFilterView category = (CategoryFilterView)c;
    	return (this.categoryId == category.getCategoryId()) && (this.categoryName.equals(category.getCategoryName()));
    }
}
