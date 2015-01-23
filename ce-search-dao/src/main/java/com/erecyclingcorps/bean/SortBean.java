package com.erecyclingcorps.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author parora
 **/

public class SortBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8813613204333132876L;

    private static final String ASCENDING = "asc";

    private static final String DESCENDING = "desc";

    private boolean sortAscending;

    private String column;

    /**
     * @param sortAscending
     * @param column
     */
    public SortBean(boolean sortAscending, String column) {
        this.sortAscending = sortAscending;
        this.column = column;
    }

    /**
     * @param column
     */
    public SortBean(String column) {
        this.column = column;
    }

    /**
     * 
     */
    public SortBean() {
    }

    /**
     * @return Returns the column.
     */
    public String getColumn() {
        return this.column;
    }

    /**
     * @param column
     *            The column to set.
     */
    public void setColumn(String column) {
        if (StringUtils.equalsIgnoreCase(this.column, column)) {
            sortAscending = !sortAscending;
        } else {
            sortAscending = true;
        }

        this.column = column;
    }

    /**
     * @return Returns the sortAscending.
     */
    public boolean getSortAscending() {
        return this.sortAscending;
    }

    /**
     * @param sortAscending
     *            The sortAscending to set.
     */
    public void setSortAscending(boolean sortAscending) {
        this.sortAscending = sortAscending;
    }

    /**
     * @return
     */
    public String toString() {
        StringBuffer result = new StringBuffer(column);
        result.append(" ");
        result.append(BooleanUtils.toString(this.getSortAscending(), ASCENDING,
                DESCENDING));
        return result.toString();
    }

    public static List<SortBean> getSingleSortBeanList(String column,
            boolean sortAscending) {
        List<SortBean> sortBeanList = new ArrayList<SortBean>();
        sortBeanList.add(new SortBean(sortAscending, column));
        return sortBeanList;
    }
}