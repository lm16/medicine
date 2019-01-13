package service.impl;

import dao.AgencyDao;
import dao.impl.AgencyDaoImpl;
import domain.Agency;
import service.AgencyService;

import java.util.List;

public class AgencyServiceImpl implements AgencyService {

    private AgencyDao agencyDao = new AgencyDaoImpl();

    @Override
    public List<Agency> getList() {
        return agencyDao.getList();
    }

    @Override
    public Agency getBean(int ano) {
        return agencyDao.getBean(ano);
    }

    @Override
    public void create(Agency agency) {
        agencyDao.create(agency);
    }

    @Override
    public void delete(int ano) {
        agencyDao.delete(ano);
    }

    @Override
    public void update(Agency agency) {
        agencyDao.update(agency);
    }
}
