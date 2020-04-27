package wizut.tpsi.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/add")
    public String addNumbers(Model model, CalculatorForm form) {
        int result = form.getX() + form.getY();
        
        form.setOperation("+");
        model.addAttribute("result", result);
        return "result";
    }

    @RequestMapping("/multiply")
    public String multiplyNumbers(Model model, CalculatorForm form) {
        int result = form.getX() * form.getY();
        
        form.setOperation("*");
        model.addAttribute("result", result);
        return "result";
    }

    @RequestMapping("/calculate")
    public String doCalculations(Model model, CalculatorForm form) {
        int result = 0;
        switch(form.getOperation()) {
            case "+":
                result = form.getX() + form.getY();
                break;
            case "-":
                result = form.getX() - form.getY();
                break;
            case "*":
                result = form.getX() * form.getY();
                break;
        }
        
        model.addAttribute("result", result);
        
        return "result";
    }
}
