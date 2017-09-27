package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

public class UserConverter implements Converter<String, User>{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User convert(String source) {
		return userRepository.getById(Long.parseLong(source));
	}
}
