import java.util.Scanner;

public class Aplicacao {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArquivoTextoEscrita type = new ArquivoTextoEscrita();
		ArquivoTextoLeitura read = new ArquivoTextoLeitura();
		Criptografe cript = new Criptografe();
		String text, name_arc, cod, decod;
		int qtde = 0;
		
		//� DADO O NOME PARA O ARQUIVO ONDE SER� GRAVADO O TEXTO DE ENTRADA
		System.out.print("Type the name of archive: ");
		name_arc = input.nextLine();
		type.abrirArquivo(name_arc);
		
		//EST� SENDO FEITO A ENTRADA DO TEXTO, E S� IR� PARAR QUANDO O USU�RIO DIGITAR A PALAVRA FIM
		//ASSIM QUE TERMINAR, O ARQUIVO SER� FECHADO
		System.out.print("Type the text, type 'fim.' to finish: ");
		do {
			text = input.nextLine();
			type.escrever(text);
			qtde += text.length();
		}while(!text.equals("fim."));
		type.fecharArquivo();
		read.abrirArquivo(name_arc);
		
		//AQUI EST� SENDO FEITO A CHAMADA PARA SER IMPRESSSO O TEXTO SALVO NO AQRUIVO TXT
		System.out.print("\nText written at the archive: ");
		do {
			text = read.ler();
			
			if(text == null)
				System.out.print("\n\t\tText imprinted completely!");
			else
				System.out.print("\n\t" + text);
		}while(text != null);
		read.fecharArquivo();
		
		//PROCESSO PARA CRIPTOGRAFAR O TEXTO ENTRADO ANTERIORMENTE
		//� PEDIDO AO USU�RIO UM NOVO NOME PARA ARMAZENA O TEXTO CRIPTOGRAFADO
		//� PASSADO POR PAR�METRO O NOME DO ARQUIVO QUE VAI SER CRIPTOGRAFADO, A QUANTIDADE DE LETRAS ARAMZANADOS NO
		//ARQUIVO, E O NOME DO NOVO ARQUIVO
		//LOGO DEPOIS � IMPRESSO O TEXTO CRIPTOGRAFADO
		System.out.print("\nName of a new archive to encrypt: ");
		cod = input.nextLine();
		cript.criptografar(name_arc, qtde, cod);
		System.out.print("Text crypted: ");
		read.abrirArquivo(cod);
		do {
			text = read.ler();
			
			if(text == null)
				System.out.print("\n\n");
			else
				System.out.print("\n\t" + text);
		}while(text != null);
		read.fecharArquivo();
		
		//PROCESSO PARA DESCRIPTOGRAFAR O TEXTO CRIPTOGRAFADO
		//� PEDIDO AO USU�RIO UM NOVO NOME PARA ARMAZENA O TEXTO DESCRIPTOGRAFADO
		//� PASSADO POR PAR�METRO O NOME DO ARQUIVO QUE VAI SER DESCRIPTOGRAFADO, A QUANTIDADE DE LETRAS ARAMZANADOS NO
		//ARQUIVO, E O NOME DO NOVO ARQUIVO
		//LOGO DEPOIS � IMPRESSO O TEXTO DESCRIPTOGRAFADO, SENDO QUE ELE TEM SER IGUAL AO TEXTO ORIGINAL,
		//ENTRADO LOGO DO COME�O
		System.out.print("\nName of the new archive to decrypt: ");
		decod = input.nextLine();
		cript.descriptografar(cod, qtde, decod);
		System.out.print("Text decrypted: ");
		read.abrirArquivo(decod);
		do {
			text = read.ler();
			
			if(text == null)
				System.out.print("\n\n");
			else
				System.out.print("\n\t" + text);
		}while(text != null);
		read.fecharArquivo();
	}

}
