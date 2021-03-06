package com.epayMall.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epayMall.common.ServerResponse;
import com.epayMall.pojo.Category;
import com.epayMall.service.impl.DataClientZuulForCategory;

@FeignClient(name="micro-epay-mall-client-zuul", fallback=DataClientZuulForCategory.class)
public interface IDataClientZuulForCategory {
	
	@PostMapping("/category/epay-mall/category/manage/get_deep_category.do")
	ServerResponse<List<Integer>> getRecursionCategoryId(
			@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) ;

	@PostMapping("/category/epay-mall/category/manage/getCategoryByCategoryId")
	ServerResponse<Category> getCategoryByCategoryId(Integer categoryId) ;
	
}
