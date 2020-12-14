package application.actionList;

import java.util.ArrayList;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire<E> implements ActionList<E>{

    private String message;
    private String code;
    private String title;
    private ArrayList<Action<AgenceBancaire>> listActions;

    public ActionListAgenceBancaire(String pfmessage,String pftitle, ArrayList<Action<AgenceBancaire>> pflistActions) {
        this.message = pfmessage;
        this.code = "0";
        this.title = pftitle;
        this.listActions = pflistActions;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(E e) throws Exception {

        while(code != "-1") {
            System.out.println("--");
            System.out.println("Agence "+((AgenceBancaire) e).getNomAgence()+" de "+((AgenceBancaire) e).getLocAgence());
            System.out.println("Menu "+listTitle());
            System.out.println("--");
            System.out.println("\n  Choisir :");

            for (int i = 0; i < listActions.size(); i++) {

                System.out.println("    "+(i+1)+" - "+listActions.get(i).actionMessage());

            }
            System.out.println("\n    0 - Pour quitter ce menu");
            System.out.println("Choisir");
            Scanner scan = new Scanner(System.in);
            int rep = scan.nextInt();

            if(rep != 0) {
                listActions.get(rep-1).execute((AgenceBancaire)e);

            }else {
                code = "-1";
            }
        }
        this.code = "0";
        System.out.println("Fin de "+this.message);



    }

    @Override
    public String listTitle() {
        return this.title;
    }

    @Override
    public int size() {
        return this.listActions.size();
    }

    @Override
    public boolean addAction(Action<E> ac) {
        for (Action<AgenceBancaire> action : listActions) {
            if(ac.actionMessage().equals(action.actionMessage())) {
                return false;
            }
        }
        listActions.add((Action<AgenceBancaire>)ac);
        return true;
    }

}
