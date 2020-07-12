package sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.entity.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
