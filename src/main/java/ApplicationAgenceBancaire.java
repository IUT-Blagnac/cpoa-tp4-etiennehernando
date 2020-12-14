
import java.util.ArrayList;

import application.action.Action;
import application.action.ActionAjouterCompte;
import application.action.ActionDeposerArgent;
import application.action.ActionList;
import application.action.ActionListeDesComptes;
import application.action.ActionRetirerArgent;
import application.action.ActionSupprimerCompte;
import application.action.ActionVoirCompteNumero;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class ApplicationAgenceBancaire {



	public static void main(String argv[]) {
		AgenceBancaire ab = new AgenceBancaire("Caisse Ecureuil", "Pibrac");
		Action<AgenceBancaire> ac1 = new ActionListeDesComptes<AgenceBancaire>("Afficher les comptes de l'agence");
		Action<AgenceBancaire> ac2 = new ActionDeposerArgent<>("Deposer");
		Action<AgenceBancaire> ac3 = new ActionRetirerArgent<>("Retirer");
		Action<AgenceBancaire> ac4 = new ActionVoirCompteNumero<AgenceBancaire>("Afficher le compte (par son numéro)");	
		Action<AgenceBancaire> ac5 = new ActionAjouterCompte<>("Ajouter un compte");
		Action<AgenceBancaire> ac6 = new ActionSupprimerCompte<>("Supprimer un compte");
		

		ArrayList<Action<AgenceBancaire>> liste1 = new ArrayList<>();
		ArrayList<Action<AgenceBancaire>> liste2 = new ArrayList<>();
		

		liste1.add(ac2);
		liste1.add(ac3);
		
		Action<AgenceBancaire> m1 = new ActionListAgenceBancaire<>("Afficher le menu des opérations de comptes", "Opérations comptes", liste1);

		
		liste2.add(ac5);
		liste2.add(ac6);

		Action<AgenceBancaire> m2 = new ActionListAgenceBancaire<>("Afficher le menu de gestion de compte", "Gestion comptes", liste2);

		
		ArrayList<Action<AgenceBancaire>> liste3 = new ArrayList<>();
		liste3.add(ac1);
		liste3.add(ac4);
		liste3.add(m1);
		liste3.add(m2);

		ActionList<AgenceBancaire> al = new ActionListAgenceBancaire<AgenceBancaire>("Menu principal","Accueil", liste3);
		try {
			al.execute(ab);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}