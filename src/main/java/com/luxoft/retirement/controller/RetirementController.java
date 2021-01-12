package com.luxoft.retirement.controller;

import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.service.RetirementService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/retirement")
public class RetirementController {

  private final RetirementService retirementService;

  @GetMapping
  public RetirementResponse calculateRetirement(@RequestParam @Positive int currentAge,
                                                @RequestParam @Positive int ageToRetire,
                                                @RequestParam @NotBlank @Email String email) {
    return retirementService.calculateRetirement(currentAge, ageToRetire, email);
  }

}
