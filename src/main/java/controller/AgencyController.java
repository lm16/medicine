package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Agency;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AgencyService;
import service.impl.AgencyServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class AgencyController {

    AgencyService agencyService = new AgencyServiceImpl();

    @RequestMapping(value="/agency-list.do", produces = "application/json; charset=UTF-8")
    public @ResponseBody String agencyList()throws JsonProcessingException{
        List<Agency> list = agencyService.getList();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);

        return json;
    }

    @RequestMapping(value="/agency-bean.do")
    public void agencyBean(){
        
    }

    @RequestMapping("/agency-create.do")
    public void agencyCreate(HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        String aname = request.getParameter("aname");
        String asex = request.getParameter("asex");
        String aphone = request.getParameter("aphone");
        String aremark = request.getParameter("aremark");

        Agency agency = new Agency();
        agency.setAname(aname);
        agency.setAsex(asex);
        agency.setAphone(aphone);
        agency.setAremark(aremark);

        agencyService.create(agency);
    }

    @RequestMapping(value="/agency-delete.do/{ano}")
    public ResponseEntity<Void> agencyDelete(@PathVariable("ano")int ano, @RequestBody Agency agency){
        agency.setAno(ano);
        agencyService.delete(ano);

        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/agency-update.do/{ano}")
    public ResponseEntity<Void> agencyUpdate(@PathVariable("ano")int ano, @RequestBody Agency agency){
        agencyService.update(agency);

        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<Void>(header, HttpStatus.OK);
    }
}
