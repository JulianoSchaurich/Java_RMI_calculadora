
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServidor implements Calculadora {

	public CalculadoraServidor() {
	}

	public double somar(double valor1, double valor2) {
		return valor1 + valor2;
	}
	
	public double subtrair(double valor1, double valor2) {
		return valor1 - valor2;
	}
	
	public double multiplicar(double valor1, double valor2) {
		return valor1 * valor2;
	}
	
	public double dividir(double valor1, double valor2) {
		return valor1 / valor2;
	}

	public static void main(String[] args) {
		try {
			
			//Criação do objeto remoto
			CalculadoraServidor obj = new CalculadoraServidor();
			
			//Exportação do objeto remoto.
			Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

			//Registro do objeto remoto com RMI Registry.
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Calculadora", stub);

			System.err.println("Servidor está pronto...");

		} catch (Exception e) {
			System.err.println("Exceção no Servidor:" + e.toString());
			e.printStackTrace();
		}
	}

}
