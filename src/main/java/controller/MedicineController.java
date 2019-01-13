package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Medicine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MedicineService;
import service.impl.MedicineServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MedicineController {

    private MedicineService medicineService = new MedicineServiceImpl();

    @RequestMapping(value="/medicine-list.do", produces = "application/json; charset=UTF-8")
    public @ResponseBody String medicineList() throws JsonProcessingException {
        List<Medicine> list = medicineService.getList();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);

        return json;
    }

    @RequestMapping("/medicineBean.do")
    public void medicineBean(HttpServletRequest request){
        int mno = Integer.parseInt(request.getParameter("mno"));
        Medicine medicine = medicineService.getBean(mno);
        request.setAttribute("bean", medicine);
    }

    @RequestMapping("/medicineCreate.do")
    public void medicineCreate(HttpServletRequest request){

    }

    @RequestMapping("/medicineDelete.do")
    public void medicineDelete(HttpServletRequest request){

    }
}
