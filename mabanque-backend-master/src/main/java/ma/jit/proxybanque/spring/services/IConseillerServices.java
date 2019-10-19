package ma.jit.proxybanque.spring.services;

import ma.jit.proxybanque.spring.web.models.Client;
import ma.jit.proxybanque.spring.web.models.Compte;
import ma.jit.proxybanque.spring.web.models.Employer;
import ma.jit.proxybanque.spring.web.models.tdo.DTOEmploye;
import ma.jit.proxybanque.spring.web.models.tdo.DTOOperation;

public interface IConseillerServices {

	/*** Gestion des Clients ***/

	Client getClients(int id);

	void deleteClient(int id);

	Client updateClient(Client client, int employeId);

	Client addClient(Client client, int employeId);

	/*** Gestion des comptes ***/

	Compte getCompte(int id);

	Compte addCompte(Compte compte, int idClient);

	void deleteCompte(int id);

	Compte updateCompte(Compte compte);

	/*** Gestion des operations ***/

	Compte addOperation(DTOOperation dtoOperation);

	/*** Gestion des employes ***/

	Employer getEmploye(int id);

	Employer updateEmploye(DTOEmploye tdoEmp);

	Employer getUser(String username);


}
