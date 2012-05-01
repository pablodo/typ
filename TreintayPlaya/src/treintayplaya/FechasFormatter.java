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
    
    static String getFechaString(Calendar calendar) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String dia, mes, anio, hr, min, seg;
        dia  = formatter.format(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        mes  = formatter.format(calendar.get(GregorianCalendar.MONTH) + 1);
        anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        hr   = formatter.format(calendar.get(GregorianCalendar.HOUR_OF_DAY));
        min  = formatter.format(calendar.get(GregorianCalendar.MINUTE));
        seg  = formatter.format(calendar.get(GregorianCalendar.SECOND));
            
        return (anio + "-" + mes + "-" + dia  + " " + hr + ":" + min + ":" + seg);
    }
    
    static String getFechaSimpleString(Calendar calendar) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumIntegerDigits(2);
        String dia, mes, anio;
        dia  = formatter.format(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        mes  = formatter.format(calendar.get(GregorianCalendar.MONTH) + 1);
        anio = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        
        return (anio + "-" + mes + "-" + dia);
    }

    static Calendar getFechaCalendar(String fecha) {
        if(fecha.endsWith(".0")){
            fecha = fecha.substring(0, fecha.length()-2);
        }
        int dia, mes, anio, hr, min, seg;
        String[] fechaSplit = fecha.split(" ")[0].split("-");
        String[] horaSplit = fecha.split(" ")[1].split(":");
        anio = Integer.parseInt(fechaSplit[0]);
        mes  = Integer.parseInt(fechaSplit[1]) - 1;
        dia  = Integer.parseInt(fechaSplit[2]);
        hr   = Integer.parseInt(horaSplit[0]);
        min  = Integer.parseInt(horaSplit[1]);
        seg  = Integer.parseInt(horaSplit[2]);
        return new GregorianCalendar(anio, mes, dia, hr, min ,seg);
    }
}
