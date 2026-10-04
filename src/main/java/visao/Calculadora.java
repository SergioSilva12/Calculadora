package visao;

import javax.swing.*;

public class Calculadora extends JFrame {
    public Calculadora(){

        //Dimensões
        setSize(232,322);

        //Funcionalidade de clicar no botão de fechar e encerrar a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        //Iniciar a aplicação no centro da tela
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        new Calculadora();
    }
}
