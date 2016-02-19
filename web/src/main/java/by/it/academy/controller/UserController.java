
package by.it.academy.controller;

import by.it.academy.pojos.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static List<Person> personList = new ArrayList();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        model.put("persons", personList);
        Person person = new Person();
        if (personList.size() > 1) {
            person = personList.get(0);
        } else {
            person = new Person();
            person.setId(1);
            person.setName("New name");
        }

        model.put("person", person);
        return "user/main";
    }

    //@PreAuthorize("APP_ROLE")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String userInfo() {

        return "user/info";
    }

    @RequestMapping(value = "/add-person", method = {RequestMethod.GET, RequestMethod.POST})
    public String addPerson(ModelMap model, @ModelAttribute Person person) {
        personList.add(person);
        model.put("persons", personList);
        model.put("person", person);

        return "user/main";
    }

    @RequestMapping(value = "/delete-person", method = {RequestMethod.GET, RequestMethod.POST})
    public String deletePerson(ModelMap model, @ModelAttribute("person") Person person,
                               @RequestParam(value = "id", defaultValue = "") Integer id) {

        return "user/main";
    }
}
