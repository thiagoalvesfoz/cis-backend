package br.uniamerica.cis.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface ControllerMethods<T> {
	EntityModel<T> one(Long id);
	CollectionModel<EntityModel<T>> all();
}
