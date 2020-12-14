package application.action;


import java.util.Scanner;

import banque.AgenceBancaire;

public class ActionDeposerArgent<E> implements Action<E> {

    String message;
    String code;


    public ActionDeposerArgent(String message) {
        this.message = message;
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
        
        System.out.println("Saisir le montant à déposer :");
        double depot = scanner.nextDouble();

        ((AgenceBancaire)e).getCompte(num).deposer(depot);
    }

}
