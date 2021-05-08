package com.assistme.svc.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistme.dao.AssistUserRepository;
import com.assistme.dao.UserRoleMapRepository;
import com.assistme.dao.UserRoleRepository;
import com.assistme.dto.AssistUserDto;
import com.assistme.dto.UserRolesDto;
import com.assistme.models.AssistUser;
import com.assistme.models.UserRoleMap;
import com.assistme.models.UserRoles;
import com.assistme.svc.UserDetailsSVC;
import com.assistme.utils.Constants;

@Service
@Transactional
public class UserDetailsSVCImpl implements UserDetailsSVC {
	
	@Autowired
	private AssistUserRepository userDao;
	
	@Autowired
	private UserRoleMapRepository roleMapDao;
	
	@Autowired
	private UserRoleRepository roleDao;
	
	@Override
	public AssistUserDto getUserByUserName(String userName) {
		AssistUser user = userDao.findByUsername(userName);
		if (user != null) {
			AssistUserDto dto = new AssistUserDto();
			List<UserRolesDto> userRoles = new ArrayList<>();
			BeanUtils.copyProperties(user, dto);
			Set<UserRoleMap> rolesMap = user.getUserRoleMaps();
			rolesMap.forEach(map -> {
				UserRoles roles = map.getUserRoles();
				UserRolesDto roleDto = new UserRolesDto();
				BeanUtils.copyProperties(roles, roleDto);
				userRoles.add(roleDto);
			});
			dto.setUserRoles(userRoles);
			return dto;
		}
		return null;
	}

	@Override
	public void updatePin(AssistUserDto assistUserDto) {
		AssistUser user = userDao.findByUsername(assistUserDto.getUserName());
		if (user == null) {
			user = new AssistUser();
			user.setUserName(assistUserDto.getUserName());
			user.setPhoneNum(assistUserDto.getPhoneNum());
			user.setActiveFlg(Boolean.FALSE);
		}
		user.setLoginIp(assistUserDto.getLoginIp());
		user.setLastLoginDt(new Date());
		user.setDeviceId(assistUserDto.getDeviceId());
		userDao.save(user);

	}
	
	@Override
	public void updateUser(AssistUserDto assistUserDto) {
		AssistUser user = userDao.findByUsername(assistUserDto.getUserName());
		if (user != null) {
			user.setActiveFlg(Boolean.TRUE);
			user.setLoginIp(assistUserDto.getLoginIp());
			user.setLastLoginDt(new Date());
			user.setDeviceId(assistUserDto.getDeviceId());
			user.setLastLoginPin(assistUserDto.getLastLoginPin());
			userDao.save(user);
			UserRoles userRoles = roleDao.findById(Constants.ROLE_USER_ID).get();
			UserRoleMap map = new UserRoleMap();
			map.setAssistUser(user);
			map.setUserRoles(userRoles);
			roleMapDao.save(map);
		}

	}

}
