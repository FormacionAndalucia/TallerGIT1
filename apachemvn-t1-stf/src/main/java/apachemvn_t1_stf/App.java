package apachemvn_t1_stf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * Author: Sergio Turrillo Fernández Date: 2024/05/02 Intention: Crear un
 * códigoQR, para que al escaneralo muestre el nombre que se introduzca
 * 
 */

public class App {

	// Definicion del Logger, para poder utilizarlo en el código
	private static final Logger registro = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException {

		System.out.println("Introduce lo que quieres que aparezca cuando se genere el código QR:");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();

		if (StringUtils.isBlank(nombre)) {
			registro.error("No has introducido nada");
		} else {
			registro.info("Generando codigo QR...");
		}

		/*
		 * * Este método principal genera el código QR con el nombre especificado.
		 *
		 * @param args Argumentos de la línea de comandos (no utilizados en este caso)
		 * 
		 * @throws IOException Si ocurre un error de E/S al guardar el código QR en un
		 * archivo
		 * 
		 * @throws WriterException Si ocurre un error al generar el código QR
		 */
		Map<EncodeHintType, Object> sugerencias = new HashMap<>(); // Inicializa el mapa vacío
		sugerencias.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // Agrega una sugerencia para especificar el conjunto de
																// caracteres que se utilizará para la codificación
		sugerencias.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // Sugerencia para especificar el
																					// nivel de correccíon de errores
		sugerencias.put(EncodeHintType.MARGIN, 1); // Sugerencia para especificar el margen que rodea el códigoQR

		// Genera el código QR
		try {
			QRCodeWriter escritorDelCodigoQR = new QRCodeWriter(); // Esta línea crea un nuevo objeto File que
																	// representa un archivo llamado "codigo_qr.png"

			BitMatrix matrizBits = escritorDelCodigoQR.encode(nombre, BarcodeFormat.QR_CODE, 200, 200, sugerencias);

			ByteArrayOutputStream salidaBytes = new ByteArrayOutputStream(); // Esta línea crea un nuevo
																				// ByteArrayOutputStream

			MatrixToImageWriter.writeToStream(matrizBits, "PNG", salidaBytes); // Esta línea llama al método estático
																				// writeToStream de la clase

			// Guarda el código QR en un archivo
			File archivoQR = new File("codigo_qr.png");
			salidaBytes.writeTo(Files.newOutputStream(archivoQR.toPath()));

			registro.info("Codigo QR generado con éxito"); // Mensaje informativo usando el logger

		} catch (WriterException e) {

			registro.error("Error al generar el código QR"); // Registra un mensaje de error usando el logger, junto con
																// la excepción "e"

		}
	}
}
