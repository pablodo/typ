/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author administrador
 */
class FechasFormatter {

	private final static String sep = "-";
    
    static String getFechaString(Calendar calendar) {
		if (calendar == null)
			return "";
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String dia, mes, anio, hr, min, seg;
        dia  = formatter.format(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        mes  = formatter.format(calendar.get(GregorianCalendar.MONTH) + 1);
        anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        hr   = formatter.format(calendar.get(GregorianCalendar.HOUR_OF_DAY));
        min  = formatter.format(calendar.get(GregorianCalendar.MINUTE));
        seg  = formatter.format(calendar.get(GregorianCalendar.SECOND));
            
        return (anio + sep + mes + sep + dia  + sep + hr + ":" + min + ":" + seg);
    }
    
    static String getFechaSimpleString(Calendar calendar) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String dia, mes, anio;
        dia  = formatter.format(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        mes  = formatter.format(calendar.get(GregorianCalendar.MONTH) + 1);
        anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        
        return (dia + sep + mes + sep + anio);
    }
    
    static String getFechaSimpleString(String fecha) {
        fecha = getFechaFromMySQL(fecha);
		fecha = fecha.split(" ")[0]; 
		String dia, mes, anio;
        dia  = fecha.split(sep)[2]; 
        mes  = fecha.split(sep)[1];
        anio = fecha.split(sep)[0];
        return (dia + sep + mes + sep + anio);
    }

    static Calendar getFechaCalendar(String fecha) {
        fecha = getFechaFromMySQL(fecha);
        int dia, mes, anio, hr, min, seg;
        String[] fechaSplit = fecha.split(" ")[0].split(sep);
        String[] horaSplit = fecha.split(" ")[1].split(":");
        anio = Integer.parseInt(fechaSplit[0]);
        mes  = Integer.parseInt(fechaSplit[1]) - 1;
        dia  = Integer.parseInt(fechaSplit[2]);
        hr   = Integer.parseInt(horaSplit[0]);
        min  = Integer.parseInt(horaSplit[1]);
        seg  = Integer.parseInt(horaSplit[2]);
        return new GregorianCalendar(anio, mes, dia, hr, min ,seg);
    }
    
    static String getFechaFromMySQL(String fecha){
		if (fecha == null)
			return "";
        if(fecha.endsWith(".0")){
            fecha = fecha.substring(0, fecha.length()-2);
        }
        return fecha;
    }

    static String getFechaToMySQL(Calendar calendar) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String dia, mes, anio;
        dia  = formatter.format(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        mes  = formatter.format(calendar.get(GregorianCalendar.MONTH) + 1);
        anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        
        return (anio + sep + mes + sep + dia);
    }

    static String getFechaToMySQL(String fecha) {
		//Suponemos que recibimos una fecha con formato dd-mm-aaaa
        String dia, mes, anio;
        dia  = fecha.split(sep)[0]; 
        mes  = fecha.split(sep)[1];
        anio = fecha.split(sep)[2];
        
        return (anio + sep + mes + sep + dia);
    }
    
    static long getTimeFromFecha(String fecha) {
        fecha = getFechaFromMySQL(fecha);
        Calendar calendar = getFechaCalendar(fecha);
        return calendar.getTimeInMillis();
    }

    static GregorianCalendar getMaxToday() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR),
                                         calendar.get(Calendar.MONTH),
                                         calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar;
    }
}
