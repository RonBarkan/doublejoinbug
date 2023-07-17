# NPE when left outer joining two or more one-to-many tables with @Query

Micronaut Data throws an NPE when two or more one-to-many tables are joined with a custom query.\
[Issue link](https://github.com/micronaut-projects/micronaut-data/issues/2363)

## Actual behavior
```
Caused by: java.lang.NullPointerException
at java.base/java.util.Objects.requireNonNull(Objects.java:208)
at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper.readChildren(SqlResultEntityTypeMapper.java:329)
at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper.readChildren(SqlResultEntityTypeMapper.java:341)
at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper.access$400(SqlResultEntityTypeMapper.java:76)
at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper$2.processRow(SqlResultEntityTypeMapper.java:302)
at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.findStream(DefaultJdbcRepositoryOperations.java:447)
```

Alternatively, an entity queried from the database will not be populated as entity/ies.

## Cause
This materializes when there are two or more one-to-many left outer joins. When one of the outer joins is not null, the other is null AND there's more than one output row. An NPE will be thrown for such a case, except for the first row of the root entity.

In the above example, the query result set should be

|A | B | C |
|-|-|-|
|a1|b1|c1|
|a1|b2|null|

The null is due to the left join of the custom query.
