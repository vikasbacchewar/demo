package com.example.demo.controller;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController("/employee")
public class EmployeeController {
	
	@GetMapping()
	public Employee get(@ApiParam(value = "id", required = true ) @RequestParam(value = "id") String id) {
		return new Employee();
	}
	
	@PostMapping()
	public Employee post(@RequestBody Employee  emBody) {
		return new Employee();
	}
	
	@PutMapping
	@ApiOperation( value = "Update Employee Information")
	public Employee put(@RequestBody Employee  emBody,@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Employee();
	}
	
	@DeleteMapping
	@ApiImplicitParams(
			@ApiImplicitParam(name="test", value = "test", paramType = "header")
			)
	public Employee delete(@RequestParam(value = "id", defaultValue = "World") String id) {
		return new Employee();
	}
	
}
