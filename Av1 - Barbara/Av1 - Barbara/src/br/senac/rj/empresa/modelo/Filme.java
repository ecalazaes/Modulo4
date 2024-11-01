package br.senac.rj.empresa.modelo;

public class Filme {

    private int codFilme;
    private String descFilme;
    private int qtdDisponível;

    public Filme() {
    }

    public Filme(int codFilme, String descFilme, int qtdDisponível) {
        this.codFilme = codFilme;
        this.descFilme = descFilme;
        this.qtdDisponível = qtdDisponível;
    }

    public int getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(int codFilme) {
        this.codFilme = codFilme;
    }

    public String getDescFilme() {
        return descFilme;
    }

    public void setDescFilme(String descFilme) {
        this.descFilme = descFilme;
    }

    public int getQtdDisponível() {
        return qtdDisponível;
    }

    public void setQtdDisponível(int qtdDisponível) {
        this.qtdDisponível = qtdDisponível;
    }

    public void reservarFilme(int qtd) {
        if (this.qtdDisponível < qtd) {
            System.out.println("Não há quantidade suficiente!");
            return;
        }
        System.out.println("Filme reservado com sucesso!");
        this.qtdDisponível -= qtd;
    }

    public void devolverFilme(int qtd) {
        System.out.println("Filme devolvido com sucesso!");
        this.qtdDisponível += qtd;
    }
}
