package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {

	public void Find(int ano, String mes_escrito, int media) {

		try {
			String conteudo = "";
			conteudo = leArquivo(ano, mes_escrito, media);
			geraArquivo(conteudo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String leArquivo(int ano, String mes_escrito, int media) throws IOException {
		StringBuffer buffer_saida = new StringBuffer();
		String caminho = "C:\\Users\\vinicius\\Desktop\\Eclipse";
		String arquivo = "SteamCharts.csv";
		File arq = new File(caminho, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			System.out.println("Ano Selecionado: " + ano + " Mês Selecionado: " + mes_escrito
					+ " Media de jogadores Selecionado: " + media);
			while (linha != null) {
				if (linha.contains(";")) {
					String[] vetLinha = linha.split(";");
					int date = Integer.parseInt(vetLinha[1]);
					if (date == ano) {
						String month = vetLinha[2];
						if (month.equals(mes_escrito)) {
							Double avg = Double.parseDouble(vetLinha[3]);
							if (avg >= media) {
								System.out.print("Nome jogo: " + vetLinha[0].substring(1));
								System.out.println(" Media jogadores: " + vetLinha[3]);
								String conteudo = "";
								conteudo = vetLinha[0] + "," + vetLinha[3];
								conteudo = conteudo.substring(1);
								buffer_saida.append(conteudo+"\r\n");
							}
						}
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
		return buffer_saida.toString();
	}

	public void geraArquivo(String conteudo) throws IOException {
		String caminho = "C:\\TEMP";
		String arquivo = "nome.csv";
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, arquivo);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			escrita(arq, existe, conteudo);
		} else {
			throw new IOException("Diretório inválido");
		}

	}

	private void escrita(File arq, boolean existe, String conteudo) throws IOException {
		FileWriter abreArquivo = new FileWriter(arq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArquivo);
		escreveArq.write(conteudo);
		escreveArq.close();
		abreArquivo.close();
		escreveArq.flush();
	}

	public String DeterminarMes(int mes) {
		String mes_escrito = "";
		switch (mes) {
		case 1:
			mes_escrito = "January";
			break;
		case 2:
			mes_escrito = "February";
			break;
		case 3:
			mes_escrito = "March";
			break;
		case 4:
			mes_escrito = "April";
			break;
		case 5:
			mes_escrito = "May";
			break;
		case 6:
			mes_escrito = "June";
			break;
		case 7:
			mes_escrito = "July";
			break;
		case 8:
			mes_escrito = "August";
			break;
		case 9:
			mes_escrito = "September";
			break;
		case 10:
			mes_escrito = "October";
			break;
		case 11:
			mes_escrito = "November";
			break;
		case 12:
			mes_escrito = "December";
			break;
		}
		return mes_escrito;

	}

}