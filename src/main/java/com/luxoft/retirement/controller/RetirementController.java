package com.luxoft.retirement.controller;

import com.luxoft.retirement.dto.RetirementResponse;
import com.luxoft.retirement.service.RetirementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/retirement")
public class RetirementController {

  private final RetirementService retirementService;

  @GetMapping
  public RetirementResponse calculateRetirement(@RequestParam int currentAge,
                                                @RequestParam int ageToRetire,
                                                @RequestParam String email) {
    return retirementService.calculateRetirement(currentAge, ageToRetire, email);
  }

}
