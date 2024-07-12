package vr.unicamp.ic.inf335.app.inf335_prj4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnuncianteBeanTest {

    @Test
    public void testDefaultConstructor() {
        AnuncianteBean anunciante = new AnuncianteBean();
        assertEquals("", anunciante.getNome());
        assertEquals("", anunciante.getCPF());
        assertTrue(anunciante.getAnuncios().isEmpty());
    }
    
    @Test
    public void testParameterizedConstructor() {
        List<AnuncioBean> anuncios = new ArrayList<>();
        AnuncioBean anuncio1 = new AnuncioBean();
        AnuncioBean anuncio2 = new AnuncioBean();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);
        
        AnuncianteBean anunciante = new AnuncianteBean("João Silva", "123.456.789-00", (ArrayList<AnuncioBean>) anuncios);
        
        assertEquals("João Silva", anunciante.getNome());
        assertEquals("123.456.789-00", anunciante.getCPF());
        assertEquals(anuncios, anunciante.getAnuncios());
    }
    
    @Test
    public void testGetSetMethods() {
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.setNome("Maria Oliveira");
        anunciante.setCPF("987.654.321-00");
        
        List<AnuncioBean> anuncios = new ArrayList<>();
        AnuncioBean anuncio = new AnuncioBean();
        anuncios.add(anuncio);
        anunciante.setAnuncios((ArrayList<AnuncioBean>) anuncios);
        
        assertEquals("Maria Oliveira", anunciante.getNome());
        assertEquals("987.654.321-00", anunciante.getCPF());
        assertEquals(anuncios, anunciante.getAnuncios());
    }
    
    @Test
    public void testAddRemoveAnuncio() {
        AnuncianteBean anunciante = new AnuncianteBean();
        AnuncioBean anuncio1 = new AnuncioBean();
        AnuncioBean anuncio2 = new AnuncioBean();
        
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        
        assertEquals(2, anunciante.getAnuncios().size());
        assertTrue(anunciante.getAnuncios().contains(anuncio1));
        assertTrue(anunciante.getAnuncios().contains(anuncio2));
        
        anunciante.removeAnuncio(0);
        assertEquals(1, anunciante.getAnuncios().size());
        assertFalse(anunciante.getAnuncios().contains(anuncio1));
    }
    
 
    
    @Test
    public void testValorMedioAnuncios() {
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descrição A", 200.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descrição B", 300.0, "Usado");
        
        AnuncioBean anuncio1 = new AnuncioBean(produto1, new ArrayList<>(), 0.1); // Valor: 180.0
        AnuncioBean anuncio2 = new AnuncioBean(produto2, new ArrayList<>(), 0.2); // Valor: 240.0
        
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        
        assertEquals(210.0, anunciante.valorMedioAnuncios(), 0.001);
    }
}