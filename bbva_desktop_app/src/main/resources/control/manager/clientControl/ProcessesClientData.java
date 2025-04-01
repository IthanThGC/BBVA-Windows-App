package main.resources.control.manager.clientControl;

import javax.swing.JTextField;

import main.java.com.bbva_digital_app.register.client.LaunchRegister1;

public class ProcessesClientData extends LaunchRegister1 {
	
	private static final long serialVersionUID = 9001149131177221333L;
	
	/*
	 *  Client attributes
	 **/
	private String nombreCompletoCliente = "nombre del cliente no disponible";
	private String fechaNacimientoCliente = "fecha de nacimiento no disponible";

    private String curpCliente = "no disponible";
    /**/
    private String estadoResidenciaCliente = "no disponible";
    private String ciudadResidenciaCliente = "no disponible";
    private String coloniaResidenciaCliente = "no disponible";
    private String calleResidenciaCliente = "no disponible";
    private String cpResidenciaCliente = "no disponible";
    private String numExteriorDomicilioCliente = "no disponible";
    private String numInteriorDomicilioCliente = "no disponible";
    /**/
    private String emailPrincipalCliente = "no disponible";
    private String emailSecundarioCliente = "no se añadio un email adicional";
    private String numCelularPrincipalCliente = "no disponible";
    private String numCelularSecundarioCliente = "no se añadio un número tel. adicional";
	
    private final String PLACEHOLDER_NUM_INTE = "No. Del domicilio";
	private final String PLACEHOLDER_PHONE_NUMBER = "Número teléfonico";
	private final String EMPTY = "";
			
	public ProcessesClientData() {
		//Empty constructor
	}
	
	/*
     *   SETTER ATTRIBUTES CLIENT
     */
    
	public void setNombreCompletoCliente(JTextField txt_name_client, JTextField txt_apellido_paterno_cliente, JTextField txt_apellido_materno_cliente){
		this.nombreCompletoCliente = txt_apellido_materno_cliente.getText().concat(" ")
				.concat(txt_apellido_paterno_cliente.getText())
				.concat(" ").concat(txt_name_client.getText());
	}

	public void setFechaNacimientoCliente(Object day, Object month, Object year){
		this.fechaNacimientoCliente = String.valueOf(day)
				.concat(" / ").concat(String.valueOf(month))
				.concat(" / ").concat(String.valueOf(year));
	}
	
	public void setCurpClient(String curpCliente) {
		this.curpCliente = curpCliente;
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public void setEstadoResidenciaCliente(String estadoResidenciaCliente) {
		this.estadoResidenciaCliente = estadoResidenciaCliente;
	}
	
	public void setCiudadResidenciaCliente(String ciudadResidenciaCliente) {
		this.ciudadResidenciaCliente = ciudadResidenciaCliente;
	}

    public void setColoniaResidenciaCliente(String coloniaResidenciaCliente) {
    	this.coloniaResidenciaCliente = coloniaResidenciaCliente;
    }
    
    public void setCalleResidenciaCliente(String calleResidenciaCliente) {
    	this.calleResidenciaCliente = calleResidenciaCliente;
    }
    
    public void setCpResidenciaCliente(String cpResidenciaCliente) {
    	//System.out.print(cpResidenciaCliente);
    	this.cpResidenciaCliente = cpResidenciaCliente;
    }
    
    public void setNumExteriorDomicilioCliente(String numExteriorDomicilioCliente) {
    	this.numExteriorDomicilioCliente = numExteriorDomicilioCliente;
    }
    
    public void setNumInteriorDomicilioCliente(String numInteriorDomicilioCliente) {
    	if(!(numInteriorDomicilioCliente.equals(PLACEHOLDER_NUM_INTE) 
    			|| numInteriorDomicilioCliente.equals(EMPTY))) {
    		this.numInteriorDomicilioCliente = numInteriorDomicilioCliente;
    	}
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public void setEmailPrincipalCliente(String emailPrincipalCliente) {
    	this.emailPrincipalCliente = emailPrincipalCliente;
    }
    
    public void setEmailSecundarioCliente(String emailSecundarioCliente) {
    	if(!(emailSecundarioCliente.equals(EMPTY))) {
    		this.emailSecundarioCliente = emailSecundarioCliente;
    	}
    }
    
    public void setNumCelularPrincipalCliente(String numCelularPrincipalCliente) {
    	this.numCelularPrincipalCliente = numCelularPrincipalCliente;
    }
    
    public void setNumCelularSecundarioCliente(String numCelularSecundarioCliente) {
    	if(!(numCelularSecundarioCliente.equals(PLACEHOLDER_PHONE_NUMBER) 
    			|| numCelularSecundarioCliente.equals(EMPTY))) {
    		this.numCelularSecundarioCliente = numCelularSecundarioCliente;
    	}
    }
    
    /*
     *   GETTER ATTRIBUTES CLIENT
     */
    
	//attributes composed of other variables

	public String getFullNameClient(){
		/*String fullName = String.valueOf(apellidoPaternoCliente).concat(" ").
				concat(String.valueOf(apellidoMaternoCliente)).concat(" ").
				concat(String.valueOf(nombreCliente));
		if(nombreCliente != null 
				&& apellidoPaternoCliente != null 
				&& apellidoMaternoCliente != null) return fullName;
		return null;*/
		return nombreCompletoCliente;
	}
    
    public Object getBornDateClient() {
		/*String bordDateClient = String.valueOf(diaNacimientoCliente).concat(" / ").
				concat(String.valueOf(mesNacimientoCliente)).concat(" / ").
				concat(String.valueOf(anioNacimientoCliente));
		if(diaNacimientoCliente != null
				&& mesNacimientoCliente != null
				&& anioNacimientoCliente != null) return bordDateClient.toString();
		return null;*/
		return fechaNacimientoCliente;
    }
    
    public String getCurpClient() {
    	return curpCliente.toString();
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public String getStateResidenceClient() {
    	return estadoResidenciaCliente.toString();
    }

    public String getCityResidenceClient(){
    	return ciudadResidenciaCliente.toString();
    }
    
    public String getNeighborhoodResidenceClient(){
    	return coloniaResidenciaCliente.toString();
    }

    public String getStreetResidenceClient(){
    	return calleResidenciaCliente.toString();
    }

    public String getCpResidenceClient(){
    	return cpResidenciaCliente.toString();
    }

    public String getNumberExteriorHomeResidenceClient(){
    	return numExteriorDomicilioCliente.toString();
    }

    public String getNumberInteriorHomeResidenceClient(){
    	return numInteriorDomicilioCliente.toString();
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public String getPrincipalEmailClient(){
    	return emailPrincipalCliente.toString();
    }

    public String getSecondEmailClient(){
    	return emailSecundarioCliente.toString();
    }

    public String getPrincipalPhoneNumberClient(){
    	return numCelularPrincipalCliente.toString();
    }

    public String getSecondPhoneNumberClient(){
    	return numCelularSecundarioCliente.toString();
    }    
    
    /*public static void main(String[] args) {
    	prepareClientData dataClient = new prepareClientData();
    	dataClient.setnombreCliente("Ethan");
    	dataClient.setapellidoPaternoCliente("Godínez");
    	dataClient.setapellidoMaternoCliente("Cisneros");
    	dataClient.setBornDateClient(26, 01, 2005);
    	
    	System.out.print(dataClient.getFullNameClient()+"\n");
    	System.out.print(dataClient.getBornDateClient());
    	System.exit(0);
    }*/
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    
    /*public ArrayList<Object> getClient(){
    	clientList.add(getFullNameClient());
    	clientList.add(getCurpClient());
    	clientList.add(getBornDateClient());
    	clientList.add(getStateResidenceClient());
    	clientList.add(getCityResidenceClient());
    	clientList.add(getNeighborhoodResidenceClient());
    	clientList.add(getStreetResidenceClient());
    	clientList.add(getNumberExteriorHomeResidenceClient());
    	clientList.add(getNumberInteriorHomeResidenceClient());
    	clientList.add(getPrincipalEmailClient());
    	clientList.add(getSecondEmailClient());
    	clientList.add(getPrincipalPhoneNumberClient());
    	clientList.add(getSecondPhoneNumberClient());
		return clientList;
	}
    
    public int getListSize() {
    	return clientList.size();
    }*/
}
