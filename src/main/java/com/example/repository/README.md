# Repository Layer
Connects SpringBoot app to the database using ``CrudRepository<T, E>``

## Builtin Methods

```java
// adds and saves single entity to the database
<S extends T> S save(S var1);

// adds and saves multiple entity to the database
<S extends T> Iterable<S> saveAll(Iterable<S> var1);

// find an entity by id
Optional<T> findById(ID var1);

// check if db has the following entity by id
boolean existsById(ID var1);

// gets all entities in db
Iterable<T> findAll();

// finds all entities that match the given ids
Iterable<T> findAllById(Iterable<ID> var1);

// count the number of entities
long count();

// delete an entity with the given Id
void deleteById(ID var1);

// delete the following entity
void delete(T var1);

// deletes the given entities
void deleteAll(Iterable<? extends T> var1);

// clears the database of entities
void deleteAll();
```

