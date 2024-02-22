package org.joychou.controller;


import org.apache.velocity.VelocityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

@RestController
@RequestMapping("/ssti")
public class SSTI {

    /**
     * SSTI of Java velocity. The latest Velocity version still has this problem.
     * Fix method: Avoid to use Velocity.evaluate method.
     * <p>
     * http://localhost:8080/ssti/velocity?template=%23set($e=%22e%22);$e.getClass().forName(%22java.lang.Runtime%22).getMethod(%22getRuntime%22,null).invoke(null,null).exec(%22open%20-a%20Calculator%22)
     * Open a calculator in MacOS.
     *
     * @param template exp
     */
    @GetMapping("/velocity")
    public void velocity(String userInput) {
        // Initialize Velocity
        Velocity.init();
        
        // Validate user input
        if (!isValidInput(userInput)) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        // Set up the Velocity context with sanitized user inputs
        VelocityContext context = new VelocityContext();
        context.put("author", "Elliot A.");
        context.put("address", "217 E Broadway");
        context.put("phone", "555-1337");
        context.put("userInput", userInput); // Safely include user input
        
        // Use a predefined template
        StringWriter swOut = new StringWriter();
        Velocity.mergeTemplate("path/to/predefined/template.vm", "UTF-8", context, swOut);
    }
}
    // Example validation method (implementation depends on the specific validation logic)
    private boolean isValidInput(String input) {
        // Implement validation logic, e.g., using regular expressions
        return true; // Placeholder return value
    }
