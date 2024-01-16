package com.eliezer.springcloud.msvc.financiera.msvcfinanciera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * Autor: Eliezer Santiago
 * Fecha:16/01/2024
 *
 * Descripcion: Clase main para ejecutar microservicio financiera
 * */

@EnableFeignClients//Habilitar Api de Feign
@SpringBootApplication
public class MsvcFinancieraApplication {

	public static void main(String[] args) {

		SpringApplication.run(MsvcFinancieraApplication.class, args);
	}

}
