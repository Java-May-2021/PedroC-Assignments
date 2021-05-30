package com.pcalixto.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.pcalixto.demojapiproject.models.Book;
import com.pcalixto.languages.models.Language;
import com.pcalixto.languages.services.LanguageService;

@Controller
public class MainController {
    private final LanguageService languageService;
    
    public MainController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @GetMapping("/languages")
    public String index(Model viewmodel, 
    					@ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        viewmodel.addAttribute("languages", languages);
        return "index.jsp";
    }
    
    @PostMapping(value="/languages")
    public String create(@Valid @ModelAttribute("language") Language language, 
    					 BindingResult result,
    					 Model viewmodel) {
        if (!result.hasErrors()) {
            languageService.createLanguage(language);
            return "redirect:/languages";
        } else {
            List<Language> languages = languageService.allLanguages();
            viewmodel.addAttribute("languages", languages);
            return "index.jsp";
        }
    }

    @GetMapping("/languages/{id}")
    public String findLanguageById(Model model, @PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
    
    @GetMapping("/languages/{id}/edit")
    public String newLanguage(@PathVariable("id") Long id, Model viewmodel) {
    	Language language = languageService.findLanguage(id);
        if (language != null){
        	viewmodel.addAttribute("language", language);
            return "edit.jsp";
        } else {
            return "redirect:/languages";
        }
    }
    
    @PutMapping("/languages/{id}")
    public String edit(@PathVariable("id") Long id, 
					   @Valid @ModelAttribute("language") Language language, 
					   BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	language.setId(id);
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }    

    @DeleteMapping("/languages/{id}")
    public String delete(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }    

}

