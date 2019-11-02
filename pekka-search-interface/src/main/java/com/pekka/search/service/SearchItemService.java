package com.pekka.search.service;

import com.pekka.common.pojo.PekkaResult;

public interface SearchItemService {
	/**
	 * 导入商品到索引库中
	 * 
	 * @return
	 */
	PekkaResult importItemsToIndex();
}
