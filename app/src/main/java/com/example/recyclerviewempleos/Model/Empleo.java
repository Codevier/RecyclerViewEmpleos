package com.example.recyclerviewempleos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Empleo {
    @SerializedName("OfertaLaboral")
    @Expose
    private String ofertaLaboral;
    @SerializedName("Empresa")
    @Expose
    private String empresa;
    @SerializedName("Cargo")
    @Expose
    private String cargo;
    @SerializedName("Correo")
    @Expose
    private String correo;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Imagen")
    @Expose
    private String imagen;

    public String getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(String ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Empleo(JSONObject a) throws JSONException {
        ofertaLaboral =  a.getString("OfertaLaboral").toString();
        empresa =  a.getString("Empresa").toString() ;
        cargo =  a.getString("Cargo").toString() ;
        correo =  a.getString("Correo").toString() ;
        imagen = a.getString("Imagen").toString() ;
        descripcion= a.getString("Descripcion").toString();
    }

    public static ArrayList<Empleo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Empleo> empleos = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            empleos.add(new Empleo(datos.getJSONObject(i)));
        }
        return empleos;
    }
}
