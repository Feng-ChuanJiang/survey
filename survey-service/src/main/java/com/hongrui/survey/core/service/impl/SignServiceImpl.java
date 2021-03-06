package com.hongrui.survey.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.hongrui.survey.core.entity.Sign;
import com.hongrui.survey.core.repository.SignRepository;
import com.hongrui.survey.core.model.SignModel;
import com.hongrui.survey.core.service.SignService;
import com.wlw.pylon.core.beans.mapping.BeanMapper;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private SignRepository signRepo;

	@Transactional
	@Override
	public int create(SignModel signModel) {
		return signRepo.insert(beanMapper.map(signModel, Sign.class));
	}

	@Transactional
	@Override
	public int createSelective(SignModel signModel) {
		return signRepo.insertSelective(beanMapper.map(signModel, Sign.class));
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(Long id) {
		return signRepo.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	@Override
	public SignModel findByPrimaryKey(Long id) {
		Sign sign = signRepo.selectByPrimaryKey(id);
		return beanMapper.map(sign, SignModel.class);
	}

	@Transactional(readOnly = true)
	@Override
	public long selectCount(SignModel signModel) {
		return signRepo.selectCount(beanMapper.map(signModel, Sign.class));
	}

	@Transactional(readOnly = true)
	@Override
	public List<SignModel> selectPage(SignModel signModel,Pageable pageable) {
		Sign sign = beanMapper.map(signModel, Sign.class);
		return beanMapper.mapAsList(signRepo.selectPage(sign,pageable),SignModel.class);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(SignModel signModel) {
		return signRepo.updateByPrimaryKey(beanMapper.map(signModel, Sign.class));
	}
	
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(SignModel signModel) {
		return signRepo.updateByPrimaryKeySelective(beanMapper.map(signModel, Sign.class));
	}

}
