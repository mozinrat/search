package com.erecyclingcorps.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author parora
 **/
public class PagerBean<T> implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -242045403033273406L;

	public static final int DEFAULT_ROWS_PER_PAGE = 15;

	private List<T> results = new ArrayList<T>();

	private int totalSize;

	private int maxResults = DEFAULT_ROWS_PER_PAGE;

	private int maxIndexPages = 10;

	private int currentPage = 0;

	@SuppressWarnings("rawtypes")
	public static PagerBean getAllResults() {
		PagerBean pager = new PagerBean();
		pager.setCurrentPage(0);
		pager.setMaxResults(0);
		return pager;
	}

	public PagerBean() {

	}

	public PagerBean(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * @return Returns the currentPage.
	 */
	public final int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * @param currentPage
	 *            The currentPage to set.
	 */
	public final void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return Returns the maxIndexPages.
	 */
	public int getMaxIndexPages() {
		return this.maxIndexPages;
	}

	/**
	 * @param maxIndexPages
	 *            The maxIndexPages to set.
	 */
	public void setMaxIndexPages(int maxIndexPages) {
		this.maxIndexPages = maxIndexPages;
	}

	/**
	 * @return Returns the maxResults.
	 */
	public int getMaxResults() {
		return this.maxResults;
	}

	/**
	 * @param maxResults
	 *            The maxResults to set.
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * @return Returns the results.
	 */
	public List<T> getResults() {
		return this.results;
	}

	/**
	 * @param results
	 *            The results to set.
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}

	/**
	 * @return Returns the totalSize.
	 */
	public int getTotalSize() {
		return this.totalSize;
	}

	/**
	 * @param totalSize
	 *            The totalSize to set.
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean getHasNext() {
		return getCurrentPage() < (getTotalPages() - 1);
	}

	public boolean getHasPrevious() {
		return getCurrentPage() > 0;
	}

	public int getTotalPages() {
		if (maxResults == 0) {
			return 1;
		} else {
			return ((totalSize + maxResults) - 1) / maxResults;
		}
	}

	public int getStartIndex() {
		return this.getCurrentPage() * this.getMaxResults();
	}

	public void reset() {
		currentPage = 0;
	}
}