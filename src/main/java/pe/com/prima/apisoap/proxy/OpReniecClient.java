package pe.com.prima.apisoap.proxy;

import lombok.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Arrays;
import java.util.List;

public interface OpReniecClient {
    @Setter
    @Getter
    public static class DniRequest {
        private String dni;
        private DatosAuditoria datosAuditoria;
    }
    @Setter
    @Getter
    public class DatosAuditoria {
        private String codAgencia;
        private String nombreAgencia;
        private String codEjecutivo;
        private String nombreEjecutivo;
        private String ip;
        private String version;
        private String codigoInstitucionSolicitante;
        private String caracteresVerificacion;
        private String dniEjecutivo;
        private int idLog;
    }
    @Setter
    @Getter
    class ByDniResponse {
        private Cabecera cabecera;
        private Resultado resultado = new Resultado();
        private RespDNIDatos datosReniec;
        private RespDNIDatos datosPensiones;
        private DataReporte dataReporte;
   }
    @Setter
    @Getter
    public class DatosComplementarios {
        private String descEstadoCivil;
        private String descGradoInstruccion;
        private String descSexo;
        private String descConstanciaVotacion;
        private String descRestriccion;
        private String descPrefijoDireccion;
        private String descPrefijoBlockChalet;
        private String descPrefijoDptoPisoInterior;
        private String descPrefijoUrbCondResid;
        private String direccionCompleta;
    }
    @Setter
    @Getter
    public class RespDNIDatos {
        private DatosComplementarios datosComplementarios;
        private String codigoError;
        private String numeroDNI;
        private String digitoVerificacion;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String apellidoCasada;
        private String nombres;
        private String codigoUbigeoDepartamentoDomicilio;
        private String codigoUbigeoProvinciaDomicilio;
        private String codigoUbigeoDistritoDomicilio;
        private String departamentoDomicilio;
        private String provinciaDomicilio;
        private String distritoDomicilio;
        private String estadoCivil;
        private String codigoGradoInstruccion;
        private String estatura;
        private String sexo;
        private String documentoSustentatorioTipoDoc;
        private String documentoSustentatorioNumeroDoc;
        private String codigoUbigeoDepartamentoNacimiento;
        private String codigoUbigeoProvinciaNacimiento;
        private String codigoUbigeoDistritoNacimiento;
        private String departamentoNacimiento;
        private String provinciaNacimiento;
        private String distritoNacimiento;
        private String fechaNacimiento;
        private String nombrePadre;
        private String nombreMadre;
        private String fechaInscripcion;
        private String fechaExpedicion;
        private String constanciaVotacion;
        private String restriccion;
        private String prefijoDireccion;
        private String direccion;
        private String numeroDireccion;
        private String blockChalet;
        private String interior;
        private String urbanizacion;
        private String etapa;
        private String manzana;
        private String lote;
        private String prefijoBlockChalet;
        private String prefijoDptoPisoInterior;
        private String prefijoUrbCondResid;
        private String reservado;
        private String foto;
        private String firma;
    }
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Resultado {
        private EstadoEnumTDO estado;
        private String mensajeInterno;

        public Resultado(Exception ex) {
            estado = EstadoEnumTDO.ERROR;
            mensajeInterno = ex.getMessage();
        }

        @Getter
        public enum EstadoEnumTDO {

            EXITO("Exito"),
            ERROR("Error");

            private final String value;

            EstadoEnumTDO(String v) {
                value = v;
            }

            public String value() {
                return value;
            }

            public static EstadoEnumTDO fromValue(String v) {
                return Arrays.stream(values()).filter(e-> e.getValue().equalsIgnoreCase(v))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(v));
            }

        }
    }
    @Setter
    @Getter
    public class Cabecera {
        private String version;
        private int longitudCabecera;
        private String tipoServicio;
        private int longitudTotalTrama;
        private String fragmentacion;
        private int ttl;
        private String tipoConsulta;
        private String caracteresVerificacion;
        private String codigoInstitucionSolicitante;
        private String codigoServidorRENIEC;
        private String agenciaInstitucionSolicitante;
        private String usuarioFinalInstitucionSolicitante;
        private String hostFinalInstitucionSolicitante;
        private String reservado;

    }
    @Setter
    @Getter
    public static class DataReporte {
        protected List<Object> any;
        protected Object any2;
    }

    @POST("reniec/v1/bydni")
    Call<ByDniResponse> consultarDNI(@Body DniRequest request);

    @Setter
    @Getter
    public static class ByNombreRequest {
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String nombres;
        private String inicio;
        private int cant;
        private DatosAuditoria datosAuditoria;
    }

    @Setter
    @Getter
    public static class ByNombreResponse {
        protected Resultado resultado = new Resultado();
        protected Cabecera cabecera;
        protected RespNombresCabecera subCabecera = new RespNombresCabecera();
        protected ArrayOfRespNombresDetalle detalles;
    }
    @Setter
    @Getter
    public class RespNombresCabecera {
        protected String codigoError;
        protected int numeroTotalCoincidencias;
        protected String reservado;
    }
    @Setter
    @Getter
    public class RespNombresDetalle {
        private String numeroDNI;
        private String caracterVerificacion;
        private String tipoFichaRegistral;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String prenombres;
        private String datos;
        private String imagen;
        private String reservado;

    }
    @Setter
    @Getter
    public class ArrayOfRespNombresDetalle {
        protected List<RespNombresDetalle> respNombresDetalle;
    }


    @POST("reniec/v1/bynames")
    Call<ByNombreResponse> consultarNombres(ByNombreRequest request);
	

}
