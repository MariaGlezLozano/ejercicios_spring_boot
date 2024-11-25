package com.ejercicio.estructuras.controlador;

import java.util.Random;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorEjercicios {
	
	
	@PostMapping("/parImpar")
	public String ejercicio1(@RequestParam int numero ) {
		String ret = "";
		if(numero % 2 == 0) {
			ret+="Es par el " + numero;
		}else {
			ret+="Es impar el " + numero;
		}
		
		
		return "<h1>"+ ret +"</h1>";
	}
	
	@PostMapping("/tablaMultiplicar")
	public String ejercicio2(@RequestParam int numero) {
		String mensaje ="";
		for(int i = 1; i<=10; i++){
			mensaje+= numero + " x " + i + " = " + (numero * i ) + "<br>";                                                                
       }
		return mensaje;
	}
	
	@PostMapping("/promedioCalificaciones")
		public String ejercicio3(@RequestParam String calificaciones) {
		String[]calificacionesSeparadas = calificaciones.split(",");
		Double suma = 0.0;
		int contador = 0;
		String nota ="";
		try {
			for (String calificacion : calificacionesSeparadas) {
	            suma += Double.parseDouble(calificacion.trim());
	            contador++;
	        }
		}catch (NumberFormatException e) {
	        return "Error: Por favor, ingresa solo números separados por comas.";
	    }		
		double promedio = suma / contador; // Calcular promedio
		nota = promedio >= 5 ? "¡Aprobado! Promedio: " + promedio : "Suspendido. Promedio: " + promedio;
       return nota;
	}
	
	@PostMapping("/calcularIMC")
		public String ejercicio4(@RequestParam double peso, double altura) {
		double imc = peso / (altura * altura);
		String categoria ="";
		if(imc < 18.5) {
			categoria = "Esta usted en bajo peso";
		}else if(imc>=18.5 && imc <=24.9) {
			categoria = "está usted en normopeso";
		}else if(imc>=25 && imc <=29.9) {
			categoria ="Está usted en sobrepeso";
		}else if(imc >=30) {
			categoria ="está usted en obesidad";
		}
		return categoria;
	}
	
	@PostMapping("/encuesta")
	public String ejercicio5(@RequestParam int satisfaccion) {
		String resulatdo="";
		switch(satisfaccion) {
			case 1: 
				resulatdo = "<h2> Ha marcado usted la opción "+ satisfaccion + ".<br> Sentimos que no esté nada satisfecho.<br> Disculpe nuestros errores.</h2>";
				break;
			case 2:
				resulatdo = "<h2> Ha marcado usted la opción "+ satisfaccion + ".<br> Sentimos que solo esté un poco satisfecho.<br> Disculpe nuestros errores.</h2>";
				break;
			case 3:
				resulatdo = "<h2> Ha marcado usted la opción "+ satisfaccion + ".<br> Agradecemos su respuesta.<br> Intentaremos mejorar.</h2>";
				break;
			case 4:
				resulatdo = "<h2> Ha marcado usted la opción "+ satisfaccion + ".<br> Agradecemos su respuesta.<br> Nos falta poco para llegar a la excelencia.</h2>";
				break;
			case 5:
				resulatdo = "<h2> Ha marcado usted la opción "+ satisfaccion + ".<br> Gracias por su votación.<br> Nos encanta que esté satisfecho con nuestro servicio.</h2>";
				break;
		}
		return resulatdo;
	}
	
	@PostMapping("/generarContrasena")
	public String ejercicio6(@RequestParam int longitud, Model model) {
		 String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
		 String contrasenyaMensaje="";
		 if(longitud<=0) {
			 model.addAttribute("error", "Debe introducir un número mayor que 0.");
			 return "<h1>Debe introducir un número mayor que 0.</h1>";
			 //System.out.println("Debe introducir un número mayor que 0.");
		 }
		 StringBuilder contrasenya = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < longitud; i++) {
	            int index = random.nextInt(caracteres.length());
	            contrasenya.append(caracteres.charAt(index));
	        }	        
	        
	        return "<h2>La longitud elegida para la contraseña es "+ longitud+
	        		"<br>Tu contraseña generada es: " + contrasenya.toString() +"</h2>";
	}
	
	@PostMapping("/sumatoria")
	public String ejercicio7(@RequestParam int numero) {
		int sumaTotal=0;
		for(int i=1;i<=numero;i++) {
			sumaTotal += i;
		}
		String resultado = String.valueOf(sumaTotal);
		return "<h2> La suma es= " + resultado + "</h2>";
	}
	
	@PostMapping("/factorial")
	public String ejercicio8(@RequestParam int numero) {
		 long factorial = 1;
	        for (int i = 1; i <= numero; i++) {
	            factorial *= i;
	        }
	        return "<h2>El calculo del factorial introducido es: " + factorial + "</h2>";
	}

}
	