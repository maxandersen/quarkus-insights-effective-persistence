### Repo for use during Quarkus Insights Effective Persistence

A nice big mix of jbang, quarkus, hibernate, sakila test db, postgres and some jooq for fun.

Edit the example using jbang: `j! edit --open db.java`

This readme.md is a obsidian.md presentation/note document.

---

### Current Effective Persistence Myths

- Hibernate is slow 
- Hibernate hides the database
- Hibernate is complicated
- Hibernate don't let you write just SQL
- "Basic SQL fwk" X, Y and Z gives me what I need 
- Managed Entities vs manual managed DTO persistence style

---

### Max's Effective Persistence Claims

- Hibernate is fast
- Hibernate optionally hides the database
- Hibernate is powerful and very mature
- Hibernate lets you use native SQL for everything
- Hibernate let you mix and match your persistence style

---
### Items covered 

- Panache Managed Entities
- Manual vs managed updates
- native queries
	- using handwritten SQL
	- using JOOQ generated SQL
- Stateless Session
	- Fetch data without using entities
- batch processing (?)

--- 

### Resources

Things used in this demo:

- [Sakila database docker image](https://hub.docker.com/r/frantiseks/postgres-sakila/) 
- [jbang for building/running](https://jbang.dev) 
- vscodium for IDE (setup automatically by jbang)
- [TestContainers for container management](https://testcontainers.io)
- [DBeaver for Database visualization]( https://dbeaver.io)
- [15 year old blog on this subject](https://in.relation.to/2006/03/17/hibernate-32-transformers-for-hql-and-sql/) 

### Commands used

```shell
jbang --main org.jooq.codegen.GenerationTool --deps org.postgresql:postgresql:42.2.14 org.jooq:jooq-codegen:3.14.7 library.xml
```

