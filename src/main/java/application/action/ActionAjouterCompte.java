package application.action;


import java.util.Scanner;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionAjouterCompte<E> implements Action<E>{
    private String message;
    private String code;

    public ActionAjouterCompte(String pfMessage) {
        this.message = pfMessage;
        this.code = "0";
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(E e) throws Exception {
        System.out.println("Saisir le numéro du compte :");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println("Saisir le propriétaire du compte :");

        String proprietaire = scanner.nextLine();

        Compte c = new Compte(num,proprietaire);
        ((AgenceBancaire) e).addCompte(c);




    }
}