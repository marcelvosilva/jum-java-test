package com.exercise.controller;

import java.util.ArrayList;
import java.util.List;

import com.exercise.models.Customer;
import com.exercise.repository.CustomerRepository;
import com.exercise.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Api(value = "Jumia Exercise")
@Slf4j
public class ExerciseController {

  @Autowired
  CustomerRepository customerRepository;

  @ApiOperation(value = "Return all customers")
  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String country,
      @RequestParam(required = false) String state) {
    try {
      List<Customer> list = new ArrayList<Customer>();
      log.info("Searching the database...");
      customerRepository.findAll().forEach(list::add);
      log.info("Search complete!");
      List<Customer> result = new ArrayList<Customer>(list);

      if (list.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      if (country != null && !country.isEmpty()) {
        log.info("Applying country filter...");
        for (Customer customer : list) {
          String countryCode = String.valueOf(CountryEnum.valueOf(country).getCode()).concat(")");
          if (!customer.getPhone().contains(String.valueOf(countryCode))) {
            result.remove(customer);
          }
        }
      }

      list = new ArrayList<Customer>(result);

      if (state != null && !state.isEmpty()) {
        if (state.equals("true")) {
          log.info("Applying state filter...");
          for (Customer customer : list) {
            if (!ValidateNumber.validateNumber(customer.getPhone())) {
              result.remove(customer);
            }
          }
        }
        else if (state.equals("false")) {
          log.info("Applying state filter...");
          for (Customer customer : list) {
            if (ValidateNumber.validateNumber(customer.getPhone())) {
              result.remove(customer);
            }
          }
        }
      }

      return new ResponseEntity<>(result, HttpStatus.OK);

    } catch (Exception e) {
      log.error(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}