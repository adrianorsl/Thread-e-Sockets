package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Iniciando o Servidor");
		ServerSocket servidor = new ServerSocket(12345);
		
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Novo cliente aceito!!! " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			Thread threadCliente = new Thread(distribuirTarefas);
			threadCliente.start();
			
			
		 
		}
	}

}
