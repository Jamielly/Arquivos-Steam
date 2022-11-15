package controller;

	import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
	
public class ArquivoController implements SteamController{
		public ArquivoController() {
			super();
		}

		@Override
		public void readDir(String path) throws IOException {
			// TODO Auto-generated method stub
			File dir = new File(path);
			if (dir.exists() && dir.isDirectory()) {
				 File[] files = dir.listFiles();
				 for(File f : files) {
					 System.out.println("     \t"+f.getName());
					System.out.println("<DIR>\t"+f.getName());
				 }
			
			} else {
				throw new IOException("Diretorio invalido");
			}
	}

		@Override
		public void createFile(String path, String nome) throws IOException {
			// TODO Auto-generated method stub
			File dir = new File(path);
			File arq = new File("C:\\TEMP", "nome.csv");
			if(dir.exists() && dir.isDirectory()) {
				boolean existe = false; 
				if (arq.exists()) {
					existe = true;
				}
			String conteudo = geraTxt();
			FileWriter fileWrite = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWrite);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWrite.close();
			} else {
				throw new IOException("Diretorio invalido");
			}
			
		}
		private String geraTxt() {
			StringBuffer buffer = new StringBuffer();
			String linha = "";
			while(!linha.equalsIgnoreCase("fim"));
				linha = JOptionPane.showInputDialog(null, "Digite um frase", 
						"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
				if(linha.equalsIgnoreCase("fim")) {
					buffer.append(linha+"/"+linha+"/"+linha);
				}
				return linha;
		}

		@Override
		public void readFile(String path, String nome) throws IOException {
			// TODO Auto-generated method stub
			File arq = new File(path, nome);
			if(arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { //procura EOF
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				throw new IOException("Arquivo invalido");
			}
		}

		@Override
		public void openFile(String path, String nome) throws IOException {
			// TODO Auto-generated method stub
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				Desktop desktop = Desktop.getDesktop();
				desktop.open(arq);
			} else {
				throw new IOException("Arquivo invalido");
			}
		}

}
