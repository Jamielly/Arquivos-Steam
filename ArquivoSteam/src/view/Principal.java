package view;

	import java.io.IOException;

import controller.SteamController;

public class Principal {
	
		public static void main(String[] args) {
			SteamController arqCont = new SteamController();
			String dirwin = "C:\\Windows";
			String path = "C:\\TEMP\\SteamChartss.cvs";
			String nome = "SteamChartss.csv";
			
			try {
				arqCont.readDir(dirwin);
				arqCont.createFile(path, nome);
				arqCont.readFile(path, nome);
				arqCont.openFile(path, nome);
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}

