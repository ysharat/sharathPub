package com.sharath.spring.ws.service;

import java.util.List;

import com.sharath.spring.shared.dto.AddressDTO;



public interface AddressService {
	List<AddressDTO> getAddresses(String userId);
    AddressDTO getAddress(String addressId);
}
