package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
/*    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String language) { return createMessage(name, language);
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // lives /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='' selected>-What language would you like to be greeted in?-</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='Chinese'>Chinese</option>" +
                "<option value='Norwegian'>Norwegian</option>" +
                "<option value='English'>English</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        if (language == "Spanish") {
            return "Hola, " + name + "!";
        } else if (language == "French") {
            return "Bonjour, " + name + "!";
        } else if (language == "Chinese") {
            return "Ni hao, " + name + "!";
        } else if (language == "Norwegian") {
            return "Hei, " + name + "!";
        } else {
            return "Hello, " + name + "! (" + language + ")";
        }
    }

}
