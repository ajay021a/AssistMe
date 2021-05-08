package com.assistme.svc;

import com.assistme.dto.AssistUserDto;

public interface UserDetailsSVC {
	
	AssistUserDto getUserByUserName(String userName);

	void updatePin(AssistUserDto assistUserDto);

	void updateUser(AssistUserDto assistUserDto);

}
