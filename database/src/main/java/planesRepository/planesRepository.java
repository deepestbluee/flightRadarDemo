package planesRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.plane;



public interface planesRepository extends JpaRepository<plane , Integer> { 
	List<plane> findByPlaneID(int planeid);
}
