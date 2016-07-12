package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private DriverManagerDataSource dataSauce;

    String owner = "TheStudentProgrammer";
    String confirm ="";
    long hack = 0;                                                                  // this will be made clear

	@RequestMapping(value="/",method = RequestMethod.GET)                           /** Working as intended */
	public String printWelcome(ModelMap model) {
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
		model.addAttribute("greeting", "Enter New Member details");
        confirm = "New Member Entry";
		return "index";
	}

    /***************************************** members *********************************************************/
    @RequestMapping(value="/editor",method = RequestMethod.POST)                    /** this looping construct can't be right. a single user obj would be better than a List obj */
    public String editMember(ModelMap model,@RequestParam("editId") long id){
        JdbcTemplate jdbctemplate = new JdbcTemplate(dataSauce);
        //String xxx="";
        //jdbctemplate.query("SELECT username FROM USERS WHERE id =5", xxx);                // nope
        //xxx = jdbctemplate.query("SELECT username FROM USERS WHERE id=5");                // nope
        //User a = jdbctemplate.query("SELECT * FROM USERS WHERE ID =?", id);               // nope
        //User b = jdbctemplate.query("SELECT * FROM USERS WHERE ID =5", new UserMapper()); // nope

        List<User> allUsers = jdbctemplate.query("SELECT * FROM USERS WHERE ID =?", new UserMapper(), id);
        String username ="";
        String password ="";
        int age = 0;

        for (User member : allUsers){
            if (member.getId() == id) {
                username = member.getUsername();
                password = member.getPassword();
                age = member.getAge();
            }
        }
        model.addAttribute("name", username);
        model.addAttribute("pass", password);
        model.addAttribute("age", age);
        model.addAttribute("id", id);
        hack = id;
        confirm = "Member Data Edit";
        return "members/editor";
    }


    @RequestMapping(value="/confirmation",method = RequestMethod.POST)              /** Working as intended */
    public String calculate(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("age") String age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO USERS(username,password,age) VALUES(?,?,?)",username,password,age);
        model.addAttribute("username", username);
        model.addAttribute("procedure", confirm);
        return "members/confirmation";
    }


    @RequestMapping(value="/memberList", method = RequestMethod.POST)               /** Working as intended */
    public String listMembers(ModelMap model) {
        /** Java solution */
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<User> allUsers = jdbcTemplate.query("SELECT * FROM USERS", new UserMapper());
        String theLot ="";
        for (User member : allUsers) {
            if (member.getAge() >=18) {
                /** html output of adults only */
                theLot += member.getId() + "&emsp;" +
                          member.getUsername() + "&emsp;" +
                          member.getPassword() + "&emsp;" +
                          member.getAge() + "<br>";
            }
            /** console output of all members */
            System.out.println(member.getId() + "\t" +
                               member.getUsername() + "\t" +
                               member.getPassword() + "\t" +
                               member.getAge());
        }

        /** Query solution */
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        List<User> adults = jdbcT.query("SELECT * FROM USERS WHERE age >= 18", new UserMapper());
        int troops = 0;
        String justAdults ="";
        for (User adult : adults){
            troops +=1;
            /** html output of adults */
            justAdults += adult.getId() + "&emsp;" +
                    adult.getUsername() + "&emsp;" +
                    adult.getPassword() + "&emsp;" +
                    adult.getAge() + "<br>";

            /** console output of adults */
            System.out.println(adult.getId() + "\t" +
                    adult.getUsername() + "\t" +
                    adult.getPassword() + "\t" +
                    adult.getAge());
        }


        System.out.println(allUsers.iterator());                // failed:seems to find address of table instead of contents of table elements
        model.addAttribute("userCount", allUsers.size());       // works: posts the total number of table entries
        model.addAttribute("owner", owner);                     // works: posts a string to the page
        model.addAttribute("roleCall", theLot);                 // works: Java solution to age data restriction
        model.addAttribute("theDraft", justAdults);             // works: Query solution to age data restriction
        model.addAttribute("eligible", troops);                 // works: counts total adults
        return "members/memberList";
    }


    @RequestMapping(value="/changed", method = RequestMethod.POST)                  /** Working... */
    public String editMember(ModelMap model, @RequestParam("newName") String username, @RequestParam("newPass") String password, @RequestParam("newAge") String age){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("UPDATE USERS SET username =?, password =?, age =? WHERE id =?", username, password, age, hack);
        model.addAttribute("procedure", confirm);
        return "members/changed";
    }


    @RequestMapping(value="/delete", method = RequestMethod.POST)                   /** Working... */
    public String deleteMember(ModelMap model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("DELETE FROM USERS WHERE ID =?", hack);
        model.addAttribute("procedure", "Delete Member Record");
        return "members/changed";
    }

    /***************************************** items ************************************************************/
    @RequestMapping(value="/shelves", method = RequestMethod.POST)                  /** Working as intended */
    public String shelf(ModelMap model) {
        String allStock ="";
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        List<Item> itemList = jdbcT.query("SELECT * FROM STOCK", new ItemMapper());
        for(Item item : itemList){
            allStock += item.getItemId() +" ";
            allStock += item.getItemName() +" ";
            allStock += item.getItemPrice() +"<br>";
        }
        model.addAttribute("stockList", allStock);
        return "items/shelves";
    }


    @RequestMapping(value="/addItem", method = RequestMethod.POST)                  /** Working as intended */
    public String newItem(ModelMap model, @RequestParam("itemId") String id, @RequestParam("itemName") String name, @RequestParam("itemPrice") float price){
        JdbcTemplate jdbcTemp = new JdbcTemplate(dataSauce);
        jdbcTemp.update("INSERT INTO STOCK(itemId,itemName,itemPrice) VALUES(?,?,?)", id, name, price);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        return "items/addItem";
    }


    @RequestMapping(value="/sellItem", method = RequestMethod.POST)                 /** Working: add more user feedback */
    public String sellItem(ModelMap model, @RequestParam("itemId") String itemId, @RequestParam("memberId") long memberId){
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        jdbcT.update("INSERT INTO SALES(memberId,itemId,price,date) VALUES(?,?,?,?)", memberId, itemId, 19.95, "fakeDate");
        model.addAttribute("memberId", memberId);
        model.addAttribute("itemId", itemId);

        jdbcT.update("DELETE FROM STOCK WHERE itemId =?", itemId);
        return "items/sellItem";
    }


    @RequestMapping(value="/salesLog", method = RequestMethod.POST)                 /* Build sale class and saleMapper */
    public String allSales(ModelMap model){
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        List<Sale> allSales = jdbcT.query("SELECT * FROM SALES", new SaleMapper());
        String history ="";
        for(Sale sale : allSales){
            history += sale.getInvoice() +" "+
                       sale.getDate() +" "+
                       sale.getMemberId() +" "+
                       sale.getItemId() +" "+
                       sale.getPrice() +"<br>";
        }
        model.addAttribute("history", history);
        return "salesLog";
    }


    @RequestMapping(value="/findItem", method = RequestMethod.POST)                 /** process item search: partially working: add search conditions */
    public String searchItem(ModelMap model, @RequestParam("findId") String id, @RequestParam("findName") String name, @RequestParam("maxPrice") float max){
        JdbcTemplate jdbcT = new JdbcTemplate(dataSauce);
        List<Item> result = jdbcT.query("SELECT * FROM STOCK WHERE itemName =?", new ItemMapper(), name);
        String nameMatches ="";

        /** Make a conditional statement to determine which cell to ue as search criteria **/
        for(Item match : result){
            nameMatches += match.getItemId() +" "+
                           match.getItemName() +" "+
                           match.getItemPrice() +"<br>";
        }
        model.addAttribute("results", nameMatches);
        return "items/findItem";
    }


    /***************************************** math *************************************************************/
    @RequestMapping(value="/addIt", method = RequestMethod.POST)                    /** Working as intended */
    public String addStuff(ModelMap model,@RequestParam("cell1") float cell1, @RequestParam("cell2") float cell2){
        float answer = cell1 + cell2;
        System.out.println(answer);
        model.addAttribute("result", answer);
        return "addMachine";
    }
}