package com.buukr.shop.service.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.buukr.shop.service.dto.ShopDto;
import com.buukr.shop.service.entity.Shop;
import com.buukr.shop.service.error.ErrorResponse;
import com.buukr.shop.service.serviceImpl.ShopServiceImpl;

import javassist.NotFoundException;

@RestController
public class ShopController {

	@Autowired
	ShopServiceImpl shopService;

	int errcode;
	
	@PostMapping("/shop/new/")
	public ResponseEntity<ShopDto> addShop(@Valid @RequestBody ShopDto shopDto) throws ErrorResponse {
		try {
			errcode = 1000;
			Shop savedShop = shopService.saveShop(shopDto);
			
			errcode = 1001;
			URI location = ServletUriComponentsBuilder
			    .fromCurrentServletMapping()
			    .path("/shop/{id}")
			    .buildAndExpand(savedShop.getId())
			    .toUri();

			errcode = 1002;
			return ResponseEntity.created(location).body(shopDto);
		}catch(Exception e) {
			throw new ErrorResponse(errcode, e.getMessage());
		}
	}

	@GetMapping("/shop/{id}")
	public ShopDto getShopById(@PathVariable Long id) throws NotFoundException {
		return shopService.getShopById(id);
	}

	@GetMapping("/shop/get/all")
	public List<ShopDto> getAllShops() {
		return shopService.getAllShops();
	}
}
