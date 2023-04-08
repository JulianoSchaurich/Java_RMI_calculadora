

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteCalculadora {

	private ClienteCalculadora() {
	}

	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];
		
		try {			
			//Obtém o stub para registro
			Registry registry = LocateRegistry.getRegistry(host);
			
			//Obtém o stub para o objeto remoto (Ola) do registro.
			Calculadora stub = (Calculadora) registry.lookup("Calculadora");
				
			Scanner s = new Scanner(System.in);
			
			System.out.println("Valor 1:");
			double valor1 = s.nextDouble();
			
			System.out.println("Valor 2:");
			double valor2 = s.nextDouble();
			
			//Invocação do método remoto
			double valorSoma = stub.somar(valor1, valor2);
			System.out.println("Soma: " + valorSoma);
			
			double valorSubtrair = stub.subtrair(valor1, valor2);
			System.out.println("Subtrair: " + valorSubtrair);
			
			double valorMultiplicar = stub.multiplicar(valor1, valor2);
			System.out.println("Multiplicar: " + valorMultiplicar);
			
			if(valor2 == 0){
				System.out.println("Não existe divisão por 0");
			}
			else{
				double valorDividir = stub.dividir(valor1, valor2);
				System.out.println("Dividir: " + valorDividir);
			}		

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exceção do cliente: " + e.toString());
		}
	}
}
