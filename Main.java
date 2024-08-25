package view;
import controller.RedesController; 
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Configuração de IP", "Ping", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            RedesController redesController = new RedesController();

            switch (choice) {
                case 0:
                    redesController.ip();
                    break;
                case 1: 
                    redesController.ping();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
}
