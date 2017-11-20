package com.springapp.mvc;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

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

    /******************************************************************************************** Invoice ************/
    @RequestMapping(value = "/getInvoiceList", method = RequestMethod.GET)
    @ResponseBody
    public String getInvoiceListAsJSON() {
        return dao.getInvoiceList();
    }

    @RequestMapping(value = "/getActivesList", method = RequestMethod.GET)
    @ResponseBody
    public String getActivesListAsJSON() {
        return dao.getActivesList();
    }

    @RequestMapping(value = "/newInvoice", method = RequestMethod.POST)
    @ResponseBody
    public void insertInvoice(@RequestBody Invoice invoice){
        dao.newInvoice(invoice);
    }

    /** UNTESTED **/
    @RequestMapping(value = "/updateInvoice", method = RequestMethod.POST)
    @ResponseBody
    public void editInvoice(@RequestBody Invoice invoice){
        dao.updateInvoice(invoice);
    }
    /** UNTESTED **/
    @RequestMapping(value = "/findInvoice", method = RequestMethod.GET)
    @ResponseBody
    public String findInvoiceById(@RequestBody Invoice invoice){
        if(invoice.getId() >0){ return dao.getInvoiceById(invoice.getId()); }
        else if(!invoice.getInvoiceNum().equalsIgnoreCase("")){ return dao.getInvoiceByNum(invoice.getInvoiceNum()); }
        else return null;
    }
    /** UNTESTED **/
    @RequestMapping(value = "/deleteInvoiceById", method = RequestMethod.POST)
    @ResponseBody
    public void deleteInvoiceById(@RequestBody Invoice invoice){
        dao.deleteInvoice(invoice.getId());
    }


    /******************************************************************************************** Client *************/
    @RequestMapping(value = "/getClientList", method = RequestMethod.GET)
    @ResponseBody
    public String getClientList() {
        return dao.getClientList();
    }
    /** UNTESTED **/
    @RequestMapping(value = "/newClient", method = RequestMethod.POST)
    @ResponseBody
    public void insertClient(@RequestBody Client client){
        dao.newClient(client);
    }


    /******************************************************************************************** Driver *************/
    @RequestMapping(value = "/getDriverList", method = RequestMethod.GET)
    @ResponseBody
    public String getDriverList() {
        return dao.getDriverList();
    }
    /** UNTESTED **/
    @RequestMapping(value = "/newDriver", method = RequestMethod.POST)
    @ResponseBody
    public void insertDriver(@RequestBody Driver driver){
        dao.newDriver(driver);
    }


    /******************************************************************************************** Location ***********/
    @RequestMapping(value = "/getLocationList", method = RequestMethod.GET)
    @ResponseBody
    public String getLocationList() {
        return dao.getLocationList();
    }
    /** UNTESTED **/
    @RequestMapping(value = "/newLocation", method = RequestMethod.POST)
    @ResponseBody
    public void insertLocation(@RequestBody Location location){
        dao.newLocation(location);
    }
}
/** JSON TO ARRAY: Client jsonToArray[] = gson.fromJson(gsonString, Client[].class); **/