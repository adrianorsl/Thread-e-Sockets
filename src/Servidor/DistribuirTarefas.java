package Servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
		
	}

	@Override
	public void run() {
		
		try {
			System.out.println("Distribuindo Tarefas para " + socket.getPort());
			
			
			
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			
			while(entradaCliente.hasNextLine()) {
				Busca dna = new Busca();
				String texto = entradaCliente.nextLine();
				String texto2 = dna.lerLinha2(texto);
				System.out.println(texto2);
				PrintStream saida = new PrintStream(socket.getOutputStream());
				saida.println(texto2);
			}
			
			entradaCliente.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conexão terminada para " +  + socket.getPort());

	}

}
