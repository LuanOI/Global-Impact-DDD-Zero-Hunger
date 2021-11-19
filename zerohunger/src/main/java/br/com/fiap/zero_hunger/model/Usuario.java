package br.com.fiap.zero_hunger.model;

public class Usuario {

    private String email;
    private String senha;

    private boolean usuarioLogado;
    private int idUsuarioLogado;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public Usuario(boolean usuarioLogado, int idUsuarioLogado){
        this.usuarioLogado = usuarioLogado;
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setIdUsuarioLogado(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }
}
