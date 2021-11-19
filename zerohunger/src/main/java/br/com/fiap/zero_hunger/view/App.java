package br.com.fiap.zero_hunger.view;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 *  Classe responsável pela criação da interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane = new JPanel();
    private JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
    private JPanel abaCadastrar = new PainelCadastrar(this);
    private JPanel abaLogin = new PainelLogin(this);
    private JPanel abaDivulgar = new PainelDivulgar();
    private JPanel abaVisualizar = new PainelVisualizar();

    boolean isUsuarioLogado = false;
    int idUsuarioLogado;

    /**
     * Método que cria a interface gráfica da aplicação.
     */
    public App() {

        setTitle("Zero Hunger");
        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 857, 627);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(abas);

        abas.setBounds(0, 0, 835, 593);
        abas.addTab("Cadastrar", null, abaCadastrar, null);
        abas.addTab("Login", null, abaLogin, null);
        abas.addTab("Divulgar Produto", null, abaDivulgar, null);
        abas.addTab("Visualizar Produto", null, abaVisualizar, null);


        abas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //abaVisualizar.clearCampos();
                if(abas.getSelectedIndex() == 2 || abas.getSelectedIndex() == 3){
                    if(!isUsuarioLogado){
                        mostrarMensagem("Usuário não logado. Favor realizar o login " +
                                        "para divulgar ou visualizar um produto!", "Usuário não logado",
                                JOptionPane.INFORMATION_MESSAGE);
                        abas.setSelectedIndex(1);
                        abas.setEnabledAt(2, false);
                        abas.setEnabledAt(3, false);
                    } else {
                        abas.setEnabledAt(2, true);
                        abas.setEnabledAt(3, true);

                    }
                }
            }
        });
    }

    /**
     * Método que mostra todas as mensagens da aplicação.
     * @param mensagem - texto da mensagem.
     * @param titulo - título da mensage,
     * @param tipo - tipo da mensagem.
     */
    public void mostrarMensagem(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);
    }

    /**
     * Método que verifica se o usuário está logado na aplicação.
     * @param isUsuarioLogado - boolean
     */
    public void isLogado(boolean isUsuarioLogado){
        this.isUsuarioLogado= isUsuarioLogado;
    }

    /**
     * Método que retorna o id do usuário que está logado na aplicação.
     * @return - id do usuário logado
     */
    public int getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    /**
     * Método que altera a variável com o id do usuário logado.
     * @param idUsuarioLogado - id do usuário logado.
     */
    public void setIdUsuarioLogado(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public boolean isUsuarioLogado() {
        return isUsuarioLogado;
    }

    /**
     * Método que retorna as abas da interface gráfica.
     * @return - abas da interface gráfica.
     */
    public JTabbedPane getAbas() {
        return abas;
    }
}
