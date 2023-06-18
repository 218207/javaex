package com.example.exc44;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CalcoolatorController {

    private final CalcoolatorService calcoolatorService;


    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(value = "number1", defaultValue = "") Float num1,
                            @RequestParam(value = "number2", defaultValue = "") Float num2,
                            @RequestParam(value = "action", defaultValue = "") String action,
                            Model model) {
        Calcoolator calcoolator = new Calcoolator();
        calcoolator.setNumber1(num1);
        calcoolator.setNumber2(num2);
        calcoolator.setAction(action);
        switch (action) {
            case "+" -> calcoolator.setResult((num1 + num2) + "");

            case "-" -> calcoolator.setResult((num1 - num2) + "");

            case "*" -> calcoolator.setResult((num1 * num2) + "");

            case "/" -> calcoolator.setResult((num1 / num2) + "");
        }
        model.addAttribute("result", calcoolator.getResult());
        calcoolatorService.saveNewResult(calcoolator);

        return "index";
    }

    @PostMapping("/show")
    public String showAll(Model model){
        model.addAttribute("results", calcoolatorService.showAllResult());
        return "index";
    }

    @PostMapping("/delete")
    public String delete(Model model){
        calcoolatorService.deleteAllResult();
        model.addAttribute("results", null);
        return "index";
    }
}
