package com.buukr.shop.service.service;

import java.util.List;

import com.buukr.shop.service.dto.ShopDto;
import com.buukr.shop.service.entity.Shop;

import javassist.NotFoundException;

public interface ShopService {
	
	public Shop saveShop(ShopDto shopDto) throws Exception;
	public List<ShopDto> getAllShops();
	public ShopDto getShopById(Long id) throws NotFoundException;
}
