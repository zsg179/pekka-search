package com.pekka.search.service;

import com.pekka.common.pojo.SearchResult;

public interface SearchService {
	/**
	 * 搜索服务
	 * 
	 * @param queryString
	 *            查询条件
	 * @param page
	 *            当前页
	 * @param rows
	 *            每页显示的记录数
	 * @return
	 * @throws Exception
	 */
	SearchResult search(String queryString, int page, int rows) throws Exception;
}
