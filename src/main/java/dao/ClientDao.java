package dao;

import domain.Client;

import java.util.List;

public interface ClientDao {

    List<Client> getList();

    Client getBean(int cno);

    void create(Client client);

    void delete(int cno);

}
