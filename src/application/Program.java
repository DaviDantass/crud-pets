package application;

import exception.InvalidPetException;
import exception.PetNotFoundException;
import model.Pet;
import repository.PetRepository;
import service.PetService;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        PetRepository repo = new PetRepository();
        PetService service = new PetService(repo);
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n--- MENU PET ---");
            System.out.println("1 - Adicionar pet");
            System.out.println("2 - Listar pets");
            System.out.println("3 - Buscar pet por ID");
            System.out.println("4 - Atualizar pet");
            System.out.println("5 - Remover pet");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();
                        service.adicionarPet(new Pet(null, nome, tipo)); // ID será gerado automaticamente
                        System.out.println("Pet adicionado!");
                        break;

                    case 2:
                        service.buscarTodos().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("ID: ");
                        Long idBusca = sc.nextLong();
                        sc.nextLine();
                        System.out.println(service.buscarPetPorId(idBusca));
                        break;

                    case 4:
                        System.out.print("ID do pet a atualizar: ");
                        Long idAtt = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo tipo: ");
                        String novoTipo = sc.nextLine();
                        service.atualizarPet(idAtt, new Pet(null, novoNome, novoTipo));
                        System.out.println("Pet atualizado!");
                        break;
                    case 5:
                        System.out.print("ID do pet a remover: ");
                        Long idDel = sc.nextLong();
                        sc.nextLine();
                        service.removerPetPorId(idDel);
                        System.out.println("Pet removido!");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (PetNotFoundException | InvalidPetException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
        sc.close();
    }
}

