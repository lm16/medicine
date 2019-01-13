package service.impl;

import dao.ClientDao;
import dao.impl.ClientDaoImpl;
import domain.Client;
import service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public List<Client> getList() {
        return clientDao.getList();
    }

    @Override
    public Client getBean(int cno) {
        return clientDao.getBean(cno);
    }

    @Override
    public void create(Client client) {
        clientDao.create(client);
    }

    @Override
    public void delete(int cno) {
        clientDao.delete(cno);
    }
}
