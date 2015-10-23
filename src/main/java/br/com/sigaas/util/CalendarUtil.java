package br.com.sigaas.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	public static Date getAsDate(Calendar calendar) {
		return calendar.getTime();
	}

	public static Calendar getAsCalendar(Date date) {
		Calendar returnCalendar = Calendar.getInstance();
		returnCalendar.setTime(date);
		return returnCalendar;
	}

	public static Date add(int campo, int quantidade, Date date) {
		Calendar aux = getAsCalendar(date);
		aux.add(campo, quantidade);
		return aux.getTime();
	}
}
