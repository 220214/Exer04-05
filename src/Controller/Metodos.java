package Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Metodos implements Icontroller {

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
			while (!linha.equalsIgnoreCase("fim")) {
				linha = JOptionPane.showInputDialog(null,"Digite uma Frase","ENTRADA de texto", JOptionPane.INFORMATION_MESSAGE);
					if (!linha.equalsIgnoreCase("fim")) {
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
				
				while (linha != null) {
					String[] vet = linha.split(",");
					for(int j =0;j<86790;j++) {
					for( int i=0;i<vet.length;i++) {
						
							if(vet[0]==vet[j]) {
								System.out.println(vet[i]);
							}
						}
					}
					
					
					//System.out.println("\t\t\n" +vetLinha[0] + " \t\t\t " +  vetLinha[1] + " \t\t" + vetLinha[2] + " \t\t" + vetLinha[3]
						//	+ "   \t\t" + vetLinha[4]+ "\t\t" + vetLinha[5] + "\t\t" + vetLinha[6]);
					//linha = buffer.readLine();
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
