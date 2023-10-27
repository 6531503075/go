package com.justwash.go;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MachineController {
    private HashMap<Integer, Machine> machines= new HashMap<Integer, Machine>();
    private int nextId = 1;

    private int date;
    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/machines")
    public String machines(Model model) {
        model.addAttribute("machines", machines.values());
        return "list-machines";
    }

    @GetMapping("/add-machine")
    public String addMachine(Model model) {
        model.addAttribute("machine", new Machine());
        return "add-machine-form";
    }

    @PostMapping("/machines")
    public String saveMachine(@ModelAttribute Machine machine) {
        machine.setId(nextId);
        machines.put(nextId, machine);
        nextId++;
        return "redirect:/machines";
    }

    @GetMapping("/delete-machine/{id}")
    private String deleteMachine(@PathVariable int id) {
        machines.remove(id);
        return "redirect:/machines";
    }

    @GetMapping("/edit-machine")
    public String removeAllMatchines(){
        machines.clear();
        nextId = 1;
        return "redirect:/machines";
    }
}
