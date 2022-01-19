package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Addess;
import com.student.exception.BusinessException;
import com.student.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Addess addAddress(Addess address) {
		if(address.getArea().length()==0 || address.getCity().isEmpty() || address.getType().isEmpty()) {
			throw new BusinessException("300", "address values in null please check");
		}
		
	try {
 Addess add=addressRepository.save(address);		 
		 return add;
	}catch(IllegalArgumentException e) {
		throw new BusinessException("300", "enter the address details");
	}
		
		
	}

}
