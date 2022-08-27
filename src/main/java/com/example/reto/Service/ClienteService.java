/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.reto.Service;

import com.example.reto.Model.Cliente;
import com.example.reto.Repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cristhian Desposorio
 */
@Service
public class ClienteService  implements InterClienteService{
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return clienteRepo.findAll();
    }
    
    @Override
    public double  promedioCliente(){
        
        List<Cliente> cliente = new ArrayList<>();
        
        cliente = clienteRepo.findAll();

        int sumaEdad = 0;
        double mediaCliente;
        for(Cliente c : cliente){
            sumaEdad = sumaEdad + c.getEdad();
        }
        
        mediaCliente = (double)  sumaEdad/cliente.size();
        
        return Math.round( mediaCliente * 100.0)/100.0 ;
    }
    
    @Override
    public double  desviacionCliente(){
        
        List<Cliente> cliente = new ArrayList<>();
        cliente = clienteRepo.findAll();

        double promedio =  promedioCliente();
        double sumatoriaUno=0.0,varianza,desviacionEstandar;
        
        for(Cliente c : cliente){
            sumatoriaUno = sumatoriaUno + Math.pow( c.getEdad() - promedio  , 2);
        }
        
        varianza = sumatoriaUno/cliente.size();
        desviacionEstandar = Math.round(Math.sqrt(varianza) * 100.0)/100.0  ;
        return desviacionEstandar;
    }
    
}
