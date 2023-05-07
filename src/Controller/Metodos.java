package Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;





public  class Metodos implements Icontroller {

	public Metodos() {

			super();
		}
		@Override
		//procurar arquivo
		public void readDir(String path) throws IOException {
			File dir = new File(path);
			if (dir.exists() && dir.isDirectory() ) {
				File[] vetFiles = dir.listFiles();
				for (File f : vetFiles) {
					if (f.isDirectory()) {
						System.out.println("     \t"+f.getName());
					} else {
						System.out.println(" <DIR>   \t"+f.getName());
					}
				}
			}else {
				throw new IOException(" Diretorio Inválido");
			}
		}
		
		@Override
		//Criando Arquivo
		public void createFile(String path, String arquivo) throws IOException {
			File dir = new File(path);
			File arq = new File(path, arquivo );
			if (dir.exists() && dir.isDirectory()) {
				boolean existe = false;
				if (arq.exists()) {
					existe = true;
				}
				String conteudo = geraTXt();
				FileWriter abre = new FileWriter(arq, existe);
				PrintWriter escreve = new PrintWriter(abre);
				escreve.write(conteudo);
				escreve.flush();//finalizar 
				escreve.close();
				abre.close();//fecha arquivo
			} else {
				throw new IOException("Diretório Inválido");
			}
			
		}
		private String geraTXt() {
			StringBuffer buffer = new StringBuffer();
			
			String linha = "";
			while (!linha.equalsIgnoreCase("")) {
				linha = "linha1";
					if (!linha.equalsIgnoreCase(" ")) {
					buffer.append(linha+"\r\n");
				}
			}
			return buffer.toString();
		}
			//Buscar dados
		
			@Override
		public void readFile(String path, String arquivo) throws IOException {
			File arq = new File(path, arquivo);
			if (arq.exists() && arq.isFile()) {
				FileInputStream abreFluxoArq = 	new FileInputStream(arq);
				InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
				BufferedReader buffer = new BufferedReader(leitorFluxo);
				String linha = buffer.readLine();
				
				String nome = null;
				String ano =null;
				String mes = null;
				String avg =null;
				
				while (linha != null) {
					String[] vet = linha.split(",");
					String nome1= vet[0];
					String ano1 =vet[1];
					String mes1 = vet[2];
					String avg1 = vet[3];
					
					
					if(nome==null) {
						nome=vet[0];
						 ano=vet[1];
						 mes = vet[2];
						 avg =vet[3];
					}
					 if( nome==nome1 ||ano==ano1 || mes==mes1 ) {
						
							System.out.println("Nome do jogo: "+ nome+ " "  + " \t\t ano: "+ ano1
						+ "\t\t mes "+ mes1 + "\t\t Avg: "+ avg1 );
						linha = buffer.readLine();
						
						
					}else {
						nome = null;
					
					}
				}
										
				
				buffer.close();
				leitorFluxo.close();
				abreFluxoArq.close();
			}else {
				throw new IOException("Arquivo Inválido");
			}
		}
			
		
		
	
		@Override
		public void openFile(String path, String arquivo) throws IOException {
			
			File arq = new File(path, arquivo);
			if (arq.exists() && arq.isFile()) {
				Desktop desktop = Desktop.getDesktop();
				desktop.open(arq);
			}else {
				throw new IOException("Arquivo Inválido");
				}
			
		}
		

}
