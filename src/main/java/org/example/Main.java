package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
        EntityManager em = mySQL.createEntityManager();
        Person bram = new Person("Bram", 44);
        em.getTransaction().begin();
        em.persist(bram); // INSERT INTO ..
        em.getTransaction().commit();

        Person person = em.find(Person.class, 1L); // SELECT * FROM PERSON WHERE id = ..
        System.out.println(person);

        person.setAge(45);

        em.getTransaction().begin();
        em.merge(person); // UPDATE ... SET ... = ... WHERE id ..
        em.getTransaction().commit();

        System.out.println(person);



        em.getTransaction().begin();
        em.persist(new Person("Sezen", 30));
        em.persist(new Person("Tom", 21));
        em.getTransaction().commit();

        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);// SELECT age[,...] FROM PERSON [WHERE ...]
        List<Person> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        TypedQuery<PersonNameAgeContainer> query1 = em.createQuery("select new org.example.PersonNameAgeContainer(p.name, p.age) from Person p", PersonNameAgeContainer.class);// SELECT age[,...] FROM PERSON [WHERE ...]
        List<PersonNameAgeContainer> resultList1 = query1.getResultList();
        resultList1.forEach(System.out::println);

        em.getTransaction().begin();
        em.remove(person); // DELETE FROM ... WHERE id ..
        em.getTransaction().commit();

        em.close();
    }
}
