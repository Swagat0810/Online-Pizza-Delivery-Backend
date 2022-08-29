package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CoupanIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCoupanOperationException;
public interface ICoupanService {

	Coupan addCoupans(Coupan coupan);

	Coupan editCoupans(Coupan coupan) throws InvalidCoupanOperationException;

	Coupan deleteCoupans(int coupanId)throws CoupanIdNotFoundException;

	List<Coupan> viewCoupans() throws CoupanIdNotFoundException;

	Coupan viewCoupan(int coupanId)throws CoupanIdNotFoundException;
	
	Coupan viewCoupanByName(String coupanName) throws CoupanIdNotFoundException;

	

	
	
	
}