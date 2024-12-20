/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JanelaPrincipalLivro extends JanelaVisualizarLivro {

    @Override
    protected void montarCabecalho() {
        super.montarCabecalho();
        Vector colunas = this.obterNomeColunasTabela();
        int qtMenus = colunas.size() * 2;
        System.out.println(" " + (qtMenus + 1) + ") Incluir Novo Livro");
        System.out.println(" " + (qtMenus + 2) + ") Alterar Livro");
        System.out.println(" " + (qtMenus + 3) + ") Excluir Livro");
    }

    private Vector lerDados() {
        System.out.println("===========================================================================================================");
        System.out.println("Digite os seguintes dados: ");
        Vector colunas = this.obterNomeColunasTabela();
        Scanner leitor = new Scanner(System.in);
        Vector dados = new Vector();
        String valor;
        for (int i = 0; i < colunas.size(); i++) {
            System.out.println(colunas.get(i));
            valor = leitor.next();
            dados.add(valor);
        }
        System.out.println("");
        System.out.println("===========================================================================================================");
        return dados;
    }



    @Override
    public void executar() {
        Vector colunas = this.obterNomeColunasTabela();
        Scanner leitorOpcao = new Scanner(System.in);
        int opcao;
        int qtMenus = colunas.size() * 2;
        do {
            this.montarLayout();

            opcao = leitorOpcao.nextInt();
            // sair
            if (opcao == 0) {
                break;
            } // ordenação
            else if (opcao <= qtMenus) {
                limparTabelaLivros();
                this.coluna = (String) colunas.get((opcao - 1) / 2);
                if ((opcao % 2) == 1) {
                    this.crescente = true;
                } else {
                    this.crescente = false;
                }
            } // incluir
            else if (opcao == qtMenus + 1) {
                limparTabelaLivros();
                Vector dados = lerDados();
                try {
                    this.controladora.inserirNovoLivro(dados);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ARQUIVO NÃO ENCONTRADO", ex);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "FALHA NA ENTRADA DE DADOS", ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "CLASSE NÃO ENCONTRADA", ex);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ERRO AO ACESSAR REGIÃO DE MEMORIA NÃO DISPONIVEL");
                }

            } // alterar
            else if (opcao == qtMenus + 2) {
                System.out.println("Digite o número da linha que deseja alterar: ");
                this.controladora.setMarcador(leitorOpcao.nextInt());
                limparTabelaLivros();
                Vector dados = lerDados();
                try {
                    this.controladora.alterarLivro(dados);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ARQUIVO NÃO ENCONTRADO", ex);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "FALHA NA ENTRADA DE DADOS", ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "CLASSE NÃO ENCONTRADA", ex);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ERRO AO ACESSAR REGIÃO DE MEMORIA NÃO DISPONIVEL");
                }

            } // excluir
            else if (opcao == qtMenus + 3) {
                System.out.println("Digite o número da linha que deseja excluir: ");
                this.controladora.setMarcador(leitorOpcao.nextInt());
                try {
                    this.controladora.excluirLivro();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ARQUIVO NÃO ENCONTRADO", ex);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "FALHA NA ENTRADA DE DADOS", ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "CLASSE NÃO ENCONTRADA", ex);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(JanelaPrincipalLivro.class.getName()).log(Level.SEVERE, "ERRO AO ACESSAR REGIÃO DE MEMORIA NÃO DISPONIVEL");
                }

                limparTabelaLivros();

            } else {
                System.out.println("Falha GERAL");
            }


        } while (true);
        leitorOpcao.close();
    }
}
