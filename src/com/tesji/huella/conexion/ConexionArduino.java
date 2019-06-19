package com.tesji.huella.conexion;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ConexionArduino {
	private String id;
	private  String mensaje;
	private  int IDhuella = 0;
	
	private  PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	private  SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			try {
				if (ino.isMessageAvailable()) {
					mensaje = ino.printMessage();
					if (mensaje.toString().trim().length() <= 3 ) {
						setIDhuella(Integer.parseInt(mensaje.toString().trim()));
						//System.out.println(getIDhuella());
					}else {
						System.out.println(mensaje);
					}
				}
			} catch (SerialPortException | ArduinoException ex) {
				System.out.println("Error conexion con arduino " + ex);
			}
		}
	};

	public ConexionArduino() {	
		try {
			ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
		} catch (ArduinoException e) {
			System.out.println("Error Conexion" + e);
		}
	}
	
	public void CerrarConexion() {
		try {
			ino.killArduinoConnection();
		} catch (ArduinoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void manterActivo() {
		try {
			ino.sendByte(0);
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
	}

	public void registroHuella() {
		Conexion idSiguiente = new Conexion();
		int id = Integer.parseInt(idSiguiente.consultaId());
		id++;
		String ids = String.valueOf(id);
		System.out.println(ids);
		try {
			ino.sendByte(2);
			//System.out.println("Date enviada id");
			ino.sendByte(id);
			System.out.println("Porfavor Coloca tu dedo indice");
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
	}
	
	public void busqueda(int opc) {
		try {
			ino.sendByte(opc);
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
		System.out.println("Salida busqueda ca");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getIDhuella() {
		return IDhuella;
	}

	public void setIDhuella(int iDhuella) {
		IDhuella = iDhuella;
	}
	
	
}
