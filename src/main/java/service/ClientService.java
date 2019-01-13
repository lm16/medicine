package service;

import domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> getList();

    Client getBean(int cno);

    void create(Client client);

    void delete(int cno);

}
