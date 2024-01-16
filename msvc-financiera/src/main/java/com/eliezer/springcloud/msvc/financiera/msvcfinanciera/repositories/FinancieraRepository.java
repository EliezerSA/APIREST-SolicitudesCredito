package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.repositories;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity.Financiera;
import org.springframework.data.repository.CrudRepository;

/***
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Repositorio que hereda de CrudRepository para los metodos de CRUD
 *
 */

public interface FinancieraRepository extends CrudRepository<Financiera, Long> {
}
