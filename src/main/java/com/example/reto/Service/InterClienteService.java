/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.reto.Service;

import com.example.reto.Model.Cliente;
import java.util.List;

/**
 *
 * @author Cristhian Desposorio
 */
public interface InterClienteService {
    
    void guardar(Cliente cliente);
    List<Cliente> listar();
    double promedioCliente();
    double desviacionCliente();
    
}
