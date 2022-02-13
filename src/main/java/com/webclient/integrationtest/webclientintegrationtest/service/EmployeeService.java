package com.webclient.integrationtest.webclientintegrationtest.service;

import com.webclient.integrationtest.webclientintegrationtest.model.Employee;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class EmployeeService {

    private WebClient webClient;
    public static String PATH_PARAM_BY_ID = "/employee/{id}";
    public static String ADD_EMPLOYEE = "/employee";

    public EmployeeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public EmployeeService(String baseUrl) {
        this.webClient = WebClient.create(baseUrl);
    }

    public Mono<Employee> getEmployeeById(Integer employeeId) {
        return webClient
                .get()
                .uri(PATH_PARAM_BY_ID, employeeId)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    public Mono<Employee> addNewEmployee(Employee newEmployee) {
        return webClient
                .post()
                .uri(ADD_EMPLOYEE)
                .body(newEmployee, Employee.class)
                .retrieve().
                        bodyToMono(Employee.class);
    }

    public Mono<Employee> updateEmployee(Integer employeeId, Employee updateEmployee) {
        return  webClient
                .put()
                .uri(PATH_PARAM_BY_ID,employeeId)
                .body(updateEmployee, Employee.class)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    public Mono<String> deleteEmployeeById(Integer employeeId) {
        return webClient
                .delete()
                .uri(PATH_PARAM_BY_ID,employeeId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
