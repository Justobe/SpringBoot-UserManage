package com.adc.gim.controllers;

import com.adc.gim.models.Role;
import com.adc.gim.models.User;
import com.adc.gim.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanMing on 2017/5/17.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserDao userDao;

    private List<Role> createUserRole(){
        List<Role> tmpList =  new ArrayList<Role>();
        Role newRole = new Role();
        Long newId = 2L;
        newRole.setId(newId);
        newRole.setRolename("ROLE_USER");
        tmpList.add(newRole);
        return tmpList;
    }

    private List<Role> createAdminRole(){
        List<Role> tmpList =  new ArrayList<Role>();
        Role newRole = new Role();
        Long newId = 1L;
        newRole.setId(newId);
        newRole.setRolename("ROLE_ADMIN");
        tmpList.add(newRole);
        return tmpList;
    }

    @RequestMapping(value = {"/home","/"})
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerPage() {
        ModelAndView model = new ModelAndView();
        User etpUser = new User();
        model.addObject(etpUser);
        //model.setViewName("registerPage");
        model.setViewName("signup");
        return model;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView();
        User etpUser = new User();
        model.addObject(etpUser);
        //model.setViewName("loginPage");
        model.setViewName("signin");
        return model;
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView registerUser(@ModelAttribute(value = "user") User user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError error:list){
                System.out.println(error.getCode()+"---"+error.getArguments().toString()+"---"+error.getDefaultMessage());
            }
            model.setViewName("signup");
            model.addObject(user);
        } else {
        try {
            System.out.print(user.getUsername() + user.getEmail()+user.getPassword());
            List<Role> tmpList =  createUserRole();
            user.setRoles(tmpList);
            userDao.save(user);
            //model.setViewName("registerOK");
            model.setViewName("signin");
            model.addObject(user);

        } catch (Exception ex) {
            System.out.print(ex.toString());
            model.setViewName("failPage");
            }
        }
        return model;
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.GET)
    public ModelAndView loginPost(){
        ModelAndView model = new ModelAndView();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String curName = userDetails.getUsername();
        //System.out.println(curName);
        User user = userDao.findByUsername(curName);
        if(user == null){
            model.setViewName("failPage");
        }else {
            model.addObject(user);
            //Role role = new Role();
            //model.addObject(role);
            //model.setViewName("loginOk");
            model.setViewName("workPage");
        }
        return model;
    }


    @RequestMapping(value = "/fail")
    public ModelAndView failPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("failPage");
        return model;
    }

    @RequestMapping(value = "/accessDenied")
    public ModelAndView accessDndPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("accessDenied");
        return model;
    }

    @RequestMapping(value = "regByAdmin",method = RequestMethod.GET)
    @ResponseBody
    public String regByAdmin(@RequestParam(value = "regName",required = false) String regName,
                                   @RequestParam(value = "regPwd",required = false) String regPwd,
                                   @RequestParam(value = "regEml",required = false) String regEml,
                                   @RequestParam(value = "regRole",required = false) String regRole) {
       ModelAndView model = new ModelAndView();
       User newUser = new User(regEml,regName,regPwd);
       String res = "wrong";
       if(regRole.equals("role_user")){
           List<Role> tmpList = createUserRole();
           newUser.setRoles(tmpList);
       }else {
           List<Role> tmpList = createAdminRole();
           newUser.setRoles(tmpList);
       }
       try {
           userDao.save(newUser);
           res = "right";
       }catch (Exception ex){

       }
       return  res;
    }


}
