package com.alura.foro.answer.service.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alura.foro.answer.CreationAnswerData;
import com.alura.foro.infra.errores.IntegrityValidation;
import com.alura.foro.user.UserRepository;

@Component
public class ExistingUsernameValidation implements AnswerValidations {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void validations(CreationAnswerData creationAnswerData) {

		if(!userRepository.existsByUsername(creationAnswerData.username())) {
			throw new IntegrityValidation("El Usuario ingresado no existe.");
		}
	}

}
