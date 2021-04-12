package dmacc.controller;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {
	
	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
		// TODO Auto-generated method stub
		return (attribute == null ? null : Time.valueOf(attribute));
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		// TODO Auto-generated method stub
		return (dbData == null ? null : dbData.toLocalTime());
	}
}