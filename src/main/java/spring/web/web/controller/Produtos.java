/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.web.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.web.web.model.dao.ProdutoDAO;
import spring.web.web.model.entity.Produto;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
@Controller
@ResponseBody
public class Produtos {
    @Autowired
    ProdutoDAO produtoDAO;
    
    @RequestMapping(path = "/produto/cadastrar", method = RequestMethod.POST )
    public Produto cadastrar(@RequestBody Produto a){
        return produtoDAO.cadastrar(a);
         
    }
    
    @RequestMapping(path = "/produto/listar", method = RequestMethod.GET)
    public ArrayList<Produto> listarProduto() {
        return produtoDAO.listar();
    }
    
}
