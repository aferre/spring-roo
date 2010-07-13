package org.springframework.roo.shell.converters;

import java.util.List;
import java.util.Locale;

import org.springframework.roo.shell.Converter;
import org.springframework.roo.shell.MethodTarget;

/**
 * {@link Converter} for {@link Locale}. Supports locales
 * with ISO-639 (ie 'en') or a combination of ISO-639 and 
 * ISO-3166 (ie 'en_AU').
 *
 * @author Stefan Schmidt
 * @since 1.1
 *
 */
public class LocaleConverter implements Converter {

	public Object convertFromText(String value, Class<?> requiredType, String optionContext) {
		if (value.length() == 2) {
			System.out.println();
			return new Locale(value); 
		} else if (value.length() == 5) {
			String[] split = value.split("_");
			return new Locale(split[0], split[1]);
		} else {
			return null;
		}
	}

	public boolean getAllPossibleValues(List<String> completions, Class<?> requiredType, String existingData, String optionContext, MethodTarget target) {
		return false;
	}

	public boolean supports(Class<?> requiredType, String optionContext) {
		return Locale.class.isAssignableFrom(requiredType);
	}

}