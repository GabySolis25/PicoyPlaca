package Metodos;

import java.text.*;
import java.util.*;

public class calculoPicoPlaca {

	public String verificarHora(String hora, String fechai, String placa){
		String resp = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");
			//horarios de inicio y fin de pico y placa.
			String hora1 = "07:00:00";
			String hora2 = "09:30:00";
			String hora3 = "16:00:00";
			String hora4 = "19:30:00";
				
			Date date1, date2, date3, date4, dateNueva;
			date1 = dateFormat.parse(hora1);
			date2 = dateFormat.parse(hora2);
			date3 = dateFormat.parse(hora3);
			date4 = dateFormat.parse(hora4);
			dateNueva = dateFormat.parse(hora);
			//verificar si la hora ingresada esta en el horario del pico y placa
			if (((date1.compareTo(dateNueva) <= 0) && (date2.compareTo(dateNueva) >= 0))||((date3.compareTo(dateNueva) <= 0) && (date4.compareTo(dateNueva) >= 0))){
				//si está dentro de las horas del pico y placa verificar el dia y el ultimo digito de la placa
				int dia1= obtenerDia(fechai);
				resp=verificarPlaca(placa, dia1);
			} else {
				resp= "Si";
			}
		} catch (ParseException parseException){
			parseException.printStackTrace();
		}
		return resp;
	}
	
	//devuelve un digito segun el dia de la semana (0-6)
	public int obtenerDia(String fechai) throws ParseException{
		Date fecha=new SimpleDateFormat("dd/mm/yyyy").parse(fechai);
		int dia= fecha.getDay();
		return dia;
	}
	
	//verifica por dia y por numero de placa si el vehiculo puede circular.
	public String verificarPlaca(String placa, int dia){
		String resp="Si";
		int digito= Integer.parseInt(placa.substring((placa.length()-1), placa.length()));
	      switch(dia) {
	         case 0 :
	        	 if(digito==1||digito==2){
	        		 resp="No";
	        	 }
	            break;
	         case 1 :
	        	 if(digito==3||digito==4){
	        		 resp="No";
	        	 }
		            break;
	         case 2 :
	        	 if(digito==5||digito==6){
	        		 resp="No";
	        	 }
		            break;
	         case 3 :
	        	 if(digito==7||digito==8){
	        		 resp="No";
	        	 }
		            break;
	         case 4 :
	        	 if(digito==9||digito==0){
	        		 resp="No";
	        	 }
		            break;
		     default:
		    	 resp= "Si";
		    }
	      return resp;
	}

}
