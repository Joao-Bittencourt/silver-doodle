/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
        estrutura da tabela produto
        create table produto(
        id int(11) not null auto_increment,
        nome varchar(100),
        valor decimal(15,2),
        primary key(id)	
        )
 */
package spring.web.web.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import spring.web.web.model.entity.Produto;

/**
 *
 * @author joao
 */
@Component
public class ProdutoDAO {

    @Autowired
    JdbcTemplate jdbc;
    
     private Produto  CriaObjeto(SqlRowSet rowSet){
           Produto p =new Produto();
           p.setNome(rowSet.getString("nome"));
           p.setId(rowSet.getInt("id"));
           p.setValor((float)rowSet.getDouble("valor"));
    return p;
    
    
    }

    public Produto cadastrar(Produto a) {
        jdbc.update("INSERT INTO produto(nome, valor) VALUES (?,?)",
                a.getNome(),
                a.getValor()
        );
        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        a.setId(id);
        return a;
    }
    
    public ArrayList<Produto> listar( ){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
       SqlRowSet rowSetProduto = jdbc.queryForRowSet("select * from produto");
         jdbc.execute("select * from produto");
        while(rowSetProduto.next()){
          
           listaProdutos.add( CriaObjeto(rowSetProduto));
        }
         return listaProdutos;
     }
}
