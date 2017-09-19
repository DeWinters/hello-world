package com.springapp.mvc;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 19/09/2017.
 */
@RestController
public class RemoteController {
    @Autowired
    private DriverManagerDataSource dataSauce;

    public void setDataSauce(DriverManagerDataSource dataSauce) {
        this.dataSauce = dataSauce;
    }

    @Autowired
    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    Gson gson = new Gson();

    @RequestMapping(value = "/gimmeJson", method = RequestMethod.GET)
    @ResponseBody
    public String getLogAsJSON() {
        return dao.getGuestLog();
    }

    @RequestMapping(value = "/newGuest", method = RequestMethod.POST)
    @ResponseBody
    public void insertAGuest(@RequestBody Client client){
        dao.insertNew(client.getFirstName(), client.getLastName());
    }

    @RequestMapping(value = "/updateGuest", method = RequestMethod.POST)
    @ResponseBody
    public void updateGuest(@RequestBody Client client){
        dao.updateGuest(client.getId(), client.getFirstName(), client.getLastName());
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public void deleteGuestById(@RequestBody Client client){
        //long fake = Long.parseLong(id);
        dao.deleteGuest(client.getId());
    }


}
/** JSON TO ARRAY: Client jsonToArray[] = gson.fromJson(gsonString, Client[].class); **/