package com.hongrui.survey.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.hongrui.survey.core.entity.User;
import com.hongrui.survey.core.repository.UserRepository;
import com.hongrui.survey.core.model.UserModel;
import com.hongrui.survey.core.service.UserService;
import com.wlw.pylon.core.beans.mapping.BeanMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private UserRepository userRepo;

	@Transactional
	@Override
	public int create(UserModel userModel) {
		return userRepo.insert(beanMapper.map(userModel, User.class));
	}

	@Transactional
	@Override
	public int createSelective(UserModel userModel) {
		return userRepo.insertSelective(beanMapper.map(userModel, User.class));
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(Long id) {
		return userRepo.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	@Override
	public UserModel findByPrimaryKey(Long id) {
		User user = userRepo.selectByPrimaryKey(id);
		return beanMapper.map(user, UserModel.class);
	}

	@Transactional(readOnly = true)
	@Override
	public long selectCount(UserModel userModel) {
		return userRepo.selectCount(beanMapper.map(userModel, User.class));
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserModel> selectPage(UserModel userModel,Pageable pageable) {
		User user = beanMapper.map(userModel, User.class);
		return beanMapper.mapAsList(userRepo.selectPage(user,pageable),UserModel.class);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(UserModel userModel) {
		return userRepo.updateByPrimaryKey(beanMapper.map(userModel, User.class));
	}
	
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(UserModel userModel) {
		return userRepo.updateByPrimaryKeySelective(beanMapper.map(userModel, User.class));
	}

}
