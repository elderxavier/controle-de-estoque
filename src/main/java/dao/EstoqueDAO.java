package dao;

import db.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estoque;


public class EstoqueDAO {
    private final  ConexaoDB conexao;
    private String sql;
    PreparedStatement stmt;    
    
    public EstoqueDAO(){
        conexao = new ConexaoDB(); 
        
    }
    
    public void Inserir(Estoque estoque){
        
        sql = "INSERT INTO `estoque` (fabricante,tipo_uni,preco_compra,preco,quantidade,descricao,tipo)"+
                "VALUES(?,?,?,?,?,?,?,?)";          
        //Estoque estoque = new Estoque();
        try {
            stmt = this.conexao.getConexaoMySQL().prepareStatement(sql);            
            stmt.setString(1, estoque.getFabricante());
            stmt.setString(2, estoque.getTipo_uni());
            stmt.setDouble(3, estoque.getPreco_compra());
            stmt.setDouble(4, estoque.getPreco());
            stmt.setInt(5, estoque.getQuantidade());
            stmt.setString(6, estoque.getDescricao());
            stmt.setString(7, estoque.getTipo());
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key.',
            `fabricante` varchar(100) NOT NULL DEFAULT '' COMMENT 'Nome do fabricante.',
            `tipo_uni` varchar(50) NOT NULL DEFAULT 'pç' COMMENT 'tipo de unidade.',
            `preco_compra` varchar(50) NOT NULL DEFAULT '0.00' COMMENT 'preço da compra.',
            `preco` varchar(50) NOT NULL DEFAULT '0.00' COMMENT 'preço final do produto.',
            `quantidade` varchar(50) NOT NULL DEFAULT '0.00' COMMENT 'quantidade em estoque.',
            `descricao` varchar(50) NOT NULL DEFAULT '0.00' COMMENT 'descricao do produto.',
            `tipo` varchar(50) NOT NULL DEFAULT '0.00' COMMENT 'tipo do produto (exe:vesturario, equipamento,diversos).',*/ 
            
    
}
