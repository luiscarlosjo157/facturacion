package com.springbootdatajpa.controllers;

import com.springbootdatajpa.models.entity.Cliente;
import com.springbootdatajpa.models.entity.Factura;
import com.springbootdatajpa.models.entity.ItemFatura;
import com.springbootdatajpa.models.entity.Producto;
import com.springbootdatajpa.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id,
                      Model model,
                      RedirectAttributes flash){
        Factura factura = factura = clienteService.fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(id); //clienteService.findFacturaById(id);
        if (factura == null){
            flash.addFlashAttribute("error", "La factura no existesee en la base de datos!");
            return "redirect:/listar";
        }

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
        return "factura/ver";
    }

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable(value = "clienteId") Long clienteId,
                        Map<String, Object> model, RedirectAttributes flash){

        Cliente cliente = clienteService.findOne(clienteId);
        if (cliente == null){
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect/listar";
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.put("factura", factura);
        model.put("titulo", "Creat Factura");
        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){
        return clienteService.finByNombre(term);
    }

    @PostMapping("/form")
    public String guardar(@Valid Factura factura,
                          BindingResult result,
                          Model model,
                          @RequestParam(name="item_id[]", required = false) Long[] itemId,
                          @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
                          RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("titulo", "Crear factura");
            return "factura/form";
        }

        if (itemId == null || itemId.length == 0){
            model.addAttribute("titulo", "Crear Factura");
            model.addAttribute("error", "Error: la Factura no puede tener lineas");
            return "factura/form";
        }
        for (int i = 0; i< itemId.length; i++){
            Producto producto = clienteService.findProductoById(itemId[i]);

            ItemFatura linea = new ItemFatura();
            linea.setCantidad(cantidad[i]);
            linea.setProducto(producto);
            factura.addItemFactura(linea);

        }

        clienteService.saveFactura(factura);

        status.setComplete();

        flash.addFlashAttribute("success", "Factura creada con éxito!");

        return "redirect:/ver/" + factura.getCliente().getId();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        Factura factura = clienteService.findFacturaById(id);

        if (factura != null){
            clienteService.deleteFactura(id);
            flash.addFlashAttribute("success" , "Factura elininada con exito");
            return "redirect:/ver/" + factura.getCliente().getId();
        }

        flash.addFlashAttribute("error", "La factura no existe en la base de datos, no se pudo eliminar!");
        return "redirect:/listar";
    }
}
