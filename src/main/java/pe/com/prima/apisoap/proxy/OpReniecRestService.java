package pe.com.prima.apisoap.proxy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import pe.com.prima.apisoap.exception.ReniecColaException;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
@Service
public class OpReniecRestService {

    private final OpReniecClient proxyReniecPac;

    public OpReniecRestService(OpReniecClient proxyReniecPac) {
    	this.proxyReniecPac = proxyReniecPac;
    }

	public OpReniecClient.ByDniResponse consultarDatosDni(OpReniecClient.DniRequest request) {
		OpReniecClient.ByDniResponse retorno = null;
    	Response<OpReniecClient.ByDniResponse> response =  null;
        Call<OpReniecClient.ByDniResponse> retrofitCall = this.proxyReniecPac.consultarDNI(request);

        try {
        	response = retrofitCall.execute();
        	if (!response.isSuccessful()) {
	    		String mensajeErrorBody = response.errorBody().string();
	            throw new Exception(mensajeErrorBody);	            
	    	} else {
	    		retorno = response.body();
	    	}
		} catch (Exception ex) {
			throw new ReniecColaException(ex.getMessage(),ex);
        }

        return retorno;
	}

	public OpReniecClient.ByNombreResponse consultarNombres(OpReniecClient.ByNombreRequest request) {
		OpReniecClient.ByNombreResponse retorno = null;
		Response<OpReniecClient.ByNombreResponse> response =  null;
		Call<OpReniecClient.ByNombreResponse> retrofitCall = this.proxyReniecPac.consultarNombres(request);
		try {
			response = retrofitCall.execute();
			if (!response.isSuccessful()) {
				String mensajeErrorBody = response.errorBody().string();
				throw new Exception(mensajeErrorBody);
			} else {
				retorno = response.body();
			}
		} catch (Exception ex) {
			throw new ReniecColaException(ex.getMessage(),ex);
		}

		return retorno;
	}

}
