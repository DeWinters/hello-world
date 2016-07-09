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

	@RequestMapping(value="/",method = RequestMethod.GET)                           /** Working as intended */
	public String printWelcome(ModelMap model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
		model.addAttribute("greeting", "Enter New Member details");
        confirm = "New Member Entry";
		return "index";
	}


    @RequestMapping(value="/editor",method = RequestMethod.POST)                    /** Needs default values from selected member's db data */
    public String editMember(ModelMap model,@RequestParam("editId") long id){
        JdbcTemplate jdbctemplate = new JdbcTemplate(dataSauce);
        //User subject = jdbctemplate.query("SELECT username FROM USERS WHERE id =5", new UserMapper());   // I cant get this restricted query to work
        List<User> allUsers = jdbctemplate.query("SELECT * FROM USERS", new UserMapper());
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
        confirm = "Member Data Edit";
        return "editor";
    }


    @RequestMapping(value="/confirmation",method = RequestMethod.POST)              /** Working as intended */
    public String calculate(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("age") String age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO USERS(username,password,age) VALUES(?,?,?)",username,password,age);
        model.addAttribute("username", username);
        model.addAttribute("procedure", confirm);
        return "confirmation";
    }


    @RequestMapping(value="/census", method = RequestMethod.POST)                   /** Working as intended */
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
        return "memberList";
    }


    @RequestMapping(value="/changed", method = RequestMethod.POST)
    public String editMember(ModelMap model,@RequestParam("newName") String username, @RequestParam("newPass") String password, @RequestParam("newAge") String age, long id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("UPDATE USERS SET(username,password,age) VALUES(?,?,?) WHERE id =(?) ", username, password, age, id);


      return "changed";
    }


    @RequestMapping(value="/addIt", method = RequestMethod.POST)                    /** Working as intended */
    public String addStuff(ModelMap model,@RequestParam("cell1") float cell1, @RequestParam("cell2") float cell2){
        float answer = cell1 + cell2;
        System.out.println(answer);
        model.addAttribute("result", answer);
        return "addMachine";
    }
}
