package maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maikiencuong.entity.Lophoc;

@Repository
public interface LophocRepo extends JpaRepository<Lophoc, Integer> {

}
