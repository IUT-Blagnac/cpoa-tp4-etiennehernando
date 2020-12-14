package application.action;

import java.util.Scanner;

import banque.AgenceBancaire;

public class ActionRetirerArgent<E> implements Action<E>{
    String message;
    String code;


    public ActionRetirerArgent(String message) {
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
        
        System.out.println("Saisir le montant à retirer :");
        double reti = scanner.nextDouble();

        ((AgenceBancaire)e).getCompte(num).retirer(reti);

    }
}