package com.buukr.shop.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buukr.shop.service.dto.ShopDto;
import com.buukr.shop.service.entity.Shop;
import com.buukr.shop.service.error.ErrorResponse;
import com.buukr.shop.service.repository.ShopRepository;
import com.buukr.shop.service.service.ShopService;

import javassist.NotFoundException;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ShopDto shopDto;

	
	
	@Override
	public Shop saveShop(ShopDto shopDto) throws ErrorResponse {
	    Shop shop = new Shop();
		shop.setName(shopDto.getName());
		shop.setAddress(shopDto.getAddress());
		shop.setPhone(shopDto.getPhone());
		shop.setopenninghours(shopDto.getopenninghours());
	
		Optional<Shop> optionalShop = Optional.of(shopRepository.save(shop));

		if(!optionalShop.isPresent()) {
		//	throw new Exception("Shop couldn't saved");
			throw new ErrorResponse(1003, "unique constraint");
		}
		return shop;
	}
	
	@Override
	public ShopDto getShopById(Long id) throws NotFoundException {
		Optional<Shop> shp = shopRepository.findById(id);
		if(shp.isPresent()) {
			shopDto.setName(shp.get().getName());
			shopDto.setAddress(shp.get().getAddress());
			shopDto.setPhone(shp.get().getPhone());
			shopDto.setopenninghours(shp.get().getopenninghours());
			return shopDto;
		}else {
			throw new NotFoundException("Shop couldn't find with id = "+ id);
		}	
	}

	@Override
	public List<ShopDto> getAllShops() {
		List<ShopDto> shopDtoList = new ArrayList<>();
        Iterable<Shop> shopList = shopRepository.findAll();
        shopList.forEach(shop -> {
        	ShopDto shopDto = new ShopDto();
        	shopDto.setName(shop.getName());
    		shopDto.setAddress(shop.getAddress());
    		shopDto.setPhone(shop.getPhone());
    		shopDto.setopenninghours(shop.getopenninghours());
    		shopDtoList.add(shopDto);
        });
        return shopDtoList;
	}
	
    
	
}
