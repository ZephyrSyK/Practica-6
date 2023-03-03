package calcualdora.copy;

import java.util.Scanner;

public class CerebroCalculadoraED {

	//Se declaran las variables usadas posteriormente, se inicia el tamaño del 
	//historial y se abre el escaner
	private double resultado = 0;
	private double numero1;
	private double numero2;
	private String[] historial = new String[5];
	Scanner tecladoCce = new Scanner(System.in);

	//Aqui se recibe el parametro recibido y se asigna a su operacion indicada,
	//si no, da un mensaje de error
	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operarHistorial();
			break;
		default:
			System.out.println("Cerrando...");
			break;
		}
	}

	//Pide su informmacion, llama a pedir dos numeros, los suma, muestra 
	//el resultado y lo añade al historial
	public void operarSuma(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir dos numeros, los resta, muestra 
	//el resultado y lo añade al historial
	public void operarResta(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir dos numeros, los multiplica, muestra 
	//el resultado y lo añade al historial
	public void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir dos numeros, los divide, muestra 
	//el resultado y lo añade al historial
	public void operarDivide(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir un numero, lo suma con el resultado 
	//anterior, muestra el resultado y lo añade al historial
	public void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir un numero, lo resta con el resultado 
	//anterior, muestra el resultado y lo añade al historial
	public void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir un numero, lo multiplica con el resultado 
	//anterior, muestra el resultado y lo añade al historial
	public void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion, llama a pedir un numero, lo divide con el resultado 
	//anterior, muestra el resultado y lo añade al historial
	public void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Pide su informmacion y muestra el resultado de la operacion por pantalla
	public void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}
	
	//Pide su informmacion, genera un numero aleatorio entre el 1 y el 100 y 
	//lo muestra por pantalla
	
	public void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		this.resultado = (Math.random()*100+1);
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
	
	//Muestra el historial de operaciones y si no esta completo lo muestra como null
	public void operarHistorial() {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
	
	//Muestra el nombre de la operacion y su informacion asociada
	public void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
	
	//Pide un numero por pantalla al usuario
	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
	
	//Pide dos numeros por pantalla al usuario
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
	
	//Muestra el resultado de la operacion con sus simbolos 
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado) + "\n");
	}
	
	//Añade el resultado de la operacion al historial, si se acaba su espacio
	//elimina el mas antiguo
	public void anadirHistorial(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}
	
	//Genera un historial aleatorio
	public void anadirHistorialAleatorio(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}


}
