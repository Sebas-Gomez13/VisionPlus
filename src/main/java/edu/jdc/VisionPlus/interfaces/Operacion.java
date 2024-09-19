package edu.jdc.VisionPlus.interfaces;

import java.util.List;


public interface Operacion<T> {
     public List<T>consultar (String orden);
    public Boolean registrar(T objRegistrar);
    public T buscar (Integer llavePrimaria);
    public Boolean actualizar (T objActualizar);
    public Boolean eliminar(Integer llavePrimaria);
    public Integer cantidadRegistros();
}
