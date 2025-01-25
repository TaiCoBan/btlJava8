package com.utc.btljava.database.service.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
  T create(T t);
  Optional<T> findById(int id);
  List<T> findAll();
  T update(T t);
  void deleteById(int id);
}
