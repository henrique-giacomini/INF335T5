package vr.unicamp.ic.inf335.app.inf335_prj4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoBeanTest {

    @Test
    public void testDefaultConstructor() {
        ProdutoBean produto = new ProdutoBean();
        assertEquals("", produto.getCodigo());
        assertEquals("", produto.getNome());
        assertEquals("", produto.getDescricao());
        assertEquals(0.0, produto.getValor());
        assertEquals("", produto.getEstado());
    }
    
    @Test
    public void testParameterizedConstructor() {
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Descrição A", 100.0, "Novo");
        assertEquals("001", produto.getCodigo());
        assertEquals("Produto A", produto.getNome());
        assertEquals("Descrição A", produto.getDescricao());
        assertEquals(100.0, produto.getValor());
        assertEquals("Novo", produto.getEstado());
    }
    
    @Test
    public void testGetSetMethods() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("002");
        produto.setNome("Produto B");
        produto.setDescricao("Descrição B");
        produto.setValor(200.0);
        produto.setEstado("Usado");
        
        assertEquals("002", produto.getCodigo());
        assertEquals("Produto B", produto.getNome());
        assertEquals("Descrição B", produto.getDescricao());
        assertEquals(200.0, produto.getValor());
        assertEquals("Usado", produto.getEstado());
    }
    
    @Test
    public void testCompareTo() {
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descrição A", 150.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descrição B", 100.0, "Novo");
        
        assertTrue(produto1.compareTo(produto2) > 0);
        assertTrue(produto2.compareTo(produto1) < 0);
        
        ProdutoBean produto3 = new ProdutoBean("003", "Produto C", "Descrição C", 150.0, "Usado");
        assertEquals(0, produto1.compareTo(produto3));
    }
}