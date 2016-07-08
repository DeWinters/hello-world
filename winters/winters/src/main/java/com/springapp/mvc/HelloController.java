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

    /** Working as intended */
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
//       List<User> enroll = jdbcTemplate.query("SELECT * FROM USERS", new UserMapper());    //does this need to be here for a reason?
//      System.out.println("Found "+users.size() + " users in database");
		model.addAttribute("greeting", "Enter New Member details");
      //  model.addAttribute("users",enroll);
		return "index";
	}

    /** Needs default values from selected member's db data */
    @RequestMapping(value="/editor",method = RequestMethod.POST)
    public String editMember(ModelMap model,@RequestParam("editId") long id){
        JdbcTemplate jdbctemplate = new JdbcTemplate(dataSauce);

        model.addAttribute("id", id);

        return "edited";
    }

    /** Working as intended */
    @RequestMapping(value="/confirmation",method = RequestMethod.POST)
    public String calculate(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("age") String age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        jdbcTemplate.update("INSERT INTO USERS(username,password,age) VALUES(?,?,?)",username,password,age);
//		System.out.println(username+password);
        model.addAttribute("username",username);
        return "thanks";
    }

    /** Needs 2nd jdbctemplate example with minors' data pre-blocked */
    @RequestMapping(value="/newPage", method = RequestMethod.POST)
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

        /** Query restriction solution goes {here} */

        System.out.println(allUsers.iterator());                // failed:seems to find address of table instead of contents of table elements
        model.addAttribute("userCount", allUsers.size());       // works: posts the total number of table entries
        model.addAttribute("owner", owner);                     // works: posts a string to the page
        model.addAttribute("roleCall", theLot);                 // works: Produces list of ADULT members
        return "derek";
    }

    /** Working as intended */
    @RequestMapping(value="/addIt", method = RequestMethod.POST)
    public String addStuff(ModelMap model,@RequestParam("cell1") float cell1, @RequestParam("cell2") float cell2){
        float answer = cell1 + cell2;
        System.out.println(answer);
        model.addAttribute("result", answer);
        return "addMachine";

    }
}

/*
    @RequestMapping(value="/newPage", method = RequestMethod.POST)
    public String listMembers(ModelMap model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSauce);
        List<User> allUsers = jdbcTemplate.query("SELECT * FROM USERS", new UserMapper());
        model.addAttribute("allUsers", allUsers);       // doesn't work
        model.addAttribute("used", allUsers.size());    // works
        model.addAttribute("owner", owner);             // works
        return "derek";
    }
*/