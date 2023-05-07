package View;

import java.io.IOException;

import Controller.Icontroller;
import Controller.Metodos;



public class Principal {

		public static void main(String[] args) {
			
			Icontroller arqCont = new Metodos();
			String path="c:\\TEMP";
			String mari = "SteamCharts.csv";
			String mari1="Nome.csv";
			try {
				arqCont.createFile(path, mari1);
				arqCont.readFile(path, mari);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Metodos m = new Metodos();
		

	}

}
