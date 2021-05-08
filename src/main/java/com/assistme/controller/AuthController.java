package com.assistme.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistme.beans.JwtResponse;
import com.assistme.beans.MessageResponse;
import com.assistme.components.JwtUtils;
import com.assistme.dto.AssistUserDto;
import com.assistme.req.LoginRequest;
import com.assistme.svc.SmsSvc;
import com.assistme.svc.UserDetailsSVC;
import com.assistme.utils.ServiceUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	SmsSvc smsSVC;

	@Autowired
	private UserDetailsSVC userDetailsService;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/sendPin")
	public ResponseEntity<?> sendPin(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {
		if(!smsSVC.sendSms(loginRequest.getPhoneNumber())) {
			return ResponseEntity.badRequest().body(new MessageResponse("something went wrong..."));
		}
		AssistUserDto assistUserDto = new AssistUserDto();
		assistUserDto.setUserName(loginRequest.getPhoneNumber());
		assistUserDto.setPhoneNum(loginRequest.getPhoneNumber());
		assistUserDto.setDeviceId(loginRequest.getDeviceId());
		assistUserDto.setLoginIp(request.getRemoteAddr());
		userDetailsService.updatePin(assistUserDto);
		return ResponseEntity.ok(new MessageResponse("User pin sent successfully!"));

	}

	@PostMapping("/validate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {
		if(ServiceUtils.isNull(loginRequest.getPin())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid Pin"));
		}
		AssistUserDto assistUserDto = userDetailsService.getUserByUserName(loginRequest.getPhoneNumber());
		System.err.println(assistUserDto);
		if (assistUserDto != null) {
			if(!smsSVC.verification(loginRequest.getPhoneNumber(), loginRequest.getPin())) {
				return ResponseEntity.badRequest().body(new MessageResponse("something went wrong..."));
			}
			assistUserDto.setDeviceId(loginRequest.getDeviceId());
			assistUserDto.setLoginIp(request.getRemoteAddr());
			assistUserDto.setLastLoginPin(loginRequest.getPin());
			userDetailsService.updateUser(assistUserDto);
			String jwt = jwtUtils.generateJwtToken(loginRequest.getPhoneNumber().toString());
			return ResponseEntity.ok(new JwtResponse(jwt));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid user"));
	}

}
