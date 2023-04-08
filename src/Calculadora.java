

import java.rmi.Remote;
import java.rmi.RemoteException;

//Interface precisa extender a classe Remote
public interface Calculadora extends Remote {
	
	//método digaOla() será chamado remotamente. É necessário lançar a exceção RemoteException
	double somar(double valor1, double valor2) throws RemoteException;
	double subtrair(double valor1, double valor2) throws RemoteException;
	double multiplicar(double valor1, double valor2) throws RemoteException;
	double dividir(double valor1, double valor2) throws RemoteException;
}
