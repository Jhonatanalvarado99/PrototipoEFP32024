/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Peliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author visitante
 */
public class PeliculasDAO {

    private static final String SQL_SELECT = "SELECT idPeliculas, nombre_pel, clasificacion_pel,  genero_pel, subtitulado_pel, idioma_pel, precio_pel FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(idPeliculas, nombre_pel, clasificacion_pel,  genero_pel, subtitulado_pel, idioma_pel, precio_pel) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE peliculas SET nombre_pel=?, clasificacion_pel=?, genero_pel=?, subtitulado_pel=?, idioma_pel=?, precio_pel=? WHERE idPeliculas = ?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE idPeliculas=?";
    private static final String SQL_QUERY = "SELECT idPeliculas, nombre_pel, clasificacion_pel,  genero_pel, subtitulado_pel, idioma_pel, precio_pel FROM peliculas WHERE idPeliculas = ?";

    public List<Peliculas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas pelicula = null;
        List<Peliculas> peliculas = new ArrayList<Peliculas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("idPeliculas");
                String nombre = rs.getString("nombre_pel");
                String clasificacion = rs.getString("clasificacion_pel");
                String genero = rs.getString("genero_pel");
                String subtitulado = rs.getString("subtitulado_pel");
                String idioma = rs.getString("idioma_pel");
                String precio = rs.getString("precio_pel");
                
                
                
                
                pelicula = new Peliculas();
                pelicula.setIdPeliculas(codigo);
                pelicula.setNombre_pel(nombre);
                pelicula.setClasificacion_pel(clasificacion);
                pelicula.setGenero_pel(genero);
                pelicula.setSubtitulado_pel(subtitulado);
                pelicula.setIdioma_pel(idioma);
                pelicula.setPrecio_pel(precio);
            
                
                
                peliculas.add(pelicula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return peliculas;
    }

    public int insert(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getIdPeliculas());
            stmt.setString(2, pelicula.getNombre_pel());
            stmt.setString(3, pelicula.getClasificacion_pel());
            stmt.setString(4, pelicula.getGenero_pel());
            stmt.setString(5, pelicula.getSubtitulado_pel());
            stmt.setString(6, pelicula.getIdioma_pel());
            stmt.setString(7, pelicula.getPrecio_pel());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getIdPeliculas());
            stmt.setString(2, pelicula.getNombre_pel());
            stmt.setString(3, pelicula.getClasificacion_pel());
            stmt.setString(4, pelicula.getGenero_pel());
            stmt.setString(5, pelicula.getSubtitulado_pel());
            stmt.setString(6, pelicula.getIdioma_pel());
            stmt.setString(7, pelicula.getPrecio_pel());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Peliculas pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pelicula.getIdPeliculas());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Peliculas query(Peliculas pelicula) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, pelicula.getIdPeliculas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("idPeliculas");
                String nombre = rs.getString("nombre_pel");
                String clasificacion = rs.getString("clasificacion_pel");
                String genero = rs.getString("genero_pel");
                String subtitulado = rs.getString("subtitulado_pel");
                String idioma = rs.getString("idioma_pel");
                String precio = rs.getString("precio_pel");
                
                pelicula = new Peliculas();
               
                pelicula.setIdPeliculas(codigo);
                pelicula.setNombre_pel(nombre);
                pelicula.setClasificacion_pel(clasificacion);
                pelicula.setGenero_pel(genero);
                pelicula.setSubtitulado_pel(subtitulado);
                pelicula.setIdioma_pel(idioma);
                pelicula.setPrecio_pel(precio);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pelicula;
    }
        
}
