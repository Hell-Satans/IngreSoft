package com.UdeA.IngreSoft.MovimientoDinero;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

public class MovimientosDinero {

        private UserPrincipal Usuario;
        private String Concepto;
        private float Monto;
        private Date Fecha;
        private Empresa empresa;

        public MovimientoDinero(UserPrincipal usuario, String concepto, float monto, Date fecha, Empresa empresa) {
            Usuario = usuario;
            Concepto = concepto;
            Monto = monto;
            Fecha = fecha;
            this.empresa = empresa;
        }

        public UserPrincipal getUsuario() {
            return Usuario;
        }

        public void setUsuario(UserPrincipal usuario) {
            Usuario = usuario;
        }

        public String getConcepto() {
            return Concepto;
        }

        public void setConcepto(String concepto) {
            Concepto = concepto;
        }

        public float getMonto() {
            return Monto;
        }

        public void setMonto(float monto) {
            Monto = monto;
        }

        public Date getFecha() {
            return Fecha;
        }

        public void setFecha(Date fecha) {
            Fecha = fecha;
        }

        public Empresa getEmpresa() {
            return empresa;
        }


}
