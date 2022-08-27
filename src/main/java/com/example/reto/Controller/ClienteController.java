/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.reto.Controller;

import com.example.reto.Model.Cliente;
import com.example.reto.Service.InterClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristhian Desposorio
 */
@RestController
@RequestMapping(value="/api")
public class ClienteController {
    
    @Autowired
    private InterClienteService intClienteService;
    
    
    @GetMapping("/listclientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarCliente(){
        return intClienteService.listar();
    }
    
    @PostMapping(name="/creacliente")
    @ResponseStatus(HttpStatus.OK)
    public void crearCliente( @RequestBody Cliente cliente){
        intClienteService.guardar(cliente); 
    }
    
    @GetMapping("/kpideclientes")
    public String kpiCliente(){
        double promedio = intClienteService.promedioCliente();
        double desviacionEstandar = intClienteService.desviacionCliente();
        
        String mensaje = "El promedio es: "+ promedio + "\n"+"La desviacion estandar es: "+desviacionEstandar + " años";
        
        return mensaje;
    }
    
}
