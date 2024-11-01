package br.senac.rj.empresa.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteFilme1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;
        List<Filme> filmes = new ArrayList<>();
        boolean filmeEncontrado;

        do {
            System.out.println("Bem vindo a Locadora de Filmes da Bárbara!");
            System.out.println("Escolha uma opção(1 a 5):");
            System.out.println("1 – Cadastrar Filme");
            System.out.println("2 – Reservar Filme");
            System.out.println("3 – Devolver Filme");
            System.out.println("4 – Consultar disponibilidade");
            System.out.println("5 - Encerrar");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Vamos cadastrar um filme!");

                    System.out.print("Informe o código do filme: ");
                    int codigo = Integer.parseInt(sc.nextLine());

                    System.out.print("Informe a descrição do filme: ");
                    String descricao = sc.nextLine();

                    System.out.print("Informe a quantidade disponivel: ");
                    int qtd = Integer.parseInt(sc.nextLine());

                    Filme filme = new Filme(codigo, descricao, qtd);
                    filmes.add(filme);

                    System.out.println("Filme " + descricao + " cadastrado com sucesso!");
                    System.out.println();

                    break;

                case 2:
                    System.out.println("Vamos reservar um filme!");

                    System.out.print("Informe o código do filme: ");
                    int codigoFilmeReservado = Integer.parseInt(sc.nextLine());

                    System.out.print("Informe a quantidade a ser reservada: ");
                    int qtdReservada = Integer.parseInt(sc.nextLine());

                    filmeEncontrado = false;

                    for (Filme filmeReservado : filmes) {
                        if (filmeReservado.getCodFilme() == codigoFilmeReservado) {
                            filmeReservado.reservarFilme(qtdReservada);
                            filmeEncontrado = true;
                            break;
                        }
                    }

                    if (!filmeEncontrado) {
                        System.out.println("Código do filme não encontrado!");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Vamos devolver um filme!");

                    System.out.print("Informe o código do filme: ");
                    int codigoFilmeDevolvido = Integer.parseInt(sc.nextLine());

                    System.out.print("Informe a quantidade a ser devolvida: ");
                    int qtdDevolvida = Integer.parseInt(sc.nextLine());

                    filmeEncontrado = false;

                    for (Filme filmeDevolvido : filmes) {
                        if (filmeDevolvido.getCodFilme() == codigoFilmeDevolvido) {
                            filmeDevolvido.devolverFilme(qtdDevolvida);
                            filmeEncontrado = true;
                            break;
                        }
                    }

                    if (!filmeEncontrado) {
                        System.out.println("Código do filme não encontrado!");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Lista de Filmes:");
                    System.out.println("----------------------");
                    for (Filme listaFilme : filmes) {
                        System.out.println("Código: " + listaFilme.getCodFilme());
                        System.out.println("Descrição: " + listaFilme.getDescFilme());
                        System.out.println("Quantidade Disponível: " + listaFilme.getQtdDisponível());
                        System.out.println("----------------------");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Encerrando o programa...!");
                    break;

                default:
                    System.out.println("Opcção incorreta, tente novamente...!");
                    System.out.println();
            }
        } while (op != 5);
        sc.close();
    }
}
