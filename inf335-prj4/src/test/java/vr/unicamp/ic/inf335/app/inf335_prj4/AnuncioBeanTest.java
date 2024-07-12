package vr.unicamp.ic.inf335.app.inf335_prj4;

import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnuncioBeanTest {

    @Test
    public void testDefaultConstructor() {
        AnuncioBean anuncio = new AnuncioBean();
        assertNotNull(anuncio.getProduto());
        assertTrue(anuncio.getFotosUrl().isEmpty());
        assertEquals(0.0, anuncio.getDesconto());
    }
    
    @Test
    public void testParameterizedConstructor() throws MalformedURLException {
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Descrição A", 200.0, "Novo");
        List<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto1.jpg"));
        fotos.add(new URL("http://example.com/foto2.jpg"));
        
        AnuncioBean anuncio = new AnuncioBean(produto, (ArrayList<URL>) fotos, 0.1);
        
        assertEquals(produto, anuncio.getProduto());
        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(0.1, anuncio.getDesconto());
    }
    
    @Test
    public void testGetSetMethods() throws MalformedURLException {
        ProdutoBean produto = new ProdutoBean("002", "Produto B", "Descrição B", 300.0, "Usado");
        List<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://example.com/foto3.jpg"));
        
        AnuncioBean anuncio = new AnuncioBean();
        anuncio.setProduto(produto);
        anuncio.setFotosUrl((ArrayList<URL>) fotos);
        anuncio.setDesconto(0.15);
        
        assertEquals(produto, anuncio.getProduto());
        assertEquals(fotos, anuncio.getFotosUrl());
        assertEquals(0.15, anuncio.getDesconto());
    }
    
    @Test
    public void testGetValor() {
        ProdutoBean produto = new ProdutoBean("003", "Produto C", "Descrição C", 500.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, new ArrayList<>(), 0.2);
        
        assertEquals(400.0, anuncio.getValor());
    }
    
    @Test
    public void testDescontoOutOfBounds() {
        AnuncioBean anuncio = new AnuncioBean();
        
        assertThrows(IllegalArgumentException.class, () -> {
            anuncio.setDesconto(-0.1);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            anuncio.setDesconto(1.1);
        });
    }
}
