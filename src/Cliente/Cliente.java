package Cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("conexão estabelecida");
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(socket.getOutputStream());

		
			String texto = teclado.nextLine();
			saida.println(texto);
			
			Scanner saidaCliente = new Scanner(socket.getInputStream());
			String saidaTexto = saidaCliente.nextLine();
			System.out.println(saidaTexto);

		
		saida.close();
		teclado.close();
		socket.close();
	}

}
