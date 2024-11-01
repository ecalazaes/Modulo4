package br.senac.rj.empresa.modelo;

public class Filme {

    private int codFilme;
    private String descFilme;
    private int qtdDisponivel;

    public Filme() {
    }

    public Filme(int codFilme, String descFilme, int qtdDisponivel) {
        this.codFilme = codFilme;
        this.descFilme = descFilme;
        this.qtdDisponivel = qtdDisponivel;
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
        return qtdDisponivel;
    }

    public void setQtdDisponível(int qtdDisponível) {
        this.qtdDisponivel = qtdDisponível;
    }

    public void reservarFilme(int qtd) {
        if (this.qtdDisponivel < qtd) {
            System.out.println("Não há quantidade suficiente!");
            return;
        }
        System.out.println("Filme reservado com sucesso!");
        this.qtdDisponivel -= qtd;
    }

    public void devolverFilme(int qtd) {
        System.out.println("Filme devolvido com sucesso!");
        this.qtdDisponivel += qtd;
    }
}
