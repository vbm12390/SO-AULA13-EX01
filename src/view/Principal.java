package view;

import javax.swing.JOptionPane;
import controller.SteamController;

public class Principal {
	public static void main(String[] args) {
		SteamController Steam = new SteamController();
		JOptionPane.showMessageDialog(null, "Algoritimo para buscar media de jogadores Steam");
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o Ano desejado"));
		int mes = 0;
		while (true) {
			mes = Integer.parseInt(JOptionPane.showInputDialog("Selecione o mês desejado:\n" + "1 - Janeiro\r\n"
					+ "2 - Fevereiro\r\n" + "3 - Março\r\n" + "4 - Abril\r\n" + "5 - Maio\r\n" + "6 - Junho\r\n"
					+ "7 - Julho\r\n" + "8 - Agosto\r\n" + "9 - Setembro\r\n" + "10 - Outubro\r\n" + "11 - Novembro\r\n"
					+ "12 - Dezembro\r\n" + ""));
			if (mes < 1 || mes > 12) {
				JOptionPane.showMessageDialog(null, "Mês Invalido ");
			} else {
				break;
			}
		}
		int media = Integer.parseInt(JOptionPane.showInputDialog("Digite a Media de jogadores "));
		String mes_escrito = Steam.DeterminarMes(mes);
		Steam.Find(ano, mes_escrito, media);
	}

}