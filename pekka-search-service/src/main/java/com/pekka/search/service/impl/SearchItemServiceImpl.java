package com.pekka.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pekka.common.pojo.PekkaResult;
import com.pekka.common.pojo.SearchItem;
import com.pekka.search.mapper.SearchItemMapper;
import com.pekka.search.service.SearchItemService;

@Service
public class SearchItemServiceImpl implements SearchItemService {
	@Autowired
	private SearchItemMapper searchItemMapper;
	@Autowired
	private SolrServer solrServer;

	@Override
	public PekkaResult importItemsToIndex() {
		try {
			// 查询商品列表
			List<SearchItem> list = searchItemMapper.getItemList();
			// 导入商品到索引库
			// 遍历每一个商品
			for (SearchItem searchItem : list) {
				// 向文档中添加域
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCategory_name());
				document.addField("item_desc", searchItem.getItem_desc());
				// 2.3索引库中添加文档
				solrServer.add(document);
			}
			// 提交
			solrServer.commit();
			return PekkaResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return PekkaResult.build(500, "导入商品失败");
		}
	}

}
