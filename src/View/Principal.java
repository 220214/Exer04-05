package View;

import java.io.IOException;

import Controller.Icontroller;
import Controller.Metodos;



public class Principal {

		public static void main(String[] args) {
			
			Icontroller arqCont = new Metodos();
			String path="c:\\TEMP";
			String mari = "SteamCharts.csv";		
			try {
				arqCont.readFile(path, mari);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Metodos m = new Metodos();
		

	}

}
