package maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maikiencuong.entity.Sinhvien;

@Repository
public interface SinhvienRepo extends JpaRepository<Sinhvien, Integer> {

	List<Sinhvien> findAllByLophoc_Id(int idLophoc);

}
