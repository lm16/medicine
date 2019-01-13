package controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClientService;
import service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ClientController {

    ClientService clientService = new ClientServiceImpl();

    @RequestMapping(value="/client-list.do", produces="application/json;charset=UTF-8")
    public @ResponseBody String clientList()throws JsonProcessingException {
        List<Client> list = clientService.getList();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);

        return json;
    }

    @RequestMapping("/clientBean.do")
    public void clientBean(HttpServletRequest request){
        int ano = Integer.parseInt(request.getParameter("ano"));
        Client client = clientService.getBean(ano);
        request.setAttribute("bean", client);
    }

    @RequestMapping("/client-create.do")
    public void clientCreate(HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        String cname = request.getParameter("cname");
        String csex = request.getParameter("csex");
        int cage = Integer.parseInt(request.getParameter("cage"));
        String caddress = request.getParameter("caddress");
        String cphone = request.getParameter("cphone");
        String csymptom = request.getParameter("csymptom");
        int mno = Integer.parseInt(request.getParameter("mno"));
        int ano = Integer.parseInt(request.getParameter("ano"));
        String cdate = request.getParameter("cdate");
        String cremark = request.getParameter("cremark");

        Client client = new Client();
        client.setCname(cname);
        client.setCsex(csex);
        client.setCage(cage);
        client.setCaddress(caddress);
        client.setCphone(cphone);
        client.setCsymptom(csymptom);
        client.setMno(mno);
        client.setAno(ano);
        client.setCdate(cdate);
        client.setCremark(cremark);

        clientService.create(client);
    }

    @RequestMapping("/clientDelete.do")
    public void clientDelete(HttpServletRequest request){

    }
}
