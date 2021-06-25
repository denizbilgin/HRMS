package HRMS.HRMS.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HRMS.HRMS.business.abstracts.LanguageService;
import HRMS.HRMS.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.core.utilities.results.Result;
import HRMS.HRMS.entities.concretes.Language;

@CrossOrigin
@RestController
@RequestMapping("/api/languages")
public class LanguagesController
{
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService)
	{
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Language language)
	{
		return ResponseEntity.ok(this.languageService.add(language)) ;
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Language language)
	{
		return this.languageService.update(language);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorDataResult<Object> handleValidationException
	            (MethodArgumentNotValidException exceptions){
	        Map<String,String> validationErrors = new HashMap<String, String>();
	        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
	            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	        }

	        ErrorDataResult<Object> errors
	                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
	        return errors;
	    }
}
