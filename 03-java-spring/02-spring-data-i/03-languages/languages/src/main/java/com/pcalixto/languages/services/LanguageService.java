package com.pcalixto.languages.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pcalixto.demojapiproject.models.Book;
import com.pcalixto.languages.models.Language;
import com.pcalixto.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
 // adding the language repository as a dependency
private final LanguageRepository languageRepository;
 
 public LanguageService(LanguageRepository languageRepository) {
     this.languageRepository = languageRepository;
 }
 // returns all languages
 public List<Language> allLanguages() {
     return languageRepository.findAll();
 }
 // creates a language
 public Language createLanguage(Language lang) {
     return languageRepository.save(lang);
 }
 // updates a language
 public Language updateLanguage(Language lang) {
	return languageRepository.save(lang);
 }

 // deletes a language
 public void deleteLanguage(Long id) {
	 languageRepository.deleteById(id);
 }
 // retrieves a language
 public Language findLanguage(Long id) {
	 return languageRepository.findById(id).orElse(null);
 }

}

