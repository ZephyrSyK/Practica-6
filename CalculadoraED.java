package calcualdora.copy;

import java.util.Scanner;

public class CalculadoraED {

	public static void main(String[] args) {
		
		//Aqui se crea el objeto que traera todas las formulas de la clase 
		//CerebroCalculadoraED, al igual que el escaner para leer lo que introduzca 
		//el usuario lo cual sera almazenado posteriormente en el String "entrada"
		CerebroCalculadoraED cce = new CerebroCalculadoraED();
		Scanner teclado = new Scanner(System.in);
		String entrada;
		
		//Este bucle es la parte que ve el usuario que imprime por pantalla
		//una cabecera y la lista de opciones, pide por pantalla la operacion a 
		//realizar, la cual debe ser valida y cerrara la calculadora con una 
		//despedida cuando se escriba "x"por pantalla
		do {
			imprimirCabecera();
			imprimirSeleccionOp();
			
			entrada = teclado.next();
			if (validarEntrada(entrada)) {
				cce.procesarOperacion(entrada);
			}else {
				System.out.println("Entrada no reconocida");
			}
		} while (!entrada.equals("x"));
		imprimirDespedida();
		teclado.close();
	}
	
	//Esta es la cabecera que se imprime en el bucle anterior
	private static void imprimirCabecera() {
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}
	
	//Esta es la despedida que se imprime en el bucle del inicio
	private static void imprimirDespedida() {
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}
	
	//Aqui se llama a la lista de opciones y se pregunta al usuario
	private static void imprimirSeleccionOp() {
		Operaciones[] ops = Operaciones.values();
		for(Operaciones op: ops)
		{
			System.out.println(op.getOpcionMenu());
	    }
		System.out.println("¿Qué operación desea realizar? (x para terminar)");
	}
	
	//Este bucle valida que la entrada este entre los valores esperados
	private static boolean validarEntrada(String entrada) {
		if (entrada.equals("x")) {
			return true;
		} else {
			boolean opValida = false;
			Operaciones[] ops = Operaciones.values();
			for(Operaciones op: ops)
			{
				if(Integer.toString(op.getId()).equals(entrada)) {
					opValida = true;
				}
		    }
			return opValida;
		}
	}
	
	

}
