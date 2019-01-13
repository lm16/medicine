package service;

import domain.Agency;

import java.util.List;

public interface AgencyService {

    List<Agency> getList();

    Agency getBean(int ano);

    void create(Agency agency);

    void delete(int ano);

    void update(Agency agency);
}
