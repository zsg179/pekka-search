package com.pekka.search.mapper;

import java.util.List;

import com.pekka.common.pojo.SearchItem;

public interface SearchItemMapper {
	List<SearchItem> getItemList();

	SearchItem getItemById(long itemId);
}
