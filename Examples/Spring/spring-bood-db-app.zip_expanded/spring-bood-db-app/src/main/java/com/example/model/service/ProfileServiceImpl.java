package com.example.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.beans.Profile;
import com.example.model.dao.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	// spring should supply the object of ProfileRepository
	@Autowired
	private ProfileRepository profileDao;
	
	@Transactional
	@Override
	public Profile storeProfile(Profile profile) {
		Profile createdProfile = profileDao.save(profile);
		return createdProfile;
	}

	@Override
	public List<Profile> fetchProfiles() {
		List<Profile> list = profileDao.findAll();
		return list;
	}

}
