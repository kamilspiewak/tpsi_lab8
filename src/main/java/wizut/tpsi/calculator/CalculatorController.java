package wizut.tpsi.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
    
   private CalculatorService calculatorService;
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/add")
    public String addNumbers(Model model, CalculatorForm form) {
        int result = calculatorService.add(form.getX(),form.getY());
        
        form.setOperation("+");
        model.addAttribute("result", result);
        return "result";
    }

    @RequestMapping("/multiply")
    public String multiplyNumbers(Model model, CalculatorForm form) {
        int result = calculatorService.multiply(form.getX(), form.getY());
        
        form.setOperation("*");
        model.addAttribute("result", result);
        return "result";
    }

    @RequestMapping("/calculate")
    public String doCalculations(Model model, CalculatorForm form) {
        int result = 0;
        switch(form.getOperation()) {
            case "+":
                result = calculatorService.add(form.getX(), form.getY());
                break;
            case "-":
                result = calculatorService.subtract(form.getX(), form.getY());
                break;
            case "*":
                result = calculatorService.multiply(form.getX(), form.getY());
                break;
        }
        
        model.addAttribute("result", result);
        
        return "result";
    }
    
}
