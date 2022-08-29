package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;

import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CoupanIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCoupanOperationException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.ICoupanRepository;

@Service
public class CoupanServiceImpl implements ICoupanService {
	@Autowired
	public ICoupanRepository repo;

	@Override
	public Coupan addCoupans(Coupan coupan) {
		Coupan rcoupan = repo.save(coupan);
		return rcoupan;
	}

	@Override
	public Coupan editCoupans(Coupan coupan) throws InvalidCoupanOperationException {
		Optional<Coupan> rcoupan = repo.findById(coupan.getCoupanId());
		if (rcoupan.isPresent()) {
			// repo.deleteById(coupon.getCouponId());
			//repo.save(coupan);
			//return rcoupan.get();
			return repo.save(coupan);
		} else {
			return addCoupans(coupan);
		}
	}

	@Override
	public Coupan deleteCoupans(int coupanId) throws CoupanIdNotFoundException {
		Optional<Coupan> op = repo.findById(coupanId);
		if (op.isPresent()) {

			repo.deleteById(coupanId);
			
			return op.get();
		} 
		else 
		{
			throw new CoupanIdNotFoundException("Pizza id is not found");
		}
	}

	@Override
	public List<Coupan> viewCoupans() throws CoupanIdNotFoundException {
		List<Coupan> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		if (list.isEmpty()) {
			throw new CoupanIdNotFoundException("Empty");
		} else {
			return list;
		}
	}

	@Override
	public Coupan viewCoupan(int coupanId) throws CoupanIdNotFoundException
	{
		
		Optional<Coupan> rcoupan = repo.findById(coupanId);
		if (rcoupan.isPresent())
		{
			
			return rcoupan.get();
		} 
		else
		{
			throw new CoupanIdNotFoundException("Coupon is not available");
		}	
	}

	@Override
	public Coupan viewCoupanByName(String coupanName) throws CoupanIdNotFoundException {
		// TODO Auto-generated method stub
		List<Coupan> list= new ArrayList<Coupan>();
		list= repo.findAll();
		int d = 0;
		for(Coupan c : list) {
			c.getCoupanDescription().equalsIgnoreCase(coupanName);
			d=c.getCoupanId();
	
		}
		Optional<Coupan> rcoupan = repo.findById(d);
		if (rcoupan.isPresent()) {
			return rcoupan.get();
		} else {
			throw new CoupanIdNotFoundException("Coupon is not available");
		}
		
	}


}