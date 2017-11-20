package com.springapp.mvc;

import com.google.gson.Gson;
import com.mysql.jdbc.exceptions.MySQLDataException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import org.apache.log4j.Logger;


@Service
public class DAO {

    @Autowired
    private DriverManagerDataSource dataSauce;

    final static Logger logger = Logger.getLogger(DAO.class);
    /******************************************************************************************** Invoice ************/
    public String getInvoiceList(){
        List<Invoice> invoiceList;
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            invoiceList = jdbcTemplate.query("SELECT * FROM invoice", new InvoiceMapper());
            logger.info("dao Full invoice list queried");
            return new Gson().toJson(invoiceList);
        }catch(Exception e){
            logger.error("dao Full invoice list query failure: "+ e.toString());
            return null;
        }
    }

    public String getActivesList(){
        List<Invoice> activesList;
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            activesList = jdbcTemplate.query("SELECT * FROM invoice WHERE active=true", new InvoiceMapper());
            logger.info("dao Active invoice list queried");
            return new Gson().toJson(activesList);
        }catch(Exception e){
            logger.error("Active invoice list query failure: "+ e.toString());
            return null;
        }
    }

    public void newInvoice(Invoice invoice){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("INSERT INTO invoice(" +
                "invoice_num," +
                "client," +
                "driver," +
                "origin," +
                "collection," +
                "destination," +
                "delivery," +
                "tarif," +
                "tax_rate," +
                "wait_fee," +
                "retour," +
                "wknd," +
                "human," +
                "prise," +
                "interne," +
                "abusive," +
                "urgent," +
                "active," +
                "paid" +
                ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                invoice.getInvoiceNum(),
                invoice.getClient(),
                invoice.getDriver(),
                invoice.getOrigin(),
                invoice.getCollection(),
                invoice.getDestination(),
                invoice.getDelivery(),
                invoice.getTarif(),
                invoice.getTaxRate(),
                invoice.getWaitFee(),
                invoice.getRetour(),
                invoice.getWknd(),
                invoice.getHuman(),
                invoice.getPrise(),
                invoice.getInterne(),
                invoice.getAbusive(),
                invoice.getUrgent(),
                invoice.getActive(),
                invoice.getPaid()
            );
            logger.info("dao New invoice: "+ invoice.getInvoiceNum()+ " created.");
        }catch(Exception e){
            logger.error("dao New invoice: "+ invoice.getInvoiceNum()+ " failure.");
        }
    }
    /** UNTESTED **/
    public void updateInvoice(Invoice invoice){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("UPDATE invoice SET " +
                            "invoice_num = ? , " +
                            "client = ?, " +
                            "driver = ?," +
                            "origin = ?," +
                            "collection = ?, " +
                            "delivery = ?, " +
                            "tarif = ?, " +
                            "tax_rate = ?, " +
                            "wait_fee = ?,"+
                            "retour = ?," +
                            "wknd = ?," +
                            "human = ?," +
                            "prise = ?," +
                            "interne = ?," +
                            "abusive = ?," +
                            "urgent = ?," +
                            "active = ?," +
                            "paid = ?" +
                            "WHERE guest_id =?",
                    invoice.getInvoiceNum(),
                    invoice.getClient(),
                    invoice.getDriver(),
                    invoice.getOrigin(),
                    invoice.getCollection(),
                    invoice.getDestination(),
                    invoice.getDelivery(),
                    invoice.getTarif(),
                    invoice.getTaxRate(),
                    invoice.getWaitFee(),
                    invoice.getRetour(),
                    invoice.getWknd(),
                    invoice.getHuman(),
                    invoice.getPrise(),
                    invoice.getInterne(),
                    invoice.getAbusive(),
                    invoice.getUrgent(),
                    invoice.getActive(),
                    invoice.getPaid(),
                    invoice.getId()
            );
            logger.info("dao Update invoice: "+ invoice.getId() + " successful");
        }catch(Exception e){
            logger.error("dao Update invoice: "+ invoice.getId() + " failed");
        }
    }
    /** UNTESTED **/
    public String getInvoiceById(long id){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            List<Invoice> listed = jdbcTemplate.query("SELECT * FROM invoice WHERE id =?", new InvoiceMapper(), id);
            logger.info("dao Find invoice: " + id + "successful");
            return new Gson().toJson(listed);
        }catch(Exception e){
            logger.error("dao Find Invoice: "+ id + " failed");
            return null;
        }
    }
    /** UNTESTED **/
    public String getInvoiceByNum(String invoiceNum){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            List<Invoice> listed = jdbcTemplate.query("SELECT * FROM invoice WHERE id =?", new InvoiceMapper(), invoiceNum);
            logger.info("dao Find invoice: " + invoiceNum + "successful");
            return new Gson().toJson(listed);
        }catch(Exception e){
            logger.error("dao Find Invoice: "+ invoiceNum + " failed");
            return null;
        }
    }
    /** UNTESTED **/
    public void deleteInvoice(long id){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("DELETE FROM invoice WHERE id =?", id);
            logger.info("dao Delete invoice: " + id + " successful");
        }catch(Exception e){
            logger.error("dao Delete invoice: " + id + " failed");
        }
    }


    /******************************************************************************************** Client ************/
    public String getClientList(){
        List<Client> clientList;
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            clientList = jdbcTemplate.query("SELECT * FROM client", new ClientMapper());
            logger.info("dao Full client list queried");
            return new Gson().toJson(clientList);
        }catch(Exception e){
            logger.error("dao Full client list query failure: "+ e.toString());
            return null;
        }
    }

    public void newClient(Client client){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("INSERT INTO client(name)VALUES(?)", client.getName());
            logger.info("dao New client: "+ client.getName()+ " created.");
        }catch(Exception e){
            logger.error("dao New client: "+ client.getName()+ " failure.");
        }
    }

    /******************************************************************************************** Driver ************/
    public String getDriverList(){
        List<Driver> driverList;
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            driverList = jdbcTemplate.query("SELECT * FROM driver", new DriverMapper());
            logger.info("dao Full driver list queried");
            return new Gson().toJson(driverList);
        }catch(Exception e){
            logger.error("dao Full driver list query failure: "+ e.toString());
            return null;
        }
    }

    public void newDriver(Driver driver){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("INSERT INTO client(" +
                    "clearance, " +
                    "first_name, " +
                    "last_name)" +
                    "VALUES(?,?,?)",
                    driver.getClearance(),
                    driver.getFirstName(),
                    driver.getLastName()
            );
            logger.info("dao New driver: "+ driver.getLastName()+ " created.");
        }catch(Exception e){
            logger.error("dao New client: "+ driver.getLastName()+ " failure.");
        }
    }

    /******************************************************************************************** Location ***********/
    public String getLocationList(){
        List<Location> locationList;
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            locationList = jdbcTemplate.query("SELECT * FROM location", new LocationMapper());
            logger.info("dao Full location list queried");
            return new Gson().toJson(locationList);
        }catch(Exception e){
            logger.error("dao Full location list query failure: "+ e.toString());
            return null;
        }
    }
    /**UNTESTED**/
    public void newLocation(Location location){
        try{
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
            jdbcTemplate.update("INSERT INTO client(name)VALUES(?)", location.getName());
            logger.info("dao New location: "+ location.getName()+ " created.");
        }catch(Exception e){
            logger.error("dao New location: "+ location.getName()+ " failure.");
        }
    }

}
